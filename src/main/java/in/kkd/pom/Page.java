package in.kkd.pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

    WebDriver driver;
    WebDriverWait wait;

    public Page(WebDriver driver){
        this.driver=driver;
        this.wait= new WebDriverWait(this.driver,15);
    }

    //abstract methods:
    public abstract String getPageTitle();
    public abstract String getPageHeader(By locator);
    public abstract WebElement getElement(By locator);
    public abstract void waitForElementPresent(By locator);
    public abstract void waitForPageTitle(String title);
    public abstract Actions getAction();

    public <TPage extends BasePage> TPage getInstance(Class<TPage> PageClass){

        try{
        return PageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

}
