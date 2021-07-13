package com.sumerge.momra.tests.ministryvisits;

import com.sumerge.momra.pages.AllVisitsViewPage;
import com.sumerge.momra.pages.MinistryVisitDetailsPage;
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

public class VerifyViewMinistryVisitDetailsPageItemsAndLabelsTest extends BaseTest {

    WebDriver driver;
    AllVisitsViewPage allVisitsViewPage;
    MinistryVisitDetailsPage ministryVisitDetailsPage;
    SoftAssert softAssert;

    @BeforeMethod(alwaysRun = true)
    public synchronized void setUp(Method method, ITestContext ctx) throws InterruptedException, MalformedURLException {
        {
            ctx.setAttribute(method.getName(), "RQM #11031 #11037 | Verify ministry visit details view page items/labels + back btn functionality");
        }
        super.setUp(Constants.VIEW_ALL_VISITS_PAGE);
        driver = getDriver();
    }

    @Test(alwaysRun = true)
    public void VerifyViewMinistryVisitDetailsPageItemsAndLabels () {
        softAssert = new SoftAssert();

        allVisitsViewPage = new AllVisitsViewPage (driver);
      ministryVisitDetailsPage =  allVisitsViewPage.clickViewVisitBtn();
        softAssert.assertEquals(ministryVisitDetailsPage.getPageTitle(),
                "تفاصيل زيارة",
                "Page title is Not Correct!");

        softAssert.assertEquals(ministryVisitDetailsPage.getSiteNameLabel(),
                "إسم المنشأة",
                "Site name label is Not Correct!");

        softAssert.assertEquals(ministryVisitDetailsPage.getAddressLabel(),
                "العنوان",
                "Address label is Not Correct!");

        softAssert.assertEquals(ministryVisitDetailsPage.getAmanaNameLabel(),
                "الأمانة",
                "Amana name label is Not Correct!");

        softAssert.assertEquals(ministryVisitDetailsPage.getBaladyaNameLabel(),
                "البلدية",
                "Balady name label is Not Correct!");

        softAssert.assertEquals(ministryVisitDetailsPage.getBedsNumberLabel(),
                "عدد الأسرة",
                "Number of beds label is Not Correct!");

        softAssert.assertEquals(ministryVisitDetailsPage.getDistrictNameLabel(),
                "الحى",
                "District name label is Not Correct!");

        softAssert.assertEquals(ministryVisitDetailsPage.getLicenseIdLabel(),
                "رقم الرخصة",
                "License Id label is Not Correct!");

        softAssert.assertEquals(ministryVisitDetailsPage.getLicensePhoneLabel(),
                "رقم جوال صاحب الرخصة",
                "License phone label is Not Correct!");

        softAssert.assertEquals(ministryVisitDetailsPage.getLicenseStatusLabel(),
                "حالة الرخصة",
                "License Status label is Not Correct!");

        softAssert.assertEquals(ministryVisitDetailsPage.getOwnerIdLabel(),
                "رقم هوية صاحب الرخصة",
                "Owner Id label is Not Correct!");

        softAssert.assertEquals(ministryVisitDetailsPage.getLicenseExpiryDateLabel(),
                "تاريخ إنتهاء الرخصة",
                "License expiry date label is Not Correct!");

        softAssert.assertEquals(ministryVisitDetailsPage.getLicenseIssueDateLabel(),
                "تاريخ إصدار الرخصة",
                "license issue date label is Not Correct!");

        softAssert.assertEquals(ministryVisitDetailsPage.getLicenseOwnerNameLabel(),
                "إسم صاحب الرخصة",
                "license owner name label is Not Correct!");

        softAssert.assertEquals(ministryVisitDetailsPage.getScheduleVisitSectionTitle(),
                "جدولة الزيارة",
                " Schedule Visit Section Title is Not Correct!");

        softAssert.assertEquals(ministryVisitDetailsPage.getVisitStatusLabel(),
                "حالة الزيارة",
                " Visit status label is Not Correct!");

        softAssert.assertEquals(ministryVisitDetailsPage.getIsVisitScheduledLabel(),
                "تم جدولة الزيارة",
                " Visit Scheduled label is Not Correct!");

        softAssert.assertEquals(ministryVisitDetailsPage.getVisitScheduledDateLabel(),
                "تاريخ جدولة الزيارة",
                "Visit Scheduled Date label is Not Correct!");

        softAssert.assertEquals(ministryVisitDetailsPage.getVisitScheduledTimeLabel(),
                "وقت الزيارة",
                "Visit Scheduled Time label is Not Correct!");

        softAssert.assertEquals(ministryVisitDetailsPage.getInspectorAllocationTypeLabel(),
                "إسناد الزيارة",
                "Inspector Allocation Type label is Not Correct!");



        softAssert.assertEquals(ministryVisitDetailsPage.getVisitNotesLabel(),
                "ملاحظات",
                "Notes label is Not Correct!");


        softAssert.assertEquals(ministryVisitDetailsPage.getVisitHistoryTitle(),
                "السجل السابق لجدولة الزيارة",
                "Visit History Title is Not Correct!");

        softAssert.assertEquals(ministryVisitDetailsPage.getNotesHeader(),
                "ملاحظات",
                "Notes header is Not Correct!");

        softAssert.assertEquals(ministryVisitDetailsPage.getStatusHeader(),
                "حالة الزيارة",
                "Status header is Not Correct!");

        softAssert.assertEquals(ministryVisitDetailsPage.getTimestampHeader(),
                "الوقت و التاريخ",
                "Timestamp header is Not Correct!");

        softAssert.assertEquals(ministryVisitDetailsPage.getUserHeader(),
                "إسم المستخدم",
                "User header is Not Correct!");

        softAssert.assertEquals(ministryVisitDetailsPage.getInspectorNameHeader(),
                "إسم المراقب",
                "Inspector Name header is Not Correct!");

        softAssert.assertEquals(ministryVisitDetailsPage.getScheduleStatusHeader(),
                "تم جدولة الزيارة",
                "Schedule Status header is Not Correct!");

        softAssert.assertEquals(ministryVisitDetailsPage.getVisitDateHeader(),
                "تاريخ جدولة الزيارة",
                "Visit Date header is Not Correct!");

        allVisitsViewPage = ministryVisitDetailsPage.clickOnBackBtn();
        softAssert.assertAll();

    }
}
