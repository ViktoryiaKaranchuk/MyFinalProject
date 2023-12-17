package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverProvider {
    public static WebDriver driver;

    private static void init() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static WebDriver getCurrentDriver() {
        init();

        return driver;
    }

    public static void closeDriver() {
        try {
            driver.quit();
        } catch (org.openqa.selenium.NoSuchSessionException e) {
            driver.close();
        }

    }
}
