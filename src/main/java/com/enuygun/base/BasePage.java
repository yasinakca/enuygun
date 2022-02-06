package com.enuygun.base;

import com.enuygun.Log4j;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class BasePage {
    public WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20, 500);
    }

    public WebElement findElement(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void clickElement(By by) {
        try {
            WebElement element = findElement(by);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            Log4j.error("Could not click element");
        }
    }

    public void clickWithJs(By by) {
        try {
            WebElement element = findElement(by);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            Log4j.error("Could not execute javascript");
        }
    }

    public void sendKeys(By by, String text) {
        try {
            WebElement element = findElement(by);
            wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);
        } catch (Exception e) {
            Log4j.error("Could not send keys");
        }
    }

    public void sendKeysWithEnter(By by, String text) {
        try {
            WebElement element = findElement(by);
            wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text,Keys.ENTER);
        } catch (Exception e) {
            Log4j.error("Could not send keys");
        }
    }

    public void sendKeysWithJs(By by, String text) {
        try {
            JavascriptExecutor jse = ((JavascriptExecutor) driver);
            WebElement element = findElement(by);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            jse.executeScript("arguments[0].setAttribute('value', '" + text +"')", element);
        } catch (Exception e) {
            Log4j.error("Could not send keys");
        }
    }


    public void navigate(String url) {
        try {
            driver.navigate().to(url);
        } catch (Exception e) {
            Log4j.error("Could not navigate to page");
        }
    }

    public Actions getActions() {
        return new Actions(driver);
    }

    public void hoverElement(By by) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            getActions().moveToElement(findElement(by)).build().perform();
        } catch (Exception e) {
            Log4j.error("Could not hover");
        }
    }

    public void clear(By by) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(by)).clear();
        } catch (Exception e) {
            Log4j.error("Could not clear the input area");
        }
    }

    public String getText(By by) {
        return findElement(by).getText();
    }

    public void scrollDown(By by) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", findElement(by));
        } catch (Exception e) {
            Log4j.error("Could not execute javascript");
        }
    }

    public void manageWindowHandle() {
        try {
            String currentWindow = driver.getWindowHandle();
            Set<String> windows = driver.getWindowHandles();
            for (String window : windows) {
                if (!currentWindow.equals(window)) {
                    driver.switchTo().window(window);
                }
            }
        } catch (Exception e) {
            Log4j.info("Could not switch to window");
        }
    }
}