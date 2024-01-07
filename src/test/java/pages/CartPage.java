package pages;

import models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.DriverProvider.getCurrentDriver;

public class CartPage extends BasePage{
    String nameProductXpath = "//div[@class='basket__name']";
    String priceProductXpath = "//span[@class='basket__price']";

    public Product getCurrentProductFromCart(){
        WebElement nameProduct = getCurrentDriver().findElement(By.xpath(nameProductXpath));
        WebElement priceProduct = getCurrentDriver().findElement(By.xpath(priceProductXpath));

        return new Product(nameProduct.getText(), getPriceDouble(priceProduct));
    }
}
