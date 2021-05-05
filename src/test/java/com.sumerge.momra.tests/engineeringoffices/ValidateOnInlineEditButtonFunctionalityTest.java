package com.sumerge.momra.tests.engineeringoffices;

import com.sumerge.momra.dataproviderobjects.SearchOfficesData;
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

public class ValidateOnInlineEditButtonFunctionalityTest extends BaseTest {
    WebDriver driver;
    EngineeringOfficesListViewPage engineeringOfficesListViewPage;
    SoftAssert softAssert;
    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public synchronized void setUp(Method method, ITestContext ctx) throws InterruptedException, MalformedURLException {

        ctx.setAttribute(method.getName(), "RQM #9880 #9882 | Validate on editable & read only fields + Validate on Inline Edit button functionality" );


        super.setUp();
        driver = getDriver();
    }

    @Test(alwaysRun = true, dataProvider = "SearchOfficesDataFeed", dataProviderClass = DataProviderSource.class)
    public void ValidateOnInlineEditButtonFunctionality (SearchOfficesData data) {
        softAssert = new SoftAssert();
        loginPage = new LoginPage(driver);

        homePage = loginPage.login(data.getUsername(), data.getPassword());
        engineeringOfficesListViewPage = homePage.clickOnOpenEngineeringOfficesSideMenuBtn();
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
