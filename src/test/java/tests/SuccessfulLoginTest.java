package tests;

import models.User;
import org.testng.annotations.Test;


public class SuccessfulLoginTest extends BaseTest {

    @Test
    public void testLoginAndVerifyWelcomeMessage() {
        User user = new User("testerovich.00@mail.ru", "Qwerty123-");

    }
}



