package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utils.DriverProvider.driver;

public class HomePage {
    By buttonArrow = By.xpath("//*[@id=\"section_header-desktop\"]/div/div/div[3]/div[2]/div[1]/i");
    By buttonLogin = By.cssSelector("a.spark-button");
    By fieldSearch = By.cssSelector(".search-input > div >  input");
    By offersList = By.cssSelector(".offers-list > span");
    public WebElement buttonArrow() {
        return driver.findElement(buttonArrow);
    }

    public WebElement buttonLogin() {
        return driver.findElement(buttonLogin);
    }

    public WebElement fieldSearch() { return driver.findElements(fieldSearch).get(2); }
    public List<WebElement> offersList() { return driver.findElements(offersList); }
}
