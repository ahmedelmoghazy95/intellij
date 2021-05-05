package com.sumerge.momra.tests.engineeringoffices;

import com.sumerge.momra.dataproviderobjects.EngineeringOfficesData;
import com.sumerge.momra.pages.EngineeringOfficesListViewPage;
import com.sumerge.momra.pages.HomePage;
import com.sumerge.momra.pages.LoginPage;
import com.sumerge.momra.tests.BaseTest;
import com.sumerge.momra.utilities.DataProviderSource;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class ValidateOnTableLabelsAndColumnsOrderTest extends BaseTest {
    WebDriver driver;
    EngineeringOfficesListViewPage engineeringOfficesListViewPage;
    SoftAssert softAssert;
    HomePage homePage;
    LoginPage loginPage;


    @BeforeMethod(alwaysRun = true)
    public synchronized void setUp(Method method, Object testData[], ITestContext ctx) throws InterruptedException, MalformedURLException {
        if (((EngineeringOfficesData) testData[0]).getTestCaseName() != "") {
            ctx.setAttribute(method.getName(), ((EngineeringOfficesData) testData[0]).getTestCaseName());
        } else {
            ctx.setAttribute(method.getName(), "RQM #9873 | Validate on table structure, labels & columns order");
        }
        super.setUp();
        driver = getDriver();
    }

    @Test(alwaysRun = true, dataProvider = "EngineeringOfficesDataFeed", dataProviderClass = DataProviderSource.class)
    public void ValidateOnTableLabelsAndColumnsOrder (EngineeringOfficesData data) {
         softAssert = new SoftAssert();
        loginPage = new LoginPage(driver);

        homePage = loginPage.login(data.getUsername(), data.getPassword());
        engineeringOfficesListViewPage = homePage.clickOnOpenEngineeringOfficesSideMenuBtn();

        softAssert.assertEquals(engineeringOfficesListViewPage.getOfficeNameLabel(),
                data.getOfficeNameLabel(),
                "The Office Name Label is Not Correct!");

        softAssert.assertEquals(engineeringOfficesListViewPage.getOfficeNumberLabel(),
                data.getOfficeNumberLabel(),
                "The Office Number Label is Not Correct!");

        softAssert.assertEquals(engineeringOfficesListViewPage.getSecretariatLabel(),
                data.getOfficeSecretariatLabel(),
                "The Secretariat Label is Not Correct!");

        softAssert.assertEquals(engineeringOfficesListViewPage.getOfficeMunicipialLabel(),
                data.getOfficeMunicipialLabel(),
                "The Office Municipial Label is Not Correct!");

        softAssert.assertEquals(engineeringOfficesListViewPage.getOfficeNumberOfInspectorLabel(),
                data.getOfficeNumberOfInspectorsLabel(),
                "The Office Number Of Inspector Label is Not Correct!");

        softAssert.assertEquals(engineeringOfficesListViewPage.getOfficeCapacityLabel(),
                data.getOfficeNumberOfInspectorsLabel(),
                "The Office Capacity Label is Not Correct!");

        softAssert.assertAll();


    }
}
