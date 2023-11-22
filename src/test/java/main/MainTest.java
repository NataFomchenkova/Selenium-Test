package main;

import core.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class MainTest extends BaseTest {

    @Test
    public void testGoAuthPageMenu() {
        MainPage mainPage = new MainPage();
        mainPage.clickAuth();
        WebElement title = driver.findElement(By.className("uk-legend"));
        assert title.getText().equals("Привет с демо-сайта для автотестов!");
    }

    @Test
    public void testGoMorePageMenu() {
        MainPage mainPage = new MainPage();
        mainPage.clickMore();
        WebElement image = driver.findElement(By.xpath("/html/body/div[2]/div[1]/img"));
        assert image.isDisplayed();
        assert image.getTagName().equals("img");
        assert image.getAttribute("alt").equals("logo");
        assert image.getAttribute("src").endsWith("pi.png");
    }

    @Test
    public void testGoMainPageMenu() {
        MainPage mainPage = new MainPage();
        mainPage.clickMain();
        WebElement image = driver.findElement(By.cssSelector("img[alt='Лисичка']"));
        assert image.getAttribute("class").equals("uk-cover");
        assert image.getAttribute("src").endsWith("fox.png");
    }

    @Test
    public void testGoUsersPageMenu() {
        MainPage mainPage = new MainPage();
        mainPage.clickUsersOpener();
        WebElement table = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#dataTable")));
        assert table.getTagName().equals("table");
        assert table.getAttribute("class").equals("uk-table uk-table-striped");
    }

    @Test
    public void testGoUsersPageDropdown() {
        MainPage mainPage = new MainPage();
        mainPage.clickUsers();
        WebElement button = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("addUser")));
        assert button.getTagName().equals("a");
        assert button.getText().equals("ДОБАВИТЬ ПОЛЬЗОВАТЕЛЯ");
        assert button.getAttribute("class").equals("uk-button uk-button-primary");
    }

    @Test
    public void testGoUserAddPageDropdown() {
        MainPage mainPage = new MainPage();
        mainPage.clickUserAdd();
        WebElement title = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("uk-legend")));
        assert title.getTagName().equals("legend");
        assert title.getText().equals("Добавление пользователя");
    }
}
