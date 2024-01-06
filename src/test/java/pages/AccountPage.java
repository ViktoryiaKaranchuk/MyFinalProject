package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

import static utils.DriverProvider.getCurrentDriver;

public class AccountPage {
    String welcomeMessageXpath = "//*[@class ='Heading-module--general__346K- CardFront--name__3inwC Heading-module--medium__3LaeM']";

    public String getWelcomeMessage() {
        WebDriverWait wait = new WebDriverWait(getCurrentDriver(), Duration.ofSeconds(30));
        WebElement welcomeMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(welcomeMessageXpath)));
        return welcomeMessageElement.getText().trim();

    }
    public void assertWelcomeMessage(String expectedMessage) {
        String actualMessage = getWelcomeMessage();
        Assert.assertEquals(actualMessage, expectedMessage);

    }
}

