package SeleniumBasics.Week14.Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static SeleniumBasics.Week12.colorOutputMsgs.msgFailed;
import static SeleniumBasics.Week12.colorOutputMsgs.msgPassed;


public class ExplicitWait {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        boolean testPass = true;
        String testedValue;
        WebElement testedElement = null;


        try {
            driver.get("https://syntaxprojects.com/synchronization-explicit-wait-homework.php");
            driver.manage().window().maximize();

//            1. Change Text
            WebElement btn = driver.findElement(By.cssSelector("button#changetext_button"));
            btn.click();
            testedValue = "Ssyntaxtechs";
            WebDriverWait waitObj = new WebDriverWait(driver, Duration.ofSeconds(20));
            waitObj.until(ExpectedConditions.textToBe(By.cssSelector("h2#headingtext"), testedValue));
            testedElement = driver.findElement(By.cssSelector("h2#headingtext"));
            System.out.print("Expected text '" + testedValue + "' ");
            if (testedElement.getText().equals(testedValue))
                System.out.println(msgPassed);
            else {
                System.out.println(msgFailed);
                testPass = false;
            }

//            2. Enable Button
            btn = driver.findElement(By.cssSelector("button#enable_button"));
            btn.click();
            testedValue = "Button";
            waitObj.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.card-body > button")));
            testedElement = driver.findElement(By.cssSelector("div.card-body > button"));
            System.out.print("Button '" + testedValue + "' is clickable ");
            if (testedElement.isEnabled())
                System.out.println(msgPassed);
            else {
                System.out.println(msgFailed);
                testPass = false;
            }

//            3. Checkbox Checked Based on Click
            btn = driver.findElement(By.cssSelector("button#checkbox_button"));
            btn.click();
            testedValue = "Checkbox";
            waitObj.until(ExpectedConditions.elementToBeSelected(By.cssSelector("div.card-body input#checkbox")));
            testedElement = driver.findElement(By.cssSelector("div.card-body input#checkbox"));
            System.out.print("Checkbox '" + testedValue + "' is selected ");
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

