package in.kkd.pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class DriverManager {
    protected WebDriver driver;
//    protected abstract void startService();
//    protected abstract void stopService();
    protected abstract void createDriver();

    public void quitDriver(){
        if(driver != null){
            driver.quit();
            driver=null;
        }
    }

    public WebDriver getDriver() {
        if(driver == null){
//            startService();
            createDriver();
        }
        return driver;
    }
}
