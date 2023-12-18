package tests;

import org.testng.annotations.Test;
import static utils.Assert.*;

public class SuccessfulLoginTest extends BaseTest {
    @Test
    public void testLoginAndVerifyWelcomeMessage() {
        homePage.buttonArrow().click();
        homePage.buttonLogin().click();

        loginPage.emailSelector().sendKeys(user.getLogin());
        loginPage.passwordSelector().sendKeys(user.getPassword());
        loginPage.loginButtonSelector().click();

        checkWelcomeText(accountPage.titleLogin().getText());
    }
}



