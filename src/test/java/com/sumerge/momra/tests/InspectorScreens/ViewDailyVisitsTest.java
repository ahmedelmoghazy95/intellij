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

        inspectorDailyVisitsPage.clickOnVisitLocationButton();
        inspectorDailyVisitsPage.clickOnVisitCloseLocationButton();

        softAssert.assertTrue(!inspectorDailyVisitsPage.getVisitNumberFieldValue().isEmpty());
        softAssert.assertTrue(!inspectorDailyVisitsPage.getVisitDateFieldValue().isEmpty());
        softAssert.assertTrue(!inspectorDailyVisitsPage.getVisitSiteNameFieldValue().isEmpty());
        softAssert.assertTrue(!inspectorDailyVisitsPage.getVisitLicenseIdFieldValue().isEmpty());
        //softAssert.assertTrue(!inspectorDailyVisitsPage.getVisitLicenseStatusFieldValue().isEmpty());
        softAssert.assertTrue(!inspectorDailyVisitsPage.getVisitAddressFieldValue().isEmpty());
        softAssert.assertTrue(!inspectorDailyVisitsPage.getVisitLicenseOwnerNameFieldValue().isEmpty());
        softAssert.assertTrue(!inspectorDailyVisitsPage.getVisitNumberOfBedsFieldValue().isEmpty());
        softAssert.assertTrue(!inspectorDailyVisitsPage.getVisitLicensePhoneFieldValue().isEmpty());


        softAssert.assertAll();


    }



}
