package advanced;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class BrowserInteractions {
    public static WebDriver driver;
    public static JavascriptExecutor js;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        js = (JavascriptExecutor) driver; //to define java script executor
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //to wait 5 seconds for searching element
        driver.get("file://D:\\IntellijProjects\\Selenium4Overview\\src\\test\\resources\\index.html");
        sendAndClick();
        selectCheckBox();
        selectDropdown();
        checkDisplay();
        checkEnable();
        checkSelect();
        getAllData();
        Thread.sleep(5000); //to wait 5 seconds
        driver.quit();
    }

    //send data in fields and click
    public static void sendAndClick() throws InterruptedException {
        WebElement email = driver.findElement(By.id("inputEmail"));
        email.sendKeys("msaber9765@gmail.com");
        WebElement password = driver.findElement(By.id("inputPassword"));
        password.sendKeys("123456");
        WebElement check = driver.findElement(By.xpath("//*[@value='remember-me']"));
        js.executeScript("arguments[0].click();", check);
        Thread.sleep(5000);
        WebElement send = driver.findElement(By.xpath("//*[text() = 'Sign in']"));
        js.executeScript("arguments[0].click();", send); //to click on un clickable item
    }

    //select items from checkbox and radio button
    public static void selectCheckBox() {
        js.executeScript("window.scrollBy(0,-2500)", ""); //to scroll up to item
        WebElement item = driver.findElement(By.id("Banana"));
        js.executeScript("arguments[0].click();", item);
    }

    //select items from dropdown with select and options tags
    public static void selectDropdown() {
        WebElement item = driver.findElement(By.id("courses"));  //define select tag
        Select dropdown = new Select(item);
        dropdown.selectByIndex(0);
        dropdown.selectByValue("cypress");
        dropdown.selectByVisibleText("appium");
    }

    //check if element is displayed or not
    public static void checkDisplay() {
        WebElement send = driver.findElement(By.xpath("//*[text() = 'Sign in']"));
        boolean display = send.isDisplayed();
        System.out.println(display);
    }

    //check if element is enabled to edit or not
    public static void checkEnable() {
        WebElement email = driver.findElement(By.id("inputEmail"));
        boolean enable = email.isEnabled();
        System.out.println(enable);
    }

    //check if element is selected in checkbox or not
    public static void checkSelect() {
        WebElement check = driver.findElement(By.xpath("//*[@value='remember-me']"));
        boolean selected = check.isSelected();
        System.out.println(selected);
    }

    //get all data of element
    public static void getAllData() {
        WebElement email = driver.findElement(By.id("inputEmail"));
        String attribute = email.getAttribute("id");
        String tagName = email.getTagName();
        String cssValue = email.getCssValue("background-color"); //to get property of style css
        Point point = email.getLocation(); //to get point of x and y
        Dimension dimension = email.getSize(); //to get dimensions of height and width
        Rectangle rectangle = email.getRect(); //to get point of x , y and dimensions of height , width
        String accessibleName = email.getAccessibleName(); //to get accessibleName of field
        String role = email.getAriaRole(); //to get type of field for example (textBox - Button)
        System.out.println("attribute value is : " + attribute);
        System.out.println("tagName value is : " + tagName);
        System.out.println("cssValue value is : " + cssValue);
        System.out.println("point value of x is : " + point.x + " and point value of y is : " + point.y);
        System.out.println("dimension value of height is : " + dimension.height + " and dimension value of width is : " + dimension.width);
        System.out.println("point value of x is : " + rectangle.x + " and dimension value of width is : " + rectangle.width);
        System.out.println("accessibleName value is : " + accessibleName);
        System.out.println("role value is : " + role);
    }
}
