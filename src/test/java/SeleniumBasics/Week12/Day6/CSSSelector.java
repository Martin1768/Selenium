package SeleniumBasics.Week12.Day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.firefox.FirefoxDriver;

import static SeleniumBasics.Week12.colorOutputMsgs.msgFailed;
import static SeleniumBasics.Week12.colorOutputMsgs.msgPassed;

public class CSSSelector {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        boolean testPass = true;
        String testedValue = "";
        WebElement testedElement = null;


        try {
            driver.get("https://syntaxprojects.com/cssSelector-homework.php");
            driver.manage().window().maximize();

//          1. The user should fill in all the text boxes in the form using*CSS selectors
//          that are unique and return only one element (1/1).
            testedValue = "UID-24-236954";
            System.out.print("User ID '" + testedValue + "' ");
            testedElement = driver.findElement(By.cssSelector("#UserID"));
            testedElement.sendKeys(testedValue);
            if (testedElement.getAttribute("value").equals(testedValue))
                System.out.println(msgPassed);
            else  {
                System.out.println(msgFailed);
                testPass = false;
            }

            testedValue = "Martin";
            System.out.print("User Name '" + testedValue + "' ");
            testedElement = driver.findElement(By.cssSelector("#UserName"));
            testedElement.sendKeys(testedValue);
            if (testedElement.getAttribute("value").equals(testedValue))
                System.out.println(msgPassed);
            else  {
                System.out.println(msgFailed);
                testPass = false;
            }

            testedValue = "Selenium";
            System.out.print("Intro to Lecture '" + testedValue + "' ");
            testedElement = driver.findElement(By.cssSelector("[data-starts='introCSSAdv']"));
            testedElement.sendKeys(testedValue);
            if (testedElement.getAttribute("value").equals(testedValue))
                System.out.println(msgPassed);
            else  {
                System.out.println(msgFailed);
                testPass = false;
            }

            testedValue = "Great instructor!";
            System.out.print("Feedback from Ray '" + testedValue + "' ");
            testedElement = driver.findElement(By.cssSelector(".form-control.feedbackBox1"));
            testedElement.sendKeys(testedValue);
            if (testedElement.getAttribute("value").equals(testedValue))
                System.out.println(msgPassed);
            else  {
                System.out.println(msgFailed);
                testPass = false;
            }

            testedValue = "Exactly! He made the material easy to understand and engaging";
            System.out.print("Feedback from Ducky '" + testedValue + "' ");
            testedElement = driver.findElement(By.cssSelector(".form-control.feedbackBox2"));
            testedElement.sendKeys(testedValue);
            if (testedElement.getAttribute("value").equals(testedValue))
                System.out.println(msgPassed);
            else  {
                System.out.println(msgFailed);
                testPass = false;
            }

            testedValue = "CID-24-00125-DW";
            System.out.print("Client ID '" + testedValue + "' ");
            testedElement = driver.findElement(By.cssSelector("[data-ends='CSSModuleconclientID']"));
            testedElement.sendKeys(testedValue);
            if (testedElement.getAttribute("value").equals(testedValue))
                System.out.println(msgPassed);
            else  {
                System.out.println(msgFailed);
                testPass = false;
            }

            testedValue = "client@gmails.com";
            System.out.print("Email '" + testedValue + "' ");
            testedElement = driver.findElement(By.cssSelector("label[for='emailinput'] + input"));
            testedElement.sendKeys(testedValue);
            if (testedElement.getAttribute("value").equals(testedValue))
                System.out.println(msgPassed);
            else  {
                System.out.println(msgFailed);
                testPass = false;
            }

            testedValue = "CSS Selectors";
            System.out.print("Course Topic '" + testedValue + "' ");
            testedElement = driver.findElement(By.cssSelector("input[data-content*='intermediate']"));
            testedElement.sendKeys(testedValue);
            if (testedElement.getAttribute("value").equals(testedValue))
                System.out.println(msgPassed);
            else  {
                System.out.println(msgFailed);
                testPass = false;
            }


        } catch (Exception e) {
            System.out.println(msgFailed + " (" + e.getMessage().split("\n")[0] + ")");
            testPass = false;
        } finally {
            driver.quit();
            if (testPass) System.out.println(msgPassed);
            else System.out.println(msgFailed);
        }
    }
}
