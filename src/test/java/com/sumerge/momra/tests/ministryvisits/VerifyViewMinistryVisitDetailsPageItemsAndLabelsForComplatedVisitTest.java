package com.sumerge.momra.tests.ministryvisits;

import com.sumerge.momra.pages.AllVisitsViewPage;
import com.sumerge.momra.pages.MinistryVisitDetailsPage;
import com.sumerge.momra.tests.BaseTest;
import com.sumerge.momra.utilities.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class VerifyViewMinistryVisitDetailsPageItemsAndLabelsForComplatedVisitTest extends BaseTest {

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
        allVisitsViewPage.clickOnCompletedVisitsTab();
      ministryVisitDetailsPage =  allVisitsViewPage.clickViewVisitBtn();

        softAssert.assertEquals(ministryVisitDetailsPage.getInspectionClausesTitle(),
                "بنود التفتيش",
                "Inspection Clauses Title is Not Correct!");
//ministryVisitDetailsPage.clickOnExpand1stClause();
        softAssert.assertEquals(ministryVisitDetailsPage.getInspection1stMainClausesTitle(),
                "clause 1",
                "Inspection 1st Main Clauses Title is Not Correct!");

//        softAssert.assertEquals(ministryVisitDetailsPage.getEmptyClauses(),
//                "عفوا، لا يوجد أى بنود تفتيش فرعية مرتبطة ببند التفتيش الرئيسى",
//                "Empty Clause MSG is Not Correct!");

//        ministryVisitDetailsPage.clickOnExpand2ndClause();
        softAssert.assertEquals(ministryVisitDetailsPage.getInspection2ndMainClausesTitle(),
                "clause 2",
                "Inspection 2nd Main Clauses Title is Not Correct!");
//        softAssert.assertEquals(ministryVisitDetailsPage.getChildClauseTitle(),
//                "clause 3",
//                "Child Clause Title is Not Correct!");
//
//        softAssert.assertEquals(ministryVisitDetailsPage.getCompliancy(),
//                "القرار",
//                "Elkarar Label is Not Correct!");
//
//        softAssert.assertEquals(ministryVisitDetailsPage.getCompliantClause(),
//                "امتثال",
//                "Compliant Option is Not Correct!");
//
//        softAssert.assertEquals(ministryVisitDetailsPage.getNonCompliantClause(),
//                "عدم امتثال",
//                "Non Compliant Option is Not Correct!");
//
//        softAssert.assertEquals(ministryVisitDetailsPage.getNotApplicableClause(),
//                "لا ينطبق",
//                "Not Applicable Option is Not Correct!");
//
//        softAssert.assertEquals(ministryVisitDetailsPage.getInspectionViolationCommentsLabel(),
//                "ملاحظات",
//                "Inspection Comment Label is Not Correct!");
//
//        softAssert.assertEquals(ministryVisitDetailsPage.getDetailedViolationAttachmentLabel(),
//                "الصور",
//                "Attachment Label is Not Correct!");




        allVisitsViewPage = ministryVisitDetailsPage.clickOnBackBtn();
        softAssert.assertAll();

    }
}
