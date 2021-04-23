package in.kkd.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NGINXDetailsPage extends BasePage{

    public NGINXDetailsPage(WebDriver driver){
        super(driver);
    }

    private By header = By.xpath("//title[text()='STL Home']");


    public WebElement getHeader(){
        return getElement(header);
    }

    public String getNGINXDetailsPageTitle(){
        return getPageTitle();
    }

    public String getNGINXDetailsPageHeader(){
        return getPageHeader(header);

    }

    @Override
    public Actions getAction() {
        return super.getAction();
    }

    public void selectPlan(String planName){
        String planLocator = "//b[@class='header_title' and text()='Plan']//following-sibling::b[text()='"+planName+"']";
        By plan = By.xpath(planLocator);
//        System.out.println(planLocator);
        waitForElementPresent(plan);
        WebElement selectPlan = driver.findElement(plan);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",selectPlan);
        getAction().moveToElement(selectPlan).perform();
        getAction().click().build().perform();
    }

    public void setNGINXConfig(String cpu,String ram, String backup,String diskStorage){
        By cpuLocator = By.xpath("//input[@id='vpc1']");
        By ramLocator = By.xpath("//input[@id='gbram1']");
        By backupLocator= By.xpath("//input[@id='gbdisk1']");
        By diskStorageLocator= By.xpath("//input[@id='gbbackups1']");

        HashMap<By,String> config = new HashMap<By, String>();
        config.put(cpuLocator,cpu);
        config.put(ramLocator,ram);
        config.put(backupLocator,backup);
//        config.put(diskStorageLocator,diskStorage);

        for (HashMap.Entry<By,String> e: config.entrySet()) {
            waitForElementPresent(e.getKey());
            driver.findElement(e.getKey()).clear();
            driver.findElement(e.getKey()).sendKeys(e.getValue());
        }
    }
}
