package tests;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import pages.AccountPage;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import utils.DriverProvider;

import static utils.DriverProvider.closeDriver;
import static utils.DriverProvider.getCurrentDriver;

public class BaseTest extends DriverProvider {
    public User user = new User("testerovich.00@mail.ru", "Qwerty123-");
    public LoginPage loginPage = new LoginPage();
    public AccountPage accountPage = new AccountPage();
    public HomePage homePage = new HomePage();
    public BasePage basePage = new BasePage();

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

    public static void waitForJQueryToBeActive() throws InterruptedException {
        Boolean isJqueryUsed = (Boolean) ((JavascriptExecutor) driver)
                .executeScript("return (typeof(jQuery) != 'undefined')");
        if (isJqueryUsed) {
            while (true) {
                // JavaScript test to verify jQuery is active or not
                Boolean ajaxIsComplete = (Boolean) (((JavascriptExecutor) driver)
                        .executeScript("return jQuery.active == 0"));
                if (ajaxIsComplete)
                    break;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
            }
        }

        Thread.sleep(1000);
    }
}
