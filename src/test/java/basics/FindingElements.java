package basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class FindingElements {
    public static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("file://D:\\IntellijProjects\\Selenium4Overview\\src\\test\\resources\\index.html");
        driver.manage().window().maximize();
        getById();
        getByName();
        getByClass();
        getByTagName();
        getByLinkText();
        getByXpath();
        driver.quit();
    }

    //to access element by id
    public static void getById() {
        WebElement element = driver.findElement(By.id("welcome"));
        String text = element.getText();
        System.out.println("textId is : " + text);
    }

    //to access element by name
    public static void getByName() {
        WebElement element = driver.findElement(By.name("description"));
        String text = element.getText();
        System.out.println("textName is : " + text);
    }

    //to access element by className
    public static void getByClass() {
        WebElement element = driver.findElement(By.className("about"));
        String text = element.getText();
        System.out.println("textClass is : " + text);
    }

    //to access element by tagName
    public static void getByTagName() {
        WebElement element = driver.findElement(By.tagName("li")); //get first item only which has tagName "li"
        String text = element.getText();
        System.out.println("textTagName is : " + text);
    }

    //to access element by linkText with full text and partial which tagName "a" and attribute "href"
    public static void getByLinkText() {
        WebElement element = driver.findElement(By.linkText("Go to About Page"));
        WebElement element2 = driver.findElement(By.partialLinkText("About Page"));
        String fullText = element.getText();
        String partialText = element2.getText();
        System.out.println("textFullLinkText is : " + fullText);
        System.out.println("textPartialLinkText is : " + partialText);
    }

    /* xpath format
     * Relative xpath :  "//tagName[@attribute='value']"   or with general tagName "//*[@attribute='value']"
     * Absolute xpath :  "//parent tagName/subParent tagName/child tagName"
     * Xpath by contains :  "//*[contains(@attribute , 'part of text')]"
     * Xpath by text :  "//*[text() = 'text']"
     */
    //to access element by xpath
    public static void getByXpath() {
        WebElement element = driver.findElement(By.xpath("//h1[@id='welcome']"));
        WebElement element2 = driver.findElement(By.xpath("//html/body/h1"));
        WebElement element3 = driver.findElement(By.xpath("//*[contains(@class , 'country-')]"));
        WebElement element4 = driver.findElement(By.xpath("//*[text() = 'Contact us']"));
        String relativeText = element.getText();
        String absoluteText = element2.getText();
        String containsText = element3.getText();
        String byText = element4.getText();
        System.out.println("textRelativeXpath is : " + relativeText);
        System.out.println("textAbsoluteXpath is : " + absoluteText);
        System.out.println("textContainsXpath is : " + containsText);
        System.out.println("textByTextXpath is : " + byText);
    }
}
