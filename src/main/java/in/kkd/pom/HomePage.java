package in.kkd.pom;
//import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class HomePage extends BasePage{

    private By header = By.xpath("//title[text()='STL Home']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement  getHeader(){
        return getElement(header);
    }

    public String getHomePageTitle(){
        return getPageTitle();
    }

    public String getHomePageHeader(){
        return getPageHeader(header);

    }

    public By getMenuLocator(String menuVal){
        return By.xpath("//a[text()="+"'"+ menuVal+ "'"+"]");
    }

    public WebElement getMenu(String menuItemval){
        System.out.println(getMenuLocator(menuItemval).toString());
        return getElement(getMenuLocator(menuItemval));
    }

    @Override
    public Actions getAction() {
        return super.getAction();
    }
    public void clickMenuItem(String menuItem){
//        waitForElementPresent(getMenuLocator(menuItem));

        //Explicit wait implementation --------
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(getMenuLocator(menuItem)));

        // Fluent Wait implementation ---------
        Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5,TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
        fwait.until(new Function<WebDriver, WebElement>() {
          public WebElement apply(WebDriver driver){
              return getMenu(menuItem);
          }
        });
        WebElement menu= getMenu(menuItem);
        getAction().moveToElement(menu).perform();
        getAction().click().build().perform();

    }
}
