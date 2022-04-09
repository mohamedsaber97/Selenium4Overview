package basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class OpenBrowsers {

    public static void main(String[] args) {
        openWithDriver();
        openWithManager();
    }

    public static void openWithDriver() {
        System.out.println("hello selenium in edge with driver");
        System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.quit();
    }

    public static void openWithManager() {
        System.out.println("hello selenium in edge with manager");
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.quit();
    }
}
