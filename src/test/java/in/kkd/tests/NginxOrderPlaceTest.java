package in.kkd.tests;

import in.kkd.pom.HomePage;
import in.kkd.pom.LoginPage;
import in.kkd.pom.NGINXDetailsPage;
import in.kkd.pom.PrivateCloudServicesPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NginxOrderPlaceTest extends BaseTest{

    @Test
    public void nginxRobin() throws InterruptedException {
        HomePage homepage = page.getInstance(LoginPage.class).doLogin("kkd23@gmail.com","password");
        String homeheader = homepage.getHomePageHeader();
//        Assert.assertEquals(homeheader,"STL Home");
//        Thread.sleep(3000);
        page.getInstance(HomePage.class).clickMenuItem("All Categories");
//        Thread.sleep(2000);
        page.getInstance(HomePage.class).clickMenuItem("Cloud Services");
        page.getInstance(HomePage.class).clickMenuItem("Private Cloud Services");
        Thread.sleep(8000);
        page.getInstance(PrivateCloudServicesPage.class).addToCart("NGINX_Robin");
        page.getInstance(NGINXDetailsPage.class).selectPlan("PLUS");
        Thread.sleep(8000);


    }
}
