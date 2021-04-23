package in.kkd.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage  extends Page{

    public BasePage(WebDriver driver){
           super(driver);
    }

    @Override
    public String getPageTitle() {
        return driver.getTitle();
    }

    @Override
    public String getPageHeader(By locator) {
        return getElement(locator).getText();
    }

    @Override
    public WebElement getElement(By locator) {
        WebElement element = null;
        WebDriverWait wait = new WebDriverWait(driver,30);
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element = driver.findElement(locator);
            return element;
        }
        catch (Exception e){
            System.out.println("some error occured while creating element"+locator.toString());
            e.printStackTrace();
        }
        return element;
    }

    @Override
    public void waitForElementPresent(By locator) {
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }catch(Exception e){
            System.out.println("some errror occured while wainting for the element"+locator.toString());
            e.printStackTrace();
        }
    }

    @Override
    public void waitForPageTitle(String title) {
        try{
            wait.until(ExpectedConditions.titleContains(title));
        }catch(Exception e){
            System.out.println("some errror occured while wainting for the title"+title.toString());
            e.printStackTrace();
        }

    }

    @Override
    public Actions getAction() {
        Actions action = new Actions(driver);
        return action;
    }
}
