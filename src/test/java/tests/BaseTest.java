package tests;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import org.testng.annotations.AfterMethod;
        import org.testng.annotations.BeforeMethod;

        import java.time.Duration;

        import static utils.DriverProvider.closeDriver;
        import static utils.DriverProvider.getCurrentDriver;

public class BaseTest {
    String acceptCookiesButtonId = "onetrust-accept-btn-handler";

    @BeforeMethod
    public void setUp() {
        getCurrentDriver().get("https://www2.hm.com/pl_pl/");
        maximizeWindow();
        acceptCookies();
    }

    @AfterMethod
    public void tearDown() { closeDriver(); }

    public void maximizeWindow() {
        getCurrentDriver().manage().window().maximize();
    }

    public void acceptCookies() {
        WebDriverWait wait = new WebDriverWait(getCurrentDriver(), Duration.ofSeconds(30));
        By acceptCookiesButtonLocator = By.id(acceptCookiesButtonId);

        try {
            WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesButtonLocator));
            acceptCookiesButton.click();
        } catch (Exception e) {

        }
    }

}

