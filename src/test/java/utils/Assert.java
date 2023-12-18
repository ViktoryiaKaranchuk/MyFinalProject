package utils;

public class Assert {
    public static void checkWelcomeText(Object expect) {
        org.testng.Assert.assertEquals(expect, "Witaj Tester Testerovich");
    }

    public static void checkCountCats(long expect) {
        org.testng.Assert.assertTrue(expect > 0);
    }
}
