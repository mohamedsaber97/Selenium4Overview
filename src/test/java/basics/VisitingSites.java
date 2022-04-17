package basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class VisitingSites {
    public static WebDriver driver;
    public static Dimension phoneDimension;

    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        getPage();
        getFile();
        getSize();
        getCurrentUrl();
        getTitle();
        getPageSource();
        getClose();
        getNavigation();
    }

    //open any web page with url
    public static void getPage() {
        driver.get("https://qacart.com");
        driver.quit();
    }

    //open any local file with absolute path
    public static void getFile() {
        driver.get("file://D:\\work\\Automation\\SiteProjects\\Selenium4Overview\\src\\test\\resources\\index.html");
        driver.quit();
    }

    //open page in different screen size
    public static void getSize() {
        driver.get("https://www.selenium.dev/documentation/");
        phoneDimension = new Dimension(375, 667);
        driver.manage().window().setSize(phoneDimension);
        driver.quit();
    }

    //get current url of page
    public static void getCurrentUrl() {
        driver.get("https://www.selenium.dev/documentation/");
        String url = driver.getCurrentUrl();
        System.out.println("The current url is : " + url);
        driver.quit();
    }

    //get title of page
    public static void getTitle() {
        driver.get("https://www.selenium.dev/documentation/");
        String title = driver.getTitle();
        System.out.println("The title is : " + title);
        driver.quit();
    }

    //get page source of page
    public static void getPageSource() {
        driver.get("https://www.selenium.dev/documentation/");
        String pageSource = driver.getPageSource();
        System.out.println("The page source is : " + pageSource);
        driver.quit();
    }

    //close page
    public static void getClose() {
        driver.get("https://www.selenium.dev/documentation/");
        driver.close(); // close first window only
        driver.quit(); // close all windows and tabs
    }

    //navigation methods
    public static void getNavigation() {
        driver.get("https://www.google.com");
        driver.navigate().to("https://www.selenium.dev/documentation/");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.quit();
    }

}
