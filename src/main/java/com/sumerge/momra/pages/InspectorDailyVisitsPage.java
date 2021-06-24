package com.sumerge.momra.pages;

import com.sumerge.momra.utilities.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InspectorDailyVisitsPage extends BasePage {

    public InspectorDailyVisitsPage(WebDriver driver) {

        super(driver);
        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "visits-viewList-visitNumber")
    private WebElement visitNumberField;

    @FindBy(id = "visits-viewList-visitDate")
    private WebElement visitDateField;

    public String getVisitNumberFieldValue(){
        return Utilities.waitAndGetWebElementText( visitNumberField, wait);
    }


}
