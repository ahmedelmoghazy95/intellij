package com.sumerge.momra.pages;

import com.sumerge.momra.utilities.Utilities;
import lombok.NoArgsConstructor;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

@NoArgsConstructor
public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Wait<WebDriver> fluentWait;

    public BasePage(WebDriver driver) {
        super();
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 40);
        this.fluentWait = new FluentWait<WebDriver>(driver).withTimeout(40, TimeUnit.SECONDS)
                .pollingEvery(3, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
    }

    String arabicEnglishTextPattern = "^(?:[a-zA-Z0-9\\u0600-\\u06FF\\u0750-\\u077F\\u08A0-\\u08FF\\uFB50-\\uFDCF\\uFDF0-\\uFDFF\\uFE70-\\uFEFF]|(?:\\uD802[\\uDE60-\\uDE9F]|\\uD83B[\\uDE00-\\uDEFF]))";

    /***********Common Methods Used across Different Pages***********/

    public WebDriverWait getWait() {
        return wait;
    }

    // TODO Need to Fix FileUpload in Headless Mode on K8s, Won't be Used
    public void fileUploadFunction(String fileUploadPath) throws AWTException {
        StringSelection strSelection = new StringSelection(fileUploadPath);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(strSelection, null);

        Robot robot = new Robot();

        robot.delay(300);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(200);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public void checkCorrectPage(String pageIdentifier, String exceptionMsg) {
        try {
            waitUntilLoadingProgressBar();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(pageIdentifier)));
        } catch (TimeoutException e) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(pageIdentifier)));
        }

        try {
            waitUntilLoadingProgressBar();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        WebElement element = driver.findElement(By.tagName("Body"));
        String elementSource;

        try {
            elementSource = element.getAttribute("innerHTML");
            if (!elementSource.contains(pageIdentifier)) {
                throw new IllegalStateException(exceptionMsg);
            }
        } catch (Exception e) {
            elementSource = element.getAttribute("innerHTML");
            if (!elementSource.contains(pageIdentifier)) {
                throw new IllegalStateException(exceptionMsg);
            }
        }
    }


    public boolean isMandatoryErrorMessageDisplayed(String errorMsg) {
        try {
            return driver.findElement(By.xpath("//*[@class='alert alert-danger']//*[contains(text(),'" + errorMsg + "')]")).isDisplayed();
        } catch(NoSuchElementException e) {
            return false;
        }
    }


    public boolean checkFieldIsDisplayed(WebElement element) {
        return Utilities.isFieldDisplayed(element, wait);
    }

    String fieldValidClassName = "ng-valid";
    String fieldInvalidClassName = "ng-invalid";

    public boolean checkFieldIsMandatory(WebElement element) {
        return Utilities.isFieldMandatory(element, fieldValidClassName, fieldInvalidClassName, wait, driver);
    }

    public boolean checkFieldIsOptional(WebElement element) {
        return Utilities.isFieldOptional(element, fieldInvalidClassName, wait, driver);
    }

    public boolean isDateFormatValid(String dateStr) {
        DateFormat sdf = new SimpleDateFormat("hh:mm - dd/mm/yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    /**********Navigation Bar Elements**********/

    @FindBy(id = "")
    WebElement loggedInUsername;


    /**********Navigation Bar Methods**********/

    public boolean isLoggedInUsernameCorrect(String username) {
        String elementSource = loggedInUsername.getAttribute("innerHTML");
        if (elementSource.contains(username.toLowerCase())) {
            return true;
        } else {
            return false;
        }
    }
    
    /************Common Loading Spinners across Different Pages************/

    public void waitUntilLoadingProgressBar() {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.tagName("mat-progress-bar")));
        } catch(TimeoutException | NoSuchElementException e) {
            e.printStackTrace();
        }
    }

}
