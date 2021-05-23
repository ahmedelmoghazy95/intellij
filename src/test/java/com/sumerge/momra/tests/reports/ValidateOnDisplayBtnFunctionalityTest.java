package com.sumerge.momra.tests.reports;


import com.sumerge.momra.dataproviderobjects.EngineeringOfficesData;
import com.sumerge.momra.dataproviderobjects.VisitsReportData;
import com.sumerge.momra.pages.EngineeringOfficesListViewPage;
import com.sumerge.momra.pages.VisitsReportPage;
import com.sumerge.momra.tests.BaseTest;
import com.sumerge.momra.utilities.DataProviderSource;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class ValidateOnDisplayBtnFunctionalityTest extends BaseTest {
    WebDriver driver;
    VisitsReportPage visitsReportPage;
    SoftAssert softAssert;


    @BeforeMethod(alwaysRun = true)
    public synchronized void setUp(Method method, Object testData[], ITestContext ctx) throws InterruptedException, MalformedURLException {
        if (((VisitsReportData) testData[0]).getTestCaseName() != "") {
            ctx.setAttribute(method.getName(), ((VisitsReportData) testData[0]).getTestCaseName());
        } else {
            ctx.setAttribute(method.getName(), "RQM #9959 | Validate on عرض button functionality");
        }
        super.setUp();
        driver = getDriver();
    }

    @Test(alwaysRun = true, dataProvider = "", dataProviderClass = DataProviderSource.class)
    public void ValidateOnDisplayBtnFunctionality (VisitsReportData data) {
        softAssert = new SoftAssert();
        visitsReportPage = new VisitsReportPage(driver);
        visitsReportPage.clickOnFilterAndSelectSecretariat("");
        visitsReportPage.clickOnFilterAndSelectMunicipials("");
        visitsReportPage.clickOnFilterAndSelectActivities("");
        visitsReportPage.clickOnFilterAndSelectOfficeNames("");
        visitsReportPage.clickOnFilterAndSelectStatuses("");
        visitsReportPage.clickReportsSubmitFilterBtn();
        softAssert.assertEquals(visitsReportPage.getVisitsReportsHeaders(),
                data.getVisitsReportsHeaders(),
                "The Visits Report Headers are Not Correct!");

        softAssert.assertEquals(visitsReportPage.getVisitsReportsBody(),
                data.getVisitsReportsBody(),
                "The Visits Report Results are Not Correct!");

        softAssert.assertAll();


    }
}
