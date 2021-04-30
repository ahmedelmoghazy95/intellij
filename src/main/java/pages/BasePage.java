package pages;

import com.sumerge.momra.utilities.Constants;
import com.sumerge.momra.utilities.Utilities;
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

    public boolean isSuccessToastMessageDisplayed() {
        try {
            return driver.findElement(By.className("toast-success")).isDisplayed();
        } catch(NoSuchElementException e) {
            return false;
        }
    }

    public boolean isErrorToastMessageDisplayed() {
        try {
            return driver.findElement(By.className("toast-error")).isDisplayed();
        } catch(NoSuchElementException e) {
            return false;
        }
    }

    public boolean isMandatoryErrorMessageDisplayed(String errorMsg) {
        try {
            return driver.findElement(By.xpath("//*[@class='alert alert-danger']//*[contains(text(),'" + errorMsg + "')]")).isDisplayed();
        } catch(NoSuchElementException e) {
            return false;
        }
    }

    public String getToastMessage() {
        try {
            waitUntilSearchLoadingSpinner();
            WebElement toast = driver.findElement(By.className("toast-message"));
            return toast.getText();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return "No Error Message Displayed!";
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

    @FindBy(id = "search-bar")
    WebElement searchBar;

    @FindBy(id = "search-icon")
    WebElement searchIconBtn;

    @FindBy(xpath = "//momra-app-search-result//*[contains(@class, 'search-msg-container')]")
    private WebElement noSearchResultsErrorMsg;

    @FindBy(id = "toast-container")
    WebElement searchErrorMsg;

    @FindBy(id = "logged-in-username")
    WebElement loggedInUsername;

    @FindBy(id = "logout-btn")
    WebElement logoutBtn;

    @FindBy(xpath = "//momra-app-nav-bar//*[@alt = 'momra-logo']")
    WebElement homepageLogoBtn;

    /**********Navigation Bar Methods**********/

    public String getSearchBarValue() {
        return searchBar.getText();
    }

    public void setSearchBarValue(String searchValue) {
        Utilities.waitClearAndSetInputField(searchBar, searchValue, wait);
    }

    public void clickOnSearchBtn() {
        Utilities.waitAndClickOnWebElement(searchIconBtn, wait, driver);
    }

    public void search(String searchValue) {
        setSearchBarValue(searchValue);
        clickOnSearchBtn();
        waitUntilSearchLoadingSpinner();
    }



    public boolean isSearchErrorMsgCorrect(String errorMsg) {
        String elementSource = searchErrorMsg.getAttribute("innerHTML");
        if (elementSource.contains(errorMsg)) {
            return true;
        } else {
            return false;
        }
    }

    public String getSearchResultsErrorMessage() {
        return noSearchResultsErrorMsg.getText();
    }

    public void clickOnLoggedInUsername() {
        PageFactory.initElements(driver, this);
        Utilities.waitAndClickOnWebElement(loggedInUsername, wait, driver);
    }



    public boolean isLoggedInUsernameCorrect(String username) {
        String elementSource = loggedInUsername.getAttribute("innerHTML");
        if (elementSource.contains(username.toLowerCase())) {
            return true;
        } else {
            return false;
        }
    }



    /**********Side Bar Elements**********/

    @FindBy(id = "privateCount")
    WebElement privateCount;

    String roleNameId = "role-name-";
    String inBasketNameId = "inbasket-name-";
    String inBasketCountId = "inbasket-count-";

    /**********Side Bar Methods**********/

    public boolean checkPrivateCountExist() {
        return privateCount.isDisplayed();
    }

    public boolean checkPrivateCountHasValue() {
        wait.until(ExpectedConditions.textMatches(By.xpath("//*[@id='privateCount']"), Pattern.compile(".*\\d.*")));
        String innerHTML = privateCount.getAttribute("innerHTML");

        if(innerHTML.matches(".*\\d.*")) {
            return true;
        } else {
            return false;
        }
    }

    public String getPrivateCount() {
        wait.until(ExpectedConditions.textMatches(By.xpath("//*[@id='privateCount']"), Pattern.compile(".*\\d.*")));
        return privateCount.getText();
    }

    public boolean checkRoleNameExist(String role) {
        try {
            String[] roleIdAndName = role.split("\\|");

            // String at Index Zero is ID, String at Index 1 is the Name
            roleIdAndName[0] = roleIdAndName[0].replace(" ", "");

            String roleId = roleNameId + roleIdAndName[0];
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(roleId)));
            WebElement roleElement = driver.findElement(By.id(roleId));

            String innerHTML = roleElement.getAttribute("innerHTML");
            if(roleElement.isDisplayed() && innerHTML.contains(roleIdAndName[1])) {
                return true;
            } else {
                System.out.println("isDisplayed: " + roleElement.isDisplayed() + " innerHTML: " + innerHTML.contains(roleIdAndName[1]));
                return false;
            }
        } catch(NotFoundException e) {
            System.out.println("Exception: " + e.toString());
            return false;
        }
    }

    public void clickOnRole(String role) {
        WebElement roleElement = driver.findElement(By.id(roleNameId + role));
        wait.until(ExpectedConditions.visibilityOf(roleElement));
        Utilities.waitAndClickOnWebElement(roleElement, wait, driver);
    }



    public boolean checkInBasketNameExist(String inBasketName) {
        try {
            WebElement inBasketNameElement = driver.findElement(By.id(inBasketNameId + inBasketName));
            return inBasketNameElement.isDisplayed();
        } catch(NotFoundException e) {
            System.out.println("Exception: " + e.toString());
            return false;
        }
    }

    public boolean checkInBasketCountExist(String inBasketCount) {
        try {
            WebElement inBasketCountElement = driver.findElement(By.id(inBasketCountId + inBasketCount));
            return inBasketCountElement.isDisplayed();
        } catch(NotFoundException e) {
            System.out.println("Exception: " + e.toString());
            return false;
        }
    }

