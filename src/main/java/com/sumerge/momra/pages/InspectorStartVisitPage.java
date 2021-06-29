package com.sumerge.momra.pages;

import com.sumerge.momra.utilities.Utilities;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class InspectorStartVisitPage extends BasePage{

    public InspectorStartVisitPage (WebDriver driver){
        super(driver);
        checkCorrectPage("visit-details-visit-status",
                "This is Not the Correct Start Visits Page!");
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "visit-details-visit-status")
    private WebElement visitStatusField;

    public String getVisitStatusFieldValue(){
        return Utilities.waitAndGetWebElementText(visitStatusField,wait);
    }

    @FindBy(id = "visit-details-visit-address")
    private WebElement licenseLocationField;

    @FindBy(id = "visit-details-visit-siteName")
    private WebElement licenseNameField;

    @FindBy(id = "visit-details-visit-licenseOwnerName")
    private WebElement licenseOwnerField;

    @FindBy(id = "visit-details-visit-licenseId")
    private WebElement licenseNumberField;

    @FindBy(id = "visit-details-visit-licenseIssueDate")
    private WebElement licenseIssueDateField;

    @FindBy(id = "visit-details-visit-licenseExpiryDate")
    private WebElement licenseExpiryDateField;

    public String getLicenseExpiryFieldValue(){
        return Utilities.waitAndGetWebElementText(licenseExpiryDateField,wait);
    }

    @FindBy(id = "visit-details-visit-numberOfBeds")
    private WebElement licenseBedsField;

    public String getLicenseBedsFieldValue(){
        return Utilities.waitAndGetWebElementText(licenseBedsField,wait);
    }

    @FindBy(id = "visit-details-visit-situation")
    private WebElement licenseSituationField;

    @FindBy (id = "visit-details-next-btn")
    private WebElement nextBtn;

    public void selectLocationSituation(String situation){
        Select situationDropdown = new Select(licenseSituationField);
        situationDropdown.selectByVisibleText(situation);
    }

    //TODO: Update Return Type
    public void clickNextBtn(){
        Utilities.waitAndClickOnWebElement(nextBtn, wait, driver);
    }

}
