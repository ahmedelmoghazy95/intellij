package com.sumerge.momra.pages;

import com.sumerge.momra.utilities.Utilities;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Data
public class InspectorDailyVisitsPage extends BasePage {

    public InspectorDailyVisitsPage(WebDriver driver) {
        super(driver);
        checkCorrectPage("open-map",
                "This is Not the Correct Daily Visits Page!");
        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "visits-viewList-visitNumber")
    private WebElement visitNumberField;

    @FindBy(id = "visits-viewList-visitDate")
    private WebElement visitDateField;

    @FindBy(id ="visits-viewList-siteName")
    private WebElement visitSiteNameField;

    @FindBy(id ="visits-viewList-licenseId")
    private WebElement visitLicenseIdField;

    @FindBy(id ="visits-viewList-licenseStatus")
    private WebElement visitLicenseStatusField;

    @FindBy(id ="visits-viewList-address")
    private WebElement visitAddressField;

    @FindBy(id ="visits-viewList-licenseOwnerName")
    private WebElement visitLicenseOwnerNameField;

    @FindBy(id ="visits-viewList-numberOfBeds")
    private WebElement visitNumberOfBedsField;

    @FindBy(id ="visits-viewList-licensePhone")
    private WebElement visitLicensePhoneField;

    @FindBy(id ="open-map")
    private WebElement visitLocationButton;

    @FindBy(id ="closeDialogButton")
    private WebElement visitCloseLocationButton;

    @FindBy (id = "startVisitButton")
    private WebElement startVisitButton;

    @FindBy (id = "navigateToVisitButton")
    private WebElement startNavigationButton;

//    public String getVisitNumberFieldValue(){
//        return Utilities.waitAndGetWebElementText( visitNumberField, wait);
//    }
    public String getVisitDateFieldValue(){
        return Utilities.waitAndGetWebElementText( visitDateField, wait);
    }
    public String getVisitSiteNameFieldValue(){
        return Utilities.waitAndGetWebElementText( visitSiteNameField, wait);
    }
    public String getVisitLicenseIdFieldValue(){ return Utilities.waitAndGetWebElementText( visitLicenseIdField, wait);
    }
    public String getVisitLicenseStatusFieldValue(){
        return Utilities.waitAndGetWebElementText( visitLicenseStatusField, wait);
    }
    public String getVisitAddressFieldValue(){ return Utilities.waitAndGetWebElementText( visitAddressField, wait);}
    public String getVisitLicenseOwnerNameFieldValue(){
        return Utilities.waitAndGetWebElementText( visitLicenseOwnerNameField, wait);
    }
    public String getVisitNumberOfBedsFieldValue(){
        return Utilities.waitAndGetWebElementText( visitNumberOfBedsField, wait);
    }
    public String getVisitLicensePhoneFieldValue(){
        return Utilities.waitAndGetWebElementText( visitLicensePhoneField, wait);
    }
    public void clickOnVisitLocationButton() {
        Utilities.waitAndClickOnWebElement(visitLocationButton, wait, driver);
    }
    public void clickOnVisitCloseLocationButton() {
        Utilities.waitAndClickOnWebElement(visitCloseLocationButton, wait, driver); }

    public InspectorStartVisitPage clickOnStartVisitButton() {
        Utilities.waitAndClickOnWebElement(startVisitButton, wait, driver);
        return new InspectorStartVisitPage(driver);
    }


}
