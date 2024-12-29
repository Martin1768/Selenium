package SeleniumBasics.Week13.Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static SeleniumBasics.Week12.colorOutputMsgs.msgFailed;
import static SeleniumBasics.Week12.colorOutputMsgs.msgPassed;

public class CheckBoxes {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        boolean testPass = true;
        WebElement testedElement = null;


        try {
            driver.get("https://syntaxprojects.com/basic-checkbox-demo-homework.php");
            driver.manage().window().maximize();
// 1. Subscribe to Newsletter
            testedElement = driver.findElement(By.xpath("//input[@id='newsletter']"));
            System.out.print("Checkbox 'Subscribe to Newsletter' is enabled ");
            if (testedElement.isEnabled()) {
                System.out.println(msgPassed);
                testedElement.click();
            } else {
                System.out.println(msgFailed);
                testPass = false;
            }

// 2. Select Your Hobbies:
            List<WebElement> testedElements = driver.findElements(By.cssSelector("input.cb-element"));
            if (!testedElements.isEmpty()) {
                for (WebElement e : testedElements) {
                    String visibleText = e.findElement(By.xpath("./..")).getText();
                    if (visibleText.equals("Reading")) {
                        e.click();
                        if (e.isSelected()) {
                            System.out.println("Checkbox 'Reading' is checked " + msgPassed);
                        } else {
                            System.out.println("Checkbox 'Reading' is not checked " + msgFailed);
                            testPass = false;
                        }
                    } else if (visibleText.equals("Cooking")) {
                        e.click();
                        if (e.isSelected()) {
                            System.out.println("Checkbox 'Cooking' is checked " + msgPassed);
                        } else {
                            System.out.println("Checkbox 'Cooking' is not checked " + msgFailed);
                            testPass = false;
                        }
                    }
                }
            } else
                System.out.println(testedElements.isEmpty());

// 3. Select Your Interests
            testedElements = driver.findElements(By.cssSelector("div.interest_section input"));
            WebElement saveMusicCHB = null;
            if (!testedElements.isEmpty()) {
                for (WebElement e : testedElements) {
                    String visibleText = e.findElement(By.xpath("./..")).getAttribute("textContent").trim();
                    if (visibleText.equals("Support")) {
                        if (!e.isDisplayed()) {
                            System.out.println("Checkbox 'Support' is invisible " + msgPassed);
                        } else {
                            System.out.println("Checkbox 'Support' is invisible " + msgFailed);
                            testPass = false;
                        }
                    } else if (visibleText.equals("Music")) {
                        saveMusicCHB = e;
                        if (!e.isDisplayed()) {
                            System.out.println("Checkbox 'Music' is invisible " + msgPassed);
                        } else {
                            System.out.println("Checkbox 'Music' is invisible " + msgFailed);
                            testPass = false;
                        }
                    }
                }
            } else
                System.out.println("Error: didn't find Interests checkboxes");

            WebElement btn = driver.findElement(By.cssSelector("button.btn.btn-default"));
            btn.click();
            Thread.sleep(200);

            if (saveMusicCHB != null) {
                if (saveMusicCHB.isDisplayed()) saveMusicCHB.click();
                else System.out.println("Selenium is too fast and don't see the 'Music' checkbox");
            }
            System.out.print("Checkbox 'Music' is checked ");
            if (saveMusicCHB.isSelected())
                System.out.println(msgPassed);
            else {
                System.out.println(msgFailed);
                testPass = false;
            }

//            4. Preferences:
            testedElement = driver.findElement(By.xpath("//input[starts-with(@value, 'Receive-')]"));
            System.out.print("Checkbox 'Receive Notifications' is disabled ");
            if (!testedElement.isEnabled()) {
                System.out.println(msgPassed);
            } else {
                System.out.println(msgFailed);
                testPass = false;
            }

            btn = driver.findElement(By.cssSelector("button#enabledcheckbox"));
            btn.click();

            System.out.print("Checkbox 'Receive Notifications' is checked ");
            testedElement.click();
            if (testedElement.isSelected()) {
                System.out.println(msgPassed);
            } else {
                System.out.println(msgFailed);
                testPass = false;
            }



        } catch( Exception e)
    {
        System.out.println(msgFailed + " (" + e.getMessage().split("\n")[0] + ")");
        testPass = false;
    } finally

    {
        // Thread.sleep(3000);
        driver.quit();
        if (testPass) System.out.println(msgPassed);
        else System.out.println(msgFailed);
    }
}
}
