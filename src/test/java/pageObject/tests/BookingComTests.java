package pageObject.tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import pageObject.pageObj.*;
import pageObject.util.Waiters;

public class BookingComTests {
    WebDriver driver = new ChromeDriver();

    @Test
    public void checkSearch() {
        BookingSearchPage bookingSearchPage = new BookingSearchPage(driver);
        bookingSearchPage.changeLanguage("en-us");
        bookingSearchPage.search("New York", "2019-09-01", "2019-09-30");

        PageHelper pageHelper = new PageHelper();
        pageHelper.switchToOtherTab(driver);

        HotelPageObject hotelPageObject = new HotelPageObject();
        String checkinInfo = hotelPageObject.getTitle(driver);
        Assert.assertTrue("Header does not contains New York", checkinInfo.contains("New York"));

        BookingSearchResultPage bSearchResultPage = new BookingSearchResultPage();
        bSearchResultPage.chooseFirstElementInHotelList(driver, 0);

        pageHelper.switchToOtherTab(driver);

        HotelPageObject checkinDayText = new HotelPageObject();
        String checkinDay = checkinDayText.getCheckIn(driver);
        Assert.assertTrue("Checking day time is not that same", checkinDay.contains("Sept 1, 2019"));

        HotelPageObject checkoutDayText = new HotelPageObject();
        String checkOut = checkoutDayText.getCheckOut(driver);
        Assert.assertTrue("Checkout day time is not that same", checkOut.contains("Sept 30, 2019"));
    }

    @Test
    public void checkSignIn() {
        BookingSearchPage bookingSearchPage = new BookingSearchPage(driver);
        bookingSearchPage.changeLanguage("en-us");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.pressSignInBtn();

        PageHelper.switchToOtherTab(driver);
        loginPage.login(System.getProperty("booking.login"), System.getProperty("booking.password"));

        PageHelper.switchToOtherTab(driver);

        By userNameBy = By.xpath("//li[@id='current_account']//span[@class='user_name_block']");
        Waiters.waitForElementPresent(driver, userNameBy);

        WebElement userName = driver.findElement(userNameBy);
        Assert.assertEquals("There is not expected name on the page", "Ivanna Volochchak", userName.getText());
    }


    @Test
    public void checkSignOut() {
        BookingSearchPage bookingSearchPage = new BookingSearchPage(driver);
        bookingSearchPage.changeLanguage("en-us");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.pressSignInBtn();

        PageHelper.switchToOtherTab(driver);
        loginPage.login(System.getProperty("booking.login"), System.getProperty("booking.password"));

        PageHelper.switchToOtherTab(driver);

        SignOutPage signOutPage = new SignOutPage(driver);
        signOutPage.clickSignOutButton();
        Assert.assertTrue("Sign in was not found", bookingSearchPage.isSignInDisplayed());
    }

    @AfterTest
    public void after(){
        driver.close();
    }

}

