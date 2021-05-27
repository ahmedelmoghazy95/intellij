package com.sumerge.momra.pages;

import com.sumerge.momra.utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class VisitsReportPage extends BasePage {

    public VisitsReportPage(WebDriver driver) {
        super(driver);

        checkCorrectPage("reports-visitDate-label", "This is Not the Visits Report Page!");
        PageFactory.initElements(driver, this);
    }


    /**************Visits Report's Filters**************/

    @FindBy(id = "assignDateStart")
    WebElement distributeStartDate;
    public static final String DISTRIBUTE_START_DATE = "Distribute Start Date Filter";

    @FindBy(id = "assignDateEnd")
    WebElement distributeEndDate;
    public static final String DISTRIBUTE_END_DATE = "Distribute End Date Filter";

    @FindBy(id = "visitDateStart")
    WebElement visitStartDate;
    public static final String VISIT_START_DATE = "Visit Start Date Filter";

    @FindBy(id = "visitDateEnd")
    WebElement visitEndDate;
    public static final String VISIT_END_DATE = "Visit End Date Filter";

    @FindBy(id = "reports-secretariats-label")
    WebElement reportsSecretariats;
    public static final String REPORTS_SECRETARIATS = "Reports Secretariats Filter";

    @FindBy(id = "reports-municipials-label")
    WebElement reportsMunicipials;
    public static final String REPORTS_MUNICIPIALS = "Reports Municipials Filter";

    @FindBy(id = "reports-activites-label")
    WebElement reportsActivities;
    public static final String REPORTS_ACTIVITIES = "Reports Activities Filter";

    @FindBy(id = "reports-officeNames-label")
    WebElement reportsOfficeNames;
    public static final String REPORTS_OFFICE_NAMES = "Reports Office Names Filter";

    @FindBy(id = "reports-statuses-label")
    WebElement reportsStatuses;
    public static final String REPORTS_STATUSES = "Reports Statuses Filter";

    @FindBy(id = "reports-viewList-submitBtn")
    WebElement reportsSubmitFilterBtn;
    public static final String REPORTS_SUBMIT_FILTER_BTN = "Reports Submit Filter Btn";

    /**************Visits Report's Results Table Headers**************/

    @FindBy(xpath = "//tr[@id='reports-table-view']/th[@class='table-headers' and  contains(text(), 'رقم الزيارة')]")
    WebElement visitNumberHeader;
    public static final String VISIT_NUMBER_HEADER = "Visit Number Header";

    @FindBy(xpath = "//tr[@id='reports-table-view']/th[@class='table-headers' and  contains(text(), 'اسم المكتب')]")
    WebElement visitOfficeNameHeader;
    public static final String VISIT_OFFICE_NAME_HEADER = "Visit Office Name Header";

    @FindBy(xpath = "//tr[@id='reports-table-view']/th[@class='table-headers' and  contains(text(), 'رقم هاتف المكتب')]")
    WebElement visitOfficePhoneHeader;
    public static final String VISIT_OFFICE_PHONE_HEADER = "Visit Office Phone Header";

    @FindBy(xpath = "//tr[@id='reports-table-view']/th[@class='table-headers' and  contains(text(), 'إسم مالك السكن')]")
    WebElement visitLicenseOwnerNameHeader;
    public static final String VISIT_LICENSE_OWNER_NAME_HEADER = "Visit License Owner Name Header";

    @FindBy(xpath = "//tr[@id='reports-table-view']/th[@class='table-headers' and  contains(text(), 'رقم الهاتف/ الجوال')]")
    WebElement visitLicensePhoneHeader;
    public static final String VISIT_LICENSE_PHONE_HEADER = "Visit License Phone Header";

    @FindBy(xpath = "//tr[@id='reports-table-view']/th[@class='table-headers' and  contains(text(), 'النطاق')]")
    WebElement visitActivityHeader;
    public static final String VISIT_ACTIVITY_HEADER = "Visit Activity Header";

    @FindBy(xpath = "//tr[@id='reports-table-view']/th[@class='table-headers' and  contains(text(), 'العنوان')]")
    WebElement visitAddressHeader;
    public static final String VISIT_ADDRESS_HEADER = "Visit Address Header";

    @FindBy(xpath = "//tr[@id='reports-table-view']/th[@class='table-headers' and  contains(text(), 'تاريخ توزيع الزيارة')]")
    WebElement visitAssignDateHeader;
    public static final String VISIT_ASSIGN_DATE_HEADER = "Visit Assign Dates Header";

    @FindBy(xpath = "//tr[@id='reports-table-view']/th[@class='table-headers' and  contains(text(), 'تاريخ تنفيذ الزيارة')]")
    WebElement visitDateHeader;
    public static final String VISIT_DATE_HEADER = "Visit Date Header";

    @FindBy(xpath = "//tr[@id='reports-table-view']/th[@class='table-headers' and  contains(text(), 'الحالة')]")
    WebElement visitStatusHeader;
    public static final String VISIT_STATUS_HEADER = "Visit Status Header";

    /**************Visits Report's Results Table 1st Row IDs**************/

    @FindBy(xpath = "//tbody[@id='reports-table-body']//td[@class='table-elements' and  contains(text(), 'visit.id')]")
    WebElement firstVisitNumber;
    public static final String FIRST_VISIT_NUMBER = "First Visit Number";

    @FindBy(xpath = "//tbody[@id='reports-table-body']//td[@class='table-elements' and  contains(text(), 'visit.officeName')]")
    WebElement firstVisitOfficeName;
    public static final String FIRST_VISIT_OFFICE_NAME = "First Visit Office Name";

    @FindBy(xpath = "//tbody[@id='reports-table-body']//td[@class='table-elements' and  contains(text(), 'visit.officePhone')]")
    WebElement firstVisitOfficePhone;
    public static final String FIRST_VISIT_OFFICE_PHONE = "First Visit Office Phone";

    @FindBy(xpath = "//tbody[@id='reports-table-body']//td[@class='table-elements' and  contains(text(), 'visit.licenseOwnerName')]")
    WebElement firstVisitLicenseOwnerName;
    public static final String FIRST_VISIT_LICENSE_OWNER = "First Visit License Owner Name";

    @FindBy(xpath = "//tbody[@id='reports-table-body']//td[@class='table-elements' and  contains(text(), 'visit.licensePhone')]")
    WebElement firstVisitLicensePhone;
    public static final String FIRST_VISIT_LICENSE_PHONE = "First Visit License Phone";

    @FindBy(xpath = "//tbody[@id='reports-table-body']//td[@class='table-elements' and  contains(text(), 'visit.activity')]")
    WebElement firstVisitActivity;
    public static final String FIRST_VISIT_ACTIVITY = "First Visit Activity";

    @FindBy(xpath = "//tbody[@id='reports-table-body']//td[@class='table-elements' and  contains(text(), 'visit.address')]")
    WebElement firstVisitAddress;
    public static final String FIRST_VISIT_ADDRESS = "First Visit Address";

    @FindBy(xpath = "//tbody[@id='reports-table-body']//td[@class='table-elements' and  contains(text(), 'visit.assignDate')]")
    WebElement firstVisitAssignDate;
    public static final String FIRST_VISIT_ASSIGN_DATE = "First Visit Assign Dates";

    @FindBy(xpath = "//tbody[@id='reports-table-body']//td[@class='table-elements' and  contains(text(), 'visit.visitDate')]")
    WebElement firstVisitDate;
    public static final String FIRST_VISIT_DATE = "First Visit Date";

    @FindBy(xpath = "//tbody[@id='reports-table-body']//td[@class='table-elements' and  contains(text(), 'visit.status')]")
    WebElement firstVisitStatus;
    public static final String FIRST_VISIT_STATUS= "First Visit Status";

    /**************Click on Action Buttons**************/

    public void clickReportsSubmitFilterBtn() {
        Utilities.waitAndClickOnWebElement(reportsSubmitFilterBtn, wait, driver);
    }
    /**************Getters for page filters**************/

    public void clickOnFilterAndSelectSecretariat (String secretariatsSelection) {
        Utilities.waitAndClickOnWebElement(reportsSecretariats, wait, driver);
            Select secretariats = new Select(reportsSecretariats);
            secretariats.selectByVisibleText(secretariatsSelection);

    }

    public void clickOnFilterAndSelectMunicipials(String municipialsSelection) {
        Utilities.waitAndClickOnWebElement(reportsMunicipials, wait, driver);
        Select municipials = new Select(reportsMunicipials);
        municipials.selectByVisibleText(municipialsSelection);
    }

    public void clickOnFilterAndSelectActivities(String activitiesSelection) {
        Utilities.waitAndClickOnWebElement(reportsActivities, wait, driver);
        Select activities = new Select(reportsActivities);
        activities.selectByVisibleText(activitiesSelection);
    }

    public void clickOnFilterAndSelectOfficeNames(String officeNamesSelection) {
        Utilities.waitAndClickOnWebElement(reportsOfficeNames, wait, driver);
        Select officeNames = new Select(reportsOfficeNames);
        officeNames.selectByVisibleText(officeNamesSelection);
    }

    public void clickOnFilterAndSelectStatuses(String statusesSelection) {
        Utilities.waitAndClickOnWebElement(reportsStatuses, wait, driver);
        Select statuses = new Select(reportsStatuses);
        statuses.selectByVisibleText(statusesSelection);
    }


    public boolean checkFieldIsDisplayed(WebElement element) {
        return Utilities.isFieldDisplayed(element, wait);
    }

    /**************Getters for table Headers**************/

    public String getVisitNumberHeader () {
        return Utilities.waitAndGetWebElementText(visitNumberHeader, wait);
    }
    public String getVisitOfficeNameHeader () {
        return Utilities.waitAndGetWebElementText(visitOfficeNameHeader, wait);
    }
    public String getVisitOfficePhoneHeader () {
        return Utilities.waitAndGetWebElementText(visitOfficePhoneHeader, wait);
    }
    public String getVisitLicenseOwnerNameHeader () {
        return Utilities.waitAndGetWebElementText(visitLicenseOwnerNameHeader, wait);
    }
    public String getVisitLicensePhoneHeader () {
        return Utilities.waitAndGetWebElementText(visitLicensePhoneHeader, wait);
    }
    public String getVisitActivityHeader () {
        return Utilities.waitAndGetWebElementText(visitActivityHeader, wait);
    }
    public String getVisitAddressHeader () {
        return Utilities.waitAndGetWebElementText(visitAddressHeader, wait);
    }
    public String getVisitAssignDateHeader () {
        return Utilities.waitAndGetWebElementText(visitAssignDateHeader, wait);
    }
    public String getVisitDateHeader () {
        return Utilities.waitAndGetWebElementText(visitDateHeader, wait);
    }
    public String getVisitStatusHeader () {
        return Utilities.waitAndGetWebElementText(visitStatusHeader, wait);
    }


    /**************Getters for table 1st Row**************/

    public String getFirstVisitNumber () {
        return Utilities.waitAndGetWebElementText(firstVisitNumber, wait);
    }
    public String getFirstVisitOfficeName() {
        return Utilities.waitAndGetWebElementText(firstVisitOfficeName, wait);
    }
    public String getFirstVisitOfficePhone () {
        return Utilities.waitAndGetWebElementText(firstVisitOfficePhone, wait);
    }
    public String getFirstVisitLicenseOwnerName () {
        return Utilities.waitAndGetWebElementText(firstVisitLicenseOwnerName, wait);
    }
    public String getFirstVisitLicensePhone () {
        return Utilities.waitAndGetWebElementText(firstVisitLicensePhone, wait);
    }
    public String getFirstVisitActivity () {
        return Utilities.waitAndGetWebElementText(firstVisitActivity, wait);
    }
    public String getFirstVisitAddress () {
        return Utilities.waitAndGetWebElementText(firstVisitAddress, wait);
    }
    public String getFirstVisitAssignDate () {
        return Utilities.waitAndGetWebElementText(firstVisitAssignDate, wait);
    }
    public String getFirstVisitDate () {
        return Utilities.waitAndGetWebElementText(firstVisitDate, wait);
    }
    public String getFirstVisitStatus () {
        return Utilities.waitAndGetWebElementText(firstVisitStatus, wait);
    }

}
