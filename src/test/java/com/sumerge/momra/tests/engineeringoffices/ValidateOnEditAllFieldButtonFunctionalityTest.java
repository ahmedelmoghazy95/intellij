package com.sumerge.momra.tests.engineeringoffices;

import com.sumerge.momra.dataproviderobjects.SearchOfficesData;
import com.sumerge.momra.pages.EngineeringOfficesListViewPage;
import com.sumerge.momra.tests.BaseTest;
import com.sumerge.momra.utilities.Constants;
import com.sumerge.momra.utilities.DataProviderSource;
import com.sumerge.momra.utilities.Utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class ValidateOnEditAllFieldButtonFunctionalityTest extends BaseTest {

    WebDriver driver;
    EngineeringOfficesListViewPage engineeringOfficesListViewPage;
    SoftAssert softAssert;

    @BeforeMethod(alwaysRun = true)
    public synchronized void setUp(Method method,Object testData[], ITestContext ctx) throws InterruptedException, MalformedURLException {
        if (((SearchOfficesData) testData[0]).getTestCaseName() != "") {
            ctx.setAttribute(method.getName(), ((SearchOfficesData) testData[0]).getTestCaseName());
        } else {

            ctx.setAttribute(method.getName(), "RQM #9882 | Search: Validate on Edit (All field) button functionality");
        }
        super.setUp(Constants.ENGINEERING_OFFICES_MODULE);
        driver = getDriver();
    }

    @Test(alwaysRun = true, dataProvider = "SearchOfficesDataFeed", dataProviderClass = DataProviderSource.class)
    public void ValidateOnEditAllFieldButtonFunctionality (SearchOfficesData data) throws InterruptedException {
        softAssert = new SoftAssert();

        engineeringOfficesListViewPage = new EngineeringOfficesListViewPage (driver);
        Thread.sleep(3000);
        softAssert.assertTrue(engineeringOfficesListViewPage.checkFieldIsDisplayed(engineeringOfficesListViewPage.getOfficeCapacityReadOnly()));
        softAssert.assertTrue(engineeringOfficesListViewPage.checkFieldIsDisplayed(engineeringOfficesListViewPage.getOfficeNumberOfInspectorReadOnly()));
        engineeringOfficesListViewPage.clickEditAllBtn();
        softAssert.assertTrue(engineeringOfficesListViewPage.checkFieldIsDisplayed(engineeringOfficesListViewPage.getOfficeCapacityEditable()));
        softAssert.assertTrue(engineeringOfficesListViewPage.checkFieldIsDisplayed(engineeringOfficesListViewPage.getOfficeNumberOfInspectorEditable()));
       engineeringOfficesListViewPage.resetOfficeCapacityEditable(Utilities.randInt(1, 999));
        engineeringOfficesListViewPage.clickOnEnabledSaveBtn();
        softAssert.assertTrue(engineeringOfficesListViewPage.checkFieldIsDisplayed(engineeringOfficesListViewPage.getOfficeCapacityReadOnly()));
        softAssert.assertTrue(engineeringOfficesListViewPage.checkFieldIsDisplayed(engineeringOfficesListViewPage.getOfficeNumberOfInspectorReadOnly()));

        softAssert.assertAll();
    }
}
