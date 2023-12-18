package utils;

import org.testng.Assert;

public class AssertsFromData {
    public static void checkWelcomeText(Object expect) {
        Assert.assertEquals(expect, "Witaj Tester Testerovich");
    }
}
