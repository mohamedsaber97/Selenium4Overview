package advanced;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {
    public static WebDriver driver;
    public static String baseUrl = "https://the-internet.herokuapp.com/";

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        waitThread();
        implicitlyWait();
        explicitWait();
        driver.quit();
    }

    /* thread.sleep
     * wait specified time before finding elements
     --disadvantages
     * You must wait for the specified time even if the item appears before the specified time
     * so it takes more time in execution
     * it is defined for only one element (local for element)
     */
    //wait using thread
    public static void waitThread() throws InterruptedException {
        driver.get(baseUrl + "login");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@type = 'submit']")).click();
    }

    /* implicitlyWait
     * it will try to find element for specified time but if it finds element before specified time , it will stop waiting and complete execution
     * it is defined one time after opening page, and it will be available for all elements in page (global for all elements)
     --disadvantages
     * it waits until element appears only, but it can’t check if element is visible or enabled or hidden or clickable or not
     * it can’t deal with covered elements and return error
     */
    //wait using implicitlyWait
    public static void implicitlyWait() {
        driver.get(baseUrl + "login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[@type = 'submit']")).click();
    }

    /* explicitWait
     * it will try to find element for specified time but if it finds element before specified time , it will stop waiting and complete execution
     * it is available for specific element with a specific condition
     * it can deal with covered elements
     */
    //wait using explicitWait
    public static void explicitWait() {
        driver.get(baseUrl + "login");
        WebElement element = driver.findElement(By.xpath("//*[@type = 'submit']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element)); //wait 5 seconds until element is visible
        element.click();
    }

    /* note
     * don’t mix using implicitlyWait and explicitWait because it causer errors
     */

}
