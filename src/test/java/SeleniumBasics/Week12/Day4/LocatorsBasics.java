package SeleniumBasics.Week12.Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.NoSuchElementException;

public class LocatorsBasics {
    public static void main(String[] args) {
        boolean passedAll = true;
        String msgPassed = "\u001B[32mTest Passed\u001B[0m";
        String msgFailed = "\u001B[31mTest Failed\u001B[0m";

        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://www.syntaxprojects.com/locator-homework.php");
            WebElement eFullName = driver.findElement(By.id("fullName"));
            eFullName.sendKeys("Martin Schwarz");
            WebElement eEmail = driver.findElement(By.id("yourEmail"));
            eEmail.sendKeys("marsch1768gmail.com");
//            eEmail.sendKeys("marsch1768@gmail.com");
            WebElement eClientName = driver.findElement(By.name("ClientName"));
            eClientName.sendKeys("John Brown");
            WebElement eClientID = driver.findElement(By.name("ClientId"));
            eClientID.sendKeys("JB-24-01245-0100");
            WebElement eClientFeedback = driver.findElement(By.id("ClientfeedbackId"));
            eClientFeedback.sendKeys("Try a different header image. Thank you.");
            WebElement eProjectName = driver.findElement(By.id("ProjectNameId"));
            eProjectName.sendKeys("Furniture Maker's Depot");
            WebElement eProjectDeadline = driver.findElement(By.name("ProjectTime"));
            eProjectDeadline.sendKeys("March 2025");
            List<WebElement> textareas = driver.findElements(By.tagName("textarea"));
            if (textareas.size() > 0) textareas.get(0).sendKeys("Street 123\nTown\nZIP code");
            if (textareas.size() > 1) textareas.get(1).sendKeys("Street 458\nTown\nZIP code");
            try {
                WebElement eClickHere = driver.findElement(By.partialLinkText("Click Here"));
                eClickHere.click();
            } catch (Exception e) {
                System.out.println("Error occured: " + e.getMessage());
            }
            int wins = driver.getWindowHandles().size();
            System.out.print("Click Here. -> New Tab opened ");
            if (wins == 2)
                System.out.println(msgPassed);
            else
                System.out.println(msgFailed);

            boolean wrongEmail = false;
            if (!eEmail.getText().contains("@")) {
                try {
                    List<WebElement> wrongValueMsgs = driver.findElements(By.tagName("small"));
                    wrongEmail = wrongValueMsgs.get(1).isDisplayed();
                    passedAll = passedAll && !wrongEmail;
                    System.out.print("Entered correct email address ");
                    System.out.println((wrongEmail) ? msgFailed : msgPassed);
                } catch (NoSuchElementException e) {
                    System.out.println("Error occurred: " + e.getMessage());
                }
            }

            WebElement eSubmitBtn = driver.findElement(By.name("btn-submit"));
            System.out.print("Submit button is ");
            if (eSubmitBtn.isEnabled())
                if (!wrongEmail)
                    System.out.println("enabled " + msgPassed);
                else {
                    passedAll = false;
                    System.out.println("enabled even if the email is wrong " + msgFailed);
                }
            else {
                if (wrongEmail)
                    System.out.println("disabled " + msgPassed);
                else {
                    passedAll = false;
                    System.out.println("disabled even if the email is correct " + msgFailed);
                }

            }
            if (eSubmitBtn.isEnabled())
                eSubmitBtn.click();
            try {
                WebElement formResults = driver.findElement(By.id("form-results"));
                System.out.print("Submit button click() -> The 'Form results' displayed ");
                System.out.println((formResults.getText().isEmpty())? msgFailed:msgPassed);
            } catch (Exception e) {
                System.out.println("Error occured: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        } finally {
            driver.quit();
            try {
                driver.getCurrentUrl();
            } catch (org.openqa.selenium.NoSuchSessionException e) {
                System.out.println("Chrome closed correctly.");
            }
            if (passedAll) System.out.println("\u001B[32m" + msgPassed.toUpperCase() + "\u001B[0m");
            else System.out.println("\u001B[31m" + msgFailed.toUpperCase() + "\u001B[0m");
        }
    }
}
