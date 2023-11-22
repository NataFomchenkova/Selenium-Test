package addUser;

import core.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class AddUserTest extends BaseTest {

    // правильные почта, пароль, имя
    // пустые поля
    // граничные значения
    // попарное
    // ошибки валидации

    //__Empty_Field__
    @Test
    public void testEmptyEmail() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("", "11", "test");
        addUserPage.clickOnAddUserButton();
        checkingIncorrectMailFormat();
    }

    @Test
    public void testEmptyName() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("qwr@qew", "11", "");
        addUserPage.clickOnAddUserButton();
        WebElement title = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='blankNameError']/p")));
        assert title.isDisplayed();
        assert title.getText().equals("Поле Имя не может быть пустым");
    }

    @Test
    public void testEmptyPass() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("qwr@qew", "", "test");
        addUserPage.clickOnAddUserButton();
        WebElement title = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='blankPasswordError']/p")));
        assert title.isDisplayed();
        assert title.getText().equals("Поле Пароль не может быть пустым");
    }

    //__Validation_Email__
    @Test
    public void testCorrectEmail() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("st%u!d$h~35de#nt@pro3535tei.ru", "1234", "test");
        addUserPage.clickOnAddUserButton();
        checkingSuccessfulUserAdd();
    }

    // The test will fall, because "-" invalid value (but it is allowed by the rules of email composition)
    @Test
    public void testCorrectEmail2() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("stu_den-4.WS@netd.cr", "1234", "test");
        addUserPage.clickOnAddUserButton();
        checkingSuccessfulUserAdd();
    }

    // Cyrillic characters are not acceptable in e-mail
    @Test
    public void testUserAddFailedIncorrectMail() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("классная@почта.ру", "1234", "test");
        addUserPage.clickOnAddUserButton();
        checkingIncorrectMailFormat();
    }

    // Invalid characters in email (),:;<>@[\] (local-part)
    @Test
    public void testUserAddFailedIncorrectMail2() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("(),:;<>@[\\]35t.@pro5tei.ru", "1234", "test");
        addUserPage.clickOnAddUserButton();
        checkingIncorrectMailFormat();
    }

    // Invalid characters in email (),:;<>@[\] (domain)
    @Test
    public void testUserAddFailedIncorrectMail3() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("35t.@pr>@[\\]5tei.ru", "1234", "test");
        addUserPage.clickOnAddUserButton();
        checkingIncorrectMailFormat();
    }

    //__Validation_Name__

    @Test
    public void testCorrectNameEn() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("student12@protei.ru", "1234", "Oleg Petrov-Ivanov");
        addUserPage.clickOnAddUserButton();
        checkingSuccessfulUserAdd();
    }

    @Test
    public void testCorrectNameRu() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("student12@protei.ru", "1234", "Олег Семенов-Иванов");
        addUserPage.clickOnAddUserButton();
        checkingSuccessfulUserAdd();
    }

    //special characters and numbers in the name are not allowed
