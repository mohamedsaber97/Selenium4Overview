package basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class OpenBrowsers {
    public static WebDriver driver;

    public static void main(String[] args) {
        openWithDriver();
        openWithManager();
    }

    //to open browser with specific driver
    public static void openWithDriver() {
        System.out.println("hello selenium in edge with driver");
        System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
        driver = new EdgeDriver();
        driver.quit();
    }

    //to open browser with driver manager
    public static void openWithManager() {
        System.out.println("hello selenium in edge with manager");
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.quit();
    }
}