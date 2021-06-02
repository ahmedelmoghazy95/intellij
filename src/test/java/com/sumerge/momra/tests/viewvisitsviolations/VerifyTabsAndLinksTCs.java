package com.sumerge.momra.tests.viewvisitsviolations;

import com.sumerge.momra.dataproviderobjects.SearchOfficesData;
import com.sumerge.momra.pages.ViewVisitsViolations1stTabPage;
import com.sumerge.momra.pages.ViewVisitsViolations2ndTabPage;
import com.sumerge.momra.pages.ViewVisitsViolations3rdTabPage;
import com.sumerge.momra.pages.ViewVisitsViolations4thTabPage;
import com.sumerge.momra.tests.BaseTest;
import com.sumerge.momra.utilities.DataProviderSource;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class VerifyTabsAndLinksTCs extends BaseTest {
    WebDriver driver;
    ViewVisitsViolations1stTabPage viewVisitsViolationsPage;
    ViewVisitsViolations2ndTabPage viewVisitsViolationsPage2;
    ViewVisitsViolations3rdTabPage viewVisitsViolationsPage3;
    ViewVisitsViolations4thTabPage viewVisitsViolationsPage4;
    SoftAssert softAssert;

    @BeforeMethod(alwaysRun = true)
    public synchronized void setUp(Method method, Object testData[], ITestContext ctx) throws InterruptedException, MalformedURLException {
//        if (((SearchOfficesData) testData[0]).getTestCaseName() != "") {
//            ctx.setAttribute(method.getName(), ((SearchOfficesData) testData[0]).getTestCaseName());
//        } else {
//            ctx.setAttribute(method.getName(), "RQM ");
//        }

        super.setUp();
        driver = getDriver();
        goToViolationsPage();
    }

    @Test
    public void ValidateColumnsNamesInTab1() {
        softAssert = new SoftAssert();

        viewVisitsViolationsPage = new ViewVisitsViolations1stTabPage(driver);

        softAssert.assertEquals(viewVisitsViolationsPage.getTab1Title().getText(), "مخالفات بإنتظار السداد", "tab 1 title is incorrect");
        softAssert.assertEquals(viewVisitsViolationsPage.getTab2Title().getText(), "مخالفات بإنتظار نتيجة الإعتراض", "tab 2 title is incorrect");
        softAssert.assertEquals(viewVisitsViolationsPage.getTab3Title().getText(), "مخالفات تم سدادها", "tab 3 title is incorrect");
        softAssert.assertEquals(viewVisitsViolationsPage.getTab4Title().getText(), "مخالفات تم قبول الإعتراض لها", "tab 4 title is incorrect");

        viewVisitsViolationsPage2 = viewVisitsViolationsPage.goTo2ndTab(driver);
        softAssert.assertEquals(viewVisitsViolationsPage2.getAppealDateLable(), "تاريخ تقديم إعتراض");
        viewVisitsViolationsPage3 = viewVisitsViolationsPage2.goTo3rdTab(driver);
        softAssert.assertEquals(viewVisitsViolationsPage3.getFinePaymentDateLabel(), "تاريخ السداد");
        viewVisitsViolationsPage4 = viewVisitsViolationsPage3.goTo4thTab(driver);
        softAssert.assertEquals(viewVisitsViolationsPage4.getAppealAcceptanceDateLabel(), "تاريخ قبول الإعتراض");

        softAssert.assertAll();
    }

}