package SeleniumBasics.Week13.Day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

import static SeleniumBasics.Week12.colorOutputMsgs.msgFailed;
import static SeleniumBasics.Week12.colorOutputMsgs.msgPassed;

public class WindowHandles {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        boolean testPass = true;
        String testedValue;
        WebElement testedElement = null;


        try {
            driver.get("https://syntaxprojects.com/window-popup-modal-demo-homework.php");
            driver.manage().window().maximize();
            String hwWindowHandle = driver.getWindowHandle();

//            1. Click on Button B1
            testedElement = driver.findElement(By.xpath("//a[@href='b1-page.php']"));
            testedElement.click();
            Set<String> allWindows = driver.getWindowHandles();
            if (allWindows.size() > 1) {
                for (String w : allWindows) {
                    driver.switchTo().window(w);
                    String url = driver.getCurrentUrl();
                    if (url.equals("https://syntaxprojects.com/b1-page.php"))
                        break;
                }
                testedElement = driver.findElement(By.cssSelector("div.col-md-6.text-left > h2"));
                testedValue = "Welcome to B1! page";
                System.out.print("Expected output: '" + testedValue + "' ");
                if (testedElement.getText().equals(testedValue)) System.out.println(msgPassed);
                else {
                    System.out.println(msgFailed);
                    testPass = false;
                }
            } else {
                System.out.println("Error: 2nd window doesn't exist");
                testPass = false;
            }

            driver.switchTo().window(hwWindowHandle);
//            2. Click on Button B2
            testedElement = driver.findElement(By.xpath("//a[@href='b2-page.php']"));
            testedElement.click();
            allWindows = driver.getWindowHandles();
            if (allWindows.size() > 1) {
                for (String w : allWindows) {
                    driver.switchTo().window(w);
                    String url = driver.getCurrentUrl();
                    if (url.equals("https://syntaxprojects.com/b2-page.php"))
                        break;
                }
                testedElement = driver.findElement(By.cssSelector("div.col-md-6.text-left > div > h2"));
                testedValue = "Welcome to B2 page";
                System.out.print("Expected output: '" + testedValue + "' ");
                if (testedElement.getText().equals(testedValue)) System.out.println(msgPassed);
                else {
                    System.out.println(msgFailed);
                    testPass = false;
                }
            } else {
                System.out.println("Error: 2nd window doesn't exist");
                testPass = false;
            }

            driver.switchTo().window(hwWindowHandle);


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

