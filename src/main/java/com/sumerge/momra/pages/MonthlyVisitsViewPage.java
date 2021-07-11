package com.sumerge.momra.pages;

import com.sumerge.momra.utilities.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MonthlyVisitsViewPage extends BasePage {

    public MonthlyVisitsViewPage(WebDriver driver) {
        super(driver);
        checkCorrectPage("visit-requests-page-title", "This is Not the Correct View All Offices Visits Page!");
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "visit-requests-page-title")
    WebElement pageTitle;
    public static final String PAGE_TITLE = "Page Title";


}


