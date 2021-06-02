package com.sumerge.momra.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewVisitsViolations4thTabPage extends BasePage {

    public ViewVisitsViolations4thTabPage(WebDriver driver) {
        super(driver);
    //    checkCorrectPage("", "This is Not the Correct ViewViolations Page!");
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "awaiting-payment-title")
    WebElement pageTitle; //مخالفات المنشأة

    @FindBy(id = "appeal-accepted-violations-tab-مخالفات بإنتظار السداد")
    WebElement tab1Title; //مخالفات بإنتظار السداد

    @FindBy(id = "appeal-accepted-violations-tab-مخالفات بإنتظار نتيجة الإعتراض")
    WebElement tab2Title; //مخالفات بإنتظار نتيجة الإعتراض

    @FindBy(id = "appeal-accepted-violations-tab-مخالفات تم سدادها")
    WebElement tab3Title; //مخالفات تم سدادها

    @FindBy(id = "appeal-accepted-violations-tab-مخالفات تم قبول الإعتراض عليها")
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


    @FindBy(id="appeal-accepted-violations-table-acceptanceDate-header")
    WebElement appealAcceptanceDate;

    public WebElement getAppealAcceptanceDate() {
        return appealAcceptanceDate;
    }


    public String getAppealAcceptanceDateLabel(){
        return appealAcceptanceDate.getText();
    }
}
