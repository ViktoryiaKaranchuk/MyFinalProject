package pages;

import helpers.BaseHook;
import helpers.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static utils.DriverProvider.driver;

public class MainPage extends BaseHook {
    By buttonArrow = By.cssSelector("i.icon:nth-child(3)");
    By buttonLogin = By.cssSelector("a.spark-button");
    By fieldEmail = By.cssSelector("input[type=email]");
    By fieldPassword = By.cssSelector("input[type=password]");
    By buttonLoginInForm = By.cssSelector("button > span");


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


    public void login() throws InterruptedException {
        hoverToArrow();
        buttonLogin().click();
        fieldEmail().sendKeys(userLogin);
        fieldPassword().sendKeys(userPassword);
        loginButtonInForm().click();
        Waits.waitForJQueryToBeActive();
    }
}
