package tests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.DriverProvider;
import static utils.Assert.*;

public class SuccessfulLoginTest extends DriverProvider {

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
    public void testLoginAndVerifyWelcomeMessage() {
        homePage.buttonArrow().click();
        homePage.buttonLogin().click();

        loginPage.emailSelector().sendKeys(user.getLogin());
        loginPage.passwordSelector().sendKeys(user.getPassword());
        loginPage.loginButtonSelector().click();

        checkWelcomeText(accountPage.titleLogin().getText());
    }
}



