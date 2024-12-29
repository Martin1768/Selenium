package SeleniumBasics.Week13.Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static SeleniumBasics.Week12.colorOutputMsgs.msgFailed;
import static SeleniumBasics.Week12.colorOutputMsgs.msgPassed;

public class RadioButtons {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        boolean testPass = true;
        String testedValue;
        WebElement testedElement = null;


        try {
            driver.get("https://syntaxprojects.com/basic-radiobutton-demo-homework.php");
            driver.manage().window().maximize();
// 1. Choose Your Favorite Beverage:
            List<WebElement> testedElements = driver.findElements(By.xpath("//input[@name='beverage']"));
            testedValue = "Juice";
            System.out.print("Radio button '" + testedValue + "' is selected ");
            testedElement = null;
            for (WebElement e : testedElements)
                if (e.getAttribute("value").equals(testedValue)) {
                    testedElement = e;
                    break;
                }
            if (testedElement != null) {
                testedElement.click();
                if (testedElement.isSelected()) {
                    System.out.println(msgPassed);
                } else {
                    System.out.println(msgFailed);
                    testPass = false;
                }
            } else {
                System.out.println(msgFailed + " (Error: Radio button '" + testedValue + "' doesn't exist)");
                testPass = false;
            }
// 2. Select Your Hobbies:
            testedElements = driver.findElements(By.xpath("//input[@name='working_enviroment']"));
            testedValue = "Hybrid";
            System.out.print("Radio button '" + testedValue + "' is selected ");
            testedElement = null;
            for (WebElement e : testedElements)
                if (e.getAttribute("value").equals(testedValue.toLowerCase())) {
                    testedElement = e;
                    break;
                }
            if (testedElement != null) {
                testedElement.click();
                if (testedElement.isSelected()) {
                    System.out.println(msgPassed);
                } else {
                    System.out.println(msgFailed);
                    testPass = false;
                }
            } else {
                System.out.println(msgFailed + " (Error: Radio button '" + testedValue + "' doesn't exist)");
                testPass = false;
            }

// 3. Choose Your Favorite Season
            testedElements = driver.findElements(By.xpath("//input[@name='season']"));
            WebElement springRB = null;
            String springValue = "spring";
            WebElement winterRB = null;
            String winterValue = "winter";

            if (!testedElements.isEmpty()) {
                for (WebElement e : testedElements) {
                    if (e.getAttribute("value").equals(springValue)) springRB = e;
                    else if (e.getAttribute("value").equals(winterValue)) winterRB = e;
                }
            } else
                System.out.println("Error: didn't find Favorite Season radio buttons");

            System.out.print("'Spring' radio button is disabled ");
            if (!springRB.isEnabled()) {
                System.out.println(msgPassed);
                WebElement btn = driver.findElement(By.cssSelector("button#enabledFruitradio"));
                btn.click();
                Thread.sleep(200);
            } else {
                System.out.println(msgFailed);
                testPass = false;
            }

            if (springRB.isEnabled()) springRB.click();
            System.out.print("'Spring' radio button is selected ");
            if (springRB.isSelected())
                System.out.println(msgPassed);
            else {
                System.out.println(msgFailed);
                testPass = false;
            }

            System.out.print("'Winter' radio button is hidden ");
            if (!winterRB.isDisplayed()) {
                System.out.println(msgPassed);
                WebElement btn = driver.findElement(By.cssSelector("button#showRadioButtons"));
                btn.click();
                System.out.print("'Winter' radio button is available after 'Show buttons' ");
                if (winterRB.isDisplayed() && winterRB.isEnabled())
                    System.out.println(msgPassed);
                else {
                    System.out.println(msgFailed);
                    testPass = false;
                }
            } else {
                System.out.println(msgFailed);
                testPass = false;
            }

//            4. Choose Your Favorite Meal
            testedElements = driver.findElements(By.xpath("//input[@name='meal']"));
            testedValue = "Lunch";
            System.out.print("'" + testedValue + "' radio button is selected ");
            testedElement = null;
            for (WebElement e : testedElements) {
                if (e.getAttribute("value").equals(testedValue.toLowerCase())) {
                    testedElement = e;
                    break;
                }
            }

            if (testedElement != null) {
                testedElement.click();
                if (testedElement.isSelected()) {
                    System.out.println(msgPassed);
                } else {
                    System.out.println(msgFailed);
                    testPass = false;
                }
            } else {
                System.out.println(msgFailed + " (Error: '" + testedValue + "' radio button doesn't exist");
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
