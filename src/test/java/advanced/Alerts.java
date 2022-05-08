package advanced;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Alerts {
    public static WebDriver driver;
    public static String baseUrl = "https://the-internet.herokuapp.com/";

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        alert();
        promptAlert();
        driver.quit();
    }

    //to access alerts and accept or dismiss
    public static void alert() throws InterruptedException {
        driver.get(baseUrl + "javascript_alerts");
        WebElement element = driver.findElement(By.xpath("//*[text() = 'Click for JS Alert']"));
        element.click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept(); //to switch to alert and accept
        WebElement element2 = driver.findElement(By.xpath("//*[text() = 'Click for JS Confirm']"));
        element2.click();
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss(); //to switch to alert and dismiss
    }

    //to access alerts and send keys and get text
    public static void promptAlert() throws InterruptedException {
        driver.get(baseUrl + "javascript_alerts");
        WebElement element = driver.findElement(By.xpath("//*[text() = 'Click for JS Prompt']"));
        element.click();
        Thread.sleep(3000);
        driver.switchTo().alert().sendKeys("welcome java script prompt alert");
        String text = driver.switchTo().alert().getText(); //to get text of prompt alert
        System.out.println("prompt alert text is : " + text);
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
    }
}
