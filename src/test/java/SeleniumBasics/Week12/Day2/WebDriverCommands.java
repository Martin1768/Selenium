package SeleniumBasics.Week12.Day2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverCommands {
    public static void main(String[] args) {
        boolean passed;
        boolean passedAll = true;
        String msgPassed = "\u001B[32mTest Passed\u001B[0m";
        String msgFailed = "\u001B[31mTest Failed\u001B[0m";

//    1. The user successfully opens Chrome and maximizes the window using `window().maximize()`.
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();

            //    2. The user navigates to `www.google.com`, and the page title is printed correctly.
            driver.get("https://www.google.com");
            passed = driver.getTitle().equals("Google");
            passedAll = passedAll && passed;
            System.out.println("Open website '" + driver.getTitle() + "' " + ((passed) ? msgPassed : msgFailed));

            //    3. The user navigates to `https://www.syntaxprojects.com/`, and the page title is printed correctly.
            driver.navigate().to("https://www.syntaxprojects.com/");
            passed = driver.getTitle().equals("Syntax - Website to practice Syntax Automation Platform");
            passedAll = passedAll && passed;
            System.out.println("Navigate to '" + driver.getTitle() + "' " + ((passed) ? msgPassed : msgFailed));

            //    4. The user successfully navigates back to `www.google.com` using `navigate().back()`.
            driver.navigate().back();
            passed = driver.getTitle().equals("Google");
            passedAll = passedAll && passed;
            System.out.println("Back to '" + driver.getTitle() + "' " + ((passed) ? msgPassed : msgFailed));

            //    5. The page at `www.google.com` is refreshed using `navigate().refresh()`.
            driver.navigate().refresh();
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        } finally {
//    6. The browser closes after completing all the navigation steps.
            driver.quit();
            try {
                driver.getCurrentUrl();
            } catch (org.openqa.selenium.NoSuchSessionException e) {
                System.out.println("Chrome closed correctly.");
            }
            if (passedAll) System.out.println("\u001B[32m" + msgPassed.toUpperCase() + "\u001B[0m");
            else System.out.println("\u001B[31m" + msgFailed.toUpperCase() + "\u001B[0m");
        }
    }
}
