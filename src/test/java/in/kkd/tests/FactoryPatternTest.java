package in.kkd.tests;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.net.MalformedURLException;
import java.net.URL;
import in.kkd.pom.*;

public class FactoryPatternTest {

    DriverManager driverManager;
//    RemoteWebDriver driver;
    WebDriver driver;

    //@BeforeTest
    @Parameters("browser")
    public void beforeTest(String browser){
        if(browser.equalsIgnoreCase("chrome")){
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        }
        if (browser.equalsIgnoreCase("firefox")){
            driverManager = DriverManagerFactory.getManager(DriverType.FIREFOX);
        }
    }
    @BeforeMethod
    public void beforeMethod(){
        driver = driverManager.getDriver();
    }
    @AfterMethod
    public void afterMethod(){
        driverManager.quitDriver();
    }

//    @Test
    public void launchTest() throws MalformedURLException {
        driver.get("http://testautomationguru.com");
        Assert.assertEquals("TestAutomationGuru – A technical blog on test automation",driver.getTitle());
    }
    @Test
    public void launchGoogle() throws MalformedURLException{
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setBrowserName("chrome");
//        capabilities.setPlatform(Platform.WIN10);
//        capabilities.setVersion("82");
//        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://10.212.136.176:4444/wd/hub"),capabilities);

//        driver.get("https://www.google.com");
        driver.navigate().to("https://www.google.com");
        Assert.assertEquals("Google",driver.getTitle());
    }
    @Test
    public void launchGoogleHTMLUnit() throws MalformedURLException{
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setBrowserName("chrome");
//        capabilities.setPlatform(Platform.WIN10);
//        capabilities.setVersion("82");
//        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://10.212.136.176:4444/wd/hub"),capabilities);
        HtmlUnitDriver unitDriver = new HtmlUnitDriver();

//        driver.get("https://www.google.com");
        unitDriver.get("https://www.google.com");
        Assert.assertEquals("Google",driver.getTitle());
    }
}
