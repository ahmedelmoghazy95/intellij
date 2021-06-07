package com.sumerge.momra.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewVisitsViolations3rdTabPage extends BasePage {

    public ViewVisitsViolations3rdTabPage(WebDriver driver) {
        super(driver);
        checkCorrectPage("paid-violations-table-paymentDate-header", "This is Not the Correct ViewViolations Page!");
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "awaiting-payment-title")
    WebElement pageTitle; //مخالفات المنشأة

    @FindBy(id = "paid-violations-tab-مخالفات بإنتظار السداد")
    WebElement tab1Title; //مخالفات بإنتظار السداد

    @FindBy(id = "paid-violations-tab-مخالفات بإنتظار نتيجة الإعتراض")
    WebElement tab2Title; //مخالفات بإنتظار نتيجة الإعتراض

    @FindBy(id = "paid-violations-tab-مخالفات تم سدادها")
    WebElement tab3Title; //مخالفات تم سدادها

    @FindBy(id = "paid-violations-tab-مخالفات تم قبول الإعتراض لها")
    WebElement tab4Title; //مخالفات تم قبول الإعتراض لها

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

    public ViewVisitsViolations4thTabPage goTo4thTab(WebDriver driver){
        getTab4Title().click();
        ViewVisitsViolations4thTabPage page = new ViewVisitsViolations4thTabPage(driver);
        return page;
    }



    @FindBy(id="paid-violations-table-paymentDate-header")
    WebElement finePaymentDate;


    public String getFinePaymentDateLabel(){
        return finePaymentDate.getText();
    }
}
