package basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class FindingElements {
    public static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("file://D:\\work\\Automation\\SiteProjects\\Selenium4Overview\\src\\test\\resources\\index.html");
        getById();
        getByName();
        getByClass();
        getByTagName();
        getByLinkText();
        getByXpath();
        getByCssSelector();
        getListElements();
        driver.quit();
    }

    //to access element by id
    public static void getById() {
        WebElement element = driver.findElement(By.id("welcome"));
        String text = element.getText();
        System.out.println("idText is : " + text);
    }

    //to access element by name
    public static void getByName() {
        WebElement element = driver.findElement(By.name("description"));
        String text = element.getText();
        System.out.println("nameText is : " + text);
    }

    //to access element by className
    public static void getByClass() {
        WebElement element = driver.findElement(By.className("about"));
        String text = element.getText();
        System.out.println("classText is : " + text);
    }

    //to access element by tagName
    public static void getByTagName() {
        WebElement element = driver.findElement(By.tagName("li")); //get first item only which has tagName "li"
        String text = element.getText();
        System.out.println("tagNameText is : " + text);
    }

    //to access element by linkText with full text and partial which tagName "a" and attribute "href"
    public static void getByLinkText() {
        WebElement element = driver.findElement(By.linkText("Go to About Page"));
        WebElement element2 = driver.findElement(By.partialLinkText("About Page"));
        String fullText = element.getText();
        String partialText = element2.getText();
        System.out.println("fullLinkText is : " + fullText);
        System.out.println("partialLinkText is : " + partialText);
    }

    /* xpath format
     * Relative xpath :  "//tagName[@attribute='value']"   or with general tagName "//*[@attribute='value']"
     * Absolute xpath :  "//parent tagName/subParent tagName/child tagName"
     * Xpath by contains :  "//*[contains(@attribute , 'part of text')]"
     * Xpath by text :  "//*[text() = 'text']"
     * to test value in web console $x("value")
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
        System.out.println("xpathRelativeText is : " + relativeText);
        System.out.println("xpathAbsoluteText is : " + absoluteText);
        System.out.println("xpathContainsText is : " + containsText);
        System.out.println("xpathByText is : " + byText);
    }

    /* Css selector format
     * "#IdValueName"
     * ".className"
     * "[attribute="value"]"
     * ".className li:nth-of-type(index)"  //to access element index in list : index start with 1
     * "parent child"  or "parent > child" //to access child element from parent  ">": means direct parent
     * to test value in web console $$("value")
     */
    //to access element by css
    public static void getByCssSelector() {
        WebElement element = driver.findElement(By.cssSelector("#welcome"));
        WebElement element2 = driver.findElement(By.cssSelector(".list1"));
        WebElement element3 = driver.findElement(By.cssSelector("[data-testId= \"welcome-header\"]"));
        WebElement element4 = driver.findElement(By.cssSelector(".course-list li:nth-of-type(5)"));
        WebElement element5 = driver.findElement(By.cssSelector(".course-list .list1"));
        String cssIdText = element.getText();
        String cssClassText = element2.getText();
        String cssIndexText = element3.getText();
        String cssAttributeText = element4.getText();
        String cssChildText = element5.getText();
        System.out.println("cssIdText is : " + cssIdText);
        System.out.println("cssClassText is : " + cssClassText);
        System.out.println("cssAttributeText is : " + cssAttributeText);
        System.out.println("cssIndexText is : " + cssIndexText);
        System.out.println("cssChildText is : " + cssChildText);
    }

    //to access list of elements
    public static void getListElements() {
        WebElement element = driver.findElements(By.cssSelector(".course-list li")).get(3); //get item from list with index
        List<WebElement> elements = driver.findElements(By.cssSelector(".course-list li")); //get all items from list
        String text = element.getText();
        System.out.println("listIndexText is : " + text);
        System.out.println("listLength is : " + elements.size());  //to print size of list
    }
}
