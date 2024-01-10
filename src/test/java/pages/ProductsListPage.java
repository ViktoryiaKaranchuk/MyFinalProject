package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static utils.DriverProvider.getCurrentDriver;

public class ProductsListPage extends BasePage{
    String firstProductLinkXpath = "//div[@class='product col-6 col-sm-4 pt-3 pb-md-3'][1]";

    public void openFirstProduct(){
        Actions action = new Actions(getCurrentDriver());
        JavascriptExecutor js = (JavascriptExecutor) getCurrentDriver();

        WebElement firstProductLink = getCurrentDriver().findElement(By.xpath(firstProductLinkXpath));
        js.executeScript("arguments[0].scrollIntoView();", firstProductLink);
        action.moveToElement(firstProductLink).build().perform();
        firstProductLink.click();
    }
}
