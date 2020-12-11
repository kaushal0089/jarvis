package in.kkd.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import sun.rmi.runtime.Log;
import in.kkd.pom.*;
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

    @Test
    public void doLoginTest(){
        HomePage homepage = page.getInstance(LoginPage.class).doLogin("kkd23@gamil.com","password");
        String homepageHeader = homepage.getHomePageTitle();
        Assert.assertEquals(homepageHeader,"STL Home");
    }


}
