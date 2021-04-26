package com.sumerge.momra.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.sumerge.momra.utilities.Constants;
import com.sumerge.momra.utilities.EmailUtils;
import com.sumerge.momra.utilities.ExtentManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Properties;

public class TestListener implements ITestListener {

    // Extent Report Declarations
    private static ExtentReports extent = ExtentManager.createInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    private String testReportFilePath;

    @Override
    public synchronized void onStart(ITestContext context) {
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
                "[MOMRA] E2E Integration Test Report on " + Constants.ENVIRONMENT_NAME,
                "Dears,\n\t\n\t Kindly find attached an HTML Report for MOMRA E2E Integration Tests Execution Results after Deployment on "
                        + Constants.ENVIRONMENT_NAME + ".\n\n Best Regards,\n Automation Team",
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
        if(result.getThrowable() != null) {
            result.getThrowable().printStackTrace();
        }
        test.get().fail(result.getThrowable());
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