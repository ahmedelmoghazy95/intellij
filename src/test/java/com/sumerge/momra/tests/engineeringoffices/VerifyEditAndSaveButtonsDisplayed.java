package com.sumerge.momra.tests.engineeringoffices;

import com.sumerge.momra.tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EngineeringOfficesListViewPage;

public class VerifyEditAndSaveButtonsDisplayed extends BaseTest {
    WebDriver driver;
    EngineeringOfficesListViewPage engineeringOfficesListViewPage;
    SoftAssert softAssert;
// Todo assert on correct page + Add before method (driver handler, login & HTML report)
    @Test(alwaysRun = true)
    public void engineeringOfficesListViewSaveBtnFunctionality () {
         softAssert = new SoftAssert();
        engineeringOfficesListViewPage = new EngineeringOfficesListViewPage(driver);
       softAssert.assertTrue(engineeringOfficesListViewPage.isSaveBtnDisplayed());
       softAssert.assertTrue(engineeringOfficesListViewPage.isEditAllBtnDisplayed());
       softAssert.assertAll();

    }
}
