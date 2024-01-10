package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.DriverProvider.getCurrentDriver;

public class AuthorizationPage extends BasePage{
    String emailFieldId = "user_login";
    String passwordFieldId = "user_pass";
    String loginButtonXpath = "//button[@class='btn --solid --medium signin_button']";

    public void login(String email, String password){
        WebElement emailField = getCurrentDriver().findElement(By.id(emailFieldId));
        emailField.sendKeys(email);

        WebElement passwordField = getCurrentDriver().findElement(By.id(passwordFieldId));
        passwordField.sendKeys(password);

        WebElement loginButton = getCurrentDriver().findElement(By.xpath(loginButtonXpath));
        loginButton.click();
    }
}
