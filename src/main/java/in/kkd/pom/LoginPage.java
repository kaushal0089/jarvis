package in.kkd.pom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

    //Page locators:
    private By emailId  = By.xpath("//input[@id='exampleInputEmail1']");
    private By password = By.xpath("//input[@id='exampleInputPassword1']");
    private By loginButton= By.xpath("//button[@type='submit' and text()='Log In']");
    private By header = By.xpath("//title[text()='STL Home']");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getEmailId() {
        return getElement(emailId);
    }

    public WebElement getPassword() {
        return getElement(password);
    }

    public WebElement getLoginButton() {
        return getElement(loginButton);
    }

    public String getLoginPageHeader() {
        return getPageHeader(header);
    }

    public String getLoginPageTitle(){
        return getPageTitle();
    }

    public String getPageHeader(){
        return getPageHeader();
    }

    public HomePage doLogin(String userName, String password){
        getEmailId().sendKeys(userName);
        getPassword().sendKeys(password);
        getLoginButton().click();

        return getInstance(HomePage.class);
    }

    public HomePage doLogin(String credentials){
        if(credentials.contains("username")){
        getEmailId().sendKeys(credentials.split(":")[0].trim());
        }
        else if (credentials.contains("password")){
        getPassword().sendKeys(credentials.split(":")[1].trim());
        }
        getLoginButton().click();

        return getInstance(HomePage.class);
    }
}
