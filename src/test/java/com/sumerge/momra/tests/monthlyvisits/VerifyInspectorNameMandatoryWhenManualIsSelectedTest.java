package com.sumerge.momra.tests.monthlyvisits;


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

public class VerifyInspectorNameMandatoryWhenManualIsSelectedTest extends BaseTest {

    WebDriver driver;
    VisitDetailsPage visitDetailsPage;
    SoftAssert softAssert;

    @BeforeMethod(alwaysRun = true)
    public synchronized void setUp(Method method, ITestContext ctx) throws InterruptedException, MalformedURLException {
        {
            ctx.setAttribute(method.getName(), "RQM #10671 | VerifyInspectorNameMandatoryWhenManualIsSelected ");
        }
        super.setUp(Constants.VIEW_VISIT_DETAILS);
        driver = getDriver();
    }

    @Test(alwaysRun = true)
    public void VerifyInspectorNameMandatoryWhenManualIsSelected () {
        softAssert = new SoftAssert();


        visitDetailsPage = new VisitDetailsPage (driver);
        visitDetailsPage.clickViewVisitBtn();
        visitDetailsPage.clickOnIsVisitScheduledYes();


        softAssert.assertEquals(visitDetailsPage.getVisitStatusScheduled(),
                "مجدولة",
                "Visit Status is Not Correct!");
        visitDetailsPage.insertVisitScheduledDate("07/30/2021");
        visitDetailsPage.selectVisitTimeFrom11To12();
        visitDetailsPage.clickOnInspectorAllocationTypeManual();

        visitDetailsPage.insertNotesText("Text");
        visitDetailsPage.clickOnSaveBtn();
        softAssert.assertEquals(visitDetailsPage.getDisplayMSGText(),
                "عفوا ، يجب إستكمال جميع الحقول الإجبارية." ,
                "Mandatory Field Error MSG is Not Correct!");
        softAssert.assertAll();

    }
}
