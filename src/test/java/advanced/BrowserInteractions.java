package advanced;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class BrowserInteractions {
    public static WebDriver driver;
    public static JavascriptExecutor js;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        js = (JavascriptExecutor) driver; //to define java script executor
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //to wait 5 seconds for searching element
        driver.get("file://D:\\IntellijProjects\\Selenium4Overview\\src\\test\\resources\\index.html");
        sendAndClick();
        selectItems();
        Thread.sleep(5000); //to wait 5 seconds
        driver.quit();
    }

    //send data in fields and click
    public static void sendAndClick() throws InterruptedException {
        WebElement email = driver.findElement(By.id("inputEmail"));
        email.sendKeys("msaber9765@gmail.com");
        WebElement password = driver.findElement(By.id("inputPassword"));
        password.sendKeys("123456");
        WebElement check = driver.findElement(By.xpath("//*[@value='remember-me']"));
        js.executeScript("arguments[0].click();", check);
        Thread.sleep(5000);
        WebElement send = driver.findElement(By.xpath("//*[text() = 'Sign in']"));
        js.executeScript("arguments[0].click();", send); //to click on un clickable item
    }

    //select items from checkbox and radio button
    public static void selectItems() {
        js.executeScript("window.scrollBy(0,-2500)", ""); //to scroll up to item
        WebElement item = driver.findElement(By.id("Banana"));
        js.executeScript("arguments[0].click();", item);
    }
}
