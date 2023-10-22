package advanced;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Alerts {
    public static WebDriver driver;
    public static String baseUrl = "https://the-internet.herokuapp.com/";

    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        acceptAlert();
        dismissAlert();
        getAlertText();
        sendTextToAlert();
        checkAlertIsPresented();
        driver.quit();
    }


    //to access alerts and accept or dismiss
    public static void acceptAlert() {
        driver.get(baseUrl + "javascript_alerts"); //open page
        WebElement element = driver.findElement(By.xpath("//*[text() = 'Click for JS Alert']")); //get element
        element.click(); //show alert
        driver.switchTo().alert().accept(); //to switch to alert and accept
    }

    //to access alerts and dismiss
    public static void dismissAlert() {
        driver.get(baseUrl + "javascript_alerts"); //open page
        WebElement element = driver.findElement(By.xpath("//*[text() = 'Click for JS Confirm']")); //get element
        element.click(); //show alert
        driver.switchTo().alert().dismiss(); //to switch to alert and dismiss
    }

    //to access alerts and get text
    public static void getAlertText() {
        driver.get(baseUrl + "javascript_alerts"); //open page
        WebElement element = driver.findElement(By.xpath("//*[text() = 'Click for JS Confirm']")); //get element
        element.click(); //show alert
        String text = driver.switchTo().alert().getText(); //to get text of prompt alert
        System.out.println("prompt alert text is : " + text); //print alert text
    }

    //to access alerts and send text data
    public static void sendTextToAlert() {
        driver.get(baseUrl + "javascript_alerts"); //open page
        WebElement element = driver.findElement(By.xpath("//*[text() = 'Click for JS Confirm']")); //get element
        element.click(); //show alert
        driver.switchTo().alert().sendKeys("welcome java script prompt alert"); //to send text into alert
    }

    //to check if alert is presented
    public static void checkAlertIsPresented() {
        driver.get(baseUrl + "javascript_alerts"); //open page
        try {
            WebElement element = driver.findElement(By.xpath("//*[text() = 'Click for JS Confirm']")); //get element
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2)); //define explicit wait
            element.click(); //show alert
            wait.until(ExpectedConditions.alertIsPresent()); //wait until alert is presented
            driver.switchTo().alert().accept(); //to switch to alert and accept
        } catch (Exception e) {
            System.out.println("-----no such alert-----"); //print if alert is not presented
        }
    }
}
