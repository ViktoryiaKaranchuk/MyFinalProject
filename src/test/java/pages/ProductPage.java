package pages;

import models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.DriverProvider.getCurrentDriver;

public class ProductPage extends BasePage{
    String addToCartButtonId = "projector_button_basket";
    String nameProductXpath = "//div[@class='product_name__wrapper']";
    String priceProductId = "projector_price_value";

    public void addToCart(){
        WebElement addToCartButton = getCurrentDriver().findElement(By.id(addToCartButtonId));
        //Click doesn't work
        addToCartButton.submit();
    }

    public Product getCurrentProduct(){
        WebElement nameProduct = getCurrentDriver().findElement(By.xpath(nameProductXpath));
        WebElement priceProduct = getCurrentDriver().findElement(By.id(priceProductId));

        return new Product(nameProduct.getText(), getPriceDouble(priceProduct));
    }
}
