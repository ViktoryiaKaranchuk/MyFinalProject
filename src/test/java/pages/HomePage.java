package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.DriverProvider.driver;

public class HomePage {
    By buttonArrow = By.xpath("//*[@id=\"section_header-desktop\"]/div/div/div[3]/div[2]/div[1]/i");
    By buttonLogin = By.cssSelector("a.spark-button");

    public WebElement buttonArrow() {
        return driver.findElement(buttonArrow);
    }

    public WebElement buttonLogin() {
        return driver.findElement(buttonLogin);
    }
}
