package in.kkd.pom;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FireFoxDriverManager extends DriverManager{

    @Override
    public void createDriver() {
        System.setProperty("webdriver.firefox.driver","geckodriver.exe");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("test-type");
        capabilities.setCapability(ChromeOptions.CAPABILITY,options);
        driver = new FirefoxDriver(options);
    }
}
