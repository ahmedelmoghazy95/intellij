package com.sumerge.momra.utilities;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Utilities {

    public static String waitAndGetWebElementText(WebElement element, WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(element));
        String textValue = element.getAttribute("value");
        if (textValue != null && textValue.length() > 0)
            return element.getAttribute("value");
        else
            return element.getText();
    }

    public static void waitAndClickOnWebElement(WebElement webElement, WebDriverWait wait, WebDriver driver) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
        } catch(NoSuchElementException | TimeoutException e) {
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
            webElement.click();
        }
    }

    public static void waitUntilSelectHasOptions(WebElement webElement, WebDriverWait wait) {
        final Select dropdown = new Select(webElement);

        wait.until(new ExpectedCondition<Boolean>() {
            @NullableDecl
            @Override
            public Boolean apply(@NullableDecl WebDriver driver) {
                return (dropdown.getOptions().size() > 1);
            }
        });
    }

    public static void waitClearAndSetInputField(WebElement element, String value, WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(value);
    }

    public static void waitAndSelectByVisibleText(WebElement element, String value, WebDriverWait wait) {
        waitUntilSelectHasOptions(element, wait);
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(value);
    }

    public static String waitAndGetCheckBoxValue(WebElement element, WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getAttribute("aria-checked");
    }

    public static boolean isAttribtuePresent(WebElement element, String attribute) {
        Boolean result = false;
        try {
            String value = element.getAttribute(attribute);
            if (value != null) {
                result = true;
            }
        } catch (Exception e) {
            System.out.println("A Handled Exception is Thrown");
            e.printStackTrace();
        }

        return result;
    }

    public static boolean isClassPresent(WebElement element, String className) {
        Boolean result = false;
        try {
            String value = element.getAttribute("class");
            if (value != null && value.contains(className)) {
                result = true;
            }
        } catch (Exception e) {
            System.out.println("A Handled Exception is Thrown");
            e.printStackTrace();
        }

        return result;
    }

    public static boolean isFieldDisplayed(WebElement element, WebDriverWait wait) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        } catch (NoSuchElementException | TimeoutException | StaleElementReferenceException e) {
            System.out.println("A Handled Exception is Thrown");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isFieldMandatory(WebElement element, String validClassName, String invalidClassName, WebDriverWait wait, WebDriver driver) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            String fieldText = element.getAttribute("value");
            element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            for (int i = 0; i < 11; i++)
                element.sendKeys(Keys.BACK_SPACE);
            if (isClassPresent(element, invalidClassName)) {
                waitAndClickOnWebElement(element, wait, driver);
                int count = fieldText.length();
                if (fieldText.length() > 0)
                    element.sendKeys(fieldText);
                else
                    element.sendKeys("1");
                return isClassPresent(element, validClassName);
            } else {
                return false;
            }
        } catch (InvalidElementStateException e) {
            System.out.println("This Field have Thrown an Exception: " + element.getAttribute("id"));
            e.printStackTrace();
            return true;
        } catch (NoSuchElementException | TimeoutException e) {
            System.out.println("A Handled Exception is Thrown" + element);
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isFieldOptional(WebElement element, String className, WebDriverWait wait, WebDriver driver) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            String fieldText = element.getAttribute("value");
            element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            for (int i = 0; i < 11; i++)
                element.sendKeys(Keys.BACK_SPACE);
            if (!isClassPresent(element, className)) {
                waitAndClickOnWebElement(element, wait, driver);
                element.sendKeys(fieldText);
                return !isClassPresent(element, className);
            } else {
                return false;
            }
        } catch (InvalidElementStateException e) {
            System.out.println("This Field have Thrown an Exception: " + element.getAttribute("id"));
            e.printStackTrace();
            return false;
        } catch (NoSuchElementException | TimeoutException e) {
            System.out.println("A Handled Exception is Thrown");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isFieldAcceptingNumbers(WebElement element, String className, WebDriverWait wait) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            for (int i = 0; i < 11; i++)
                element.sendKeys(Keys.BACK_SPACE);
            element.sendKeys("01234567899");
            if(element.getAttribute("value").length() > 0) {
                return isClassPresent(element, className);
            } else {
                return false;
            }
        } catch(NoSuchElementException | TimeoutException e) {
            System.out.println("A Handled Exception is Thrown");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isFieldAcceptingString(WebElement element, String className, WebDriverWait wait) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            for (int i = 0; i < 11; i++)
                element.sendKeys(Keys.BACK_SPACE);
            element.sendKeys("abc dfgh");
            if(element.getAttribute("value").length() > 0) {
                return isClassPresent(element, className);
            } else {
                return false;
            }
        } catch(NoSuchElementException | TimeoutException e) {
            System.out.println("A handled exception is thrown");
            e.printStackTrace();
            return false;
        }

    }

    public static boolean isFieldAcceptingSpecialCharacters(WebElement element, String className, WebDriverWait wait) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            for (int i = 0; i < 11; i++)
                element.sendKeys(Keys.BACK_SPACE);
            element.sendKeys("% @$# () !*& _ = '\" ?<> ");
            if(element.getAttribute("value").length() > 0) {
                return isClassPresent(element, className);
            } else {
                return false;
            }
        } catch(NoSuchElementException | TimeoutException e) {
            System.out.println("A handled exception is thrown");
            e.printStackTrace();
            return false;
        }
    }

}
