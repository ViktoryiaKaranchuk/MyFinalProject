package tests;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.Assert;
import utils.DriverProvider;

import static utils.Assert.checkSumBeforAndAfter;
import static utils.Assert.checkTooltip;

public class BaseTest extends DriverProvider {
    @Test
    public void emptyCart() {
        basePage.cart().click();
        checkTooltip(basePage.tooltipMessage().getText());
    }

    @Test
    public void addCart() throws InterruptedException {
        homePage.fieldSearch().click();
        homePage.fieldSearch().sendKeys("Honor");
        homePage.fieldSearch().sendKeys(Keys.ENTER);

        //1
        Thread.sleep(5000);
        basePage.getListCart().get(0).click();
        refreshPage();
        basePage.cart().click();
        waitForJQueryToBeActive();

        var firstTotalPrice = basePage.totalValue().getText();

        //
        backToPage();

        //2
        basePage.getListCart().get(1).click();
        Thread.sleep(3000);
        refreshPage();
        basePage.cart().click();
        waitForJQueryToBeActive();

        var secondTotalPrice = basePage.totalValue().getText();

        checkSumBeforAndAfter(firstTotalPrice, secondTotalPrice);
    }
}
