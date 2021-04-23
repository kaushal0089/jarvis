package in.kkd.pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FireFoxDriverManager extends DriverManager{


//    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    @Override
    public void createDriver() {
        System.setProperty("webdriver.firefox.driver","geckodriver.exe");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("test-type");
        capabilities.setCapability(ChromeOptions.CAPABILITY,options);
//        driver.set(new FirefoxDriver());
//        driver = new FirefoxDriver();
        driver.set(new FirefoxDriver());
//        return new FirefoxDriver();
    }
//    public WebDriver getDriver(){
//        return driver.get();
//    }

}
