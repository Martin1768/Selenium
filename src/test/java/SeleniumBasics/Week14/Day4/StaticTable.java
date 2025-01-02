package SeleniumBasics.Week14.Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static SeleniumBasics.Week12.colorOutputMsgs.msgFailed;
import static SeleniumBasics.Week12.colorOutputMsgs.msgPassed;


public class StaticTable {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        boolean testPass = true;
        String testedValue;
        WebElement testedElement = null;


        try {
            driver.get("https://syntaxprojects.com/table-search-filter-demo-homework.php");
            driver.manage().window().maximize();

//            1. Print All Entries with the Country "USA"
            List<WebElement> countriesColumn = driver.findElements(By.cssSelector("table#task-table tbody td:nth-child(3)"));
            testedValue = "USA";
            int rowNr = 1;
            for (WebElement country : countriesColumn) {
                String cellValue = country.getText();
                if (cellValue.equals(testedValue)) {
                    testedElement = driver.findElement(By.cssSelector("table#task-table tbody tr:nth-child(" + rowNr + ")"));
                    String row = testedElement.getText();
                    System.out.print("Row " + rowNr + " contains country '" + testedValue + "': ");
                    System.out.print(row + " ");
                    if (row.contains(testedValue))
                        System.out.println(msgPassed);
                    else {
                        System.out.println(msgFailed);
                        testPass = false;
                    }
                }
                rowNr += 1;
            }

//            2. Dynamic Logic
            // List<WebElement> countriesColumn = driver.findElements(By.cssSelector("table#task-table tbody td:nth-child(3)"));
            String[] testedValues = {"Canada", "Australia", "UK"};
            for (int i=0; i<testedValues.length; i++) {
                testedValue = testedValues[i];
                rowNr = 1;
                for (WebElement country : countriesColumn) {
                    String cellValue = country.getText();
                    if (cellValue.equals(testedValue)) {
                        testedElement = driver.findElement(By.cssSelector("table#task-table tbody tr:nth-child(" + rowNr + ")"));
                        String row = testedElement.getText();
                        System.out.print("Row " + rowNr + " contains country '" + testedValue + "': ");
                        System.out.print(row + " ");
                        if (row.contains(testedValue))
                            System.out.println(msgPassed);
                        else {
                            System.out.println(msgFailed);
                            testPass = false;
                        }
                    }
                    rowNr += 1;
                }
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

