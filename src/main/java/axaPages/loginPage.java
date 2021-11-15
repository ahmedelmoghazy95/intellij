package axaPages;

import com.sumerge.momra.pages.BasePage;
import com.sumerge.momra.utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage extends BasePage {

    public loginPage(WebDriver driver) {
        super(driver);
//        checkCorrectPage("", "This is Not the Correct Login Page!");
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "kt_sign_in_submit")
    WebElement submitBtn;

    @FindBy(xpath = "//*[@id=\"asideMenu\"]/div[5]/a/span[2]")
    private WebElement SearchProspect;


    public SearchPage clickSubmit() {
        Utilities.waitAndClickOnWebElement(submitBtn, wait, driver);
        return (new SearchPage(driver));
    }

    public SearchPage clickSearchProspect(){
         Utilities.waitAndClickOnWebElement(SearchProspect , wait, driver);
        return (new SearchPage(driver));
    }

}
