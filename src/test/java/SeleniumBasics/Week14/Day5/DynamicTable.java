package SeleniumBasics.Week14.Day5;

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


public class DynamicTable {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        boolean testPass = true;
        String testedValue;
        WebElement testedElement = null;


        try {
            driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
            driver.manage().window().maximize();

//            1. Look for an Employee ID on Page 3
//            manually

//            2. Dynamic Search and Deletion
//            Login part
            driver.findElement(By.id("txtUsername")).sendKeys("Admin");
            driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
            driver.findElement(By.id("btnLogin")).click();

//            Open Employee List = click on 'PIM' tab
            driver.findElement(By.cssSelector("a#menu_pim_viewPimModule")).click();

//            Searching for ID '89643895' from the page 3
//            and than 2 next IDs from other pages
            WebDriverWait waitObj = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement lastBtn = driver.findElement(By.xpath("//a[text()='Last']"));
            int lastPage = Integer.parseInt(lastBtn.getAttribute("href").split("[^\\d]+")[1]);
            // lastPage = 2;    // simulation of not finding the requested ID
            boolean notFound;
            int rowNr, pageNr;
            String[] testedValues = {"89643895", "111637A", "111037A"};  // pages 3, 2, 5
            for (int i = 0; i < testedValues.length; i++) {
                testedValue = testedValues[i];
                pageNr = 1;
                notFound = true;
                while (notFound) {
                    WebElement nextBtn = driver.findElement(By.xpath("//a[text()='Next']"));
                    List<WebElement> idColumn = driver.findElements(By.cssSelector("table#resultTable tbody td:nth-child(2)"));
                    rowNr = 1;
                    for (WebElement id : idColumn) {
                        String cellValue = id.getText();
                        if (cellValue.equals(testedValue)) {
                            testedElement = driver.findElement(By.cssSelector("table#resultTable tbody tr:nth-child(" + rowNr + ")"));
                            String row = testedElement.getText();
                            System.out.print("Row " + rowNr + " contains id '" + testedValue + "' on page " + pageNr + ": ");
                            System.out.print(row + " ");
                            if (row.contains(testedValue))
                                System.out.println(msgPassed);
                            else {
                                System.out.println(msgFailed);
                                testPass = false;
                            }
//                        click the checkbox
                            testedElement = driver.findElement(By.cssSelector("table#resultTable tbody tr:nth-child(" + rowNr + ") input"));
                            testedElement.click();
                            waitObj.until(ExpectedConditions.elementToBeSelected(By.cssSelector("table#resultTable tbody tr:nth-child(" + rowNr + ") input")));
                            System.out.print("Checkbox is selected ");
                            if (testedElement.isSelected())
                                System.out.println(msgPassed);
                            else {
                                System.out.println(msgFailed);
                                testPass = false;
                            }
                            notFound = false;
                        }
                        rowNr += 1;
                    }
                    if (pageNr++ < lastPage) {
                        if (notFound) nextBtn.click();
                    } else {
                        notFound = false;
                        System.out.println(msgFailed + " (ID '" + testedValue + "' doesn't exists)");
                        testPass = false;
                    }
                }
                driver.findElement(By.xpath("//a[text()='First']")).click();
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

