package users;

import core.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class UsersTest extends BaseTest {

    @Test
    public void testClickOnAddUserButton() {
        UsersPage usersPage = new UsersPage();
        usersPage.clickAddUserButton();
        WebElement title = driver.findElement(By.className("uk-legend"));
        assert title.getTagName().equals("legend");
        assert title.getText().equals("Добавление пользователя");
    }
}
