package LiveClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionClass {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://syntaxprojects.com/simple_context_menu.php#");

        WebElement hoverBtn = driver.findElement(By.xpath("//button[text()='Hover me!']"));

        Actions action = new Actions(driver);
        action.moveToElement(hoverBtn).perform();

        Thread.sleep(2000);
        WebElement rightClick = driver.findElement(By.xpath("//button[text()='Right Click!']"));
        action.contextClick(rightClick).perform();

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement dropLoc = driver.findElement(By.id("droppable"));

//        action.dragAndDrop(draggable,dropLoc).perform();

        action.clickAndHold(draggable).moveToElement(dropLoc).release().build().perform();

        WebElement img = driver.findElement(By.xpath("(//img[@data-animation='animated zoomInLeft'])[2]"));
        action.scrollToElement(img).perform();

    }
}
