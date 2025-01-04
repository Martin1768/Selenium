package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonMethods {
    public static WebDriver driver;
    public static void openBrowser(){

//        read the browser and url from the config.properties
        String browser= ConfigReader.read("browser");
        switch (browser){
            case "chrome":
                driver=new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser name: " + browser);
        }

        driver.manage().window().maximize();
        driver.get(ConfigReader.read("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public static void closeBrowser(){
        if(driver!=null){
            driver.close();
        }
    }

    //    make a method for declaration of explicit wait
    public static WebDriverWait getWait(){
        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
        return wait;
    }

    public static void waitForElementToBeClickable(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void waitForElementToBeVisible(WebElement element) {
        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public static void clickOnElement(WebElement element){
        waitForElementToBeClickable(element);
        element.click();
    }

    public static void sentText(String text, WebElement element){
        waitForElementToBeVisible(element);
        element.clear();
        element.sendKeys(text);
    }

    public static void selectFromDropDown(WebElement element, int index ){
        Select sel=new Select(element);
        sel.selectByIndex(index);
    }

    public static  void selectFromDropDown(WebElement element, String value){
        Select sel=new Select(element);
        sel.selectByValue(value);
    }

    public static  void selectFromDropDown(String text, WebElement element){
        Select sel=new Select(element);
        sel.selectByVisibleText(text);
    }
    //takescreenshot
    //timestamp

}
