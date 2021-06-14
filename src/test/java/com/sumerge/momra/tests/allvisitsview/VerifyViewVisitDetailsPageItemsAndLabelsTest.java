package com.sumerge.momra.tests.allvisitsview;

import com.sumerge.momra.pages.AllVisitsViewPage;
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
    AllVisitsViewPage allVisitsViewPage;
    VisitDetailsPage visitDetailsPage;
    SoftAssert softAssert;

    @BeforeMethod(alwaysRun = true)
    public synchronized void setUp(Method method, ITestContext ctx) throws InterruptedException, MalformedURLException {
        {
            ctx.setAttribute(method.getName(), "RQM #10350 | Verify visit details view page items/labels");
        }
        super.setUp(Constants.VIEW_ALL_VISITS_PAGE);
        driver = getDriver();
    }

    @Test(alwaysRun = true)
    public void VerifyViewVisitDetailsPageItemsAndLabels () {
        softAssert = new SoftAssert();

        allVisitsViewPage = new AllVisitsViewPage(driver);

        allVisitsViewPage.clickViewVisitBtn();

        softAssert.assertEquals(visitDetailsPage.getPageTitle(),
                "تفاصيل زيارة" ,
                "Engineering Office Header is Not Correct!");

        softAssert.assertEquals(visitDetailsPage.getSiteNameLabel(),
                "إسم المنشأة" ,
                "Page title is Not Correct!");

        softAssert.assertEquals(visitDetailsPage.getAddressLabel(),
                "العنوان" ,
                "1st tab title is Not Correct!");

        softAssert.assertEquals(visitDetailsPage.getAmanaNameLabel(),
                "الأمانة" ,
                "2nd tab title is Not Correct!");

        softAssert.assertEquals(visitDetailsPage.getBaladyaNameLabel(),
                "البلدية" ,
                "3rd tab title is Not Correct!");

        softAssert.assertEquals(visitDetailsPage.getBedsNumberLabel(),
                "عدد الأسرة" ,
                "4th tab title is Not Correct!");

        softAssert.assertEquals(visitDetailsPage.getDistrictNameLabel(),
                "الحى" ,
                "Visit ID Header is Not Correct!");

        softAssert.assertEquals(visitDetailsPage.getLicenseIdLabel(),
                "رقم الرخصة" ,
                "Site Name Header is Not Correct!");

        softAssert.assertEquals(visitDetailsPage.getLicensePhoneLabel(),
                "رقم جوال صاحب الرخصة" ,
                "License ID Header isNot Correct!");

        softAssert.assertEquals(visitDetailsPage.getLicenseStatusLabel(),
                "حالة الرخصة" ,
                "License Status Header is Not Correct!");

        softAssert.assertEquals(visitDetailsPage.getOwnerIdLabel(),
                "رقم هوية صاحب الرخصة" ,
                "Amana Header is Not Correct!");

        softAssert.assertEquals(visitDetailsPage.getLicenseExpiryDateLabel(),
                "تاريخ إنتهاء الرخصة" ,
                "Baladya Header is Not Correct!");

        softAssert.assertEquals(visitDetailsPage.getLicenseIssueDateLabel(),
                "تاريخ إصدار الرخصة" ,
                "Visit Status Header is Not Correct!");

        softAssert.assertEquals(visitDetailsPage.getLicenseOwnerNameLabel(),
                "إسم صاحب الرخصة" ,
                "No. of beds Header is Not Correct!");


        softAssert.assertAll();

    }
}
