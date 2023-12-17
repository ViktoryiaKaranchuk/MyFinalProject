package tests;

import helpers.BaseHook;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MainPage;


public class SuccessfulLoginTest extends BaseHook {
    MainPage mainPage = new MainPage();
    HomePage homePage = new HomePage();


    @Test
    public void testLoginAndVerifyWelcomeMessage() throws InterruptedException {
        mainPage.login();
        Assert.assertEquals(homePage.titleLogin().getText(), expectTitle);
    }
}



