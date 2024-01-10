package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.DriverProvider.getCurrentDriver;

public class WindowAddedToCartPage extends BasePage{
    String goToCartButtonXpath = "//a[@class='btn --solid --medium added__button --add']";

    public void clickGoToCart(){
        WebDriverWait wait = new WebDriverWait(getCurrentDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(goToCartButtonXpath)));

        WebElement goToCartButton = getCurrentDriver().findElement(By.xpath(goToCartButtonXpath));
        goToCartButton.click();
    }
}
