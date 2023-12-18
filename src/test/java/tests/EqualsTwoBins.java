package tests;

import helpers.BaseHook;
import helpers.Waits;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MainPage;
import utils.DriverProvider;

public class EqualsTwoBins extends BaseHook {
    @Test
    public void testMatchingTwoPricesWithoutLogin() throws InterruptedException {
        homePage.checkEmptyCart();

        var totalPrice1 = homePage.getPriceFromAddedCart(linkIphone);
        var totalPrice2 = homePage.getPriceFromAddedCart(linkPhone2);

        Assert.assertEquals(totalPrice1, totalPrice1);
        Assert.assertNotEquals(totalPrice1, totalPrice2);
    }

    @Test
    public void testMatchingTwoPricesWithLogin() throws InterruptedException {
        mainPage.login();

        var totalPrice1 = homePage.getPriceFromAddedCart(linkIphone);
        var totalPrice2 = homePage.getPriceFromAddedCart(linkPhone2);

        Assert.assertEquals(totalPrice1, totalPrice1);
        Assert.assertNotEquals(totalPrice1, totalPrice2);
    }

}



