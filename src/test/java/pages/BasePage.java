package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.DriverProvider.getCurrentDriver;

public class BasePage {
    String perfumyCatalogLinkXpath = "//a[@href='/pl/menu/perfumy-153.html']";
    String userMenuIconId = "menu_additional";
    String loginLinkXpath = "//a[@class='account_link']";
    String logoutButtonXpath = "//div[@class='menu_additional__links']//a[@class='logout_link']";

    public void openPerfumyCatalog(){
        WebElement perfumyCatalogLink = getCurrentDriver().findElement(By.xpath(perfumyCatalogLinkXpath));
        perfumyCatalogLink.click();
    }

    public void openAuthorizationPage(){
        WebElement userMenuIcon = getCurrentDriver().findElement(By.id(userMenuIconId));
        userMenuIcon.click();

        WebElement loginLink = getCurrentDriver().findElement(By.xpath(loginLinkXpath));
        loginLink.click();
    }

    public boolean isUserAuthorized(){
        WebElement userMenuIcon = getCurrentDriver().findElement(By.id(userMenuIconId));
        userMenuIcon.click();

        try {
            WebElement logoutButton = getCurrentDriver().findElement(By.xpath(logoutButtonXpath));
            return logoutButton.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public void logout(){
        WebElement userMenuIcon = getCurrentDriver().findElement(By.id(userMenuIconId));
        userMenuIcon.click();

        WebElement logoutButton = getCurrentDriver().findElement(By.xpath(logoutButtonXpath));
        logoutButton.click();
    }

    public double getPriceDouble(WebElement element){
        String priceText = element.getText().replaceAll(",", ".");
        priceText = priceText.substring(0,priceText.length() - 3);
        return Double.parseDouble(priceText);
    }
}
