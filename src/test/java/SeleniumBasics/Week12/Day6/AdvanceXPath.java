package SeleniumBasics.Week12.Day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.firefox.FirefoxDriver;

import static SeleniumBasics.Week12.colorOutputMsgs.*;

public class AdvanceXPath {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        boolean testPass = true;
        String testedValue = "";
        WebElement testedElement = null;


        try {
            driver.get("https://syntaxprojects.com/advanceXpath-homework.php");
            driver.manage().window().maximize();

//            1.The user should enter the names of books in reverse order from least favorite to favorite using advanced Xpath
//            (such as `parent`, `following-sibling`, or `preceding-sibling`).
            testedValue = "Chariots of the Gods?";
            System.out.print("01: 3rd field '" + testedValue + "' ");
            testedElement = driver.findElement(By.xpath("//input[@id='least-favorite']"));
            testedElement.sendKeys(testedValue);
            if (testedElement.getAttribute("value").equals(testedValue))
                System.out.println(msgPassed);
            else  {
                System.out.println(msgFailed);
                testPass = false;
            }

            testedValue = "Unacknowledged: An Exposé of the World's Greatest Secret";
            System.out.print("01: 2nd field '" + testedValue + "' ");
            testedElement = driver.findElement(By.xpath("//input[@id='least-favorite']/preceding-sibling::input[1]"));
            testedElement.sendKeys(testedValue);
            if (testedElement.getAttribute("value").equals(testedValue))
                System.out.println(msgPassed);
            else  {
                System.out.println(msgFailed);
                testPass = false;
            }

            testedValue = "1984";
            System.out.print("01: 1st field '" + testedValue + "' ");
            testedElement = driver.findElement(By.xpath("//input[@id='least-favorite']/preceding-sibling::input[2]"));
            testedElement.sendKeys(testedValue);
            if (testedElement.getAttribute("value").equals(testedValue))
                System.out.println(msgPassed);
            else  {
                System.out.println(msgFailed);
                testPass = false;
            }

//            2. The user should enter the name of their favorite book using advanced Xpath.
            testedValue = "Java: The Complete Reference";
            System.out.print("02: 1st field '" + testedValue + "' ");
            testedElement = driver.findElement(By.xpath("//input[@id='favouriteBook']"));
            testedElement.sendKeys(testedValue);
            if (testedElement.getAttribute("value").equals(testedValue))
                System.out.println(msgPassed);
            else  {
                System.out.println(msgFailed);
                testPass = false;
            }

            testedValue = "Effective Modern C++";
            System.out.print("02: 2nd field '" + testedValue + "' ");
            testedElement = driver.findElement(By.xpath("//input[@id='favouriteBook']/following-sibling::input[1]"));
            testedElement.sendKeys(testedValue);
            if (testedElement.getAttribute("value").equals(testedValue))
                System.out.println(msgPassed);
            else  {
                System.out.println(msgFailed);
                testPass = false;
            }

            testedValue = "Automate the Boring Stuff with Python";
            System.out.print("02: 3rd field '" + testedValue + "' ");
            testedElement = driver.findElement(By.xpath("//input[@id='favouriteBook']/following-sibling::input[2]"));
            testedElement.sendKeys(testedValue);
            if (testedElement.getAttribute("value").equals(testedValue))
                System.out.println(msgPassed);
            else  {
                System.out.println(msgFailed);
                testPass = false;
            }

//            3. The user should enter the names of grandparent, parent, and child fields using advanced Xpath.
            testedValue = "John";
            System.out.print("03: 1st field '" + testedValue + "' ");
            testedElement = driver.findElement(By.xpath("//div[@id='familyTree']/input[1]"));
            testedElement.sendKeys(testedValue);
            if (testedElement.getAttribute("value").equals(testedValue))
                System.out.println(msgPassed);
            else  {
                System.out.println(msgFailed);
                testPass = false;
            }

            testedValue = "George";
            System.out.print("03: 2nd field '" + testedValue + "' ");
            testedElement = driver.findElement(By.xpath("//div[@id='familyTree']/input[2]"));
            testedElement.sendKeys(testedValue);
            if (testedElement.getAttribute("value").equals(testedValue))
                System.out.println(msgPassed);
            else  {
                System.out.println(msgFailed);
                testPass = false;
            }

            testedValue = "Martin";
            System.out.print("03: 3rd field '" + testedValue + "' ");
            testedElement = driver.findElement(By.xpath("//div[@id='familyTree']/input[3]"));
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
            if (testPass) System.out.println(msgPassed + " - You should submit the form.");
            else System.out.println(msgFailed);
        }
    }
}
