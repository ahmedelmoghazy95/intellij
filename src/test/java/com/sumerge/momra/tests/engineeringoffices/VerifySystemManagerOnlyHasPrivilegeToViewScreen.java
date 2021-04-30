package com.sumerge.momra.tests.engineeringoffices;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EngineeringOfficesListViewPage;

public class VerifySystemManagerOnlyHasPrivilegeToViewScreen {
    WebDriver driver;
    EngineeringOfficesListViewPage engineeringOfficesListViewPage;
    SoftAssert softAssert;

    @Test(alwaysRun = true)
    public void engineeringOfficesListViewSaveBtnFunctionality () {
        softAssert = new SoftAssert();
        engineeringOfficesListViewPage = new EngineeringOfficesListViewPage(driver);
        engineeringOfficesListViewPage.clickInlineEditBtn();
        engineeringOfficesListViewPage.clickEditAllBtn();
        engineeringOfficesListViewPage.clickSaveBtn();
    }
}
