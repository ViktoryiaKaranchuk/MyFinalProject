package tests;

import org.testng.annotations.Test;
import utils.AssertsFromData;

public class SuccessfulLoginTest extends BaseTest {

    @Test
    public void testLoginAndVerifyWelcomeMessage() throws InterruptedException {
        homePage.buttonArrow().click();
        homePage.buttonLogin().click();

        loginPage.emailSelector().sendKeys(user.getLogin());
        loginPage.passwordSelector().sendKeys(user.getPassword());
        loginPage.loginButtonSelector().click();


        AssertsFromData.checkWelcomeText(accountPage.titleLogin().getText());
    }
}



