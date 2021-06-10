package com.sumerge.momra.tests.allvisitsview;

import com.sumerge.momra.dataproviderobjects.SearchOfficesData;
import com.sumerge.momra.pages.AllVisitsViewPage;
import com.sumerge.momra.pages.EngineeringOfficesListViewPage;
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

public class VerifyPageItemsAndLabels extends BaseTest {

    WebDriver driver;
    AllVisitsViewPage allVisitsViewPage;
    SoftAssert softAssert;

    @BeforeMethod(alwaysRun = true)
    public synchronized void setUp(Method method, ITestContext ctx) throws InterruptedException, MalformedURLException {
        {
            ctx.setAttribute(method.getName(), "RQM #10350 | Verify page items/labels");
        }
        super.setUp(Constants.VIEW_ALL_VISITS_PAGE);
        driver = getDriver();
    }

    @Test(alwaysRun = true)
    public void ValidateOnEditAllFieldButtonFunctionality () {
        softAssert = new SoftAssert();

        allVisitsViewPage = new AllVisitsViewPage(driver);

        softAssert.assertEquals(allVisitsViewPage.getPageTitle(),
                "قوائم زيارات التفتيش" ,
                "Page title is Not Correct!");

        softAssert.assertEquals(allVisitsViewPage.getNewVisitsTab(),
                "زيارات بإنتظار الجدولة" ,
                "1st tab title is Not Correct!");

        softAssert.assertEquals(allVisitsViewPage.getScheduledVisitsTab(),
                "زيارات تم جدولتها" ,
                "2nd tab title is Not Correct!");

        softAssert.assertEquals(allVisitsViewPage.getCompletedVisitsTab(),
                "زيارات تم تنفيذها" ,
                "3rd tab title is Not Correct!");

        softAssert.assertEquals(allVisitsViewPage.getRejectedVisitsTab(),
                "زيارات معلقة و مرفوضة" ,
                "4th tab title is Not Correct!");

        softAssert.assertEquals(allVisitsViewPage.getViewVisitIdLabel(),
                "رقم تقرير الزيارة" ,
                "Visit ID Header is Not Correct!");

        softAssert.assertEquals(allVisitsViewPage.getVisitSiteNameLabel(),
                "إسم المنشأة" ,
                "Site Name Header is Not Correct!");

        softAssert.assertEquals(allVisitsViewPage.getVisitLicenseIdLabel(),
                "رقم الرخصة" ,
                "License ID Header isNot Correct!");

        softAssert.assertEquals(allVisitsViewPage.getVisitLicenseStatusLabel(),
                "حالة الرخصة" ,
                "License Status Header is Not Correct!");

        softAssert.assertEquals(allVisitsViewPage.getVisitAmanaLabel(),
                "الأمانة" ,
                "Amana Header is Not Correct!");

        softAssert.assertEquals(allVisitsViewPage.getVisitBaladyaLabel(),
                "البلدية" ,
                "Baladya Header is Not Correct!");

        softAssert.assertEquals(allVisitsViewPage.getVisitStatusLabel(),
                "حالة تقرير الزيارة" ,
                "Visit Status Header is Not Correct!");

        softAssert.assertEquals(allVisitsViewPage.getVisitBedsNumberLabel(),
                "عدد الأسّرة" ,
                "No. of beds Header is Not Correct!");

        softAssert.assertEquals(allVisitsViewPage.getVisitEngineeringOfficeNameLabel(),
                "إسم المكتب الهندسى" ,
                "Engineering Office Header is Not Correct!");

        softAssert.assertEquals(allVisitsViewPage.getVisitActionsLabel(),
                "الإجراءات" ,
                "Actions Header is Not Correct!");

allVisitsViewPage.clickOnScheduledVisitsTab();

        softAssert.assertEquals(allVisitsViewPage.getViewVisitIdLabel(),
                "رقم تقرير الزيارة" ,
                "Visit ID Header is Not Correct!");

        softAssert.assertEquals(allVisitsViewPage.getVisitSiteNameLabel(),
                "إسم المنشأة" ,
                "Site Name Header is Not Correct!");

        softAssert.assertEquals(allVisitsViewPage.getVisitLicenseIdLabel(),
                "رقم الرخصة" ,
                "License ID Header isNot Correct!");

        softAssert.assertEquals(allVisitsViewPage.getScheduledVisitDateLabel(),
                "تاريخ جدولة الزيارة" ,
                "Scheduled visit date Header is Not Correct!");

        softAssert.assertEquals(allVisitsViewPage.getVisitAmanaLabel(),
                "الأمانة" ,
                "Amana Header is Not Correct!");

        softAssert.assertEquals(allVisitsViewPage.getVisitBaladyaLabel(),
                "البلدية" ,
                "Baladya Header is Not Correct!");

        softAssert.assertEquals(allVisitsViewPage.getVisitStatusLabel(),
                "حالة تقرير الزيارة" ,
                "Visit Status Header is Not Correct!");

        softAssert.assertEquals(allVisitsViewPage.getVisitBedsNumberLabel(),
                "عدد الأسّرة" ,
                "No. of beds Header is Not Correct!");

        softAssert.assertEquals(allVisitsViewPage.getVisitEngineeringOfficeNameLabel(),
                "إسم المكتب الهندسى" ,
                "Engineering Office Header is Not Correct!");

        softAssert.assertEquals(allVisitsViewPage.getVisitActionsLabel(),
                "الإجراءات" ,
                "Actions Header is Not Correct!");

        allVisitsViewPage.clickOnCompletedVisitsTab();

        softAssert.assertEquals(allVisitsViewPage.getViewVisitIdLabel(),
                "رقم تقرير الزيارة" ,
                "Visit ID Header is Not Correct!");

        softAssert.assertEquals(allVisitsViewPage.getVisitSiteNameLabel(),
                "إسم المنشأة" ,
                "Site Name Header is Not Correct!");

        softAssert.assertEquals(allVisitsViewPage.getVisitLicenseIdLabel(),
                "رقم الرخصة" ,
                "License ID Header isNot Correct!");

        softAssert.assertEquals(allVisitsViewPage.getCompletedVisitDateLabel(),
                "تاريخ تنفيذ الزيارة" ,
                "Completed visit date Header is Not Correct!");

        softAssert.assertEquals(allVisitsViewPage.getVisitAmanaLabel(),
                "الأمانة" ,
                "Amana Header is Not Correct!");

        softAssert.assertEquals(allVisitsViewPage.getVisitBaladyaLabel(),
                "البلدية" ,
                "Baladya Header is Not Correct!");

        softAssert.assertEquals(allVisitsViewPage.getVisitStatusLabel(),
                "حالة تقرير الزيارة" ,
                "Visit Status Header is Not Correct!");

        softAssert.assertEquals(allVisitsViewPage.getVisitBedsNumberLabel(),
                "عدد الأسّرة" ,
                "No. of beds Header is Not Correct!");

        softAssert.assertEquals(allVisitsViewPage.getVisitEngineeringOfficeNameLabel(),
                "إسم المكتب الهندسى" ,
                "Engineering Office Header is Not Correct!");

        softAssert.assertEquals(allVisitsViewPage.getVisitActionsLabel(),
                "الإجراءات" ,
                "Actions Header is Not Correct!");

        allVisitsViewPage.clickOnRejectedVisitsTab();

        softAssert.assertEquals(allVisitsViewPage.getViewVisitIdLabel(),
                "رقم تقرير الزيارة" ,
                "Visit ID Header is Not Correct!");

        softAssert.assertEquals(allVisitsViewPage.getVisitSiteNameLabel(),
                "إسم المنشأة" ,
                "Site Name Header is Not Correct!");

        softAssert.assertEquals(allVisitsViewPage.getVisitLicenseIdLabel(),
                "رقم الرخصة" ,
                "License ID Header isNot Correct!");

        softAssert.assertEquals(allVisitsViewPage.getVisitDateLabel(),
                "تاريخ تنفيذ الزيارة" ,
                "Rejected/onHold visit date Header is Not Correct!");

        softAssert.assertEquals(allVisitsViewPage.getVisitAmanaLabel(),
                "الأمانة" ,
                "Amana Header is Not Correct!");

        softAssert.assertEquals(allVisitsViewPage.getVisitBaladyaLabel(),
                "البلدية" ,
                "Baladya Header is Not Correct!");

        softAssert.assertEquals(allVisitsViewPage.getVisitStatusLabel(),
                "حالة تقرير الزيارة" ,
                "Visit Status Header is Not Correct!");

        softAssert.assertEquals(allVisitsViewPage.getVisitBedsNumberLabel(),
                "عدد الأسّرة" ,
                "No. of beds Header is Not Correct!");

        softAssert.assertEquals(allVisitsViewPage.getVisitEngineeringOfficeNameLabel(),
                "إسم المكتب الهندسى" ,
                "Engineering Office Header is Not Correct!");

        softAssert.assertEquals(allVisitsViewPage.getRejectedVisitActionsLabel(),
                "الإجراءات" ,
                "Actions Header is Not Correct!");
        softAssert.assertAll();

    }
}
