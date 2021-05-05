package com.sumerge.momra.pages;

import com.sumerge.momra.utilities.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EngineeringOfficesListViewPage extends BasePage {

    public EngineeringOfficesListViewPage (WebDriver driver) {
        super(driver);
        checkCorrectPage("offices-viewList-refreshOfficesBtn", "This is Not the Correct Engineering Offices Page!");
        PageFactory.initElements(driver, this);
    }


    /**************Engineering Offices table View Fields**************/
    @FindBy(id = "offices-viewList-officeName")
    WebElement officeName;
    public static final String OFFICE_NAME = "Office Name";

    @FindBy(id = "offices-viewList-officeNumber")
    WebElement officeNumber;
    public static final String OFFICE_NUMBER = "Office Number";

    @FindBy(id = "offices-viewList-secretariat")
    WebElement officeSecretariat;
    public static final String SECRETARIAT  = "Secretariat";

    @FindBy(id = "offices-viewList-municipial")
    WebElement officeMunicipial;
    public static final String OFFICE_MUNICIPIAL = "Office Municipial";

    @FindBy(id = "offices-viewList-numberOfInspectors")
    WebElement officeNumberOfInspectorsReadOnly;
    public static final String OFFICE_NUMBER_OF_INSPECTOR_READ_ONLY = "Office Number Of Inspectors Read Only";

    @FindBy(id = "offices-viewList-capacity")
    WebElement officeCapacityReadOnly;
    public static final String OFFICE_CAPACITY_READ_ONLY  = "Office Capacity Read Only";

    @FindBy(id = "")
    WebElement officeNumberOfInspectorsEditable;
    public static final String OFFICE_NUMBER_OF_INSPECTOR_EDITABLE = "Office Number Of Inspectors Editable Field";

    @FindBy(id = "offices-viewList-capacityEditAllInput")
    WebElement officeCapacityEditable;
    public static final String OFFICE_CAPACITY_EDITABLE  = "Office Capacity Editable Field";

    @FindBy(id = "offices-viewList-filterINput")
    WebElement search;
    public static final String SEARCH = "Search Field";

    @FindBy(id = "offices-viewList-refreshOfficesBtn")
    WebElement refreshOfficesBtn;
    public static final String REFRESH_OFFICES_BTN  = "Refresh Offices Btn";


    /*************Getters For Offices List View Page**************/

    public WebElement getOfficeName() {
        return officeName;
    }
    public WebElement getOfficeNumber () {return officeNumber;}
    public WebElement getSecretariat () {
        return officeSecretariat;
    }
    public WebElement getOfficeMunicipial () { return officeMunicipial; }
    public WebElement getOfficeCapacityReadOnly () {
        return officeCapacityReadOnly;
    }
    public WebElement getOfficeNumberOfInspectorReadOnly () { return officeNumberOfInspectorsReadOnly; }
    public WebElement getOfficeCapacityEditable () {
        return officeCapacityEditable;
    }
    public WebElement getOfficeNumberOfInspectorEditable () { return officeNumberOfInspectorsEditable;}

    public void searchWithOfficeName (String officeNameValue) {
        officeName.sendKeys(officeNameValue);
    }

    /**************Table Headers(Labels) IDs **************/

    @FindBy(id = "")
    WebElement officeNameLabel;

    @FindBy(id = "")
    WebElement officeNumberLabel;

    @FindBy(id = "")
    WebElement officeSecretariatLabel;

    @FindBy(id = "")
    WebElement officeMunicipialLabel;

    @FindBy(id = "")
    WebElement officeNumberOfInspectorsLabel;

    @FindBy(id = "")
    WebElement officeCapacityLabel;

    /*************Getters For Table Headers(Labels)**************/

    public String getOfficeNameLabel() {
        return Utilities.waitAndGetWebElementText(officeNameLabel, wait);
    }
    public String getOfficeNumberLabel () {return Utilities.waitAndGetWebElementText(officeNumberLabel,wait);}
    public String getSecretariatLabel () {
        return Utilities.waitAndGetWebElementText(officeSecretariatLabel, wait);
    }
    public String getOfficeMunicipialLabel () { return Utilities.waitAndGetWebElementText(officeMunicipialLabel, wait); }
    public String getOfficeCapacityLabel () {
        return Utilities.waitAndGetWebElementText(officeCapacityLabel, wait);
    }
    public String getOfficeNumberOfInspectorLabel () { return Utilities.waitAndGetWebElementText(officeNumberOfInspectorsLabel, wait); }

    /************** 1st Row data IDs **************/

    @FindBy(id = "")
    WebElement firstOfficeName;

    @FindBy(id = "")
    WebElement firstOfficeNumber;

    @FindBy(id = "")
    WebElement firstOfficeSecretariat;

    @FindBy(id = "")
    WebElement firstOfficeMunicipial;

    @FindBy(id = "")
    WebElement firstOfficeNumberOfInspectors;

    @FindBy(id = "")
    WebElement firstOfficeCapacity;

    /*************Getters For 1st Row data**************/

    public String getFirstOfficeName() {
        return Utilities.waitAndGetWebElementText(firstOfficeName, wait);
    }
    public String getFirstOfficeNumber () {return Utilities.waitAndGetWebElementText(firstOfficeNumber,wait);}
    public String getFirstSecretariat () {
        return Utilities.waitAndGetWebElementText(firstOfficeSecretariat, wait);
    }
    public String getFirstOfficeMunicipial () { return Utilities.waitAndGetWebElementText(firstOfficeMunicipial, wait); }
    public String getFirstOfficeCapacity () {
        return Utilities.waitAndGetWebElementText(firstOfficeCapacity, wait);
    }
    public String getFirstOfficeNumberOfInspector () { return Utilities.waitAndGetWebElementText(firstOfficeNumberOfInspectors, wait); }

    /*************Page Action Buttons**************/

    @FindBy(id = "offices-viewList-submitBtn")
    WebElement saveBtn;
    public static final String SAVE_BTN = "Offices List Save Button";

    @FindBy(id = "offices-viewList-editAllBtn")
    WebElement editAllBtn;
    public static final String EDIT_ALL_BTN = "Offices Edit All Button";

    @FindBy(id = "")
    WebElement inlineEditBtn;
    public static final String INLINE_EDIT_BTN = "Offices Inline Edit Button";

    /**************Click on Action Buttons**************/

    public void clickSaveBtn() {Utilities.waitAndClickOnWebElement(saveBtn, wait, driver);
    }

    public void clickEditAllBtn() {Utilities.waitAndClickOnWebElement(editAllBtn, wait, driver);
    }

    public void clickInlineEditBtn() {Utilities.waitAndClickOnWebElement(inlineEditBtn, wait, driver);
    }

    public void clickRefreshOfficesBtn() {Utilities.waitAndClickOnWebElement(refreshOfficesBtn, wait, driver);
    }

    public boolean checkFieldIsDisplayed(WebElement element) {
        return Utilities.isFieldDisplayed(element, wait);
    }

    public boolean isSaveBtnDisplayed (){
        return saveBtn.isDisplayed();
    }

    public boolean isEditAllBtnDisplayed (){
        return editAllBtn.isDisplayed();
    }

}

