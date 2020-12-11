package in.kkd.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import in.kkd.pom.*;

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

}
