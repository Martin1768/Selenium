package SeleniumBasics.Week12.Day2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowser {
    public static void main(String[] args) {
        boolean passed;
        boolean passedAll = true;
        String msgPassed = "\u001B[32mTest Passed\u001B[0m";
        String msgFailed = "\u001B[31mTest Failed\u001B[0m";

//    1. The user should be able to launch a web browser and navigate to the URL `https://www.syntaxprojects.com/`.
        WebDriver driver = new FirefoxDriver();

        try {
            driver.get("https://www.syntaxprojects.com/");
//    2. The user should be able to maximize the browser window
            driver.manage().window().maximize();

//    3. The current URL should be printed on the console and match `https://www.syntaxprojects.com/`.
            passed = driver.getCurrentUrl().equals("https://www.syntaxprojects.com/");
            passedAll = passedAll && passed;
            System.out.println("Current URL '" + driver.getCurrentUrl() + "' " + ((passed) ? msgPassed : msgFailed));
//    4. The page title retrieved should be printed on the console and match `Syntax - Website to practice Syntax Automation Platform`.
            passed = driver.getTitle().equals("Syntax - Website to practice Syntax Automation Platform");
            passedAll = passedAll && passed;
            System.out.println("Title '" + driver.getTitle() + "' " + ((passed) ? msgPassed : msgFailed));
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        } finally {
//    5. The browser should close automatically after retrieving both the URL and title
            driver.quit();
            try {
                driver.getCurrentUrl();
            } catch (org.openqa.selenium.NoSuchSessionException e) {
                System.out.println("Firefox closed correctly.");
            }
            if (passedAll) System.out.println("\u001B[32m" + msgPassed.toUpperCase() + "\u001B[0m");
            else System.out.println("\u001B[31m" + msgFailed.toUpperCase() + "\u001B[0m");
        }
    }
}
