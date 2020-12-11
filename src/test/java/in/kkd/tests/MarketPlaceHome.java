package in.kkd.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import in.kkd.pom.*;
public class MarketPlaceHome {
    WebDriver driver;
    By loggedinUsername = By.xpath("//a[text()='shopizer100']");
    public MarketPlaceHome(WebDriver driver){
        this.driver=driver;
    }

    public String getHomePageUsername(){
        return driver.findElement(loggedinUsername).getText();
    }
}
