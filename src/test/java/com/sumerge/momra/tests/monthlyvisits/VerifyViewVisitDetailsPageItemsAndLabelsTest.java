package com.sumerge.momra.tests.monthlyvisits;

import com.sumerge.momra.pages.AllVisitsViewPage;
import com.sumerge.momra.pages.MonthlyVisitsViewPage;
import com.sumerge.momra.pages.VisitDetailsPage;
import com.sumerge.momra.tests.BaseTest;
import com.sumerge.momra.utilities.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class VerifyViewVisitDetailsPageItemsAndLabelsTest extends BaseTest {

    WebDriver driver;
    MonthlyVisitsViewPage monthlyVisitsViewPage;
    VisitDetailsPage visitDetailsPage;
    SoftAssert softAssert;

    @BeforeMethod(alwaysRun = true)
    public synchronized void setUp(Method method, ITestContext ctx) throws InterruptedException, MalformedURLException {
        {
            ctx.setAttribute(method.getName(), "RQM #10392 #10399 #10395 | Verify visit details view page items/labels + back btn functionality");
        }
        super.setUp(Constants.VIEW_VISIT_DETAILS);
        driver = getDriver();
    }

    @Test(alwaysRun = true)
    public void VerifyViewVisitDetailsPageItemsAndLabels() {
        softAssert = new SoftAssert();


        visitDetailsPage = new VisitDetailsPage (driver);
        visitDetailsPage.clickViewVisitBtn();
        softAssert.assertEquals(visitDetailsPage.getPageTitle(),
                "تفاصيل زيارة",
                "Page title is Not Correct!");

        softAssert.assertEquals(visitDetailsPage.getSiteNameLabel(),
                "إسم المنشأة",
                "Site name label is Not Correct!");

        softAssert.assertEquals(visitDetailsPage.getAddressLabel(),
                "العنوان",
                "Address label is Not Correct!");

        softAssert.assertEquals(visitDetailsPage.getAmanaNameLabel(),
                "الأمانة",
                "Amana name label is Not Correct!");

        softAssert.assertEquals(visitDetailsPage.getBaladyaNameLabel(),
                "البلدية",
                "Balady name label is Not Correct!");

        softAssert.assertEquals(visitDetailsPage.getBedsNumberLabel(),
                "عدد الأسرة",
                "Number of beds label is Not Correct!");

        softAssert.assertEquals(visitDetailsPage.getDistrictNameLabel(),
                "الحى",
                "District name label is Not Correct!");

        softAssert.assertEquals(visitDetailsPage.getLicenseIdLabel(),
                "رقم الرخصة",
                "License Id label is Not Correct!");

        softAssert.assertEquals(visitDetailsPage.getLicensePhoneLabel(),
                "رقم جوال صاحب الرخصة",
                "License phone label is Not Correct!");

        softAssert.assertEquals(visitDetailsPage.getLicenseStatusLabel(),
                "حالة الرخصة",
                "License Status label is Not Correct!");

        softAssert.assertEquals(visitDetailsPage.getOwnerIdLabel(),
                "رقم هوية صاحب الرخصة",
                "Owner Id label is Not Correct!");

        softAssert.assertEquals(visitDetailsPage.getLicenseExpiryDateLabel(),
                "تاريخ إنتهاء الرخصة",
                "License expiry date label is Not Correct!");

        softAssert.assertEquals(visitDetailsPage.getLicenseIssueDateLabel(),
                "تاريخ إصدار الرخصة",
                "license issue date label is Not Correct!");

        softAssert.assertEquals(visitDetailsPage.getLicenseOwnerNameLabel(),
                "إسم صاحب الرخصة",
                "license owner name label is Not Correct!");

        softAssert.assertEquals(visitDetailsPage.getScheduleVisitSectionTitle(),
                "جدولة الزيارة",
                " Schedule Visit Section Title is Not Correct!");

        softAssert.assertEquals(visitDetailsPage.getVisitStatusLabel(),
                "حالة الزيارة",
                " Visit status label is Not Correct!");

        softAssert.assertEquals(visitDetailsPage.getIsVisitScheduledLabel(),
                "تم جدولة الزيارة",
                " Visit Scheduled label is Not Correct!");

        softAssert.assertEquals(visitDetailsPage.getVisitScheduledDateLabel(),
                "تاريخ جدولة الزيارة",
                "Visit Scheduled Date label is Not Correct!");

        softAssert.assertEquals(visitDetailsPage.getVisitScheduledTimeLabel(),
                "وقت الزيارة",
                "Visit Scheduled Time label is Not Correct!");

        softAssert.assertEquals(visitDetailsPage.getInspectorAllocationTypeLabel(),
                "إسناد الزيارة",
                "Inspector Allocation Type label is Not Correct!");

        softAssert.assertEquals(visitDetailsPage.getVisitInspectorNameLabel(),
                "إسم المراقب",
                "Inspector NAme label is Not Correct!");

        softAssert.assertEquals(visitDetailsPage.getVisitNotesLabel(),
                "ملاحظات",
                "Notes label is Not Correct!");

        softAssert.assertTrue(visitDetailsPage.isSaveBtnDisplayed());

        softAssert.assertEquals(visitDetailsPage.getVisitHistoryTitle(),
                "السجل السابق لجدولة الزيارة",
                "Visit History Title is Not Correct!");

        softAssert.assertEquals(visitDetailsPage.getNotesHeader(),
                "ملاحظات",
                "Notes header is Not Correct!");

        softAssert.assertEquals(visitDetailsPage.getStatusHeader(),
                "حالة الزيارة",
                "Status header is Not Correct!");

        softAssert.assertEquals(visitDetailsPage.getTimestampHeader(),
                "الوقت و التاريخ",
                "Timestamp header is Not Correct!");

        softAssert.assertEquals(visitDetailsPage.getUserHeader(),
                "إسم المستخدم",
                "User header is Not Correct!");

        softAssert.assertEquals(visitDetailsPage.getInspectorNameHeader(),
                "إسم المراقب",
                "Inspector Name eader is Not Correct!");

        softAssert.assertEquals(visitDetailsPage.getScheduleStatusHeader(),
                "تم جدولة الزيارة",
                "Schedule Status Header is Not Correct!");

        softAssert.assertEquals(visitDetailsPage.getVisitDateHeader(),
                "تاريخ جدولة الزيارة",
                "Visit Date Header is Not Correct!");


        monthlyVisitsViewPage = visitDetailsPage.clickOnBackBtn();
        softAssert.assertAll();

    }
}
