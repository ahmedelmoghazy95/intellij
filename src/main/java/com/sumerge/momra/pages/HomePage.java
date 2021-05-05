package com.sumerge.momra.pages;

import com.sumerge.momra.utilities.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
        // Need to Change this Once InBasket Page is Done, Including Search-bar ID
        wait.until(ExpectedConditions.urlContains("Add here URL"));
        checkCorrectPage("search-bar", "This is Not the Correct Home Page!");
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "")
    WebElement openEngineeringOfficesBtn;

    public EngineeringOfficesListViewPage clickOnOpenEngineeringOfficesSideMenuBtn() {
        Utilities.waitAndClickOnWebElement(openEngineeringOfficesBtn, wait, driver);
        return new EngineeringOfficesListViewPage (driver);
    }
    
}
