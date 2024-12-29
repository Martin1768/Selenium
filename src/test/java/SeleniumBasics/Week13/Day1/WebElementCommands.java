package SeleniumBasics.Week13.Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static SeleniumBasics.Week12.colorOutputMsgs.*;

public class WebElementCommands {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        boolean testPass = true;
        String testedValue = "";
        WebElement testedElement = null;


        try {
            driver.get("https://syntaxprojects.com/selenium_commands_selector-homework.php");
            driver.manage().window().maximize();
// 1. Retrieve Attribute
            testedValue = "inspect me to view my custom attribute";
            testedElement = driver.findElement(By.xpath("//div[@id='textattr']"));
            System.out.print("Retrieved text '" + testedElement.getText() + "' ");
            if (testedElement.getText().startsWith(testedValue)) System.out.println(msgPassed);
            else {
                System.out.println(msgFailed);
                testPass = false;
            }

// 2. Meal Preference
            testedElement = driver.findElement(By.xpath("//input[@value='music_festival']"));
            System.out.print("'Music Festival' is enabled ");
            if (testedElement.isEnabled()) {
                System.out.println(msgPassed);
                testedElement.click();
            } else {
                System.out.println(msgFailed);
                testPass = false;
            }
            testedElement = driver.findElement(By.xpath("//input[@value='tech_talk']"));
            System.out.print("'Tech Talk' is disabled ");
            if (!testedElement.isEnabled()) {
                System.out.println(msgPassed);
            } else {
                System.out.println(msgFailed);
                testPass = false;
            }

            WebElement btn = driver.findElement(By.cssSelector(".btn.btn-default"));
            btn.click();

            testedElement = driver.findElement(By.xpath("//input[@value='art_exhibition']"));
            System.out.print("'Art Exhibition' is visible ");
            if (testedElement.isDisplayed()) {
                System.out.println(msgPassed);
            } else {
                System.out.println(msgFailed);
                testPass = false;
            }

//            3. Mystery Message
            testedElement = driver.findElement(By.xpath("//div[contains(text(), 'Hover over me to')]"));
            System.out.print("Title from the element containing the text 'Hover over me to ...' = ");
            System.out.println(testedElement.getAttribute("title"));

// 4. Option Box:
            testedElement = driver.findElement(By.xpath("//input[@value='CheckboxFirst']"));
                    System.out.print("'Checkbox 1' is enabled ");
            if (testedElement.isEnabled()) {
                System.out.println(msgPassed);
                testedElement.click();
            } else {
                System.out.println(msgFailed);
                testPass = false;
            }

            testedElement = driver.findElement(By.xpath("//input[@value='disabledCheckbox']"));
                    System.out.print("'Checkbox 2' is disabled ");
            if (!testedElement.isEnabled()) {
                System.out.println(msgPassed);
                testedElement.click();
            } else {
                System.out.println(msgFailed);
                testPass = false;
            }

//            5. Input Field
            testedElement = driver.findElement(By.xpath("//input[@id='inputField']"));
            testedValue = "here is the custom text entered";
            System.out.print("The input field contains text '" + testedValue + "' ");
            testedElement.clear();
            testedElement.sendKeys("here is the custom text entered");
            if (testedElement.getAttribute("value").equals(testedValue)) {
                System.out.println(msgPassed);
            } else {
                System.out.println(msgFailed);
                testPass = false;
            }


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
