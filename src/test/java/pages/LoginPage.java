package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.DriverProvider.driver;

public class LoginPage {
    By emailSelector = By.cssSelector("input[type=email]");
    By passwordSelector = By.cssSelector("input[type=password]");
    By loginButtonSelector = By.cssSelector("button > span");
    String userProfileIconClass = "";

    public WebElement emailSelector() {
        return driver.findElement(emailSelector);
    }
    public WebElement passwordSelector() {
        return driver.findElement(passwordSelector);
    }
    public WebElement loginButtonSelector() {
        return driver.findElements(loginButtonSelector).get(4);
    }

}
