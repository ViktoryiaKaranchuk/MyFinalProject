package utils;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static utils.DriverProvider.*;

public class Hooks {

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

}
