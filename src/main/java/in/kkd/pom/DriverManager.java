package in.kkd.pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class DriverManager {
//    WebDriver  driver;
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
//    protected abstract void startService();
//    protected abstract void stopService();
//    protected abstract void createDriver();
    protected abstract void createDriver();

    public void quitDriver(){
        if(driver != null){
            driver.get().quit();
            driver=null;
        }
    }

    public ThreadLocal<WebDriver> getDriver() {
//        if(driver == null){
//            startService();
        createDriver();
//            driver = new ThreadLocal<>();
//            driver.set(createDriver());
//        }
        return driver;
    }
}
