package utils;

public class Assert {
    public static void checkWelcomeText(Object expect) {
        org.testng.Assert.assertEquals(expect, "Witaj Tester Testerovich");
    }

    public static void checkCountCats(long expect) {
        org.testng.Assert.assertTrue(expect > 0);
    }

    public static void checkTooltip(Object textMessage) {
        org.testng.Assert.assertEquals(textMessage, "Twój koszyk jest pusty");
    }

    public static void checkSumBeforAndAfter(Object number1, Object number2) {
        org.testng.Assert.assertNotEquals(number1, number2);
    }
}
