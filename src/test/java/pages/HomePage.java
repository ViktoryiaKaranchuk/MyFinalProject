package pages;

import helpers.CommonData;
import helpers.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.DriverProvider;

import static utils.DriverProvider.driver;

public class HomePage extends CommonData {
    By titleLogin = By.cssSelector("h3.headline");
    By titleShoppingCart = By.cssSelector("div.header-tooltip.is-active");
    By shoppingCart = By.cssSelector("i.icon.utility-nav-icon.icon-cart3");
    By addCart = By.cssSelector(".add-to-cart");
    By totalPrice = By.cssSelector("span.total-value");
    public String price1;
    public String price2;

    public WebElement titleLogin() {
        return  driver.findElement(titleLogin);
    }

    public WebElement shoppingCart() {
        return driver.findElement(shoppingCart);
    }

    public WebElement shoppingCartTitle() {
        return driver.findElement(titleShoppingCart);
    }

    public void clickBtnAddCart() {
        driver.findElements(addCart).get(1).click();
    }

    public String getTotalPrice() {
        return driver.findElement(totalPrice).getText();
    }

    public void checkEmptyCart() throws InterruptedException {
        shoppingCart().click();
        Waits.waitForJQueryToBeActive();

        Assert.assertEquals(shoppingCartTitle().getText(), CommonData.titleShoppingCart);
    }

    public String getPriceFromAddedCart(String link) throws InterruptedException {
        DriverProvider.driver.get(link);
        Waits.waitForJQueryToBeActive();

        clickBtnAddCart();
        Waits.waitForJQueryToBeActive();

        DriverProvider.driver.navigate().refresh();
        shoppingCart().click();

        // added first cart and remember price cost
        return getTotalPrice();
    }
}
