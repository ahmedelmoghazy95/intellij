package com.sumerge.momra.tests.engineeringoffices;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EngineeringOfficesListViewPage;

public class ValidateOnInlineEditButtonFunctionality {
    WebDriver driver;
    EngineeringOfficesListViewPage engineeringOfficesListViewPage;
    SoftAssert softAssert;

    @Test(alwaysRun = true)
    public void engineeringOfficesListViewSaveBtnFunctionality () {
        softAssert = new SoftAssert();
        engineeringOfficesListViewPage = new EngineeringOfficesListViewPage(driver);
//       ***********ValidateOnEditableAndReadOnlyFields***********
//        ***********ValidateOnInlineEditButtonFunctionality***********
        softAssert.assertTrue(engineeringOfficesListViewPage.checkFieldIsDisplayed(engineeringOfficesListViewPage.getOfficeCapacityReadOnly()));
        softAssert.assertTrue(engineeringOfficesListViewPage.checkFieldIsDisplayed(engineeringOfficesListViewPage.getOfficeNumberOfInspectorReadOnly()));
        softAssert.assertTrue(engineeringOfficesListViewPage.checkFieldIsDisplayed(engineeringOfficesListViewPage.getOfficeName()));
        softAssert.assertTrue(engineeringOfficesListViewPage.checkFieldIsDisplayed(engineeringOfficesListViewPage.getOfficeNumber()));
        softAssert.assertTrue(engineeringOfficesListViewPage.checkFieldIsDisplayed(engineeringOfficesListViewPage.getOfficeMunicipial()));
        softAssert.assertTrue(engineeringOfficesListViewPage.checkFieldIsDisplayed(engineeringOfficesListViewPage.getSecretariat()));
        engineeringOfficesListViewPage.clickEditAllBtn();
        softAssert.assertTrue(engineeringOfficesListViewPage.checkFieldIsDisplayed(engineeringOfficesListViewPage.getOfficeCapacityEditable()));
        softAssert.assertTrue(engineeringOfficesListViewPage.checkFieldIsDisplayed(engineeringOfficesListViewPage.getOfficeNumberOfInspectorEditable()));
        softAssert.assertTrue(engineeringOfficesListViewPage.checkFieldIsDisplayed(engineeringOfficesListViewPage.getOfficeName()));
        softAssert.assertTrue(engineeringOfficesListViewPage.checkFieldIsDisplayed(engineeringOfficesListViewPage.getOfficeNumber()));
        softAssert.assertTrue(engineeringOfficesListViewPage.checkFieldIsDisplayed(engineeringOfficesListViewPage.getOfficeMunicipial()));
        softAssert.assertTrue(engineeringOfficesListViewPage.checkFieldIsDisplayed(engineeringOfficesListViewPage.getSecretariat()));
        engineeringOfficesListViewPage.clickSaveBtn();
        softAssert.assertTrue(engineeringOfficesListViewPage.checkFieldIsDisplayed(engineeringOfficesListViewPage.getOfficeCapacityReadOnly()));
        softAssert.assertTrue(engineeringOfficesListViewPage.checkFieldIsDisplayed(engineeringOfficesListViewPage.getOfficeNumberOfInspectorReadOnly()));
        softAssert.assertTrue(engineeringOfficesListViewPage.checkFieldIsDisplayed(engineeringOfficesListViewPage.getOfficeName()));
        softAssert.assertTrue(engineeringOfficesListViewPage.checkFieldIsDisplayed(engineeringOfficesListViewPage.getOfficeNumber()));
        softAssert.assertTrue(engineeringOfficesListViewPage.checkFieldIsDisplayed(engineeringOfficesListViewPage.getOfficeMunicipial()));
        softAssert.assertTrue(engineeringOfficesListViewPage.checkFieldIsDisplayed(engineeringOfficesListViewPage.getSecretariat()));
        softAssert.assertAll();
    }
}
