package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static utils.DriverProvider.driver;

public class Waits {

    public static void scrollIntoView(WebElement ele) throws InterruptedException {
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(" + ele.getLocation().x + "," + ele.getLocation().y + ")");
        waitForJQueryToBeActive();
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
