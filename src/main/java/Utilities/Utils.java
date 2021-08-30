package Utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Utils extends Setup {

    public static void holdExecution(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static WebElement wait(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void click(WebElement element) {
        try {
            wait(element);
            element.click();
        } catch (NoSuchElementException e) {
            element.click();
            holdExecution(10);
        } catch (StaleElementReferenceException e) {
            element.click();
            holdExecution(10);
        }
    }

    public static void enterText(WebElement element, String text) {
        try {
            wait(element).clear();
            element.sendKeys(text);
        } catch (NoSuchElementException e) {
            element.sendKeys(text);
            holdExecution(10);
        } catch (StaleElementReferenceException e) {
            element.sendKeys(text);
            holdExecution(10);
        }
    }

    public static boolean isDisplayed(WebElement element) {
        boolean flag = false;
        try {
            if (element.isDisplayed())
                flag = true;
        } catch (NoSuchElementException e) {
            flag = false;
        }
        return flag;
    }

    public static boolean arePresent(List<WebElement> elements, List<String> actual) {
        boolean flag = false;
        for (int i = 0; i < actual.size(); i++) {
            if (elements.get(i).getText().equalsIgnoreCase(actual.get(i))) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public void enterTextForListOfElements(List<WebElement> elements, List<String> text) {
        for (int i = 0; i < text.size(); i++) {
            enterText(elements.get(i), text.get(i));
        }
    }

    public void switchToFrame(String id) {
        driver.switchTo().frame(id);
    }

    public void switchToFrame(int index) {
        driver.switchTo().frame(index);
    }

    public void switchToFrame(WebElement element) {
        try {
            driver.switchTo().frame(element);
        } catch (NoSuchWindowException e) {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
        } catch (WebDriverException e) {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
        }
    }


    public boolean areDisplayed(List<WebElement> elements) {
        boolean flag = false;
        for (WebElement e : elements) {
            if (isDisplayed(e)) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static boolean isPresent(WebElement element, String actual) {
        boolean flag = false;
        if (element.getText().equals(actual)) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public void scrollTillTheElementIsVisible(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", element);
    }

    public void switchToDefaultContent(){
        driver.switchTo().defaultContent();
    }
}
