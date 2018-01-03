import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    WebDriver driver;

    @FindBy(name="email")
    WebElement userName;

    @FindBy(name="password")
    WebElement userPassword;

    @FindBy(id="login")
    WebElement userLogin;


    public SignInPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Get username element
    public WebElement getuserName(){
        return userName;
    }
    //Get password element
    public WebElement getPassword(){
        return userPassword;
    }
    //Set user name in textbox
    public String setUserName(String strUserName) throws Exception{
        userName.sendKeys(strUserName);
        return strUserName;
    }
    //Set password in password textbox
    public String setPassword(String strPassword)throws Exception{
        userPassword.sendKeys(strPassword);
        return strPassword;
    }

    //Click Login button
    public void clickLogin(){
        userLogin.click();
    }
}
