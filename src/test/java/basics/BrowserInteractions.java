package basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.Set;

public class BrowserInteractions {
    public static WebDriver driver;
    public static JavascriptExecutor js;
    public static Actions actions;
    public static String baseUrl = "https://the-internet.herokuapp.com/";

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        js = (JavascriptExecutor) driver; //to define java script executor
        actions = new Actions(driver); //to define actions
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //to wait 5 seconds for searching element
        sendAndClick();
        selectCheckBox();
        selectDropdown();
        checkDisplay();
        checkEnable();
        checkSelect();
        getAllData();
        rightDoubleClick();
        moveToElement();
        dragAndDrop();
        handleWindow();
        Thread.sleep(3000); //to wait 5 seconds before quit
        driver.quit();
    }

    //send data in fields and click
    public static void sendAndClick() {
        driver.get(baseUrl + "login");
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("mohamed saber");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("123456");
        WebElement login = driver.findElement(By.xpath("//*[@type = 'submit']"));
        login.click();
        //js.executeScript("arguments[0].click();", login); //to click on un clickable item
    }

    //select items from checkbox and radio button
    public static void selectCheckBox() {
        driver.get(baseUrl + "checkboxes");
        WebElement item = driver.findElement(By.xpath("//*[text() = ' checkbox 1']"));
        item.click();
    }

    //select items from dropdown with select and options tags
    public static void selectDropdown() {
        driver.get(baseUrl + "dropdown");
        WebElement item = driver.findElement(By.id("dropdown"));  //define select tag
        Select dropdown = new Select(item);
        dropdown.selectByIndex(0);
        dropdown.selectByValue("1");
        dropdown.selectByVisibleText("Option 2");
    }

    //check if element is displayed or not
    public static void checkDisplay() {
        driver.get(baseUrl + "checkboxes");
        WebElement item = driver.findElement(By.xpath("//*[text() = ' checkbox 1']"));
        boolean display = item.isDisplayed();
        System.out.println("display is :  " + display);
    }

    //check if element is enabled to edit or not
    public static void checkEnable() {
        driver.get(baseUrl + "login");
        WebElement username = driver.findElement(By.id("username"));
        boolean enable = username.isEnabled();
        System.out.println("enable is :  " + enable);
    }

    //check if element is selected in checkbox or not
    public static void checkSelect() {
        driver.get(baseUrl + "checkboxes");
        WebElement item = driver.findElement(By.xpath("//*[text() = ' checkbox 1']"));
        boolean selected = item.isSelected();
        System.out.println("selected is :  " + selected);
    }

    //get all data of element
    public static void getAllData() {
        driver.get(baseUrl + "login");
        WebElement username = driver.findElement(By.id("username"));
        String attribute = username.getAttribute("id");
        String tagName = username.getTagName();
        String cssValue = username.getCssValue("background-color"); //to get property of style css
        Point point = username.getLocation(); //to get point of x and y
        Dimension dimension = username.getSize(); //to get dimensions of height and width
        Rectangle rectangle = username.getRect(); //to get point of x , y and dimensions of height , width
        String accessibleName = username.getAccessibleName(); //to get accessibleName of field
        String role = username.getAriaRole(); //to get type of field for example (textBox - Button)
        System.out.println("attribute value is : " + attribute);
        System.out.println("tagName value is : " + tagName);
        System.out.println("cssValue value is : " + cssValue);
        System.out.println("point value of x is : " + point.x + " and point value of y is : " + point.y);
        System.out.println("dimension value of height is : " + dimension.height + " and dimension value of width is : " + dimension.width);
        System.out.println("point value of x is : " + rectangle.x + " and dimension value of width is : " + rectangle.width);
        System.out.println("accessibleName value is : " + accessibleName);
        System.out.println("role value is : " + role);
    }

    //make right click and double-click on element
    public static void rightDoubleClick() {
        driver.get(baseUrl + "add_remove_elements/");
        WebElement item = driver.findElement(By.xpath("//*[text() = 'Add Element']"));
        actions.doubleClick(item).perform();
        actions.contextClick(item).perform(); //to make right click
    }

    //move to element with mouse only without any action
    public static void moveToElement() {
        driver.get(baseUrl + "hovers");
        WebElement item = driver.findElement(By.xpath("//*[@alt = 'User Avatar']"));
        actions.moveToElement(item).perform();
    }

    //to drag and drop from element to another element
    public static void dragAndDrop() {
        driver.get(baseUrl + "drag_and_drop");
        WebElement source = driver.findElement(By.id("column-a"));
        WebElement destination = driver.findElement(By.id("column-b"));
        actions.dragAndDrop(source, destination).perform();
        actions.clickAndHold(source).moveToElement(destination).release().build().perform();
    }

    //handle multiple window
    public static void handleWindow() {
        driver.get(baseUrl + "windows");
        String parentTab = driver.getWindowHandle(); //to get parent window tab id
        System.out.println("parent tab id is : " + parentTab);
        WebElement newPage = driver.findElement(By.linkText("Click Here"));
        newPage.click();
        Set<String> allTabsId = driver.getWindowHandles(); //to get list of window tab ids
        System.out.println("all tab ids are : " + allTabsId); //to get list of window tab ids
        for (String window : allTabsId) {
            if (!window.equalsIgnoreCase(parentTab)) { //to ignore upper case
                driver.switchTo().window(window);
                System.out.println("title of new page is : " + driver.getTitle());
                driver.close(); //to close the new tab only
            }
        }
        driver.switchTo().window(parentTab); //to return to parent window
    }
}
