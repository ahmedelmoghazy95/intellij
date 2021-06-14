package com.sumerge.momra.pages;

import com.sumerge.momra.utilities.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VisitDetailsPage extends BasePage {

    public VisitDetailsPage(WebDriver driver) {
        super(driver);
        checkCorrectPage("", "This is Not the Correct Visit Details Page!");
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "")
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


    /*************Getters For Page Elements **************/

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


}


