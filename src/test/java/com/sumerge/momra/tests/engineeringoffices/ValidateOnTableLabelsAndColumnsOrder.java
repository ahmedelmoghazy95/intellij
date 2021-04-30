package com.sumerge.momra.tests.engineeringoffices;

import com.sumerge.momra.tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EngineeringOfficesListViewPage;

public class ValidateOnTableLabelsAndColumnsOrder extends BaseTest {
    WebDriver driver;
    EngineeringOfficesListViewPage engineeringOfficesListViewPage;
    SoftAssert softAssert;

    @Test(alwaysRun = true)
    public void engineeringOfficesListViewSaveBtnFunctionality () {
         softAssert = new SoftAssert();
        engineeringOfficesListViewPage = new EngineeringOfficesListViewPage(driver);

        softAssert.assertEquals(engineeringOfficesListViewPage.getOfficeNameLabel(),
                data.getPrimaryPersonUsersData().getName(),
                "The Office Name Label is Not Correct!");

        softAssert.assertEquals(engineeringOfficesListViewPage.getOfficeNumberLabel(),
                data.getPrimaryPersonUsersData().getName(),
                "The Office Number Label is Not Correct!");

        softAssert.assertEquals(engineeringOfficesListViewPage.getSecretariatLabel(),
                data.getPrimaryPersonUsersData().getName(),
                "The Secretariat Label is Not Correct!");

        softAssert.assertEquals(engineeringOfficesListViewPage.getOfficeMunicipialLabel(),
                data.getPrimaryPersonUsersData().getName(),
                "The Office Municipial Label is Not Correct!");

        softAssert.assertEquals(engineeringOfficesListViewPage.getOfficeNumberOfInspectorLabel(),
                data.getPrimaryPersonUsersData().getName(),
                "The Office Number Of Inspector Label is Not Correct!");

        softAssert.assertEquals(engineeringOfficesListViewPage.getOfficeCapacityLabel(),
                data.getPrimaryPersonUsersData().getName(),
                "The Office Capacity Label is Not Correct!");

        softAssert.assertAll();


    }
}
