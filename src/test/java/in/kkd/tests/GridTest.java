package in.kkd.tests;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GridTest {
    @Test
    public void launchGoogle() throws MalformedURLException {
//        System.setProperty("webdriver.chrome.driver","C:\\Users\\kaushal.kanjariya\\IdeaProjects\\Jarvis-Test\\chromedriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.LINUX);
//        capabilities.setCapability("seleniumProtocol","WebDriver");
//        capabilities.setVersion("86");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.setHeadless(true);
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://10.151.35.12:4444/wd/hub"),options);
        driver.navigate().to("https://www.google.com");
        Assert.assertEquals("Google",driver.getTitle());
        driver.quit();
    }
    @Test
    public void flaunchGoogle() throws MalformedURLException {
//        System.setProperty("webdriver.firefox.driver","chromedriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setBrowserName("firefox");
        capabilities.setPlatform(Platform.WIN10);
        FirefoxOptions options = new FirefoxOptions();
//        options.setCapability("marinette","true");
        options.merge(capabilities);
//        capabilities.setVersion("86");
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://10.212.136.176:4444/wd/hub"),options);
        driver.navigate().to("https://www.google.com");
        Assert.assertEquals("Google",driver.getTitle());
        driver.quit();
    }
    @Test
    public void claunchGoogle() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\kaushal.kanjariya\\IdeaProjects\\Jarvis-Test\\chromedriver.exe");
//        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//        capabilities.setBrowserName("firefox");
//        capabilities.setPlatform(Platform.WIN10);
//        FirefoxOptions options = new FirefoxOptions();
//        options.merge(capabilities);
//        capabilities.setVersion("86");
//        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://10.212.136.176:4444/wd/hub"),options);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("https://www.google.com");
        Assert.assertEquals("Google",driver.getTitle());
        driver.quit();
    }


}