/*    @Test
    public void testUserAddFailedIncorrectName() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("student12@protei.ru", "1234", "!#$%&3'*+-/=?^_{|}~");
        addUserPage.clickOnAddUserButton();
        // сообщение об ошибке
    }*/


    //__Boundary_Values_for_Email__
    @Test
    public void testBoundaryValuesEmailMin() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("q@y", "11", "test");
        addUserPage.clickOnAddUserButton();
        checkingSuccessfulUserAdd();
    }

    @Test
    public void testBoundaryValuesEmailLessMin() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("@y", "11", "test");
        addUserPage.clickOnAddUserButton();
        checkingIncorrectMailFormat();
    }

    @Test
    public void testBoundaryValuesEmailMoreMin() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("qw@y", "11", "test");
        addUserPage.clickOnAddUserButton();
        checkingSuccessfulUserAdd();
    }

    @Test
    public void testBoundaryValuesEmailMax() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("12345678901234567890@yandex.ru", "11", "test"); // max = 30
        addUserPage.clickOnAddUserButton();
        checkingSuccessfulUserAdd();
    }

    @Test
    public void testBoundaryValuesEmailLessMax() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("12345678901234567890@yandex.r", "11", "test");
        addUserPage.clickOnAddUserButton();
        checkingSuccessfulUserAdd();
    }

    @Test
    public void testBoundaryValuesEmailMoreMax() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("12345678901234567890@yan.dex.ru", "11", "test");
        addUserPage.clickOnAddUserButton();
        WebElement title = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("uk-modal-body")));
        assert title.isDisplayed();
        assert title.getText().equals("ОШИБКА! FAIL");
    }

    //_Boundary_Values_for_Name_
    @Test
    public void testBoundaryValuesNameMin() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("test@mail.ru", "11", "N");
        addUserPage.clickOnAddUserButton();
        checkingSuccessfulUserAdd();
    }

    @Test
    public void testBoundaryValuesNameMoreMin() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("test@mail.ru", "11", "Ni");
        addUserPage.clickOnAddUserButton();
        checkingSuccessfulUserAdd();
    }

    @Test
    public void testBoundaryValuesNameMax() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("test@mail.ru", "11", "Семеновва Ангелина Альбертовна"); // max = 30
        addUserPage.clickOnAddUserButton();
        checkingSuccessfulUserAdd();
    }

    @Test
    public void testBoundaryValuesNameLessMax() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("test@mail.ru", "11", "Семенова Ангелина Альбертовна");
        addUserPage.clickOnAddUserButton();
        checkingSuccessfulUserAdd();
    }

    @Test
    public void testBoundaryValuesNameMoreMax() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("test@mail.ru", "11", "Семеновва Анггелина Альбертовна");
        addUserPage.clickOnAddUserButton();
        WebElement title = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("uk-modal-body")));
        assert title.isDisplayed();
        assert title.getText().equals("ОШИБКА! FAIL");
    }

    // Without @ in email
    @Test
    public void testEmailWithoutAt() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("testprotei.ru", "11", "test");
        addUserPage.clickOnAddUserButton();
        checkingIncorrectMailFormat();
    }

    //__Helpers__
    private void checkingSuccessfulUserAdd() {
        WebElement title = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("uk-modal-body")));
        assert title.isDisplayed();
        assert title.getText().equals("Данные добавлены.");
    }

    private void checkingIncorrectMailFormat() {
        WebElement title = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='emailFormatError']/p")));
        assert title.isDisplayed();
        assert title.getText().equals("Неверный формат E-Mail");
    }

    //_Pairwise_Tests_

    @Test
    public void testPairwise_M_1_1() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("testM1_1@ya.ru", "11", "test");
        addUserPage.setGender("M");
        addUserPage.setRadioButton(1);
        addUserPage.setSelectButton(true, false, false);
        addUserPage.clickOnAddUserButton();
        checkingSuccessfulUserAdd();

    }

    @Test
    public void testPairwise_M_2_2() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("testM2_2@ya.ru", "11", "test");
        addUserPage.setGender("M");
        addUserPage.setRadioButton(2);
        addUserPage.setSelectButton(false, true, false);
        addUserPage.clickOnAddUserButton();
        checkingSuccessfulUserAdd();
    }

    @Test
    public void testPairwise_M_1_3() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("testM1_3@ya.ru", "11", "test");
        addUserPage.setGender("M");
        addUserPage.setRadioButton(1);
        addUserPage.setSelectButton(false, false, true);
        addUserPage.clickOnAddUserButton();
        checkingSuccessfulUserAdd();
    }

    @Test
    public void testPairwise_M_2_12() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("testM2_12@ya.ru", "11", "test");
        addUserPage.setGender("M");
        addUserPage.setRadioButton(2);
        addUserPage.setSelectButton(true, true, false);
        addUserPage.clickOnAddUserButton();
        checkingSuccessfulUserAdd();
    }

    @Test
    public void testPairwise_M_1_23() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("test1_23@ya.ru", "11", "test");
        addUserPage.setGender("M");
        addUserPage.setRadioButton(1);
        addUserPage.setSelectButton(false, true, true);
        addUserPage.clickOnAddUserButton();
        checkingSuccessfulUserAdd();
    }

    @Test
    public void testPairwise_M_2_13() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("testM2_13@ya.ru", "11", "test");
        addUserPage.setGender("M");
        addUserPage.setRadioButton(2);
        addUserPage.setSelectButton(true, false, true);
        addUserPage.clickOnAddUserButton();
        checkingSuccessfulUserAdd();
    }

    @Test
    public void testPairwise_M_1_123() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("testM1_123@ya.ru", "11", "test");
        addUserPage.setGender("M");
        addUserPage.setRadioButton(1);
        addUserPage.setSelectButton(true, true, true);
        addUserPage.clickOnAddUserButton();
        checkingSuccessfulUserAdd();
    }

    @Test
    public void testPairwise_M_2_() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("testM2_@ya.ru", "11", "test");
        addUserPage.setGender("M");
        addUserPage.setRadioButton(2);
        addUserPage.setSelectButton(false, false, false);
        addUserPage.clickOnAddUserButton();
        checkingSuccessfulUserAdd();
    }

    @Test
    public void testPairwise_F_2_3() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("testF2_3@ya.ru", "11", "test");
        addUserPage.setGender("F");
        addUserPage.setRadioButton(2);
        addUserPage.setSelectButton(false, false, true);
        addUserPage.clickOnAddUserButton();
        checkingSuccessfulUserAdd();
    }

    @Test
    public void testPairwise_F_1_12() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("testF1_12@ya.ru", "11", "test");
        addUserPage.setGender("F");
        addUserPage.setRadioButton(1);
        addUserPage.setSelectButton(true, true, false);
        addUserPage.clickOnAddUserButton();
        checkingSuccessfulUserAdd();
    }

    @Test
    public void testPairwise_F_2_23() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("testF2_23@ya.ru", "11", "test");
        addUserPage.setGender("F");
        addUserPage.setRadioButton(2);
        addUserPage.setSelectButton(false, true, true);
        addUserPage.clickOnAddUserButton();
        checkingSuccessfulUserAdd();
    }

    @Test
    public void testPairwise_F_1_13() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("testF1_13@ya.ru", "11", "test");
        addUserPage.setGender("F");
        addUserPage.setRadioButton(1);
        addUserPage.setSelectButton(true, false, true);
        addUserPage.clickOnAddUserButton();
        checkingSuccessfulUserAdd();
    }

    @Test
    public void testPairwise_F_2_123() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("testF2_123@ya.ru", "11", "test");
        addUserPage.setGender("F");
        addUserPage.setRadioButton(2);
        addUserPage.setSelectButton(true, true, true);
        addUserPage.clickOnAddUserButton();
        checkingSuccessfulUserAdd();
    }

    @Test
    public void testPairwise_F_1_() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("testF1_@ya.ru", "11", "test");
        addUserPage.setGender("F");
        addUserPage.setRadioButton(1);
        addUserPage.setSelectButton(false, false, false);
        addUserPage.clickOnAddUserButton();
        checkingSuccessfulUserAdd();
    }

    @Test
    public void testPairwise_F_2_1() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("testF2_1@ya.ru", "11", "test");
        addUserPage.setGender("F");
        addUserPage.setRadioButton(2);
        addUserPage.setSelectButton(true, false, false);
        addUserPage.clickOnAddUserButton();
        checkingSuccessfulUserAdd();
    }

    @Test
    public void testPairwise_F_1_2() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.enterLoginPasswordName("testF1_2@ya.ru", "11", "test");
        addUserPage.setGender("F");
        addUserPage.setRadioButton(1);
        addUserPage.setSelectButton(false, true, false);
        addUserPage.clickOnAddUserButton();
        checkingSuccessfulUserAdd();
    }
}
