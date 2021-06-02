package com.sumerge.momra.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewVisitsViolations1stTabPage extends BasePage {
    public ViewVisitsViolations1stTabPage(WebDriver driver) {
        super(driver);
//        checkCorrectPage("", "This is Not the Correct ViewViolations Page!");
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "awaiting-payment-title")
    WebElement pageTitle; //مخالفات المنشأة

    @FindBy(id = "awaiting-payment-violations-tab-مخالفات بإنتظار السداد")
    WebElement tab1Title; //مخالفات بإنتظار السداد

    @FindBy(id = "awaiting-payment-violations-tab-مخالفات بإنتظار نتيجة الإعتراض")
    WebElement tab2Title; //مخالفات بإنتظار نتيجة الإعتراض

    @FindBy(id = "awaiting-payment-violations-tab-مخالفات تم سدادها")
    WebElement tab3Title; //مخالفات تم سدادها

    @FindBy(id = "awaiting-payment-violations-tab-مخالفات تم قبول الإعتراض عليها")
    WebElement tab4Title; //مخالفات تم قبول الإعتراض لها

    @FindBy(id="awaiting-payment-back-btn")
    WebElement backBtn;

    public ViewVisitsViolations2ndTabPage goTo2ndTab(WebDriver driver){
        getTab2Title().click();
        ViewVisitsViolations2ndTabPage page = new ViewVisitsViolations2ndTabPage(driver);
        return page;
    }

    public WebElement getTab1Title() {
        return tab1Title;
    }

    public WebElement getTab2Title() {
        return tab2Title;
    }

    public WebElement getTab3Title() {
        return tab3Title;
    }

    public WebElement getTab4Title() {
        return tab4Title;
    }




    public WebElement getPageTitle() {
        return pageTitle;
    }

    public WebElement getBackBtn() {
        return backBtn;
    }
}
