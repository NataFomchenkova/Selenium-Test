package addUser;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddUserPage extends BasePage {

    private static final String ADD_USER_URL = "http://149.255.118.78:7080/add_user";
    @FindBy(id = "dataEmail")
    private WebElement email;
    @FindBy(xpath = "//*[@id='dataPassword']")
    private WebElement password;
    @FindBy(id = "dataName")
    private WebElement name;
    @FindBy(id = "dataSelect11")
    private WebElement radioButton11;
    @FindBy(id = "dataSelect12")
    private WebElement radioButton12;
    @FindBy(id = "dataSelect21")
    private WebElement selectButton21;
    @FindBy(id = "dataSelect22")
    private WebElement selectButton22;
    @FindBy(id = "dataSelect23")
    private WebElement selectButton23;
    @FindBy(id = "dataSend")
    private WebElement addButton;

    public AddUserPage(){
        driver.get(ADD_USER_URL);
        PageFactory.initElements(driver, this);
    }
}
