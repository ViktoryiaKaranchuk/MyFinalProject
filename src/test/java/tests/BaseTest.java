package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import static utils.DriverProvider.closeDriver;
import static utils.DriverProvider.getCurrentDriver;

public class BaseTest {
    String closeMessageAboutCookiesButtonXpath = "//span[@class='ck_dsclr__btn_v2']";
String x;
    @BeforeMethod
    public void setUp() {
        getCurrentDriver().get("https://www.ezebra.pl/");
        closeMessageAboutCookies();
    }

    @AfterMethod
    public void tearDown() {
        closeDriver();
    }


    public void closeMessageAboutCookies() {
        WebDriverWait wait = new WebDriverWait(getCurrentDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(closeMessageAboutCookiesButtonXpath)));

        WebElement closeMessageAboutCookiesButton = getCurrentDriver().findElement(By.xpath(closeMessageAboutCookiesButtonXpath));
        closeMessageAboutCookiesButton.click();
    }
}
