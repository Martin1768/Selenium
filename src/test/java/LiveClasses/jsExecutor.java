package LiveClasses;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

public class jsExecutor {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver= new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://syntaxprojects.com/simple_context_menu.php");


        JavascriptExecutor js = (JavascriptExecutor) driver;



        Thread.sleep(2000);
        driver.quit();
    }
}
