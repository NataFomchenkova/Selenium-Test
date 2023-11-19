package main;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class MainPage extends BasePage {
    private static final String MAIN_URL = "http://149.255.118.78:7080/main";
    @FindBy(id = "menuAuth")
    private WebElement authButton;
    @FindBy(id = "menuMain")
    private WebElement mainButton;
    @FindBy(id = "menuUsersOpener")
    private WebElement usersOpenerButton;
    @FindBy(id = "menuUsers")
    private WebElement usersButton;
    @FindBy(id = "menuUserAdd")
    private WebElement userAddButton;

    @FindBy(id = "menuMore")
    private WebElement moreButton;

    public MainPage() {
        driver.get(MAIN_URL);
        PageFactory.initElements(driver, this);
    }

    public MainPage clickAuth() {
        authButton.click();
        return this;
    }

    public MainPage clickMain() {
        mainButton.click();
        return this;
    }

    public MainPage clickUsersOpener() {
        usersOpenerButton.click();
        usersOpenerButton.click();
        return this;
    }
    public MainPage clickUserAdd() {
        usersOpenerButton.click();
        userAddButton.click();
        return this;
    }
    public MainPage clickUsers() {
        usersOpenerButton.click();
        usersButton.click();
        return this;
    }
    public MainPage clickMore() {
        moreButton.click();
        return this;
    }
}
