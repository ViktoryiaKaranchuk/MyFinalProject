package tests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static utils.DriverProvider.closeDriver;
import static utils.DriverProvider.getCurrentDriver;

public class BaseTest {

    @BeforeMethod
    public void setUp() {

        getCurrentDriver().get("https://www.mediaexpert.pl/");

    }

    @AfterMethod
    public void tearDown() {
        closeDriver();
    }
}
