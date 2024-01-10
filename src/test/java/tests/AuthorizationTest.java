package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AuthorizationPage;
import pages.HomePage;

public class AuthorizationTest extends BaseTest{
    @Test
    public void authorizationTest(){
        User user = new User("testerovich.00@mail.ru", "Qwerty123-");
        HomePage homePage = new HomePage();
        AuthorizationPage authorizationPage = new AuthorizationPage();

        homePage.openAuthorizationPage();
        authorizationPage.login(user.getEmail(), user.getPassword());

        Assert.assertTrue(homePage.isUserAuthorized());

        homePage.logout();

        Assert.assertFalse(homePage.isUserAuthorized());
    }
}
