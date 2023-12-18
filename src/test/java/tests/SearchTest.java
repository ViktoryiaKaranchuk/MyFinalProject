package tests;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import utils.Assert;
import utils.DriverProvider;

public class SearchTest extends DriverProvider {
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
