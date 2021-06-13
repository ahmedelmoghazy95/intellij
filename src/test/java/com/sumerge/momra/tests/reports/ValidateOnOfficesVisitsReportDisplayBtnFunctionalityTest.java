package com.sumerge.momra.tests.reports;

import com.sumerge.momra.dataproviderobjects.VisitsReportData;
import com.sumerge.momra.pages.VisitsReportPage;
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

public class ValidateOnOfficesVisitsReportDisplayBtnFunctionalityTest extends BaseTest {
    WebDriver driver;
    VisitsReportPage visitsReportPage;
    SoftAssert softAssert;


    @BeforeMethod(alwaysRun = true)
    public synchronized void setUp(Method method, Object testData[], ITestContext ctx) throws InterruptedException, MalformedURLException {
        if (((VisitsReportData) testData[0]).getTestCaseName() != "") {
            ctx.setAttribute(method.getName(), ((VisitsReportData) testData[0]).getTestCaseName());
        } else {
            ctx.setAttribute(method.getName(), "RQM #9959 | Validate on عرض button functionality in offices-reports-ui");
        }
        super.setUp(Constants.OFFICES_VISITS_REPORT_MODULE);
        driver = getDriver();
    }

    @Test(alwaysRun = true, dataProvider = "VisitsReportDataFeed", dataProviderClass = DataProviderSource.class)
    public void ValidateOnOfficesVisitsDisplayBtnFunctionality (VisitsReportData data)  {
        softAssert = new SoftAssert();

        visitsReportPage = new VisitsReportPage(driver);


        visitsReportPage.clickOnFilterAndSelectSecretariat("أمانة مدينة الرياض");
        visitsReportPage.clickOnFilterAndSelectMunicipials("بلدية مدينة الرياض");
        visitsReportPage.clickOnFilterAndSelectActivities("النطاق");
        visitsReportPage.clickOnFilterAndSelectOfficeNames("المكتب السعودي");
        visitsReportPage.clickOnFilterAndSelectStatuses("جديدة");
        visitsReportPage.clickReportsSubmitFilterBtn();

        softAssert.assertEquals(visitsReportPage.getVisitNumberHeader(),
               "رقم الزيارة" ,
                "The Visits Number Header is Not Correct!");
        softAssert.assertEquals(visitsReportPage.getVisitOfficeNameHeader(),
                "اسم المكتب" ,
                "The Visit Office Name Header is Not Correct!");
        softAssert.assertEquals(visitsReportPage.getVisitOfficePhoneHeader(),
                "رقم هاتف المكتب" ,
                "The Visit Office Phone Header is Not Correct!");
        softAssert.assertEquals(visitsReportPage.getVisitLicenseOwnerNameHeader(),
                "إسم مالك السكن" ,
                "The Visit License Owner Name Header is Not Correct!");
        softAssert.assertEquals(visitsReportPage.getVisitLicensePhoneHeader(),
                "رقم الهاتف/ الجوال" ,
                "The Visit License Phone Header is Not Correct!");
        softAssert.assertEquals(visitsReportPage.getVisitAddressHeader(),
                "العنوان" ,
                "The Visit Address Header is Not Correct!");
        softAssert.assertEquals(visitsReportPage.getVisitActivityHeader(),
                "النطاق" ,
                "The Visit Activity Header are is Correct!");
        softAssert.assertEquals(visitsReportPage.getVisitAssignDateHeader(),
                "تاريخ توزيع الزيارة" ,
                "The Visit Assign Date Header is Not Correct!");
        softAssert.assertEquals(visitsReportPage.getVisitDateHeader(),
                "تاريخ تنفيذ الزيارة" ,
                "The Visit Date Header is Not Correct!");
        softAssert.assertEquals(visitsReportPage.getVisitStatusHeader(),
                "الحالة" ,
                "The Visit Status Header is Not Correct!");


        softAssert.assertEquals(visitsReportPage.getFirstVisitNumber(),
                data.getVisitNumber(),
                "The First Visit Number is Not Correct!");
        softAssert.assertEquals(visitsReportPage.getFirstVisitOfficeName(),
                data.getVisitOfficeName(),
                "The First Visit Office Name is Not Correct!");
        softAssert.assertEquals(visitsReportPage.getFirstVisitOfficePhone(),
                data.getVisitOfficePhone(),
                "The First Visit Office Phone is Not Correct!");
        softAssert.assertEquals(visitsReportPage.getFirstVisitLicenseOwnerName(),
                data.getVisitLicenseOwnerName(),
                "The First Visit License Owner Name is Not Correct!");
        softAssert.assertEquals(visitsReportPage.getFirstVisitLicensePhone(),
                data.getVisitLicensePhone(),
                "The First Visit License Phone is Not Correct!");
        softAssert.assertEquals(visitsReportPage.getFirstVisitAddress(),
                data.getVisitAddress(),
                "The First Visit Address is Not Correct!");
        softAssert.assertEquals(visitsReportPage.getFirstVisitActivity(),
                data.getVisitActivity(),
                "The First Visit Activity is Not Correct!");
        softAssert.assertEquals(visitsReportPage.getFirstVisitAssignDate(),
                data.getVisitAssignDate(),
                "The First Visit Assign Date is Not Correct!");
        softAssert.assertEquals(visitsReportPage.getFirstVisitDate(),
                data.getVisitDate(),
                "The First Visit Date is Not Correct!");
        softAssert.assertEquals(visitsReportPage.getFirstVisitStatus(),
                data.getVisitStatus(),
                "The First Visit Status is Not Correct!");

        softAssert.assertAll();
    }
}
