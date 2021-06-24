package com.sumerge.momra.tests.InspectorScreens;

import com.sumerge.momra.pages.InspectorDailyVisitsPage;
import com.sumerge.momra.tests.BaseTest;
import com.sumerge.momra.utilities.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class ViewDailyVisitsTest extends BaseTest {

    WebDriver driver;
    SoftAssert softAssert;
    InspectorDailyVisitsPage inspectorDailyVisitsPage;

    @BeforeMethod(alwaysRun = true)
    public synchronized void setUp(Method method, Object testData[], ITestContext ctx) throws InterruptedException, MalformedURLException {

        ctx.setAttribute(method.getName(), "RQM e2e scenario to check labels ");

        super.setUp(Constants.INSPECTOR_SCREENS_DAILY_VISITS);
        driver = getDriver();
    }

    @Test(alwaysRun = true)
    public void verifyInspectorDailyVisitsPageElements(){

        softAssert = new SoftAssert();
        inspectorDailyVisitsPage = new InspectorDailyVisitsPage(driver);

        softAssert.assertTrue(inspectorDailyVisitsPage.getVisitNumberFieldValue().isEmpty());


    }



}
