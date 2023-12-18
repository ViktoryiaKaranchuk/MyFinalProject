package pages;

import helpers.BaseHook;
import helpers.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static utils.DriverProvider.driver;

public class MainPage extends BaseHook {
    By buttonArrow = By.cssSelector("i.icon:nth-child(3)");
    By buttonLogin = By.cssSelector("a.spark-button");
    By fieldEmail = By.cssSelector("input[type=email]");
    By fieldPassword = By.cssSelector("input[type=password]");
    By buttonLoginInForm = By.cssSelector("button > span");
    By fieldSearch = By.cssSelector(".search-input > div >  input");
    By iconSearch = By.cssSelector(".icon-search01");
    By offersList = By.cssSelector(".offers-list > span");


    public void hoverToArrow() {
        Actions act = new Actions(driver);
        var button = driver.findElement(buttonArrow);
        act.moveToElement(button).perform(); //This opens menu list
    }

    public WebElement buttonLogin() {
        return driver.findElement(buttonLogin);
    }

    public WebElement fieldEmail() {
        return driver.findElement(fieldEmail);
    }

    public WebElement fieldPassword() {
        return driver.findElement(fieldPassword);
    }

    public WebElement loginButtonInForm() {
        return driver.findElements(buttonLoginInForm).get(4);
    }
    public WebElement fieldSearch() { return driver.findElements(fieldSearch).get(2); }
    public WebElement iconSearch() { return driver.findElement(iconSearch); }
    public List<WebElement> offersList() { return driver.findElements(offersList); }

    public void login() throws InterruptedException {
        hoverToArrow();
        buttonLogin().click();
        fieldEmail().sendKeys(userLogin);
        fieldPassword().sendKeys(userPassword);
        loginButtonInForm().click();
        Waits.waitForJQueryToBeActive();
    }

    public List<WebElement> fieldSearchCarts(String nameCart) {
        fieldSearch().click();
        fieldSearch().sendKeys(nameCart);
        fieldSearch().sendKeys(Keys.ENTER);


        if (offersList().stream().count() > 0) {
            return offersList();
        } else {
            return null;
        }
    }
}
