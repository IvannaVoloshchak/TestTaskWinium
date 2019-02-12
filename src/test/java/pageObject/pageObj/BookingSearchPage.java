package pageObject.pageObj;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class BookingSearchPage extends Page {
    public static final String BOOKING_URL = "https://www.booking.com";

    public BookingSearchPage(WebDriver driver) {
        super(driver);
        open();
    }
    public void open() {
        driver.get(BOOKING_URL);
        driver.manage().window().maximize();
    }
    public void search(String city, String checkIn, String checkOut) {
        setCityName(city);
        WebElement chooseDate = driver.findElement(By.xpath("//div[@class='xp__dates-inner']"));
        chooseDate.click();
        selectDate(checkIn);
        selectDate(checkOut);
        WebElement submitSearchButton = driver.findElement(By.xpath("//form[@role=\"search\"]//button[@type='submit']"));
        submitSearchButton.click();
    }

    public void selectDate(String date){
        WebElement nextMonth = driver.findElement(By.xpath("//div[@data-bui-ref='calendar-next']"));
        WebElement month = driver.findElement(By.xpath("//div[@class='bui-calendar__month']"));
        while (!month.getText().equals("September 2019")) {
            nextMonth.click();
            nextMonth = driver.findElement(By.xpath("//div[@data-bui-ref='calendar-next']"));
            month = driver.findElement(By.xpath("//div[@class='bui-calendar__month']"));
        }
        WebElement dateElement = driver.findElement(By.xpath(String.format("//td[@data-date=\"%s\"]", date)));
        dateElement.click();
    }

    public void setCityName(String name) {
        WebElement setCityName = driver.findElement(By.xpath("//input[@type = 'search']"));
        setCityName.clear();
        setCityName.sendKeys(name);
    }
    public void changeLanguage(String lang) {
        By chosenLanguage =By.xpath(String.format("//div[@id=\"current_language_foldout\"]//a[contains(@hreflang, '%s')]", lang));
        WebElement language = driver.findElement(By.xpath("//li[@data-id=\"language_selector\"]"));
        language.click();
        WebElement engLanguage = driver.findElement(chosenLanguage);
        engLanguage.click();
    }

    public boolean isSignInDisplayed(){
        WebElement checkSignIn = driver.findElement(By.xpath("//div[@id='top']//a[contains(@data-command-params,'tab=signin')]"));
        return checkSignIn.isDisplayed();
    }

}
