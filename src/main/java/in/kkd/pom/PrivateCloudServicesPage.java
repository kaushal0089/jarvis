package in.kkd.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PrivateCloudServicesPage extends BasePage{

    public PrivateCloudServicesPage(WebDriver driver){
        super(driver);
    }
    private By header = By.xpath("//title[text()='STL Home']");


    public WebElement  getHeader(){
        return getElement(header);
    }

    public String getPrivateCloudServicesPageTitle(){
        return getPageTitle();
    }

    public String getPrivateCloudServicesPageHeader(){
        return getPageHeader(header);

    }

    public void addToCart(String productName){
        String productLocator = "//div[@class='card']//h4[text()='"+productName+"']/parent::*/parent::*/parent::*/following-sibling::*/div/a[1]";
//        waitForElementPresent(By.xpath(productLocator));
        driver.findElement(By.xpath(productLocator)).click();
    }

}
