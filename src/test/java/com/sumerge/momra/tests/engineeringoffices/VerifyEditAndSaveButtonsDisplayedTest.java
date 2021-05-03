package com.sumerge.momra.tests.engineeringoffices;

import com.sumerge.momra.dataproviderobjects.SearchOfficesData;
import com.sumerge.momra.tests.BaseTest;
import com.sumerge.momra.utilities.DataProviderSource;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EngineeringOfficesListViewPage;
import pages.HomePage;
import pages.LoginPage;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class VerifyEditAndSaveButtonsDisplayedTest extends BaseTest {
    WebDriver driver;
    EngineeringOfficesListViewPage engineeringOfficesListViewPage;
    SoftAssert softAssert;
    HomePage homePage;
    LoginPage loginPage;
// Todo assert on correct page + Add before method (driver handler, login & HTML report)

    @BeforeMethod(alwaysRun = true)
    public synchronized void setUp(Method method, ITestContext ctx) throws InterruptedException, MalformedURLException {

            ctx.setAttribute(method.getName(), "RQM #9884 | Verify Edit/save buttons are displayed");

        super.setUp();
        driver = getDriver();
    }

    @Test(alwaysRun = true, dataProvider = "SearchOfficesDataFeed", dataProviderClass = DataProviderSource.class)
    public void VerifyEditAndSaveButtonsDisplayed (SearchOfficesData data) {
         softAssert = new SoftAssert();
        loginPage = new LoginPage(driver);

        homePage = loginPage.login(data.getUsername(), data.getPassword());
        engineeringOfficesListViewPage = homePage.clickOnOpenEngineeringOfficesSideMenuBtn();
       softAssert.assertTrue(engineeringOfficesListViewPage.isSaveBtnDisplayed());
       softAssert.assertTrue(engineeringOfficesListViewPage.isEditAllBtnDisplayed());
       softAssert.assertAll();

    }
}
