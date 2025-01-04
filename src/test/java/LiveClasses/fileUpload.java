package LiveClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class fileUpload {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://syntaxprojects.com/upload-image.php" );


        WebElement chooseFile = driver.findElement(By.xpath("//input[@id='image-file']"));
        chooseFile.sendKeys("/Users/user/Desktop/Java-TypeCasting.png");
//        make sure the path of the file is correct

        Thread.sleep(5000);
        driver.quit();
    }
}
