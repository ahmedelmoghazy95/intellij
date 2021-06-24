package com.sumerge.momra.tests.allvisitsview.visitdetails;


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

public class VerifyVisitStatusIsSetAutomaticallyToScheduledWhenIfYesScheduledIsSelectedTest extends BaseTest {

    WebDriver driver;
    VisitDetailsPage visitDetailsPage;
    SoftAssert softAssert;

    @BeforeMethod(alwaysRun = true)
    public synchronized void setUp(Method method, ITestContext ctx) throws InterruptedException, MalformedURLException {
        {
            ctx.setAttribute(method.getName(), "RQM #10670 | VerifyVisitStatusIsSetAutomaticallyToScheduledWhenIfYesScheduledIsSelectedTest");
        }
        super.setUp(Constants.VIEW_VISIT_DETAILS);
        driver = getDriver();
    }

    @Test(alwaysRun = true)
    public void VerifyVisitStatusIsSetAutomaticallyToScheduledWhenIfYesScheduledIsSelected () {
        softAssert = new SoftAssert();


        visitDetailsPage = new VisitDetailsPage (driver);
        visitDetailsPage.clickViewVisitBtn();
        visitDetailsPage.clickOnIsVisitScheduledYes();


        softAssert.assertEquals(visitDetailsPage.getVisitStatusScheduled(),
                "مجدولة",
                "Visit Status is Not Correct!");
        visitDetailsPage.clickOnIsVisitScheduledNo();
        visitDetailsPage.selectVisitStatusRejected();
        softAssert.assertEquals(visitDetailsPage.getVisitStatusRejected(),
                "مرفوضة",
                "Visit Status is Not Correct!");

        softAssert.assertAll();

    }
}
