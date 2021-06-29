package com.sumerge.momra.tests.InspectorScreens;

import com.sumerge.momra.pages.InspectorDailyVisitsPage;
import com.sumerge.momra.pages.InspectorStartVisitPage;
import com.sumerge.momra.tests.BaseTest;
import com.sumerge.momra.utilities.Constants;
import com.sumerge.momra.utilities.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class StartVisitTest extends BaseTest {

    WebDriver driver;
    SoftAssert softAssert;
    InspectorDailyVisitsPage inspectorDailyVisitsPage;
    InspectorStartVisitPage inspectorStartVisitPage;


    @BeforeMethod(alwaysRun = true)
    public synchronized void setUp(Method method, Object testData[],
                                   ITestContext ctx) throws InterruptedException,
            MalformedURLException {

        ctx.setAttribute(method.getName(), "RQM 10728 | Start Daily Visits Happy Scenario ");

        super.setUp(Constants.INSPECTOR_SCREENS_DAILY_VISITS);
        driver = getDriver();
    }

    @Test (alwaysRun = true)
    public void startDailyVisitHappyScenario(){

        softAssert = new SoftAssert();
        inspectorDailyVisitsPage = new InspectorDailyVisitsPage(driver);

        inspectorDailyVisitsPage.clickOnVisitLocationButton();
        inspectorStartVisitPage = inspectorDailyVisitsPage.clickOnStartVisitButton();

        softAssert.assertTrue(!inspectorStartVisitPage.getVisitStatusFieldValue().isEmpty()
                , "Visit Status Field is Empty");

        softAssert.assertTrue(!inspectorStartVisitPage.getLicenseExpiryFieldValue().
                isEmpty() , "License Expiry Date Field is Empty");

        softAssert.assertTrue(!inspectorStartVisitPage.getLicenseBedsFieldValue().
                isEmpty() , "License Beds Field is Empty");

        softAssert.assertAll();

        inspectorStartVisitPage.selectLocationSituation("المنشأة مفتوحة");

    }


}
