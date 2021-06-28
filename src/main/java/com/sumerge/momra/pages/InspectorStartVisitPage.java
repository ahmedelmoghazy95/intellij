package com.sumerge.momra.pages;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Data
public class InspectorStartVisitPage extends BasePage{

    public InspectorStartVisitPage (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
        wait.until(ExpectedConditions.visibilityOf(visitStatusField));

    }

    @FindBy(id = "visit-details-visit-status")
    private WebElement visitStatusField;

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

    @FindBy(id = "visit-details-visit-numberOfBeds")
    private WebElement licenseBedsField;

    @FindBy(id = "visit-details-visit-situation")
    private WebElement licenseSituationField;

}
