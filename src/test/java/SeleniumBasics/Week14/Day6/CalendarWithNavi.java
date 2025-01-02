package SeleniumBasics.Week14.Day6;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import static SeleniumBasics.Week12.colorOutputMsgs.msgFailed;
import static SeleniumBasics.Week12.colorOutputMsgs.msgPassed;


public class CalendarWithNavi {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        boolean testPass = true;
        WebElement testedElement = null;

        try {
            driver.get("https://syntaxprojects.com/jquery-date-picker-demo-homework.php");
            driver.manage().window().maximize();

//            1. Select "From" and "To" Dates
            List<WebElement> testedElements = new ArrayList<>();
            testedElements.add(driver.findElement(By.id("from_date")));
            testedElements.add(driver.findElement(By.id("to_date")));
            String[] testedDates = {"01/31/2025", "08/02/2026"};
            // String[] testedDates = {"02/30/2025", "08/02/2026"}; // nonexistent date simulation

            for (int i = 0; i < testedDates.length; i++) {
                testedElements.get(i).click();
                int dateDay = Integer.parseInt(testedDates[i].substring(3, 5));
                String dateMonthYear = Month.of(Integer.parseInt(testedDates[i].substring(0, 2))).toString() + " " + testedDates[i].substring(6);
                boolean notFound = true;

                while (notFound) {
                    String currMonth = driver.findElement(By.cssSelector("div.ui-datepicker-title")).getText();
                    if (currMonth.toUpperCase().equals(dateMonthYear)) {
                        List<WebElement> dates = driver.findElements(By.cssSelector("table.ui-datepicker-calendar a"));
                        testedElement = null;
                        for (WebElement d : dates) {
                            if (Integer.parseInt(d.getText()) == dateDay) {
                                testedElement = d;
                                break;
                            }
                        }
                        System.out.print("Expected date '" + testedDates[i] + "': ");
                        if (testedElement != null) {
                            testedElement.click();
                            System.out.print(testedElements.get(i).getAttribute("value") + " ");
                            if (testedDates[i].equals(testedElements.get(i).getAttribute("value")))
                                System.out.println(msgPassed);
                            else {
                                System.out.println(msgFailed);
                                testPass = false;
                            }
                        } else {    // date does not exist
                            driver.findElement(By.tagName("body")).sendKeys(Keys.ESCAPE);
                            System.out.println("date does not exist " + msgFailed);
                            testPass = false;
                        }
                        notFound = false;
                    } else {
                        driver.findElement(By.cssSelector("a.ui-datepicker-next.ui-corner-all")).click();
                    }
                }
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

