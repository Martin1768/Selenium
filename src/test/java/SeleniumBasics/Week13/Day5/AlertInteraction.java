package SeleniumBasics.Week13.Day5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static SeleniumBasics.Week12.colorOutputMsgs.msgFailed;
import static SeleniumBasics.Week12.colorOutputMsgs.msgPassed;

public class AlertInteraction {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        boolean testPass = true;
        String testedValue;
        WebElement testedElement = null;


        try {
            driver.get("https://syntaxprojects.com/javascript-alert-box-demo-homework.php");
            driver.manage().window().maximize();
//            1. Birthday Reminder
            testedElement = driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']"));
            testedElement.click();
            // Thread.sleep(2000);
            Alert alertDialog = driver.switchTo().alert();
            alertDialog.accept();

//            2. Delete Confirmation
            testedElement = driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']"));
            testedElement.click();
            // Thread.sleep(2000);
            alertDialog.dismiss();
            WebElement msg = driver.findElement(By.cssSelector("p#confirm-demo"));
            String expectedOut = "You pressed Cancel!";
            System.out.print("Expected output: " + expectedOut);
            if (msg.getText().equals(expectedOut)) System.out.println(" " + msgPassed);
            else {
                System.out.println(" " + msgFailed);
                testPass = false;
            }

//            3. Name Collection
            testedElement = driver.findElement(By.xpath("//button[@onclick='myPromptFunction()']"));
            testedElement.click();
            //Thread.sleep(2000);
            testedValue = "Martin";
            alertDialog.sendKeys(testedValue);
            alertDialog.accept();
            msg = driver.findElement(By.cssSelector("p#prompt-demo"));
            expectedOut = "You have entered '" + testedValue + "' !";
            System.out.print("Expected output: " + expectedOut);
            if (msg.getText().equals(expectedOut)) System.out.println(" " + msgPassed);
            else {
                System.out.println(" " + msgFailed);
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

