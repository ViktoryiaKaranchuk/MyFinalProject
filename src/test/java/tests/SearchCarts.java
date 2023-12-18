package tests;

import helpers.BaseHook;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchCarts extends BaseHook {
    @Test
    public void testSearchCart() throws InterruptedException {
        var listOffers = mainPage.fieldSearchCarts("honor");

        Assert.assertTrue(listOffers.stream().count() > 0);
    }
    @Test
    public void testSearchCartEmptyField() throws InterruptedException {
        var listOffers = mainPage.fieldSearchCarts(" ");

        Assert.assertNull(listOffers, null);
    }

}