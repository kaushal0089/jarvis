package in.kkd.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    public void selectPlan(String planName){
        String planLocator = "b[@class='header_title' and text()='"+planName+"']//following-sibling::b[text()='Plus']";
        By plan = By.xpath(planLocator);
        waitForElementPresent(plan);
        driver.findElement(plan).click();
    }
}
