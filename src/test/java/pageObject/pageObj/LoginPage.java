package pageObject.pageObj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObject.util.Waiters;

public class LoginPage extends Page {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void pressSignInBtn() {
        WebElement signInBooking = driver.findElement(By.xpath("//div[@id='top']//a[contains(@data-command-params,'tab=signin')]"));
        signInBooking.click();
    }

    public void login(String login, String password) {
        if (driver.getCurrentUrl().contains("https://account.booking.com")) {
            loginFromNewPage(login, password);

        } else {
            loginFromPopup(login, password);
        }
    }

    private void loginFromNewPage(String login, String password) {
        WebElement enterEmail = driver.findElement(By.name("username"));
        enterEmail.clear();
        enterEmail.sendKeys(login);
        // enterEmail.sendKeys(System.getProperty("booking.login"));
        WebElement enterButton = driver.findElement(By.xpath("//div//button[@type='submit']"));
        enterButton.click();
        Waiters.waitForElementVisible(driver, By.name("password"));
        WebElement passwordEnter = driver.findElement(By.name("password"));
        passwordEnter.clear();
        // passwordEnter.sendKeys(System.getProperty("booking.password"));
        passwordEnter.sendKeys(password);
        WebElement signInBtn = driver.findElement(By.xpath("//div//button[@type='submit']"));
        signInBtn.click();
    }

    private void loginFromPopup(String login, String password) {
        WebElement enterEmail = driver.findElement(By.name("username"));
        enterEmail.clear();
        enterEmail.sendKeys(login);
        WebElement passwordEnter = driver.findElement(By.name("password"));
        passwordEnter.clear();
        //passwordEnter.sendKeys(System.getProperty("booking.password"));
        passwordEnter.sendKeys(password);
        WebElement signInBtn = driver.findElement(By.xpath("//div[@role='dialog']//following-sibling::div//input[@value='Sign in']"));
        signInBtn.click();
    }
}
