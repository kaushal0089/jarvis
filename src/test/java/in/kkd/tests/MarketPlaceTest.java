package in.kkd.tests;

//import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.util.List;
import java.util.concurrent.TimeUnit;
import in.kkd.pom.*;
public class MarketPlaceTest {
    static ExtentTest test;
    static ExtentReports report;
    WebDriver driver;
    MarketPlaceLogin login;
    MarketPlaceHome home;

    @BeforeClass
    public static void startTest()
    {
        report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
        test = report.startTest("ExtentDemo");
    }

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void marketplaceLogin() throws InterruptedException{
        driver.get("http://10.151.35.12:30000");
        driver.findElement(By.xpath("//a[text()='Login']")).click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        login = new MarketPlaceLogin(driver);
        login.loginToMarketplace("shopizer100@gmail.com","password",test);
        home = new MarketPlaceHome(driver);
        System.out.println("Username is "+home.getHomePageUsername());
        Assert.assertNotEquals(home.getHomePageUsername(),"shopizer10012");
//        test.log(LogStatus.PASS,"You have Logged in successfully...");
        test.log(LogStatus.FAIL,"UserName should be shopizer10012 so this test case is failed");

    }


    public void vRANOrder() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://10.151.35.38:30000");
        test.log(LogStatus.PASS, "Navigated to the Marketplace URL");
        driver.findElement(By.xpath("//a[text()='Know more' and @role='button']")).click();
        test.log(LogStatus.PASS, "Click on the know more");
//      //WebElement ele = driver.findElement(By.xpath("//label[@class='btn btn-secondary btn-outline active']//child::input[@id='option2' and @type='radio']"));
        //Actions action = new Actions(driver);
        //action.moveToElement(ele);
        //action.click().build().perform();
        driver.findElement(By.xpath("//a[text()='ADD TO CART']")).click();
        List<WebElement> eles = driver.findElements(By.xpath("//a[text()='4G']"));
        System.out.println("Elements size:"+eles.size());
        eles.get(1).click();
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void nginxCloudService() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://10.151.35.38:30000");
        test.log(LogStatus.PASS, "Navigated to the Marketplace URL");
        driver.manage().window().maximize();
        Actions action = new Actions(driver);
        WebElement allCategory = driver.findElement(By.xpath("//a[@id='allcategories']"));
        action.moveToElement(allCategory).perform();
        action.click().build().perform();
        WebElement cloudServices = driver.findElement(By.xpath("//a[text()='Cloud Services']"));
        action.moveToElement(cloudServices).perform();
        action.click().build().perform();
        WebElement privateCloudServices = driver.findElement(By.xpath("//a[text()='Private Cloud Services']"));
        action.moveToElement(privateCloudServices).perform();
        action.click().build().perform();
        test.log(LogStatus.PASS, "Move to the cloud services URL");
        WebElement NGINXCard = driver.findElement(By.xpath("//a[@href='./nginxplusdetails' and text()='Add']"));
        NGINXCard.click();
        WebElement NGINXPLUS = driver.findElement(By.xpath("//b[@class='header_title' and text()='Plan']//following-sibling::b[text()='Plus']"));
        action.moveToElement(NGINXPLUS).perform();
        Thread.sleep(2000);
        action.click().build().perform();
        WebElement cpuAllocation = driver.findElement(By.xpath("//input[@id='vpc1']"));
        cpuAllocation.clear();
        cpuAllocation.sendKeys("2");
        WebElement memoryAllocation = driver.findElement(By.xpath("//input[@id='gbram1']"));
        memoryAllocation.clear();
        memoryAllocation.sendKeys("4");
        WebElement diskAllocation = driver.findElement(By.xpath("//input[@id='gbdisk1']"));
        diskAllocation.clear();
        diskAllocation.sendKeys("50");
        WebElement diskAllocationBackup = driver.findElement(By.xpath("//input[@id='gbbackups1']"));
        diskAllocationBackup.clear();
        diskAllocationBackup.sendKeys("100");
        WebElement targetNamespace = driver.findElement(By.xpath("//input[@id='target_namespace']"));
        targetNamespace.sendKeys("dep-rnd");
        WebElement checkmarkTerms = driver.findElement(By.xpath("//span[@class='checkmark']"));
        checkmarkTerms.click();
        Thread.sleep(1000);
        WebElement addToCart = driver.findElement(By.xpath("//button[@type='submit' and text()='Add to Cart']"));
        addToCart.click();
        WebElement checkout = driver.findElement(By.xpath("//a[text()='Checkout' and @class='btn btn-success btn-checkout withoutRadiusBorder']"));
        checkout.click();
        WebElement paymentConfirmation = driver.findElement(By.xpath("//a[@type='button' and text()='Confirmation']"));
        paymentConfirmation.click();
        Thread.sleep(5000);
        WebElement NGINXStatus = driver.findElement(By.xpath("//h4[text()='NGINX deployed successfully on k8s cluster']"));
        System.out.println("Meesage :"+NGINXStatus.getText());
        Assert.assertEquals(NGINXStatus.getText(),"NGINX deployed successfully on k8s cluster");
        driver.close();

    }
    @AfterClass
    public static void endTest()
    {
        report.endTest(test);
        report.flush();
    }
    @AfterTest
    public void tearDown()
    {
        driver.close();
    }
}
