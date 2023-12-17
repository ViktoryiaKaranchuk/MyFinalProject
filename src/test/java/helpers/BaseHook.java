package helpers;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverProvider;

import static helpers.Waits.waitForJQueryToBeActive;

public class BaseHook extends CommonData {

    @BeforeMethod
    public void setUp() throws InterruptedException {
        DriverProvider.getCurrentDriver().get(baseUrl);
        DriverProvider.driver.findElement(By.cssSelector("#onetrust-accept-btn-handler")).click();

        waitForJQueryToBeActive();
    }

    @AfterMethod
    public void tearDown() {
        DriverProvider.closeDriver();
    }
}
