package pages;

import helpers.CommonData;
import helpers.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.DriverProvider;

import java.util.List;

import static helpers.Waits.*;
import static utils.DriverProvider.driver;

public class HomePage extends CommonData {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    By titleLogin = By.cssSelector("h3.headline");
    By titleShoppingCart = By.cssSelector("div.header-tooltip.is-active");
    By shoppingCart = By.cssSelector("i.icon.utility-nav-icon.icon-cart3");
    By addCart = By.cssSelector(".add-to-cart");
    By totalPrice = By.cssSelector("span.total-value");
    By iconBasket = By.cssSelector(".icon-basket");
    By primaryBtn = By.cssSelector(".dialog .is-primary");
    public String price1;
    public String price2;

    public WebElement titleLogin() throws InterruptedException {
        waitForJQueryToBeActive();
        return  driver.findElement(titleLogin);
    }

    public WebElement shoppingCart() throws InterruptedException {
        waitForJQueryToBeActive();
        return driver.findElement(shoppingCart);
    }

    public WebElement shoppingCartTitle() throws InterruptedException {
        waitForJQueryToBeActive();
        return driver.findElement(titleShoppingCart);
    }

    public void clickBtnAddCart() throws InterruptedException {
        waitForJQueryToBeActive();
        driver.navigate().refresh();
        closeModal();
        driver.findElements(addCart).get(1).click();
    }

    public String getTotalPrice() {
        return driver.findElement(totalPrice).getText();
    }

    public List<WebElement> iconBasket() { return driver.findElements(iconBasket); }
    public WebElement primaryBtn() { return driver.findElement(primaryBtn); }

    public void checkEmptyCart() throws InterruptedException {
        driver.navigate().refresh();
        shoppingCart().click();
        waitForJQueryToBeActive();

        Assert.assertEquals(shoppingCartTitle().getText(), CommonData.titleShoppingCart);
    }
    public void closeModal() throws InterruptedException {
        if (driver.findElement(By.cssSelector(".close")).isDisplayed()) {
            driver.navigate().refresh();
        }
        Thread.sleep(2000);
        if (driver.findElement(By.cssSelector(".close")).isDisplayed()) {
            driver.navigate().refresh();
        }
    }

    public String getPriceFromAddedCart(String link) throws InterruptedException {
        DriverProvider.driver.get(link);
        waitForJQueryToBeActive();
        closeModal();

        clickBtnAddCart();
        waitForJQueryToBeActive();
        closeModal();

        DriverProvider.driver.navigate().refresh();
        shoppingCart().click();

        // added first cart and remember price cost
        return getTotalPrice();
    }
}
