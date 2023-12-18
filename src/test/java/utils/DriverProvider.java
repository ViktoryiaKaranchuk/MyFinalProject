package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.AccountPage;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class DriverProvider extends Hooks {
    public User user = new User("testerovich.00@mail.ru", "Qwerty123-");
    public LoginPage loginPage = new LoginPage();
    public AccountPage accountPage = new AccountPage();
    public HomePage homePage = new HomePage();
    public BasePage basePage = new BasePage();
    public static WebDriver driver;

    public static WebDriver getCurrentDriver() {
            if (driver == null) {
                init();
            }
            return driver;
    }

    private static void init() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        driver.manage().window().setSize(new Dimension(1920,1080));
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
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

    public static void refreshPage() throws InterruptedException {
        driver.navigate().refresh();
        waitForJQueryToBeActive();
    }

    public static void backToPage() throws InterruptedException {
        driver.navigate().back();
        waitForJQueryToBeActive();
    }
}
