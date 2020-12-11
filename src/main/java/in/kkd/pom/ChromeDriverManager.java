package in.kkd.pom;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.URL;

public class ChromeDriverManager extends DriverManager {
    private ChromeDriverService chService;

//    @Override
//    public void startService() {
//        if(chService == null){
//            try{
//                chService = new ChromeDriverService.Builder().usingDriverExecutable(new File("chromedriver.exe")).usingAnyFreePort().build();
//            }
//            catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//
//    }
//
//    @Override
//    public void stopService() {
//        if(chService != null & chService.isRunning()){
//            chService.stop();
//        }
//    }

    @Override
    public void createDriver() {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("test-type");
//        capabilities.setCapability(ChromeOptions.CAPABILITY,options);
        capabilities.setPlatform(Platform.WIN10);
        capabilities.setBrowserName("chrome");
//        capabilities.setVersion("86");
//        driver = new ChromeDriver(options);
        try{
//           driver = new ChromeDriver();
         driver = new RemoteWebDriver(new URL("http://10.212.136.176:4444/wd/hub"),capabilities);
        }
        catch (Exception e){e.printStackTrace();}

    }

}
