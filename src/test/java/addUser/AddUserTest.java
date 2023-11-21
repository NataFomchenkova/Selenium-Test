package addUser;

import core.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import users.UsersPage;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class AddUserTest extends BaseTest {

    /*@Test
    public void test() {
        UsersPage usersPage = new UsersPage();
        Assert.assertFalse(driver.findElement(By.xpath()));
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("test1@ya.ru","11", "Olga");
    }*/


    private void checkingForPairwiseTest() {
        WebElement title = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("uk-modal-body")));
        assert title.isDisplayed();
        assert title.getText().equals("Данные добавлены.");
    }

    @Test
    public void testPairwise_M_1_1() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("testM1_1@ya.ru", "11", "test");
        addUserPage.setGender("M");
        addUserPage.setRadioButton(1);
        addUserPage.setSelectButton(true, false, false);
        addUserPage.clickOnAdduserButton();
        checkingForPairwiseTest();

    }

    @Test
    public void testPairwise_M_2_2() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("testM2_2@ya.ru", "11", "test");
        addUserPage.setGender("M");
        addUserPage.setRadioButton(2);
        addUserPage.setSelectButton(false, true, false);
        addUserPage.clickOnAdduserButton();
        checkingForPairwiseTest();
    }

    @Test
    public void testPairwise_M_1_3() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("testM1_3@ya.ru", "11", "test");
        addUserPage.setGender("M");
        addUserPage.setRadioButton(1);
        addUserPage.setSelectButton(false, false, true);
        addUserPage.clickOnAdduserButton();
        checkingForPairwiseTest();
    }

    @Test
    public void testPairwise_M_2_12() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("testM2_12@ya.ru", "11", "test");
        addUserPage.setGender("M");
        addUserPage.setRadioButton(2);
        addUserPage.setSelectButton(true, true, false);
        addUserPage.clickOnAdduserButton();
        checkingForPairwiseTest();
    }

    @Test
    public void testPairwise_M_1_23() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("test1_23@ya.ru", "11", "test");
        addUserPage.setGender("M");
        addUserPage.setRadioButton(1);
        addUserPage.setSelectButton(false, true, true);
        addUserPage.clickOnAdduserButton();
        checkingForPairwiseTest();
    }

    @Test
    public void testPairwise_M_2_13() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("testM2_13@ya.ru", "11", "test");
        addUserPage.setGender("M");
        addUserPage.setRadioButton(2);
        addUserPage.setSelectButton(true, false, true);
        addUserPage.clickOnAdduserButton();
        checkingForPairwiseTest();
    }

    @Test
    public void testPairwise_M_1_123() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("testM1_123@ya.ru", "11", "test");
        addUserPage.setGender("M");
        addUserPage.setRadioButton(1);
        addUserPage.setSelectButton(true, true, true);
        addUserPage.clickOnAdduserButton();
        checkingForPairwiseTest();
    }

    @Test
    public void testPairwise_M_2_() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("testM2_@ya.ru", "11", "test");
        addUserPage.setGender("M");
        addUserPage.setRadioButton(2);
        addUserPage.setSelectButton(false, false, false);
        addUserPage.clickOnAdduserButton();
        checkingForPairwiseTest();
    }

    @Test
    public void testPairwise_F_2_3() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("testF2_3@ya.ru", "11", "test");
        addUserPage.setGender("F");
        addUserPage.setRadioButton(2);
        addUserPage.setSelectButton(false, false, true);
        addUserPage.clickOnAdduserButton();
        checkingForPairwiseTest();
    }

    @Test
    public void testPairwise_F_1_12() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("testF1_12@ya.ru", "11", "test");
        addUserPage.setGender("F");
        addUserPage.setRadioButton(1);
        addUserPage.setSelectButton(true, true, false);
        addUserPage.clickOnAdduserButton();
        checkingForPairwiseTest();
    }

    @Test
    public void testPairwise_F_2_23() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("testF2_23@ya.ru", "11", "test");
        addUserPage.setGender("F");
        addUserPage.setRadioButton(2);
        addUserPage.setSelectButton(false, true, true);
        addUserPage.clickOnAdduserButton();
        checkingForPairwiseTest();
    }

    @Test
    public void testPairwise_F_1_13() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("testF1_13@ya.ru", "11", "test");
        addUserPage.setGender("F");
        addUserPage.setRadioButton(1);
        addUserPage.setSelectButton(true, false, true);
        addUserPage.clickOnAdduserButton();
        checkingForPairwiseTest();
    }

    @Test
    public void testPairwise_F_2_123() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("testF2_123@ya.ru", "11", "test");
        addUserPage.setGender("F");
        addUserPage.setRadioButton(2);
        addUserPage.setSelectButton(true, true, true);
        addUserPage.clickOnAdduserButton();
        checkingForPairwiseTest();
    }

    @Test
    public void testPairwise_F_1_() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("testF1_@ya.ru", "11", "test");
        addUserPage.setGender("F");
        addUserPage.setRadioButton(1);
        addUserPage.setSelectButton(false, false, false);
        addUserPage.clickOnAdduserButton();
        checkingForPairwiseTest();
    }

    @Test
    public void testPairwise_F_2_1() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("testF2_1@ya.ru", "11", "test");
        addUserPage.setGender("F");
        addUserPage.setRadioButton(2);
        addUserPage.setSelectButton(true, false, false);
        addUserPage.clickOnAdduserButton();
        checkingForPairwiseTest();
    }

    @Test
    public void testPairwise_F_1_2() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("testF1_2@ya.ru", "11", "test");
        addUserPage.setGender("F");
        addUserPage.setRadioButton(1);
        addUserPage.setSelectButton(false, true, false);
        addUserPage.clickOnAdduserButton();
        checkingForPairwiseTest();
    }
}
