package com.sumerge.momra.tests.engineeringoffices;

import com.sumerge.momra.tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EngineeringOfficesListViewPage;

public class ValidateOnSearchFunctionality extends BaseTest {
    WebDriver driver;
    EngineeringOfficesListViewPage engineeringOfficesListViewPage;
    SoftAssert softAssert;

    @Test(alwaysRun = true)
    public void engineeringOfficesListViewSaveBtnFunctionality () {
         softAssert = new SoftAssert();
        engineeringOfficesListViewPage = new EngineeringOfficesListViewPage(driver);
        engineeringOfficesListViewPage.searchWithOfficeName("Testing Tests");
        softAssert.assertEquals(engineeringOfficesListViewPage.getFirstOfficeName(), data.getName(),
                "The Office Name Displayed in search results is Not Correct!");
        softAssert.assertEquals(engineeringOfficesListViewPage.getFirstOfficeNumber(), data.getName(),
                "The Office Number Displayed in search results is Not Correct!");
        softAssert.assertEquals(engineeringOfficesListViewPage.getFirstSecretariat(), data.getName(),
                "The Office Secretariat Displayed in search results is Not Correct!");
        softAssert.assertEquals(engineeringOfficesListViewPage.getFirstOfficeMunicipial(), data.getName(),
                "The Office Municipial Displayed in search results is Not Correct!");
        softAssert.assertEquals(engineeringOfficesListViewPage.getFirstOfficeCapacity(), data.getName(),
                "The Office Capacity Displayed in search results is Not Correct!");
        softAssert.assertEquals(engineeringOfficesListViewPage.getFirstOfficeNumberOfInspector(), data.getName(),
                "The Office NumberOfInspector Displayed in search results is Not Correct!");
        softAssert.assertAll();


    }
}
