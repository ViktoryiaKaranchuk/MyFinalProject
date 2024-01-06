package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

import static utils.DriverProvider.getCurrentDriver;


public class HomePage {

    String userProfileIconXpath = "//*[@class ='wd3S']";


    public void goToLoginPage() {
        WebElement userProfileIcon = new WebDriverWait(getCurrentDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(userProfileIconXpath)));
        userProfileIcon.click();

    }
}