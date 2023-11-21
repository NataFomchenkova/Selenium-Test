package auth;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthPage extends BasePage {
    private static final String AUTH_URL = "http://149.255.118.78:7080/";
    @FindBy(id = "loginEmail")
    private WebElement login;
    @FindBy(id = "loginPassword")
    private WebElement password;
    @FindBy(id = "authButton")
    private WebElement enter;

    public AuthPage() {
        driver.get(AUTH_URL);
        PageFactory.initElements(driver, this);
    }

    public AuthPage enterLoginPassword(String loginValue, String passwordValue){
        setLogin(loginValue);
        setPassword(passwordValue);
        enter.click();
        return this;
    }

    public void setLogin(String loginValue) {
        login.sendKeys(loginValue);
    }
    public void setPassword(String passwordValue) {
        password.sendKeys(passwordValue);
    }

}

