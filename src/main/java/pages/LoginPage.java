package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        checkCorrectPage("login-btn", "This is Not the Correct Login Page!");
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "")
    WebElement username;

    @FindBy(id = "")
    WebElement password;

    @FindBy(id = "")
    WebElement loginBtn;

    @FindBy(id = "")
    WebElement loginErrorMsg;

    public void setLoginUsername(String userName) {
        username.sendKeys(userName);
    }

    public void setLoginPassword(String passwordValue) {
        password.sendKeys(passwordValue);
    }

    public void clickOnLoginBtn() {
        loginBtn.click();
    }

    public void waitUntilLoginLoadingSpinner() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("login-spinner")));
    }

    public String getLoginErrorMessage() {
        waitUntilLoginLoadingSpinner();
        return loginErrorMsg.getText();
    }

    public HomePage login(String userNameValue, String passwordValue) {
        setLoginUsername(userNameValue);
        setLoginPassword(passwordValue);
        clickOnLoginBtn();
        HomePage homePage = new HomePage(driver);
        return homePage;
    }

}
