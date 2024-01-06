package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.DriverProvider.getCurrentDriver;

public class LoginPage {

    String emailId = "email";
    String passwordId = "password";
    String loginButtonXpath = "//*[@type ='submit']";

    public void doLogin(String email, String password) {
        WebDriverWait wait = new WebDriverWait(getCurrentDriver(), Duration.ofSeconds(30));

        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(emailId)));
        WebElement passwordField = getCurrentDriver().findElement(By.id(passwordId));
        WebElement loginButton = getCurrentDriver().findElement(By.xpath(loginButtonXpath));

        emailField.sendKeys(email);
        passwordField.sendKeys(password);

        loginButton.click();

    }

}