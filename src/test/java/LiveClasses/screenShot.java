package LiveClasses;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

public class screenShot {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver= new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");

        TakesScreenshot ss = (TakesScreenshot) driver;

        File ssFile = ss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(ssFile, new File("screenshots/image2.png"));

        Thread.sleep(2000);
        driver.quit();
    }
}
