package SeleniumBasics.Week13.Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static SeleniumBasics.Week12.colorOutputMsgs.msgFailed;
import static SeleniumBasics.Week12.colorOutputMsgs.msgPassed;

public class DropDownWithoutSelect {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        boolean testPass = true;
        String testedValue;
        WebElement testedElement = null;


        try {
            driver.get("https://syntaxprojects.com/no-select-tag-dropdown-demo-homework.php");
            driver.manage().window().maximize();
//            1. Choose Your Dream Fruit
            WebElement dd = driver.findElement(By.cssSelector("div#dream_fruits"));
            dd.click();
            List<WebElement> testedElements = driver.findElements(By.cssSelector("ul.dropdown-menu.single-dropdown-menu li a"));
            testedValue = "Mango";
            testedElement = null;
            for (WebElement e : testedElements) {
                if (e.getText().equals(testedValue)) {
                    testedElement = e;
                    break;
                }
            }
            System.out.print("Dropdown '" + testedValue + "' is selected ");
            if (testedElement != null) {
                testedElement.click();
                if (dd.getText().equals(testedValue))
                    System.out.println(msgPassed);
                else {
                    System.out.println(msgFailed);
                    testPass = false;
                }
            } else {
                System.out.println(msgFailed + " (Error: Dropdown '" + testedValue + "' doesn't exist");
                testPass = false;
            }

//            2. Choose Your Favorite Hobby:
            dd = driver.findElement(By.cssSelector("div#favorite_hobbies"));
            dd.click();
            testedElements = driver.findElements(By.cssSelector("ul.dropdown-menu.multi-dropdown-menu li a"));
            testedValue = "Reading";
            testedElement = null;
            for (WebElement e : testedElements) {
                if (e.getText().equals(testedValue)) {
                    testedElement = e;
                    break;
                }
            }
            System.out.print("Dropdown '" + testedValue + "' is selected ");
            if (testedElement != null) {
                testedElement.click();
                if (dd.getText().equals(testedValue))
                    System.out.println(msgPassed);
                else {
                    System.out.println(msgFailed);
                    testPass = false;
                }
            } else {
                System.out.println(msgFailed + " (Error: Dropdown '" + testedValue + "' doesn't exist");
                testPass = false;
            }

        } catch (Exception e) {
            System.out.println(msgFailed + " (" + e.getMessage().split("\n")[0] + ")");
            testPass = false;
        } finally {
            // Thread.sleep(8000);
            driver.quit();
            if (testPass) System.out.println(msgPassed);
            else System.out.println(msgFailed);
        }
    }
}
