package com.sumerge.momra.pages;

import com.sumerge.momra.utilities.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllVisitsViewPage extends BasePage {

    public AllVisitsViewPage(WebDriver driver) {
        super(driver);
        checkCorrectPage("visit-requests-page-title", "This is Not the Correct View All Offices Visits Page!");
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "visit-requests-page-title")
    WebElement pageTitle;
    public static final String PAGE_TITLE = "Page Title";

//    ****************** 1st Tab Elements ******************

    @FindBy(id = "pending-tab")
    WebElement newVisitsTab;
    public static final String NEW_VISITS_TITLE = "New Visits Title";

    @FindBy(id = "View-list-license-status-header")
    WebElement visitLicenseStatusLabel;
    public static final String VISIT_LICENSE_STATUS_LABEL = "Visit License Status Label";

    //    ****************** 2nd Tab Elements ******************

    @FindBy(id = "scheduled-tab")
    WebElement scheduledVisitsTab;
    public static final String SCHEDULED_VISITS_TITLE = "Scheduled Visits Title";

    @FindBy(id = "view-list-visit-date-header")
    WebElement scheduledVisitDateLabel;
    public static final String SCHEDULED_VISIT_DATE_LABEL = "Scheduled Visit Date Label";

//    ****************** 3rd Tab Elements ******************

    @FindBy(id = "")
    WebElement completedVisitsTab;
    public static final String COMPLETED_VISITS_TITLE = "Completed Visits Title";

    @FindBy(id = "view-list-visit-date-header")
    WebElement completedVisitDateLabel;
    public static final String COMPLETED_VISIT_DATE_LABEL= "Completed Visit Date Label";

//    ****************** 4th Tab Elements ******************

    @FindBy(id = "rejected-tab")
    WebElement rejectedVisitsTab;
    public static final String REJECTED_VISITS_TITLE = "Rejected Visits Title";

    @FindBy(id = "view-list-visit-date-header")
    WebElement visitDateLabel;
    public static final String VISIT_DATE_LABEL = "Visit Date Label";


    //    ****************** Click on tabs ******************
    public void clickOnNewVisitsTab () {Utilities.waitAndClickOnWebElement(newVisitsTab, wait, driver);
    }
    public void clickOnCompletedVisitsTab () {Utilities.waitAndClickOnWebElement(completedVisitsTab, wait, driver);
    }
    public void clickOnRejectedVisitsTab () {Utilities.waitAndClickOnWebElement(rejectedVisitsTab, wait, driver);
    }
    public void clickOnScheduledVisitsTab () {Utilities.waitAndClickOnWebElement(scheduledVisitsTab, wait, driver);
    }

//  ****************** Table Common Headers IDs ******************

    @FindBy(id = "view-list-visit-id-header")
    WebElement viewVisitIdLabel ;
    public static final String VIEW_VISIT_ID_LABEL = "View Visit Id Label";

    @FindBy(id = "view-list-site-name-header")
    WebElement VisitSiteNameLabel ;
    public static final String VISIT_SITE_NAME_LABEL = "Visit Site Name Label";

    @FindBy(id = "view-list-license-id-header")
    WebElement visitLicenseIdLabel;
    public static final String VISIT_LICENSE_ID_LABEL = "Visit License Id Label";


    @FindBy(id = "view-list-amana-header")
    WebElement visitAmanaLabel;
    public static final String VISIT_AMANA_LABEL = "visit Amana Label";

    @FindBy(id = "view-list-baladya-header")
    WebElement visitBaladyaLabel;
    public static final String VISIT_BALADYA_LABEL  = "visit Baladya Label";

    @FindBy(id = "view-list-status-header")
    WebElement visitStatusLabel;
    public static final String VISIT_STATUS_LABEL = "Visit Status Label";

    @FindBy(id = "view-list-no-0f-beds-header")
    WebElement visitBedsNumberLabel;
    public static final String VISITS_BEDS_NUMBER_LABEL = "Visit Number Of Beds Label";

    @FindBy(id = "view-list-office-name-header")
    WebElement visitEngineeringOfficeNameLabel;
    public static final String VISITS_ENG_OFFICES_NAME_LABEL = "Visit Engineering Office Name Label";

    @FindBy(id = "view-list-actions-header")
    WebElement visitActionsLabel;
    public static final String VISITS_ACTIONS_LABEL = "Visit Actions Label";

    /*************Getters For Page Elements **************/

    public String getPageTitle () {
        return Utilities.waitAndGetWebElementText( pageTitle, wait);
    }
    public String getNewVisitsTab () {
        return Utilities.waitAndGetWebElementText( newVisitsTab, wait);
    }
    public String getScheduledVisitsTab () {
        return Utilities.waitAndGetWebElementText( scheduledVisitsTab, wait);
    }
    public String getCompletedVisitsTab () {
        return Utilities.waitAndGetWebElementText( completedVisitsTab, wait);
    }
    public String getRejectedVisitsTab () {
        return Utilities.waitAndGetWebElementText( rejectedVisitsTab, wait);
    }
    public String getViewVisitIdLabel () {
        return Utilities.waitAndGetWebElementText( viewVisitIdLabel, wait);
    }
    public String getVisitSiteNameLabel () {
        return Utilities.waitAndGetWebElementText( VisitSiteNameLabel, wait);
    }
    public String getVisitLicenseIdLabel () {
        return Utilities.waitAndGetWebElementText( visitLicenseIdLabel, wait);
    }
    public String getVisitLicenseStatusLabel () {
        return Utilities.waitAndGetWebElementText( visitLicenseStatusLabel, wait);
    }
    public String getVisitAmanaLabel () {
        return Utilities.waitAndGetWebElementText( visitAmanaLabel, wait);
    }
    public String getVisitBaladyaLabel () {
        return Utilities.waitAndGetWebElementText( visitBaladyaLabel, wait);
    }
    public String getVisitStatusLabel () {
        return Utilities.waitAndGetWebElementText( visitStatusLabel, wait);
    }
    public String getVisitBedsNumberLabel () {
        return Utilities.waitAndGetWebElementText( visitBedsNumberLabel, wait);
    }
    public String getVisitEngineeringOfficeNameLabel () {
        return Utilities.waitAndGetWebElementText( visitEngineeringOfficeNameLabel, wait);
    }
    public String getVisitActionsLabel () {
        return Utilities.waitAndGetWebElementText( visitActionsLabel, wait);
    }

    public String getScheduledVisitDateLabel () {
        return Utilities.waitAndGetWebElementText( visitActionsLabel, wait);
    }
    public String getCompletedVisitDateLabel () {
        return Utilities.waitAndGetWebElementText( visitActionsLabel, wait);
    }
    public String getVisitDateLabel () {
        return Utilities.waitAndGetWebElementText( visitActionsLabel, wait);
    }


}


