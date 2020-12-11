package in.kkd.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import in.kkd.pom.*;

public class FacebookTest {
    WebDriver driver;
    @Test
    public void postWithImages() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("http://facebook.com");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("kaushal.kanjariya");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("kkdvas@0089");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
        Thread.sleep(5000);
        int size = driver.findElements(By.xpath("//div[@data-pagelet='FeedUnit_{n}']//img[@alt='Image']")).size();
        System.out.println("post with images are : "+size);
    }
}
