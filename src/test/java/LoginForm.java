import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends PageObject{
    private final String USERNAME = "standard_user";
    private final String PASSWORD = "secret_sauce";
    private final String WRONGUSERNAME = "wrong_username";
    private final String WRONGPASSWORD ="wrong_password";

    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement login_button;

    @FindBy(xpath = "//h3[contains(text(),'Epic sadface: Username and password do not match any user in this service')]")
    private WebElement error_label;

    public LoginForm(WebDriver driver){
        super(driver);
    }

    public void enterUsername(){
        this.username.sendKeys(USERNAME);
    }

    public void enterWrongUsername(){
        this.username.sendKeys(WRONGUSERNAME);
    }

    public void enterPassword(){
        this.password.sendKeys(PASSWORD);
    }

    public void enterWrongPassword(){
        this.password.sendKeys(WRONGPASSWORD);
    }

    public void pressLoginButton(){
        this.login_button.click();
    }

    public String getErrorText(){
        return this.error_label.getText();
    }

    public String getLoginButtonValue(){
        return login_button.getAttribute("value");

    }
}
