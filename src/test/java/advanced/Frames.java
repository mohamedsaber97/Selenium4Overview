package advanced;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class Frames {
    public static WebDriver driver;
    public static String baseUrl = "https://the-internet.herokuapp.com/";

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        getFrameById();
        getFrameByElement();
        getNestedFrames();
        Thread.sleep(3000);
        driver.quit();
    }

    public static void getFrameById() {
        driver.get(baseUrl + "iframe");
        WebDriver frame = driver.switchTo().frame("mce_0_ifr"); //switch to frame by id or name
        System.out.println("frame title by id is : " + frame.getTitle());
    }

    public static void getFrameByElement() {
        driver.get(baseUrl + "iframe");
        WebElement element = driver.findElement(By.id("mce_0_ifr")); //define frame element
        WebDriver subFrame = driver.switchTo().frame(element); //switch to frame by element
        System.out.println("subFrame title by element is : " + subFrame.getTitle());
        WebDriver parentFrame = driver.switchTo().parentFrame(); //switch to parent frame
        System.out.println("parentFrame title by element is : " + parentFrame.getTitle());
    }

    public static void getNestedFrames() {
        driver.get(baseUrl + "nested_frames");
        driver.switchTo().frame("frame-top");
        WebDriver nestedFrame = driver.switchTo().frame("frame-left"); //switch to nested frame
        System.out.println("nestedFrame source is : " + nestedFrame.getPageSource());
        driver.switchTo().parentFrame(); //switch to parent of sub frame
        WebDriver mainPage = driver.switchTo().parentFrame(); //switch to main page
        System.out.println("mainPage source is : " + mainPage.getPageSource());
    }
}
