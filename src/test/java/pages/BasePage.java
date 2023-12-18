package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utils.DriverProvider.driver;

public class BasePage {
    By cart =  By.cssSelector(".utility-nav-icon.icon-cart3");
    By tooltipMessage =  By.cssSelector(".header-tooltip.is-active");
    By listCart =  By.cssSelector(".add-button.add-to-cart");
    By totalValue =  By.cssSelector(".total-value");

    public WebElement totalValue() {
        return driver.findElement(totalValue);
    }

    public List<WebElement> getListCart() {
        return driver.findElements(listCart);
    }

    public WebElement cart() {
        return driver.findElement(cart);
    }

    public WebElement tooltipMessage() {
        return driver.findElement(tooltipMessage);
    }

}
