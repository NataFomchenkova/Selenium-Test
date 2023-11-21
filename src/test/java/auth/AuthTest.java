package auth;

import core.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class AuthTest extends BaseTest {

    @Test
    public void testCorrectLoginCorrectPassword(){
        AuthPage authPage = new AuthPage();
        authPage.enterLoginPassword("test@protei.ru", "test");
        WebElement title  = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("uk-card-title")));
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
        WebElement errorMassage  = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='emailFormatError']/p")));
        assert errorMassage.getTagName().equals("p");
        assert errorMassage.getText().equals("Неверный формат E-Mail");
    }

    @Test
    public void testAuthFailureIncorrectLogin(){
        AuthPage authPage = new AuthPage();
        authPage.enterLoginPassword("111@protei.ru", "test");
        WebElement massage = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("KEKEKEKEKEKKEKE")));
        assert massage.getTagName().equals("div");
        assert massage.getText().equals("Неверный E-Mail или пароль");
    }

    @Test
    public void testAuthFailureIncorrectPassword(){
        AuthPage authPage = new AuthPage();
        authPage.enterLoginPassword("test@protei.ru", "111");
        WebElement title = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("uk-legend")));
        assert title.getText().equals("Привет с демо-сайта для автотестов!");
        //WebElement title = driver.findElement(By.xpath("//*[@id='authPage']/form/fieldset/div[2]/label"));
    }

  /*  @Test
    public void test(){
        AuthPage authPage = new AuthPage();
        WebElement title = driver.findElement(By.className("Привет с демо-сайта для автотестов!"));
        assert title.getText().equals("Привет с демо-сайта для автотестов!");
        //WebElement title = driver.findElement(By.xpath("//*[@id='authPage']/form/fieldset/div[2]/label"));
    }*/
}
