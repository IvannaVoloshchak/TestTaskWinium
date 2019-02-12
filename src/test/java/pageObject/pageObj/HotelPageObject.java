package pageObject.pageObj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HotelPageObject {

    public String getTitle(WebDriver driver) {
        WebElement checkinDay = driver.findElement(By.xpath("//div[@class='sr_header--title']"));
        return checkinDay.getText();
    }


    public String getCheckOut(WebDriver driver) {
        WebElement checkinDay = driver.findElement(By.xpath("//div[@class='av-summary-section']//a[contains(@class, 'checkout')]"));
        return checkinDay.getText();
    }

    public String getCheckIn(WebDriver driver) {
        WebElement checkinDay = driver.findElement(By.xpath("//div[@class='av-summary-content']//a[contains(@class,'checkin')]"));
        return checkinDay.getText();
    }
}
