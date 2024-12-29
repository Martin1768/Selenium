package SeleniumBasics.Week13.Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static SeleniumBasics.Week12.colorOutputMsgs.msgFailed;
import static SeleniumBasics.Week12.colorOutputMsgs.msgPassed;

public class MultiSelectDropDown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        boolean testPass = true;
        String testedValue;
        WebElement testedElement = null;


        try {
            driver.get("https://syntaxprojects.com/basic-select-dropdown-demo-homework.php");
            driver.manage().window().maximize();
//            1. Select List Demo
            testedElement = driver.findElement(By.cssSelector("select#fav_fruit_selector"));
            testedValue = "Pear";
            Select select = new Select(testedElement);
            select.selectByVisibleText(testedValue);

            System.out.print("Single select - item '" + testedValue + "' is selected ");
            if (testedElement.getAttribute("value").equals(testedValue))
                System.out.println(msgPassed);
            else {
                System.out.println(msgFailed);
                testPass = false;
            }
            System.out.print("All options: ");
            for (WebElement e : select.getOptions())
                if (e.isEnabled()) System.out.print("'" + e.getText() + "' ");
            System.out.println();

//            2. Select Multiple Options:
            testedElement = driver.findElement(By.cssSelector("select#select_multi_hobbies"));
            testedValue = "Traveling";
            select = new Select(testedElement);
            System.out.print("Favorite Hobbies dropdown is multiselect ");
            if (select.isMultiple()) {
                System.out.println(msgPassed);
            } else {
                System.out.println(msgFailed);
                testPass = false;
            }
            select.selectByVisibleText("Traveling");
            select.selectByVisibleText("Cooking");
            select.selectByVisibleText("Gardening");
            WebElement btn = driver.findElement(By.cssSelector("button#get_all"));
            btn.click();
            System.out.print("Options selected are : ");
            for(WebElement e : select.getAllSelectedOptions())
                System.out.print("'" + e.getText() + "' ");
            System.out.println();
            Thread.sleep(5000);
            select.deselectByVisibleText("Traveling");
            btn.click();
            System.out.print("Options selected are : ");
            for(WebElement e : select.getAllSelectedOptions())
                System.out.print("'" + e.getText() + "' ");
            System.out.println();

        } catch (Exception e) {
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
