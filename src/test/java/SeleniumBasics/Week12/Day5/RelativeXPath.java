package SeleniumBasics.Week12.Day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

import static SeleniumBasics.Week12.colorOutputMsgs.*;

public class RelativeXPath {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        boolean testPass = true;
        WebElement testedElement;
        String testedValue = "";

        try {
            driver.get("https://www.syntaxprojects.com/Xpath-homework.php");

// 1. The user is able to enter their hobbies using XPath.
            testedValue = "Woodworking, gardening";
            System.out.print("Hobbies '" + testedValue + "' ");
            testedElement = driver.findElement(By.xpath("//input[@id='yourHobbiesId']"));
            testedElement.sendKeys(testedValue);
            if (testedElement.getAttribute("value").equals(testedValue))
                System.out.println(msgPassed);
            else {
                System.out.println(msgFailed + "(" + testedElement.getAttribute("value") + ")");
                testPass = false;
            }

// 2. When the user clicks the "Click Here" button using XPath.,
//   Then the message `"Button clicked:"` should be displayed on the screen.
            testedValue = "Button Clicked";
            System.out.print("Text '" + testedValue + "' is visible after click() ");
            testedElement = driver.findElement(By.xpath("//p[starts-with(text(), '" + testedValue.split(" ")[0] + "')]"));
            WebElement btn = driver.findElement((By.xpath("//button[@id='display_text']")));
            btn.click();
            if (testedElement.isDisplayed()) System.out.println(msgPassed);
            else {
                System.out.println(msgFailed);
                testPass = false;
            }
// 3. The user successfully enters their favorite movie using XPath to find the text boxes.
            testedValue = "Christmas with the Kranks, Contact";
            System.out.print("Favorite movies '" + testedValue + "' ");
            testedElement = driver.findElement(By.xpath("//input[@id='favoriteMoviesId']"));
            testedElement.sendKeys(testedValue);
            if (testedElement.getAttribute("value").equals(testedValue))
                System.out.println(msgPassed);
            else {
                System.out.println(msgFailed + "(" + testedElement.getAttribute("value") + ")");
                testPass = false;
            }
// 4. The user uses the `contains()` method of XPath to locate a specific text element on the page and prints it to the console.
            testedValue = "Lorem ipsum";
            System.out.print("The paragraph '" + testedValue + " ...' exists ");
            testedElement = driver.findElement(By.xpath("//label[contains(text(), 'consectetur')]"));
            if (testedElement.getText().startsWith(testedValue)) System.out.println(msgPassed);
            else {
                System.out.println(msgFailed);
                testPass = false;
            }

// 5. The user is able to enter the city in the designated field.
            testedValue = "Bruntal";
            System.out.print("City '" + testedValue + "' ");
            testedElement = driver.findElement(By.xpath("//input[@id='yourCity']"));
            testedElement.sendKeys(testedValue);
            if (testedElement.getAttribute("value").equals(testedValue))
                System.out.println(msgPassed);
            else {
                System.out.println(msgFailed);
                testPass = false;
            }

// 6. The user must use the **indexing technique** learned in class to enter  email addresses.
            testedValue = "user1@gmails.com";
            System.out.print("Personal email '" + testedValue + "' ");
            testedElement = driver.findElement(By.xpath("(//input[@type='email'])[1]"));
            testedElement.sendKeys(testedValue);
            if (testedElement.getAttribute("value").equals(testedValue))
                System.out.println(msgPassed);
            else {
                System.out.println(msgFailed);
                testPass = false;
            }
            testedValue = "user2@gmails.com";
            System.out.print("Office email '" + testedValue + "' ");
            testedElement = driver.findElement(By.xpath("(//input[@type='email'])[2]"));
            testedElement.sendKeys(testedValue);
            if (testedElement.getAttribute("value").equals(testedValue))
                System.out.println(msgPassed);
            else {
                System.out.println(msgFailed);
                testPass = false;
            }
            testedValue = "user3@gmails.com";
            System.out.print("Professional email '" + testedValue + "' ");
            testedElement = driver.findElement(By.xpath("(//input[@type='email'])[3]"));
            testedElement.sendKeys(testedValue);
            if (testedElement.getAttribute("value").equals(testedValue))
                System.out.println(msgPassed);
            else {
                System.out.println(msgFailed);
                testPass = false;
            }

// 7. The user must use the **operators technique** (e.g., `and`, `or`) to enter both the client name and client ID.
            testedValue = "Joe Black";
            System.out.print("Client name '" + testedValue + "' ");
            testedElement = driver.findElement(By.xpath("//input[@id='clientName' and @data-detail='one']"));
            testedElement.sendKeys(testedValue);
            if (testedElement.getAttribute("value").equals(testedValue))
                System.out.println(msgPassed);
            else {
                System.out.println(msgFailed);
                testPass = false;
            }
            testedValue = "24-0154.2-ER";
            System.out.print("Client ID '" + testedValue + "' ");
            testedElement = driver.findElement(By.xpath("//input[@id='clientId' and @data-detail='two']"));
            testedElement.sendKeys(testedValue);
            if (testedElement.getAttribute("value").equals(testedValue))
                System.out.println(msgPassed);
            else {
                System.out.println(msgFailed);
                testPass = false;
            }

// 8. The user can use **any XPath technique** to enter the street number and house number.
            testedValue = "1589";
            System.out.print("Street No '" + testedValue + "' ");
            testedElement = driver.findElement(By.xpath("//input[@name='StreetNo' and @data-detail='one']"));
            testedElement.sendKeys(testedValue);
            if (testedElement.getAttribute("value").equals(testedValue))
                System.out.println(msgPassed);
            else {
                System.out.println(msgFailed);
                testPass = false;
            }
            testedValue = "25";
            System.out.print("House No '" + testedValue + "' ");
            testedElement = driver.findElement(By.xpath("//input[@name='HouseNo' and @data-detail='two']"));
            testedElement.sendKeys(testedValue);
            if (testedElement.getAttribute("value").equals(testedValue))
                System.out.println(msgPassed);
            else {
                System.out.println(msgFailed);
                testPass = false;
            }

            // Removes focus from the last tested element, not necessary of course, just playing and learning :)
            WebElement body = driver.findElement(By.tagName("body"));
            body.click();

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
