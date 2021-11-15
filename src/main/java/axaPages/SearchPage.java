package axaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.sumerge.momra.pages.*;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver)
    {
        super(driver);
//        checkCorrectPage("", "This is Not the Correct Login Page!");
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "search-fname-input")
    WebElement firstnameTxt;

    @FindBy(id = "search-lname-input")
    WebElement lastnameTxt;

    @FindBy(id = "search-policy-input")
    WebElement policyNoTxt;

    @FindBy(id = "search-fa-name-input")
    WebElement faNameTxt;

    @FindBy(id = "search-ticket-input")
    WebElement ticketNoTxt;

    @FindBy(id = "search-serial-number-input")
    WebElement serialNoTxt;

    @FindBy(id = "mat-select-value-1")
    WebElement prospectStatusList;

    @FindBy(id = "mat-select-value-3")
    WebElement BranchList;

    @FindBy(id = "mat-select-value-5")
    WebElement BankStaffList;

    @FindBy(id = "mat-select-value-7")
    WebElement FollowUpActionList;

    @FindBy(id = "search-dob-from-input")
    WebElement DateOfBirthFrom;

    @FindBy(id = "search-dob-to-input")
    WebElement DateOfBirthTo;

    @FindBy(id = "search-follow-up-date-from-input")
    WebElement FollowUpDateFrom;

    @FindBy(id = "search-follow-up-date-to-input")
    WebElement FollowUpDateTo;

    @FindBy(id = "search-btn-input")
    WebElement SearchBtn;

    @FindBy(id = "search-clear-btn-input")
    WebElement ClearFiltersBtn;


    public void setFirstname(String firstName) {
        firstnameTxt.sendKeys(firstName);
    }
    public void setLastname(String lastName) {
        lastnameTxt.sendKeys(lastName);
    }
    public void setPolicyNo(String policyNo) {
        policyNoTxt.sendKeys(policyNo);
    }
    public void setFaName(String faName) {
        faNameTxt.sendKeys(faName);
    }
    public void setTicketNo(String ticketNo) {
        ticketNoTxt.sendKeys(ticketNo);
    }
    public void setSerialNo(String serialNo) {
        serialNoTxt.sendKeys(serialNo);
    }
    public void setDateOfBirthFrom(String dateOfBirthFrom) {
        DateOfBirthFrom.sendKeys(dateOfBirthFrom);
    }
    public void setDateOfBirthTo(String dateOfBirthTo) {
        DateOfBirthTo.sendKeys(dateOfBirthTo);
    }
    public void setFollowUpDateFrom(String followUpDateFrom) {
        FollowUpDateFrom.sendKeys(followUpDateFrom);
    }
    public void setFollowUpDateTo(String followUpDateTO) {
        FollowUpDateTo.sendKeys(followUpDateTO);
    }
    public void Search() {
        SearchBtn.click();
    }
    public void ClearFilters() {
        ClearFiltersBtn.click();
    }
    public void selectProspectStatus(String prospectStatus) {
        prospectStatusList.click();
        driver.findElement(By.cssSelector("mat-option[value='"+prospectStatus+"']")).click();
    }
    public void selectBranch(String branch) {
        BranchList.click();
        driver.findElement(By.cssSelector("mat-option[value='"+branch+"']")).click();
    }
    public void selectBankStaff(String bankStaff) {
        BankStaffList.click();
        driver.findElement(By.cssSelector("mat-option[value='"+bankStaff+"']")).click();
    }
    public void selectFollowUpAction(String followUpAction) {
        FollowUpActionList.click();
        driver.findElement(By.cssSelector("mat-option[value='"+followUpAction+"']")).click();
    }

}
