package com.sumerge.momra.pages;

import com.sumerge.momra.utilities.Utilities;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    @FindBy(xpath = "//*[@id='view-list-license-status-header']//*[contains(@class, 'mat-sort-header-content')]")
    WebElement visitLicenseStatusLabel;
    public static final String VISIT_LICENSE_STATUS_LABEL = "Visit License Status Label";

    //    ****************** 2nd Tab Elements ******************

    @FindBy(id = "scheduled-tab")
    WebElement scheduledVisitsTab;
    public static final String SCHEDULED_VISITS_TITLE = "Scheduled Visits Title";


    @FindBy(xpath = "//*[@id='view-list-visit-date-header']//*[contains(@class, 'mat-sort-header-content')]")
    WebElement scheduledVisitDateLabel;
    public static final String SCHEDULED_VISIT_DATE_LABEL = "Scheduled Visit Date Label";

//    ****************** 3rd Tab Elements ******************

    @FindBy(id = "completed-tab")
    WebElement completedVisitsTab;
    public static final String COMPLETED_VISITS_TITLE = "Completed Visits Title";


    @FindBy(xpath = "//*[@id='view-list-visit-date-header']//*[contains(@class, 'mat-sort-header-content')]")
    WebElement completedVisitDateLabel;
    public static final String COMPLETED_VISIT_DATE_LABEL= "Completed Visit Date Label";

//    ****************** 4th Tab Elements ******************

    @FindBy(id = "rejected-tab")
    WebElement rejectedVisitsTab;
    public static final String REJECTED_VISITS_TITLE = "Rejected Visits Title";


    @FindBy(xpath = "//*[@id='view-list-visit-date-header']//*[contains(@class, 'mat-sort-header-content')]")
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

    @FindBy(xpath = "//*[@id='view-list-visit-number-header']//*[contains(@class, 'mat-sort-header-content')]")
    WebElement viewVisitIdLabel ;
    public static final String VIEW_VISIT_ID_LABEL = "View Visit Id Label";


    @FindBy(xpath = "//*[@id='view-list-site-name-header']//*[contains(@class, 'mat-sort-header-content')]")
    WebElement VisitSiteNameLabel ;
    public static final String VISIT_SITE_NAME_LABEL = "Visit Site Name Label";


    @FindBy(xpath = "//*[@id='view-list-license-id-header']//*[contains(@class, 'mat-sort-header-content')]")
    WebElement visitLicenseIdLabel;
    public static final String VISIT_LICENSE_ID_LABEL = "Visit License Id Label";


    @FindBy(xpath = "//*[@id='view-list-amana-header']//*[contains(@class, 'mat-sort-header-content')]")
    WebElement visitAmanaLabel;
    public static final String VISIT_AMANA_LABEL = "visit Amana Label";

    @FindBy(xpath = "//*[@id='view-list-baladya-header']//*[contains(@class, 'mat-sort-header-content')]")
    WebElement visitBaladyaLabel;
    public static final String VISIT_BALADYA_LABEL  = "visit Baladya Label";

    @FindBy(xpath = "//*[@id='view-list-status-header']//*[contains(@class, 'mat-sort-header-content')]")
    WebElement visitStatusLabel;
    public static final String VISIT_STATUS_LABEL = "Visit Status Label";


    @FindBy(xpath = "//*[@id='view-list-no-0f-beds-header']//*[contains(@class, 'mat-sort-header-content')]")
    WebElement visitBedsNumberLabel;
    public static final String VISITS_BEDS_NUMBER_LABEL = "Visit Number Of Beds Label";


    @FindBy(xpath = "//*[@id='view-list-office-name-header']//*[contains(@class, 'mat-sort-header-content')]")
    WebElement visitEngineeringOfficeNameLabel;
    public static final String VISITS_ENG_OFFICES_NAME_LABEL = "Visit Engineering Office Name Label";

    @FindBy(xpath = "//*[@id='view-list-actions-header']//*[contains(@class, 'actions-header')]")
    WebElement visitActionsLabel;
    public static final String VISITS_ACTIONS_LABEL = "Visit Actions Label";


    @FindBy(xpath = "//*[@id='visits-view-list-actions-header']//*[contains(@class, 'actions-header')]")
    WebElement visitRejectedActionsLabel;
    public static final String VISITS_REJECTED_ACTIONS_LABEL = "Visit Rejected Actions Label";

    /*************Page Action Btns **************/

    @FindBy(id = "display-visit-info")
    WebElement viewMinistryVisitBtn;
    public static final String VIEW_MINISTRY_VISIT_BTN = "View Ministry Visit Btn";

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

    public String getRejectedVisitActionsLabel () {
        return Utilities.waitAndGetWebElementText( visitRejectedActionsLabel, wait);
    }

    public String getScheduledVisitDateLabel () {
        return Utilities.waitAndGetWebElementText( scheduledVisitDateLabel, wait);
    }
    public String getCompletedVisitDateLabel () {
        return Utilities.waitAndGetWebElementText( completedVisitDateLabel, wait);
    }
    public String getVisitDateLabel () {
        return Utilities.waitAndGetWebElementText( visitDateLabel, wait);
    }

    public MinistryVisitDetailsPage clickViewVisitBtn() {
        Utilities.waitAndClickOnWebElement(viewMinistryVisitBtn, wait, driver);
        return new  MinistryVisitDetailsPage (driver);
    }

    public void waitUntilAttachmentLoadingIndicatorDisappear() {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@type='ball-spin-clockwise']")));
        } catch(TimeoutException | NoSuchElementException e) {
            e.printStackTrace();
        }
    }


}


