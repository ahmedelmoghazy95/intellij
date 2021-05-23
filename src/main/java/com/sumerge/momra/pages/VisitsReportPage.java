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

    @FindBy(id = "reports-table-view")
    WebElement visitsReportHeaders;
    public static final String VISITS_REPORTS_HEADERS = "Visits Report Headers";

    /**************Visits Report's Results Table Body**************/

    @FindBy(id = "reports-table-body")
    WebElement visitsReportBody;
    public static final String VISITS_REPORTS_BODY = "Visits Report Body";

    /**************Click on Action Buttons**************/

    public void clickReportsSubmitFilterBtn() {
        Utilities.waitAndClickOnWebElement(reportsSubmitFilterBtn, wait, driver);
    }

    public void clickOnFilterAndSelectSecretariat (String secretariatsSelectionId) {
        Utilities.waitAndClickOnWebElement(reportsSecretariats, wait, driver);
            Select secretariats = new Select(driver.findElement(By.id("Add here selection Id")));
            secretariats.selectByVisibleText(secretariatsSelectionId);

    }

    public void clickOnFilterAndSelectMunicipials(String municipialsSelectionId) {
        Utilities.waitAndClickOnWebElement(reportsMunicipials, wait, driver);
        Select municipials = new Select(driver.findElement(By.id("Add here selection Id")));
        municipials.selectByVisibleText(municipialsSelectionId);
    }

    public void clickOnFilterAndSelectActivities(String activitiesSelectionId) {
        Utilities.waitAndClickOnWebElement(reportsActivities, wait, driver);
        Select activities = new Select(driver.findElement(By.id("Add here selection Id")));
        activities.selectByVisibleText(activitiesSelectionId);
    }

    public void clickOnFilterAndSelectOfficeNames(String officeNamesSelectionId) {
        Utilities.waitAndClickOnWebElement(reportsOfficeNames, wait, driver);
        Select officeNames = new Select(driver.findElement(By.id("Add here selection Id")));
        officeNames.selectByVisibleText(officeNamesSelectionId);
    }

    public void clickOnFilterAndSelectStatuses(String statusesSelectionId) {
        Utilities.waitAndClickOnWebElement(reportsStatuses, wait, driver);
        Select statuses = new Select(driver.findElement(By.id("Add here selection Id")));
        statuses.selectByVisibleText(statusesSelectionId);
    }


    public boolean checkFieldIsDisplayed(WebElement element) {
        return Utilities.isFieldDisplayed(element, wait);
    }

    public String getVisitsReportsHeaders () { return Utilities.waitAndGetWebElementText(visitsReportHeaders, wait); }
    public String getVisitsReportsBody () { return Utilities.waitAndGetWebElementText(visitsReportBody, wait); }
//    public void selectSecretariats (String secretariatsValue) {
//        Select secretariats = new Select(driver.findElement(By.id("Add here selection Id")));
//        secretariats.selectByVisibleText(secretariatsValue);
//    }


}
