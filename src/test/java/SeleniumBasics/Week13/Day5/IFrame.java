package SeleniumBasics.Week13.Day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static SeleniumBasics.Week12.colorOutputMsgs.msgFailed;
import static SeleniumBasics.Week12.colorOutputMsgs.msgPassed;

public class IFrame {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        boolean testPass = true;
        String testedValue;
        WebElement testedElement = null;


        try {
            driver.get("https://syntaxprojects.com/handle-iframe-homework.php");
            driver.manage().window().maximize();
//            1. Select Age Checkbox
            driver.switchTo().frame(1);
            WebElement iFrame = driver.findElement(By.cssSelector("iframe#checkboxIframe"));
            driver.switchTo().frame(iFrame);
            testedElement = driver.findElement(By.cssSelector("input.cb1-element"));
            testedElement.click();
            System.out.print("'Age' is checked ");
            if (testedElement.isSelected()) System.out.println(msgPassed);
            else {
                System.out.println(msgFailed);
                testPass = false;
            }
            driver.switchTo().parentFrame();
            testedElement = driver.findElement(By.cssSelector("select#cities"));
            Select ddCities = new Select(testedElement);
            testedValue = "Dallas";
            ddCities.selectByVisibleText(testedValue);
            System.out.print("City '" + testedValue + "' is selected ");
            if (ddCities.getFirstSelectedOption().getText().equals(testedValue)) System.out.println(msgPassed);
            else {
                System.out.println(msgFailed);
                testPass = false;
            }

            driver.switchTo().defaultContent();
            driver.switchTo().frame(0);
            testedElement = driver.findElement(By.xpath("//input[@placeholder='User Name']"));
            testedElement.clear();
            testedValue = "Martin Schwarz";
            testedElement.sendKeys(testedValue);
            System.out.print("Username is '" + testedValue + "' ");
            if (testedElement.getAttribute("value").equals(testedValue)) System.out.println(msgPassed);
            else {
                System.out.println(msgFailed);
                testPass = false;
            }


        } catch (Exception e) {
            System.out.println(msgFailed + " (" + e.getMessage().split("\n")[0] + ")");
            testPass = false;
        } finally {
            Thread.sleep(3000);
            driver.quit();
            if (testPass) System.out.println(msgPassed);
            else System.out.println(msgFailed);
        }
    }
}

