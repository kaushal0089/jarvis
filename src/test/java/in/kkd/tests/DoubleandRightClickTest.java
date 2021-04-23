package in.kkd.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DoubleandRightClickTest extends BaseTest{

    @Test(enabled = false)
    public void rightClick() throws InterruptedException {
        driver.get().get("http://demo.guru99.com/test/simple_context_menu.html");
        driver.get().manage().window().maximize();
        Actions act = new Actions(driver.get());
        WebElement ele = driver.get().findElement(By.xpath("//span[text()='right click me']"));
        act.contextClick(ele).perform();
        Thread.sleep(20000);
    }
    @Test(enabled = false)
    public void doubleClick() throws InterruptedException {
        driver.get().get("http://demo.guru99.com/test/simple_context_menu.html");
        driver.get().manage().window().maximize();
        Actions act = new Actions(driver.get());
        WebElement ele = driver.get().findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
        act.doubleClick(ele).perform();
        Alert alt = driver.get().switchTo().alert();
        alt.accept();
        Thread.sleep(20000);
    }

    @Test(enabled = false)
    public void selectFromDropDownList() throws InterruptedException {
        driver.get().get("http://demo.guru99.com/test/newtours/register.php");
        List<WebElement> dropDown = driver.get().findElements(By.cssSelector("select[name='country'] option"));
        WebElement ele = driver.get().findElement(By.cssSelector("select[name='country']"));
//        Select select = new Select(dropDown);
//        select.selectByIndex(1);
//        Thread.sleep(10000);
        JavascriptExecutor js = (JavascriptExecutor)driver.get();
        js.executeScript("arguments[0].scrollIntoView();",ele);
          for(WebElement el : dropDown){
              if(el.getText().equalsIgnoreCase("ARUBA")){

                  el.click();
              }
          }
          Thread.sleep(10000);

    }
    @Test
    public void dropDownWithoutSelect() throws InterruptedException {
        driver.get().get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
        WebElement drp = driver.get().findElement(By.xpath("//button[@class='multiselect dropdown-toggle btn btn-default']"));
        drp.click();
        System.out.println("Source code is : "+drp.getAttribute("innerHTML"));

        List<WebElement> elements = driver.get().findElements(By.xpath("//ul[@class='multiselect-container dropdown-menu']//li/a/label"));
        for (WebElement el : elements){
            if(el.getText().equalsIgnoreCase("Java")){
                el.click();
            }
        }
        Thread.sleep(10000);
    }



}
