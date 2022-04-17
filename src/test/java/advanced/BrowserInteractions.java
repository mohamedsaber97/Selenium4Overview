package advanced;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserInteractions {
    public static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("file://D:\\IntellijProjects\\Selenium4Overview\\src\\test\\resources\\index.html");
        sendAndClick();
        driver.quit();
    }

    public static void sendAndClick() {
        WebElement email = driver.findElement(By.id("inputEmail"));
        email.sendKeys("msaber9765@gmail.com");
        WebElement password = driver.findElement(By.id("inputPassword"));
        password.sendKeys("123456");
        WebElement send = driver.findElement(By.xpath("//*[text() = 'Sign in']"));
        send.click();
    }
}