//    public boolean checkInbasketNameExist(String raw) {
//        try {
//            String[] roleIdAndInbasketRaw = raw.split(">");
//
//            // String at Index Zero is Role ID, String at Index 1 is the InbasketRaw
//            roleIdAndInbasketRaw[0] = roleIdAndInbasketRaw[0].replace(" ", "");
//            clickOnRole(roleIdAndInbasketRaw[0]);
//
//            String[] inBasketIdAndNames = roleIdAndInbasketRaw[1].split(",");
//
//            for(int i = 0; i < inBasketIdAndNames.length; i++) {
//                String[] inBasketIdAndName = inBasketIdAndNames[i].split("\\|");
//                // String at Index Zero is InBasket ID, String at Index 1 is the InBasketName
//                inBasketIdAndName[0] = inBasketIdAndName[0].replace(" ", "");
//
//                WebElement inBasketElement = driver.findElement(By.id(inBasketNameId + inBasketIdAndName[0]));
//                String innerHTML = inBasketElement.getAttribute("innerHTML");
//                if(inBasketElement.isDisplayed() && innerHTML.contains(inBasketIdAndName[1])) {
//                    return true;
//                } else {
//                    return false;
//                }
//            }
//
//        } catch(NotFoundException e) {
//            System.out.println("Exception: " + e.toString());
//            return false;
//        }
//    }

    public String[] parseRoles(String roles) {
        return roles.split(",");
    }

    public String[] parseInbaskets(String inbaskets) {
        return inbaskets.split(";");
    }



    public boolean checkPublicInBasketIsSelected(String inBasketId) {
        WebElement inBasketNameElement = driver.findElement(By.id(inBasketNameId + inBasketId));
        return Utilities.isClassPresent(inBasketNameElement, "activatedStep");
    }

    /************Common Loading Spinners across Different Pages************/

    public void waitUntilSearchLoadingSpinner() {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("search-spinner")));
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    public void waitUntilSuspensionLoadingSpinner() {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("suspension-spinner")));
        } catch(TimeoutException | NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public void waitUntilRejectionLoadingSpinner() {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("rejection-spinner")));
        } catch(TimeoutException | NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public void waitUntilLoadingProgressBar() {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.tagName("mat-progress-bar")));
        } catch(TimeoutException | NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public void waitUntilAttachmentLoadingProgressBar() {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@role='progressbar']")));
        } catch(TimeoutException | NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public void waitUnitlAdNameIsDisplayedInSearchResultsPage() {
        try {
            wait.until(ExpectedConditions.textMatches(By.id("search-cell-adv-name-0"), Pattern.compile(arabicEnglishTextPattern)));
        } catch (TimeoutException | NoSuchElementException e) {
            System.out.println("Wait for Ad Name Text to be Displayed Function Timed Out!");
        }
    }

    public void waitUnitlAdNameIsDisplayedInInBasketPage() {
        try {
            wait.until(ExpectedConditions.textMatches(By.id("inbasket-cell-adv-name-0"), Pattern.compile(arabicEnglishTextPattern)));
        } catch (TimeoutException | NoSuchElementException e) {
            System.out.println("Wait for Ad Name Text to be Displayed Function Timed Out!");
        }
    }

    public void waitUntilSuccessToastPopupIsNotDisplayed() {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(@class, 'toast-success')]")));
        } catch(TimeoutException | NoSuchElementException e) {
            e.printStackTrace();
        }
    }

}
