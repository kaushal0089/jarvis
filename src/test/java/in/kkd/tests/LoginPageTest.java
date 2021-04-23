package in.kkd.tests;

import in.kkd.Utility.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//import sun.rmi.runtime.Log;
import in.kkd.pom.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class LoginPageTest extends BaseTest{

    @Test(enabled = false)
    public void verifyLoginPageTitleTest(){

        String title = page.getInstance(LoginPage.class).getLoginPageTitle();
        System.out.println(title);
        Assert.assertEquals(title,"STL Home");
    }

    @Test(enabled = false)
    public void verifyLoginPageHeaderTest(){
        String header = page.getInstance(LoginPage.class).getLoginPageHeader();
        System.out.println(header);
        Assert.assertEquals(header,"");
    }



    
    @Test(dataProvider = "getTestData",enabled = false)
    public void doLoginTest(String firstname,String password){
//        HomePage homepage = page.getInstance(LoginPage.class).doLogin("kkd23@gamil.com","password");
        HomePage homepage = page.getInstance(LoginPage.class).doLogin(firstname,password);
        String homepageHeader = homepage.getHomePageTitle();
        Assert.assertEquals(homepageHeader,"STL Home");
    }

    @DataProvider(parallel = true)
    public Iterator<Object[]> getTestData() throws IOException {
        ArrayList<Object[]> testData = TestUtil.getDataFromExcell();
        return testData.iterator();
    }

    @Test(dataProvider = "getTestData")
    public void facebookLogin(String firstname, String password) throws InterruptedException{
        driver.get().navigate().to("https://www.facebook.com");
        driver.get().findElement(By.xpath("//input[@id='email']")).sendKeys(firstname);
        driver.get().findElement(By.xpath("//input[@id='pass']")).sendKeys(password);
        driver.get().findElement(By.xpath("//button[@name='login']")).submit();
        Thread.sleep(30000);
    }



}
