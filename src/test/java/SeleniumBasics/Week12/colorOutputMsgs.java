package SeleniumBasics.Week12;

public final class colorOutputMsgs {
    public static final String green = "\u001B[32m";
    public static final String red = "\u001B[31m";
    public static final String nocolor = "\u001B[0m";
    public static final String msgPassed = green + "Test Passed" + nocolor;
    public static final String msgFailed = red + "Test Failed" + nocolor;

    private colorOutputMsgs() {
        // Prevent instantiation
    }
}

