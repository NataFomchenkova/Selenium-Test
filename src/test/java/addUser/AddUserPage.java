package addUser;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddUserPage extends BasePage {
    private static final String ADD_USER_URL = "http://149.255.118.78:7080/add_user";
    @FindBy(id = "dataEmail")
    private WebElement email;
    @FindBy(xpath = "//*[@id='dataPassword']")
    private WebElement password;
    @FindBy(id = "dataName")
    private WebElement name;
    @FindBy(id = "dataGender")
    private WebElement selectGender;
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

    public AddUserPage() {
        driver.get(ADD_USER_URL);
        PageFactory.initElements(driver, this);
    }

    public AddUserPage enterLoginPasswordName(String emailValue, String passwordValue, String nameValue) {
        setEmail(emailValue);
        setPassword(passwordValue);
        setName(nameValue);
        return this;
    }

    public void setEmail(String emailValue) {
        email.sendKeys(emailValue);
    }

    public void setPassword(String passwordValue) {
        password.sendKeys(passwordValue);
    }

    public void setName(String nameValue) {
        name.sendKeys(nameValue);
    }

    public void setGender(String gender) {
        Select dropdown = new Select(selectGender);
        selectGender.click();
        if (gender.equals("M")) {
            dropdown.getOptions().get(0).click();
        } else {
            dropdown.getOptions().get(1).click();
        }
    }

    public void setRadioButton(int i) {
        if (i == 1) {
            radioButton11.click();
        } else {
            radioButton12.click();
        }
    }

    public void setSelectButton(boolean one, boolean two, boolean three) {
        if ((!selectButton21.isSelected() && one) || (selectButton21.isSelected() && !one)) {
            selectButton21.click();
        }
        if ((!selectButton22.isSelected() && two) || (selectButton22.isSelected() && !two)) {
            selectButton22.click();
        }
        if ((!selectButton23.isSelected() && three) || (selectButton23.isSelected() && !three)) {
            selectButton23.click();
        }
    }

    public void clickOnAddUserButton() {
        addButton.click();
    }
}
