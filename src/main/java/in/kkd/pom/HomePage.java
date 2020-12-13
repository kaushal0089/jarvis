package in.kkd.pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
        waitForElementPresent(getMenuLocator(menuItem));
        WebElement menu= getMenu(menuItem);
        getAction().moveToElement(menu).perform();
        getAction().click().build().perform();
    }
}
