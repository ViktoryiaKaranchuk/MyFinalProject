package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Assert;
import utils.DriverProvider;

public class SearchTest extends DriverProvider {

    @BeforeMethod
    public void setUp() throws InterruptedException {
        getCurrentDriver().get("https://www.mediaexpert.pl/");
        driver.findElement(By.cssSelector("#onetrust-accept-btn-handler")).click();

        waitForJQueryToBeActive();
    }

    @AfterMethod
    public void tearDown() {
        closeDriver();
    }

    @Test
    public void findCatFromSearchField() {
        homePage.fieldSearch().click();
        homePage.fieldSearch().sendKeys("Honor");
        homePage.fieldSearch().sendKeys(Keys.ENTER);

        Assert.checkCountCats(homePage.offersList().stream().count());
    }

    @Test
    public void findCatFromSearchFieldWithLogin() {
        new SuccessfulLoginTest().testLoginAndVerifyWelcomeMessage();

        homePage.fieldSearch().click();
        homePage.fieldSearch().sendKeys("Honor");
        homePage.fieldSearch().sendKeys(Keys.ENTER);

        Assert.checkCountCats(homePage.offersList().stream().count());
    }

}
