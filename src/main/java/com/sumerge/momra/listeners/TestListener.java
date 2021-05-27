package com.sumerge.momra.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.google.common.util.concurrent.Uninterruptibles;
import com.sumerge.momra.utilities.*;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestListener extends DriverHandler implements ITestListener {

    // Extent Report Declarations
    private static ExtentReports extent = ExtentManager.createInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    private WebDriver driver;
    private static String screenshotPath;
    private static String screenshotTitle;
    private static String screenshotEncoded;

    private String testReportFilePath;

    @Override
    public synchronized void onStart(ITestContext context) {
        //intentionally added this as chrome/firefox containers take few ms to register
        //to hub - test fails saying hub does not have node!!
        //very rare
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        System.out.println("Extent Reports Version 5 Test Suite started!");
    }

    @Override
    public synchronized void onFinish(ITestContext context) {
        System.out.println(("Extent Reports Version 5  Test Suite is ending!"));
        extent.flush();

        EmailUtils email = new EmailUtils();
        testReportFilePath = ExtentManager.filePathAndName;

        Properties prop = email.readFromPropertiesFile();
        email.sendTestReportEmail(prop.getProperty("email.user"), prop.getProperty("email.pass"), prop.getProperty("server.host"), prop.getProperty("server.port"),
                prop.getProperty("email.sender"), prop.getProperty("email.recepient"), prop.getProperty("email.recepientCC"),
                "[MOMRA] Automation Test Report on " + Constants.APPLICATION_HOST,
                "Dears,\n\t\n\t Kindly find attached an HTML Report for MOMRA Automation Tests Execution Results after Deployment on "
                        + Constants.APPLICATION_HOST + ".\n\n Best Regards,\n Automation Team",
                ExtentManager.reportFileName, testReportFilePath);
    }

    @Override
    public synchronized void onTestStart(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " started!"));

        ExtentTest extentTest = extent.createTest(
                result.getTestContext().getAttribute(result.getMethod().getMethodName()).toString(),
                result.getMethod().getDescription());

        test.set(extentTest);
    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " Passed!"));
        test.get().pass("Test Passed");
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " Failed!"));

        Class<?> testClass = result.getTestClass().getRealClass();
        try {
            // this field name must be present and equals in any testcase
            Field field = testClass.getDeclaredField("driver");

            field.setAccessible(true);

            driver = (WebDriver) field.get(result.getInstance());
            Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);

            if (screenshot != null) {
                File src;

                EncodeToBase64Utils encodeScreenshot = new EncodeToBase64Utils();

                screenshotTitle = result.getMethod().getMethodName() + "_"
                        + new SimpleDateFormat("dd-MM-yyyy hh-mm-ss-ms").format(new Date());

                screenshotPath = "TestReport\\Screenshots\\" + screenshotTitle + ".png";

                ImageIO.write(screenshot.getImage(), "PNG", src = new File(screenshotPath));

                screenshotEncoded = encodeScreenshot.encodeFileToBase64Binary(src);

                test.get().fail(result.getThrowable()).addScreenCaptureFromBase64String(screenshotEncoded);
            } else {
                if(result.getThrowable() != null) {
                    result.getThrowable().printStackTrace();
                    test.get().fail(result.getThrowable());
                }
            }

        } catch (NullPointerException | IOException | NoSuchFieldException | SecurityException
                | IllegalArgumentException | IllegalAccessException | NoClassDefFoundError e) {
            e.printStackTrace();
            if(result.getThrowable() != null && test.get() != null) {
                test.get().fail(result.getThrowable());
            }
        }
    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " Skipped!"));
        if(result.getThrowable() != null) {
            result.getThrowable().printStackTrace();
        }
        test.get().skip(result.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
    }

}