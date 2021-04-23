package in.kkd.tests;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import in.kkd.Utility.TestUtil;


public class MarketPlaceLogin {

    WebDriver driver;
    ExtentTest test;
    By userName = By.xpath("//input[@id='exampleInputEmail1']");
    By password = By.xpath("//input[@id='exampleInputPassword1']");
    By login = By.xpath("//button[@type='submit' and text()='Log In']");

    public MarketPlaceLogin(WebDriver driver){
        this.driver = driver;
    }

    public void setUserName(String strUserName){
        driver.findElement(userName).sendKeys(strUserName);
    }
    public void setPassword(String strPassword){
        driver.findElement(password).sendKeys(strPassword);
    }
    public void loginClick(){
        driver.findElement(login).click();
    }


    @DataProvider
    public Iterator<Object[]> getTestData() throws IOException {
        ArrayList<Object[]> testData = TestUtil.getDataFromExcell();
        System.out.println(testData.size());
        return testData.iterator();
    }
    @Test(dataProvider = "getTestData")
    public void loginToMarketplace(String strUserName, String strPassword, ExtentTest test){
        System.out.println("dataprovider: "+strUserName+strPassword);
        this.setUserName(strUserName);
        test.log(LogStatus.PASS, "Username is set as : "+strUserName);
        this.setPassword(strPassword);
        test.log(LogStatus.PASS, "Password is set as : "+strPassword);
        this.loginClick();
    }

    @Test
    public void checktest(){
        System.out.println("runningnnn");
    }

}
