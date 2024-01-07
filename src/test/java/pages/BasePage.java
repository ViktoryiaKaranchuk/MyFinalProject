package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.DriverProvider.getCurrentDriver;

public class BasePage {
    String perfumyCatalogLinkXpath = "//a[@href='/pl/menu/perfumy-153.html']";

    public void openPerfumyCatalog(){
        WebElement perfumyCatalogLink = getCurrentDriver().findElement(By.xpath(perfumyCatalogLinkXpath));
        perfumyCatalogLink.click();
    }

    public double getPriceDouble(WebElement element){
        String priceText = element.getText().replaceAll(",", ".");
        priceText = priceText.substring(0,priceText.length() - 3);
        return Double.parseDouble(priceText);
    }
}
