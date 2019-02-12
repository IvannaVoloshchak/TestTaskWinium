package pageObject.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiters {
    public static final int WAIT_60 = 60;

    public static void waitForElementPresent(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_60);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static void waitForElementVisible(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
