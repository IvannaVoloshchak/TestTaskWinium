package pageObject.pageObj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BookingSearchResultPage {
    public void chooseFirstElementInHotelList(WebDriver driver, int num) {
        List<WebElement> hotelsLink = driver.findElements(By.xpath("//div[@id='hotellist_inner']//a[@class='hotel_name_link url']"));
        hotelsLink.get(num).click();
    }
}
