package com.sumerge.momra.pages;

import com.sumerge.momra.utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MinistryVisitDetailsPage extends BasePage {


    public MinistryVisitDetailsPage(WebDriver driver) {
        super(driver);
        checkCorrectPage("page-title", "This is Not the Correct Visit Details Page!");
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "page-title")
    WebElement pageTitle;

    /****************** Visit Details IDs ******************/

    @FindBy(id = "site-name")
    WebElement siteNameLabel;


    @FindBy(id = "license-id")
    WebElement LicenseIdLabel;


    @FindBy(id = "license-status")
    WebElement licenseStatusLabel;


    @FindBy(id = "license-issue-date")
    WebElement licenseIssueDateLabel;

    @FindBy(id = "license-expiry-date")
    WebElement licenseExpiryDateLabel;

    @FindBy(id = "amana-name")
    WebElement amanaNameLabel;
    public static final String AMANA_NAME_LABEL = "Amana Name Label";

    @FindBy(id = "baladya-name")
    WebElement baladyaNameLabel;


    @FindBy(id = "district-name")
    WebElement districtNameLabel;


    @FindBy(id = "number-of-beds")
    WebElement bedsNumberLabel;


    @FindBy(id = "license-owner-name")
    WebElement licenseOwnerNameLabel;


    @FindBy(id = "owner-id")
    WebElement ownerIdLabel;


    @FindBy(id = "license-phone")
    WebElement licensePhoneLabel;


    @FindBy(id = "address")
    WebElement addressLabel;


    /****************** Visit Re/scheduling section IDs ******************/

    @FindBy(id = "visit-rescheduling-section-title")
    WebElement scheduleVisitSectionTitle;

    @FindBy(id = "is-visit-rescheduled")
    WebElement isVisitScheduledLabel;


    @FindBy(id = "visit-status")
    WebElement visitStatusLabel;


    @FindBy(id = "visit-scheduled-date")
    WebElement visitScheduledDateLabel;


    @FindBy(id = "visit-scheduled-time")
    WebElement visitScheduledTimeLabel;


    @FindBy(id = "inspector-allocation-type")
    WebElement inspectorAllocationTypeLabel;


    @FindBy(id = "visit-notes-label")
    WebElement visitNotesLabel;


    /****************** Visit History IDs ******************/
    @FindBy(id = "visit-history-title")
    WebElement visitHistoryTitle;


    @FindBy(id = "timestamp")
    WebElement timestampHeader;


    @FindBy(id = "user")
    WebElement userHeader;


    @FindBy(id = "scheduling-status")
    WebElement scheduleStatusHeader;


    @FindBy(id = "status")
    WebElement statusHeader;


    @FindBy(id = "visit-date")
    WebElement visitDateHeader;


    @FindBy(id = "inspector-name")
    WebElement inspectorNameHeader;


    @FindBy(id = "notes")
    WebElement notesHeader;


    @FindBy(id = "visit-details-back-btn")
    WebElement visitDetailsBackBtn;


    /****************** Visit Clauses Section IDs ******************/

    @FindBy(id = "inspection-clauses-title")
    WebElement inspectionClausesTitle;


    @FindBy(id = "mat-expansion-panel-header-0")
    WebElement inspection1stMainClauseTitle;

    @FindBy(xpath = "//mat-panel-title[@id='inspection-main-clause-title'and contains(text(), 'clause 2' )]")
    WebElement inspection2ndMainClauseTitle;


    /*************Getters For Visit Details Elements **************/
    public String getPageTitle() {
        return Utilities.waitAndGetWebElementText(pageTitle, wait);
    }

    public String getSiteNameLabel() {
        return Utilities.waitAndGetWebElementText(siteNameLabel, wait);
    }

    public String getLicenseIdLabel() {
        return Utilities.waitAndGetWebElementText(LicenseIdLabel, wait);
    }

    public String getLicenseStatusLabel() {
        return Utilities.waitAndGetWebElementText(licenseStatusLabel, wait);
    }

    public String getLicenseIssueDateLabel() {
        return Utilities.waitAndGetWebElementText(licenseIssueDateLabel, wait);
    }

    public String getLicenseExpiryDateLabel() {
        return Utilities.waitAndGetWebElementText(licenseExpiryDateLabel, wait);
    }

    public String getAmanaNameLabel() {
        return Utilities.waitAndGetWebElementText(amanaNameLabel, wait);
    }

    public String getBaladyaNameLabel() {
        return Utilities.waitAndGetWebElementText(baladyaNameLabel, wait);
    }

    public String getDistrictNameLabel() {
        return Utilities.waitAndGetWebElementText(districtNameLabel, wait);
    }

    public String getBedsNumberLabel() {
        return Utilities.waitAndGetWebElementText(bedsNumberLabel, wait);
    }

    public String getLicenseOwnerNameLabel() {
        return Utilities.waitAndGetWebElementText(licenseOwnerNameLabel, wait);
    }

    public String getOwnerIdLabel() {
        return Utilities.waitAndGetWebElementText(ownerIdLabel, wait);
    }

    public String getLicensePhoneLabel() {
        return Utilities.waitAndGetWebElementText(licensePhoneLabel, wait);
    }

    public String getAddressLabel() {
        return Utilities.waitAndGetWebElementText(addressLabel, wait);
    }

    /*************Getters For Visit Scheduling Section **************/

    public String getScheduleVisitSectionTitle() {
        return Utilities.waitAndGetWebElementText(scheduleVisitSectionTitle, wait);
    }

    public String getVisitStatusLabel() {
        return Utilities.waitAndGetWebElementText(visitStatusLabel, wait);
    }

    public String getIsVisitScheduledLabel() {
        return Utilities.waitAndGetWebElementText(isVisitScheduledLabel, wait);
    }

    public String getVisitScheduledDateLabel() {
        return Utilities.waitAndGetWebElementText(visitScheduledDateLabel, wait);
    }

    public String getVisitScheduledTimeLabel() {
        return Utilities.waitAndGetWebElementText(visitScheduledTimeLabel, wait);
    }

    public String getInspectorAllocationTypeLabel() {
        return Utilities.waitAndGetWebElementText(inspectorAllocationTypeLabel, wait);
    }


    public String getVisitNotesLabel() {
        return Utilities.waitAndGetWebElementText(visitNotesLabel, wait);
    }


    /*************Getters For Visit History Section **************/
    public String getVisitHistoryTitle() {
        return Utilities.waitAndGetWebElementText(visitHistoryTitle, wait);
    }

    public String getTimestampHeader() {
        return Utilities.waitAndGetWebElementText(timestampHeader, wait);
    }

    public String getUserHeader() {
        return Utilities.waitAndGetWebElementText(userHeader, wait);
    }

    public String getScheduleStatusHeader() {
        return Utilities.waitAndGetWebElementText(scheduleStatusHeader, wait);
    }

    public String getStatusHeader() {
        return Utilities.waitAndGetWebElementText(statusHeader, wait);
    }

    public String getVisitDateHeader() {
        return Utilities.waitAndGetWebElementText(visitDateHeader, wait);
    }

    public String getInspectorNameHeader() {
        return Utilities.waitAndGetWebElementText(inspectorNameHeader, wait);
    }

    public String getNotesHeader() {
        return Utilities.waitAndGetWebElementText(notesHeader, wait);
    }

    public AllVisitsViewPage clickOnBackBtn() {
        Utilities.waitAndClickOnWebElement(visitDetailsBackBtn, wait, driver);
        return new AllVisitsViewPage(driver);
    }


    /*************Getters For Visit Clauses Elements **************/

    public String getInspection1stMainClausesTitle() {
        return Utilities.waitAndGetWebElementText(inspection1stMainClauseTitle, wait);
    }

    public String getInspection2ndMainClausesTitle() {
        return Utilities.waitAndGetWebElementText(inspection2ndMainClauseTitle, wait);
    }

    public String getInspectionClausesTitle() {
        return Utilities.waitAndGetWebElementText(inspectionClausesTitle, wait);
    }


}



