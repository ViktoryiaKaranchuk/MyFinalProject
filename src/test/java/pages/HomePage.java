package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.DriverProvider.driver;

public class HomePage {
    By titleLogin = By.cssSelector("h3.headline");

    public WebElement titleLogin() {
        return  driver.findElement(titleLogin);
    }

}
