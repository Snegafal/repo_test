package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import utils.BaseTest;

public class LoginTest extends BaseTest {

    LoginPage loginPage = new LoginPage();

    @Test
    @DisplayName("Попытка авторизации без заполнения логина и пароля")
    public void impossibleLoginWithoutFillInLoginAndPassword() {
        loginPage.clickSignInBtn();
        Assertions.assertEquals(loginPage.getLoginFieldErrorMessageText(), "Поле не заполнено");
        Assertions.assertEquals(loginPage.getPasswordFieldErrorMessageText(), "Поле не заполнено");
    }

    @Test
    @DisplayName("Проверка модального окна Стать клиентом Триколора")
    public void becomeTricolorClientPopup() {
        loginPage
                .clickRegistrationLink()
                .becomeTricolorClientPopupIsVisible()
                .clickHaveTricolorTVBoxBtn();

        Selenide.switchTo().window(1);
        Assertions.assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), "https://portal.tricolor.ru/registration");
        Assertions.assertEquals(Selenide.$x("//h1").getText(), "РЕГИСТРАЦИЯ КЛИЕНТА");

        Selenide.closeWindow();
        Selenide.switchTo().window(0);

        loginPage.clickWatchViaInternetBtn();
        Selenide.switchTo().window(1);
        Assertions.assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), "https://kino.tricolor.tv/?login");
        Selenide.closeWindow();
        Selenide.switchTo().window(0);

        loginPage.closeBtn_becomeTricolorClientPopup();
    }

    @Test
    @Story("Неверный пароль")
    @Feature("Авторизация в ЛКА")
    @DisplayName("Неуспешная авторизация с неверным паролем")
    public void unsuccessfulLoginWithWrongPassword () {
        loginPage
                .fillInLoginField()
                .fillInWrongPassword()
                .clickSignInBtn();
        Assertions.assertEquals(loginPage.getWrongLoginPasswordErrorPopupTitle(), "ПРОИЗОШЛА ОШИБКА");
        Assertions.assertEquals(loginPage.getWrongLoginPasswordErrorPopupText(), "Неверный логин или пароль");
        loginPage.closeLoginErrorPopup();
    }
}

