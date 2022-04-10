package basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class VisitingSites {
    public static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        getPage();
    }

    //open any web page with url
    public static void getPage() {
        driver.get("https://qacart.com");
        driver.manage().window().maximize();
    }

}
