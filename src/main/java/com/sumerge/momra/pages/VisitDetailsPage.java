package com.sumerge.momra.pages;

import com.sumerge.momra.utilities.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VisitDetailsPage extends BasePage {


    public VisitDetailsPage(WebDriver driver) {
        super(driver);
        checkCorrectPage("visit-requests-page-title", "This is Not the Correct Visit Details Page!");
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "page-title")
    WebElement pageTitle;
    public static final String PAGE_TITLE = "Page Title";

//    ****************** Visit Details IDs ******************

    @FindBy(id = "site-name")
    WebElement siteNameLabel;
    public static final String SITE_NAME_LABEL = "Site Name Label";

    @FindBy(id = "license-id")
    WebElement LicenseIdLabel;
    public static final String LICENSE_ID_LABEL = "License Id Label";

    @FindBy(id = "license-status")
    WebElement licenseStatusLabel;
    public static final String LICENSE_STATUS_LABEL = "License Status Label";

    @FindBy(id = "license-issue-date")
    WebElement licenseIssueDateLabel;
    public static final String LICENSE_ISSUE_DATE_LABEL = "License Issue Date Label";

    @FindBy(id = "license-expiry-date")
    WebElement licenseExpiryDateLabel;
    public static final String LICENSE_EXPIRY_DATE_LABEL = "License Expiry Date Label";

    @FindBy(id = "amana-name")
    WebElement amanaNameLabel;
    public static final String AMANA_NAME_LABEL = "Amana Name Label";

    @FindBy(id = "baladya-name")
    WebElement baladyaNameLabel;
    public static final String BALADYA_NAME_LABEL  = "Baladya Name Label";

    @FindBy(id = "district-name")
    WebElement districtNameLabel;
    public static final String DISTRICT_NAME_LABEL = "District Name Label";

    @FindBy(id = "number-of-beds")
    WebElement bedsNumberLabel;
    public static final String BEDS_NUMBER_LABEL = "Number Of Beds Label";


    @FindBy(id = "license-owner-name")
    WebElement licenseOwnerNameLabel;
    public static final String LICENSE_OWNER_NAME_LABEL = "License Owner Name Label";

    @FindBy(id = "owner-id")
    WebElement ownerIdLabel;
    public static final String OWNER_ID_LABEL = "Owner Id Label";

    @FindBy(id = "license-phone")
    WebElement licensePhoneLabel;
    public static final String LICENSE_PHONE_LABEL = "License Phone Label";

    @FindBy(id = "address")
    WebElement addressLabel;
    public static final String ADDRESS_LABEL = "Address Label";

    //    ****************** Visit Re/scheduling section IDs ******************

    @FindBy(id = "visit-rescheduling-section-title")
    WebElement scheduleVisitSectionTitle;
    public static final String SCHEDULE_VISIT_SECTION_TITLE = "Schedule Visit Section Title";

    @FindBy(id = "is-visit-rescheduled")
    WebElement isVisitScheduledLabel;
    public static final String IS_VISIT_SCHEDULED_LABEL = "Is Visit Scheduled Label";

    @FindBy(id = "visit-status")
    WebElement visitStatusLabel;
    public static final String VISIT_STATUS_LABEL = "Visit Status Label";

    @FindBy(id = "visit-scheduled-date")
    WebElement visitScheduledDateLabel;
    public static final String VISIT_SCHEDULED_DATE_LABEL = "Visit Scheduled Date Label";

    @FindBy(id = "visit-scheduled-time")
    WebElement visitScheduledTimeLabel;
    public static final String VISIT_SCHEDULED_TIME_LABEL = "Visit Scheduled Time Label";

    @FindBy(id = "inspector-allocation-type")
    WebElement inspectorAllocationTypeLabel ;
    public static final String INSPECTOR_ALLOCATION_TYPE_LABEL = "Inspector Allocation Type Label";

    @FindBy(id = "visit-inspector-name")
    WebElement visitInspectorNameLabel;
    public static final String VISIT_INSPECTOR_NAME_LABEL = "Visit Inspector Name Label";

    @FindBy(id = "visit-notes")
    WebElement visitNotesLabel;
    public static final String VISIT_NOTES_LABEL = "Visit Notes Label";

    @FindBy(id = "edit-visit-save-btn")
    WebElement editVisitSaveBtn;
    public static final String EDIT_VISIT_SAVE_BTN = "Edit Visit Save Btn";

    //    ****************** Visit History IDs ******************
    @FindBy(id = "visit-history-title")
    WebElement visitHistoryTitle;
    public static final String VISIT_HISTORY_TITLE  = "visitHistoryTitle";

    @FindBy(id = "view-list-timestamp")
    WebElement timestampHeader;
    public static final String TIMESTAMP_HEADER = "Timestamp Header";

    @FindBy(id = "view-list-user")
    WebElement userHeader;
    public static final String USER_HEADER = "User Header";

    @FindBy(id = "view-list-visit-scheduling-status")
    WebElement scheduleStatusHeader;
    public static final String  SCHEDULE_STATUS_HEADER= "Schedule Status Header";

    @FindBy(id = "view-list-status")
    WebElement statusHeader;
    public static final String STATUS_HEADER = "Status Header";

    @FindBy(id = "view-list-visit-date")
    WebElement visitDateHeader;
    public static final String VISIT_DATE_HEADER = "visit Date Header";

    @FindBy(id = "view-list-inspector-name")
    WebElement inspectorNameHeader;
    public static final String INSPECTOR_NAME_HEADER = "Inspector Name Header";

    @FindBy(id = "view-list-notes")
    WebElement notesHeader;
    public static final String NOTES_HEADER = "Notes Header";

    @FindBy(id = "visit-details-back-btn")
    WebElement visitDetailsBackBtn;
    public static final String VISIT_DETAILS_BACK_BTN = "visit Details Back Btn";

    /*************Page Action Btns **************/

    @FindBy(id = "display-visit-info")
    WebElement viewVisitBtn;
    public static final String VIEW_VISIT_BTN = "View Visit Btn";

    /*************Getters For Visit Details Elements **************/

    public String getPageTitle () {
        return Utilities.waitAndGetWebElementText( pageTitle, wait);
    }
    public String getSiteNameLabel () {
        return Utilities.waitAndGetWebElementText( siteNameLabel, wait);
    }
    public String getLicenseIdLabel () {
        return Utilities.waitAndGetWebElementText( LicenseIdLabel, wait);
    }
    public String getLicenseStatusLabel () {
        return Utilities.waitAndGetWebElementText( licenseStatusLabel, wait);
    }
    public String getLicenseIssueDateLabel () {
        return Utilities.waitAndGetWebElementText( licenseIssueDateLabel, wait);
    }
    public String getLicenseExpiryDateLabel () {
        return Utilities.waitAndGetWebElementText( licenseExpiryDateLabel, wait);
    }
    public String getAmanaNameLabel () {
        return Utilities.waitAndGetWebElementText( amanaNameLabel, wait);
    }
    public String getBaladyaNameLabel () {
        return Utilities.waitAndGetWebElementText( baladyaNameLabel, wait);
    }
    public String getDistrictNameLabel () {
        return Utilities.waitAndGetWebElementText( districtNameLabel, wait);
    }
    public String getBedsNumberLabel () {
        return Utilities.waitAndGetWebElementText( bedsNumberLabel, wait);
    }
    public String getLicenseOwnerNameLabel () {
        return Utilities.waitAndGetWebElementText( licenseOwnerNameLabel, wait);
    }
    public String getOwnerIdLabel () {
        return Utilities.waitAndGetWebElementText( ownerIdLabel, wait);
    }
    public String getLicensePhoneLabel () {
        return Utilities.waitAndGetWebElementText( licensePhoneLabel, wait);
    }
    public String getAddressLabel () {
        return Utilities.waitAndGetWebElementText( addressLabel, wait);
    }

    /*************Getters For Visit Scheduling Section **************/

    public String getScheduleVisitSectionTitle () {
        return Utilities.waitAndGetWebElementText( scheduleVisitSectionTitle, wait);
    }
    public String getVisitStatusLabel () {
        return Utilities.waitAndGetWebElementText( visitStatusLabel, wait);
    }
    public String getIsVisitScheduledLabel () {
        return Utilities.waitAndGetWebElementText( isVisitScheduledLabel, wait);
    }
    public String getVisitScheduledDateLabel () {
        return Utilities.waitAndGetWebElementText( visitScheduledDateLabel, wait);
    }
    public String getVisitScheduledTimeLabel () {
        return Utilities.waitAndGetWebElementText( visitScheduledTimeLabel, wait);
    }
    public String getInspectorAllocationTypeLabel () {
        return Utilities.waitAndGetWebElementText( inspectorAllocationTypeLabel, wait);
    }
    public String getVisitInspectorNameLabel () {
        return Utilities.waitAndGetWebElementText( visitInspectorNameLabel, wait);
    }
    public String getVisitNotesLabel () {
        return Utilities.waitAndGetWebElementText( visitNotesLabel, wait);
    }
    public boolean isSaveBtnDisplayed (){
        return editVisitSaveBtn.isDisplayed();
    }

    /*************Getters For Visit History Section **************/
    public String getVisitHistoryTitle () {
        return Utilities.waitAndGetWebElementText( visitHistoryTitle, wait);
    }
    public String getTimestampHeader () {
        return Utilities.waitAndGetWebElementText( timestampHeader, wait);
    }
    public String getUserHeader () {
        return Utilities.waitAndGetWebElementText( userHeader, wait);
    }
    public String getScheduleStatusHeader () {
        return Utilities.waitAndGetWebElementText( scheduleStatusHeader, wait);
    }
    public String getStatusHeader () {
        return Utilities.waitAndGetWebElementText( statusHeader, wait);
    }
    public String getVisitDateHeader () {
        return Utilities.waitAndGetWebElementText( visitDateHeader, wait);
    }
    public String getInspectorNameHeader () {
        return Utilities.waitAndGetWebElementText( inspectorNameHeader, wait);
    }
    public String getNotesHeader () {
        return Utilities.waitAndGetWebElementText( notesHeader, wait);
    }
    public AllVisitsViewPage clickOnBackBtn() {Utilities.waitAndClickOnWebElement(visitDetailsBackBtn, wait, driver);
        return new AllVisitsViewPage (driver); }

    public void clickViewVisitBtn() {Utilities.waitAndClickOnWebElement(viewVisitBtn, wait, driver);
    }
}


