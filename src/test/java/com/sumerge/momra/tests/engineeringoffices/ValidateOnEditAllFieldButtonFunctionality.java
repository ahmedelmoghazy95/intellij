package com.sumerge.momra.tests.engineeringoffices;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EngineeringOfficesListViewPage;

public class ValidateOnEditAllFieldButtonFunctionality {
    WebDriver driver;
    EngineeringOfficesListViewPage engineeringOfficesListViewPage;
    SoftAssert softAssert;

    @Test(alwaysRun = true)
    public void engineeringOfficesListViewSaveBtnFunctionality () {
        softAssert = new SoftAssert();
        engineeringOfficesListViewPage = new EngineeringOfficesListViewPage(driver);

        softAssert.assertTrue(engineeringOfficesListViewPage.checkFieldIsDisplayed(engineeringOfficesListViewPage.getOfficeCapacityReadOnly()));
        softAssert.assertTrue(engineeringOfficesListViewPage.checkFieldIsDisplayed(engineeringOfficesListViewPage.getOfficeNumberOfInspectorReadOnly()));
        engineeringOfficesListViewPage.clickEditAllBtn();
        softAssert.assertTrue(engineeringOfficesListViewPage.checkFieldIsDisplayed(engineeringOfficesListViewPage.getOfficeCapacityEditable()));
        softAssert.assertTrue(engineeringOfficesListViewPage.checkFieldIsDisplayed(engineeringOfficesListViewPage.getOfficeNumberOfInspectorEditable()));
        engineeringOfficesListViewPage.clickSaveBtn();
        softAssert.assertTrue(engineeringOfficesListViewPage.checkFieldIsDisplayed(engineeringOfficesListViewPage.getOfficeCapacityReadOnly()));
        softAssert.assertTrue(engineeringOfficesListViewPage.checkFieldIsDisplayed(engineeringOfficesListViewPage.getOfficeNumberOfInspectorReadOnly()));
        softAssert.assertAll();

    }
}
