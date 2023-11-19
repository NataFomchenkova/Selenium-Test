package users;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersPage extends BasePage {
    private static final String USERS_URL = "http://149.255.118.78:7080/users";

    @FindBy(id = "addUser")
    private WebElement addUserButton;

    public UsersPage(){
        driver.get(USERS_URL);
        PageFactory.initElements(driver, this);
    }

    public UsersPage clickAddUserButton() {
        addUserButton.click();
        return this;
    }
}
