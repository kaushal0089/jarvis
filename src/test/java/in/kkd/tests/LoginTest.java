package in.kkd.tests;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;



import javax.swing.*;
import javax.xml.transform.Result;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import in.kkd.pom.*;
public class LoginTest {

    WebDriver driver;

  @Test
  void loginTest() throws InterruptedException {
      System.setProperty("webdriver.chrome.driver","chromedriver.exe");
      WebDriver driver = new ChromeDriver();
      driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_elem_input");

      List<WebElement> elements = driver.findElements(By.tagName("iframe"));
      int noOfTags = elements.size();
      System.out.println("NO of elements : "+ noOfTags);
      // switch to the frame using frame id
      //driver.switchTo().frame("iframeResult");
      driver.switchTo().frame(driver.findElement(By.xpath("//iFrame[@id='iframeResult']")));
      // print the frame source code
//      System.out.println("Frame Title: "+driver.getTitle());
      driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("kaushal will earn 20 lakh package");
//      driver.findElement(By.xpath("//input[@name='fname']")).sendKeys(Keys.ENTER);
      driver.findElement(By.xpath("//input[@type='submit']")).click();
      driver.switchTo().parentFrame();
      Thread.sleep(5000);
      driver.close();
  }
  @Test
    void checkbox() throws InterruptedException {
      System.setProperty("webdriver.chrome.driver","chromedriver.exe");
      WebDriver driver = new ChromeDriver();
      boolean selection;
      driver.get("https://datatables.net/extensions/select/examples/initialisation/checkbox.html");
      driver.findElement(By.xpath("//td[text()='Brenden Wagner']//preceding-sibling::td[@class=' select-checkbox']")).click();
      WebElement checkbox = driver.findElement(By.xpath("//td[text()='Brenden Wagner']//preceding-sibling::td[@class=' select-checkbox']"));
      System.out.println("CHeck selecitin : "+checkbox.isSelected());
      Thread.sleep(10000);
      //driver.close();
  }
  @Test
     void dropDown() throws Exception {
      System.setProperty("webdriver.chrome.driver","chromedriver.exe");
      WebDriver driver = new ChromeDriver();
      driver.get("https://www.browserstack.com/guide/handling-frames-in-selenium");
      Actions action = new Actions(driver);
      WebElement ele =  driver.findElement(By.cssSelector("a[id='developers-menu-toggle'] "));
      action.moveToElement(ele).perform();
      //a[@title='Support' and text()='Support']
      WebElement subMenu = driver.findElement(By.xpath("//a[@title='Support' and text()='Support']"));
      action.moveToElement(subMenu);
      action.click().build().perform();
      this.takeSnapShot(driver, "C:\\Users\\kaushal.kanjariya\\Pictures\\Screenshots\\testsnap.png");
      DesiredCapabilities capability = DesiredCapabilities.chrome();
      capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
  }
  @Test
    void dropDownUsingSelect() throws MalformedURLException {
      System.setProperty("webdriver.driver.chrome","chromedriver.exe");
//      WebDriver driver = new ChromeDriver();
      DesiredCapabilities capability = DesiredCapabilities.chrome();
      capability.setBrowserName("chrome");
      capability.setPlatform(Platform.WIN10);
      URL url = new URL("http://192.168.43.140:4444/wd/hub");
      WebDriver driver = new RemoteWebDriver(url,capability);
      driver.get("https://www.facebook.com/");
      WebElement day = driver.findElement(By.id("day"));
      WebElement month = driver.findElement(By.id("month"));
      WebElement year = driver.findElement(By.id("year"));

      Select select = new Select(day);
      select.selectByVisibleText("25");
      select = new Select(month);
      select.selectByVisibleText("Aug");
      select = new Select(year);
      select.selectByVisibleText("1992");
  }
  @Test
   void linksCount(){
      System.setProperty("webdirver.driver.chrome","chromedriver.exe");
      WebDriver driver = new ChromeDriver();
      driver.get("https://www.facebook.com");
      System.out.println("No of links in facebook page : "+driver.findElements(By.xpath("//a")).size());
  }

  public void setup(){
      System.setProperty("webdriver.driver.chrome","chromedriver.exe");
      WebDriver driver = new ChromeDriver();
      driver.manage().window().maximize();
  }

  @Test
   public void waitFunction() throws InterruptedException, IOException {
    Process p = Runtime.getRuntime().exec("echo running shell");

  }

        public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
//Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
//Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
//Move image file to new destination
        File DestFile=new File(fileWithPath);
//Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
    }
}
