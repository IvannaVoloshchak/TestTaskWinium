package pageObject.pageObj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObject.util.Waiters;

public class SignOutPage extends Page {

    public SignOutPage(WebDriver driver) {
        super(driver);
    }

    public void clickSignOutButton() {
        By userNameBy = By.xpath("//li[@id='current_account']//span[@class='user_name_block']");
        Waiters.waitForElementPresent(driver, userNameBy);
        WebElement userName = driver.findElement(userNameBy);
        WebElement closeAlertBtn = driver.findElement(By.xpath("//div //button[@title='Close']"));
       if (closeAlertBtn.isEnabled()) {
            closeAlertBtn.click();
        }
        userName.click();

        WebElement singOutBtn = driver.findElement(By.xpath("//div[contains(@class,'profile-menu')]//input[last()]"));
        singOutBtn.click();
    }


}
