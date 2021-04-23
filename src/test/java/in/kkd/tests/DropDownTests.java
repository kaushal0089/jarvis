package in.kkd.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class DropDownTests{

    WebDriver driver;
    @Test
    public void selectFromDropDownList(){
        driver = new ChromeDriver();
        driver.get("https://paperbirdtech.com/");
//        String url = "https://facebook.com";
//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        js.executeScript("window.open(arguments[0])",url);
        String MainWindow = driver.getWindowHandle();
        driver.findElement(By.xpath("//span[@class='ti-facebook']/parent::*")).click();
        driver.findElement(By.xpath("//span[@class='ti-facebook']/parent::*")).sendKeys(Keys.chord(Keys.CONTROL, "n"));
        System.out.println("now of windows are : "+driver.getWindowHandles().size());
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> i = windows.iterator();
        while (i.hasNext()){
              String childWindow = i.next();
            if(!childWindow.equalsIgnoreCase(MainWindow)){
                System.out.println("Child window is : "+childWindow);
                driver.switchTo().window(childWindow);
                System.out.println("child window title : "+driver.getTitle());
            }
        }
        driver.switchTo().window(MainWindow);
        System.out.println("Main window Title is : "+driver.getTitle());
//        driver.quit();

    }

    @Test
    public void newWindow(){

    }
}
