package tests;

import models.Product;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class AddProductToCartTest extends BaseTest{

    @Test
    public void addProductToCartTest(){
        HomePage homePage = new HomePage();
        ProductsListPage productsListPage = new ProductsListPage();
        ProductPage productPage = new ProductPage();
        WindowAddedToCartPage windowAddedToCartPage = new WindowAddedToCartPage();
        CartPage cartPage = new CartPage();

        homePage.openPerfumyCatalog();
        productsListPage.openFirstProduct();

        Product choseProduct = productPage.getCurrentProduct();

        productPage.addToCart();
        windowAddedToCartPage.clickGoToCart();

        Product productFromCart = cartPage.getCurrentProductFromCart();

        Assert.assertEquals(choseProduct.getPrice(), productFromCart.getPrice());
    }
}
