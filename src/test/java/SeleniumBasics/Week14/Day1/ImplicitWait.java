package SeleniumBasics.Week14.Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static SeleniumBasics.Week12.colorOutputMsgs.msgFailed;
import static SeleniumBasics.Week12.colorOutputMsgs.msgPassed;


public class ImplicitWait {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        boolean testPass = true;
        String testedValue;
        WebElement testedElement = null;


        try {
            driver.get("https://syntaxprojects.com/synchronization-waits-homework.php");
            driver.manage().window().maximize();

//            1. Button Click and Checkbox Selection

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

            testedElement = driver.findElement(By.cssSelector("button#show_text_synchronize_three"));
            testedElement.click();
            testedValue = "Option-1";
            testedElement = driver.findElement(By.xpath("//input[@value='" + testedValue + "']"));
            testedElement.click();
            System.out.print("Checkbox '" + testedValue + "' is checked ");
            if (testedElement.isSelected())
                System.out.println(msgPassed);
            else {
                System.out.println(msgFailed);
                testPass = false;
            }

        } catch (
                Exception e) {
            System.out.println(msgFailed + " (" + e.getMessage().split("\n")[0] + ")");
            testPass = false;
        } finally {
            // Thread.sleep(3000);
            driver.quit();
            if (testPass) System.out.println(msgPassed);
            else System.out.println(msgFailed);
        }
    }
}

