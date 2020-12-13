package in.kkd.tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import in.kkd.pom.*;

import java.io.File;
import java.security.PublicKey;

public class BaseTest {

    WebDriver driver;
    DriverManager driverManager;
    public  Page page;

    @BeforeMethod
    @Parameters(value= {"browser"})
    public void setUp(String browser){
        if(browser.equalsIgnoreCase("chrome")){
            driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
            driver = driverManager.getDriver();
        }
        if(browser.equalsIgnoreCase("firefox")){
            driverManager = DriverManagerFactory.getManager(DriverType.FIREFOX);
            driver = driverManager.getDriver();
        }

        driver.get("http://10.151.35.38:30000/login");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        page = new BasePage(driver);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @AfterMethod
    public void takeSnapShot() throws Exception{
        //Convert web driver object to TakeScreenshot
//        if(testResult.getStatus()==ITestResult.FAILURE) {
            TakesScreenshot scrShot = ((TakesScreenshot) driver);
            //Call getScreenshotAs method to create image file
            File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
            //Move image file to new destination
            File DestFile = new File("C:\\Users\\kaushal.kanjariya\\Pictures\\Screenshots\\testsnap.png");
            //Copy file at destination
            FileUtils.copyFile(SrcFile, DestFile);
//        }
    }

//    public void clickMenuItem(String menuItem){
//        page.waitForElementPresent(page.getInstance(HomePage.class).getMenuLocator(menuItem));
//        WebElement menu= page.getInstance(HomePage.class).getMenu(menuItem);
//        page.getInstance(HomePage.class).getAction().moveToElement(menu).perform();
//        page.getInstance(HomePage.class).getAction().click().build().perform();
//    }

}
