package com.sumerge.momra.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewVisitsViolations2ndTabPage  extends BasePage {

    public ViewVisitsViolations2ndTabPage(WebDriver driver) {
        super(driver);
        checkCorrectPage("awaiting-decision-violations-table-submitDate-header", "This is Not the Correct ViewViolations Page!");
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "awaiting-payment-title")
    WebElement pageTitle; //مخالفات المنشأة

    @FindBy(id = "awaiting-decision-violations-tab-مخالفات بإنتظار السداد")
    WebElement tab1Title; //مخالفات بإنتظار السداد

    @FindBy(id = "awaiting-decision-violations-tab-مخالفات بإنتظار نتيجة الإعتراض")
    WebElement tab2Title; //مخالفات بإنتظار نتيجة الإعتراض

    @FindBy(id = "awaiting-decision-violations-tab-مخالفات تم سدادها")
    WebElement tab3Title; //مخالفات تم سدادها

    @FindBy(id = "awaiting-decision-violations-tab-مخالفات تم قبول الإعتراض لها")
    WebElement tab4Title; //مخالفات تم قبول الإعتراض لها

    @FindBy(id="awaiting-payment-back-btn")
    WebElement backBtn;

    public ViewVisitsViolations3rdTabPage goTo3rdTab(WebDriver driver){
        getTab3Title().click();
        ViewVisitsViolations3rdTabPage page = new ViewVisitsViolations3rdTabPage(driver);
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

    @FindBy(id="awaiting-decision-violations-table-submitDate-header")
    WebElement appealDate;


    public WebElement getAppealDate() {
        return appealDate;
    }


    public String getAppealDateLable(){
        return appealDate.getText();
    }
}
