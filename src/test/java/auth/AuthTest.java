package auth;

import core.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class AuthTest extends BaseTest {

    @Test
    public void testCorrectLoginCorrectPassword(){
        AuthPage authPage = new AuthPage();
        authPage.enterLoginPassword("test@protei.ru", "test");
        WebElement title = driver.findElement(By.className("uk-card-title"));
        assert title.isDisplayed();
        assert title.getText().equals("Добро пожаловать!");
        assert title.getTagName().equals("h3");
    }

/*    @Test
    public void testAuthSuccessful(){
        Auth.AuthPage authPage = new Auth.AuthPage();
        authPage.enterLoginPassword("student@protei.ru", "student");
        WebElement title = driver.findElement(By.className("uk-card-title"));
        assert title.isDisplayed();
        assert title.getText().equals("Добро пожаловать!");
        assert title.getTagName().equals("h3");
    }*/

    @Test
    public void testEmptyFields() {
        AuthPage authPage = new AuthPage();
        authPage.enterLoginPassword("", "");
        WebElement errorMassage = driver.findElement(By.xpath("//*[@id='emailFormatError']/p"));
        assert errorMassage.getTagName().equals("p");
        assert errorMassage.getText().equals("Неверный формат E-Mail");
    }

    @Test
    public void testAuthFailureIncorrectLogin(){
        AuthPage authPage = new AuthPage();
        authPage.enterLoginPassword("111@protei.ru", "test");
        WebElement massage = driver.findElement(By.id("KEKEKEKEKEKKEKE"));
        assert massage.getTagName().equals("div");
        assert massage.getText().equals("Неверный E-Mail или пароль");
    }

    @Test
    public void testAuthFailureIncorrectPassword(){
        AuthPage authPage = new AuthPage();
        authPage.enterLoginPassword("test@protei.ru", "111");
        WebElement title = driver.findElement(By.className("uk-legend"));
        assert title.getText().equals("Привет с демо-сайта для автотестов!");
        //WebElement title = driver.findElement(By.xpath("//*[@id='authPage']/form/fieldset/div[2]/label"));
    }
}
