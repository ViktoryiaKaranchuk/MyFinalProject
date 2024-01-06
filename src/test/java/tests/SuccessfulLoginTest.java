package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.AccountPage;


public class SuccessfulLoginTest extends BaseTest {

    @Test
    public void testLoginAndVerifyWelcomeMessage() {
        User standardUser = new User("testerovich.00@mail.ru", "Qwerty123-");
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        homePage.goToLoginPage();

        loginPage.doLogin(standardUser.getLogin(), standardUser.getPassword());

        AccountPage accountPage = new AccountPage();

        String welcomeMessage = accountPage.getWelcomeMessage();
        Assert.assertEquals(welcomeMessage, "Witaj, Klubowicz!", "Welcome message is incorrect");

    }
}


