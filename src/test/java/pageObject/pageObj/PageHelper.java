package pageObject.pageObj;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class PageHelper {

    public static void switchToOtherTab(WebDriver driver) {
        Set handles = driver.getWindowHandles();
        //  System.out.println(handles);
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
    }

}
