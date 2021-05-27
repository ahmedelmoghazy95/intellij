package com.sumerge.momra.tests.engineeringoffices;

import com.sumerge.momra.dataproviderobjects.SearchOfficesData;
import com.sumerge.momra.pages.EngineeringOfficesListViewPage;
import com.sumerge.momra.tests.BaseTest;
import com.sumerge.momra.utilities.DataProviderSource;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class ValidateOnSearchFunctionalityTest extends BaseTest {
    WebDriver driver;
    EngineeringOfficesListViewPage engineeringOfficesListViewPage;
    SoftAssert softAssert;

    @BeforeMethod(alwaysRun = true)
    public synchronized void setUp(Method method, Object testData[], ITestContext ctx) throws InterruptedException, MalformedURLException {
        if (((SearchOfficesData) testData[0]).getTestCaseName() != "") {
            ctx.setAttribute(method.getName(), ((SearchOfficesData) testData[0]).getTestCaseName());
        } else {
            ctx.setAttribute(method.getName(), "RQM #9874 | Validate on search functionality");
        }
        super.setUp();
        driver = getDriver();
    }

    @Test(alwaysRun = true, dataProvider = "SearchOfficesDataFeed", dataProviderClass = DataProviderSource.class)
    public void ValidateOnSearchFunctionality (SearchOfficesData data) {
        softAssert = new SoftAssert();

        engineeringOfficesListViewPage = new EngineeringOfficesListViewPage (driver);

        engineeringOfficesListViewPage.searchWithOfficeName("Testing 2");
        softAssert.assertEquals(engineeringOfficesListViewPage.getFirstOfficeName(), data.getOfficeName(),
                "The Office Name Displayed in search results is Not Correct!");
        softAssert.assertEquals(engineeringOfficesListViewPage.getFirstOfficeNumber(), data.getOfficeNumber(),
                "The Office Number Displayed in search results is Not Correct!");
        softAssert.assertEquals(engineeringOfficesListViewPage.getFirstSecretariat(), data.getOfficeSecretariat(),
                "The Office Secretariat Displayed in search results is Not Correct!");
        softAssert.assertEquals(engineeringOfficesListViewPage.getFirstOfficeMunicipial(), data.getOfficeMunicipial(),
                "The Office Municipial Displayed in search results is Not Correct!");
        softAssert.assertEquals(engineeringOfficesListViewPage.getFirstOfficeCapacity(), data.getOfficeCapacityReadOnly(),
                "The Office Capacity Displayed in search results is Not Correct!");
        softAssert.assertEquals(engineeringOfficesListViewPage.getFirstOfficeNumberOfInspector(), data.getOfficeNumberOfInspectorsReadOnly(),
                "The Office NumberOfInspector Displayed in search results is Not Correct!");

        softAssert.assertAll();
    }
}