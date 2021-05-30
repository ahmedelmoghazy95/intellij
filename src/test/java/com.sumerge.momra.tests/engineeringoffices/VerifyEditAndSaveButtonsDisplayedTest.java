package com.sumerge.momra.tests.engineeringoffices;

import com.sumerge.momra.dataproviderobjects.SearchOfficesData;
import com.sumerge.momra.pages.EngineeringOfficesListViewPage;
import com.sumerge.momra.pages.HomePage;
import com.sumerge.momra.pages.LoginPage;
import com.sumerge.momra.tests.BaseTest;
import com.sumerge.momra.utilities.Constants;
import com.sumerge.momra.utilities.DataProviderSource;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class VerifyEditAndSaveButtonsDisplayedTest extends BaseTest {
    WebDriver driver;
    EngineeringOfficesListViewPage engineeringOfficesListViewPage;
    SoftAssert softAssert;
    HomePage homePage;
    LoginPage loginPage;


    @BeforeMethod(alwaysRun = true)
    public synchronized void setUp(Method method,Object testData[], ITestContext ctx) throws InterruptedException, MalformedURLException {
        if (((SearchOfficesData) testData[0]).getTestCaseName() != "") {
            ctx.setAttribute(method.getName(), ((SearchOfficesData) testData[0]).getTestCaseName());
        } else {
            ctx.setAttribute(method.getName(), "RQM #9884 | Verify Edit/save buttons are displayed");
        }
        super.setUp(Constants.ENGINEERING_OFFICES_MODULE);
        driver = getDriver();
    }

    @Test(alwaysRun = true, dataProvider = "SearchOfficesDataFeed", dataProviderClass = DataProviderSource.class)
    public void VerifyEditAndSaveButtonsDisplayed (SearchOfficesData data) {
         softAssert = new SoftAssert();
//        loginPage = new LoginPage(driver);
        engineeringOfficesListViewPage = new EngineeringOfficesListViewPage (driver);

//        homePage = loginPage.login(data.getUsername(), data.getPassword());
//        engineeringOfficesListViewPage = homePage.clickOnOpenEngineeringOfficesSideMenuBtn();
       softAssert.assertTrue(engineeringOfficesListViewPage.isDisabledSaveBtnDisplayed());
       softAssert.assertTrue(engineeringOfficesListViewPage.isEditAllBtnDisplayed());
       softAssert.assertAll();

    }
}