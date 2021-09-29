package seleniumTest.seleniumTestExample;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Chrome Web Driver Started!" );
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Owner\\Desktop\\HOME\\Home\\PROYECTOS\\"
        		+ "selenium\\WebDrivers\\chromedriver_win32\\chromedriver.exe");
      	WebDriver driver = new ChromeDriver();
      	String baseUrl = "http://demo.guru99.com/test/newtours/";
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = "";
        driver.get(baseUrl);
        actualTitle = driver.getTitle();
        if (actualTitle.contentEquals(expectedTitle)) {
        	System.out.println( "Test Passed!" );
        } else {
        	System.out.println( "Test Failed!" );
        }
        //---------------------------------------------------------------
        baseUrl = "http://www.facebook.com";
        String tagName = "";
        driver.get(baseUrl);
        tagName = driver.findElement(By.id("email")).getTagName();
        System.out.println(tagName);
        //---------------------------------------------------------------
        //SELENIUM SELECTOR TESTING
        baseUrl = "http://the-internet.herokuapp.com/login";
        driver.get(baseUrl);
        List<WebElement> ems = new ArrayList<WebElement>();
        //1. Selector By Tag Name
        ems = driver.findElements(By.tagName("em"));
        //2. Selector By Id
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys(ems.get(0).getText());
        WebElement userPass = driver.findElement(By.id("password"));
        userPass.sendKeys(ems.get(1).getText());
        WebElement form = driver.findElement(By.id("login"));
        form.submit();
        WebElement result = driver.findElement(By.id("flash"));
        System.out.println(result.getText());
        //3.1 By.className	finds elements based on the value of the “class” attribute	findElement(By.className(“someClassName”))
        List<WebElement> rowElements = new ArrayList<WebElement>();
        rowElements = driver.findElements(By.className("row"));
        for (WebElement element: rowElements) {
        	System.out.println("Por clase: " + element.getText());
        }
        //3.2 Compound class (XPATH)
        WebElement element = driver.findElement(By.xpath("//div[@class='large-12 columns']"));
       	System.out.println("Por clase compuesta (xpath): " + element.getTagName() );
       	//4. By.cssSelector	finds elements based on the driver’s underlying CSS Selector engine	findElement(By.cssSelector(“input#email”))
        List<WebElement> rowElementsByCssSelector = new ArrayList<WebElement>();
        rowElementsByCssSelector = driver.findElements(By.cssSelector("div.row"));
        for (WebElement elementByCssSelector: rowElementsByCssSelector) {
        	System.out.println("Por CSS selector: " + elementByCssSelector.getText());
        }
        //5. By.linkText	finds a link element by the exact text it displays	findElement(By.linkText(“REGISTRATION”))
        driver.findElement(By.linkText("Elemental Selenium")).click();
        //Switch to new tab
        App app =  new App();
        app.switchTab(driver);
        //6. By.name	locates elements by the value of the “name” attribute	findElement(By.name(“someName”))
        driver.findElement(By.name("fields[email]")).sendKeys("adg08101@gmail.com");
        //Select Element
        Select selectElement = new Select(driver.findElement(By.name("fields[programming_language]")));
        selectElement.selectByValue("java");
        driver.findElement(By.id("submit")).click();
        app.switchTab(driver);
        //7. By.partialLinkText	locates elements that contain the given link text	findElement(By.partialLinkText(“REG”)) 
        driver.findElement(By.partialLinkText("Back to Previous")).click();
        //driver.close();
        //System.exit(0);
    }
    
    public void switchTab(WebDriver driver) {
    	for (String windowsHandle: driver.getWindowHandles()) {
        	driver.switchTo().window(windowsHandle);
        }
    }
}
