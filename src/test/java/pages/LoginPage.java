package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.BasePageOperations;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePageOperations {
    private static final SelenideElement signInButton = $(".personal-area_body_form_footer_login-btn");
    private static final SelenideElement loginFieldErrorMessage = $x("//div[@class='personal-area_body_form_body_left_form-item_input login']/div");
    private static final SelenideElement passwordFieldErrorMessage = $x("//div[@class='personal-area_body_form_body_left_form-item_input password']/div[2]");
    private static final SelenideElement registrationLink = $x("//div[text()='Регистрация'] ");
    private static final SelenideElement becomeTricolorClientPopup = $x("//div[@class='personal-area_modal_form register']");
    private static final SelenideElement haveTricolorTVBoxBtn = $x("//div[@class='personal-area_modal_form_btns']/a[1]");
    private static final SelenideElement watchViaInternetBtn = $x("//div[@class='personal-area_modal_form_btns']/a[2]");
    private static final SelenideElement closeBtn_becomeTricolorClientPopup = $x("//div[@class='personal-area_modal_form register']/div[1]");
    private static final SelenideElement loginField = $(By.name("login"));
    private static final SelenideElement passwordField = $(By.name("password"));
    private static final SelenideElement wrongLoginPasswordErrorPopup = $(".personal-area_modal_form_error");
    private static final SelenideElement closeWrongLoginPasswordErrorPopup = $x("//div[@class='personal-area_modal_form error']/div[1]");
    private static final SelenideElement wrongLoginPasswordErrorPopupTitle = $x("//div[@class='personal-area_modal_form error']//div[@class='personal-area_modal_form_title']");
    private static final SelenideElement wrongLoginPasswordErrorPopupText = $x("//div[@class='personal-area_modal_form error']//div[@class='personal-area_modal_form_body']");

    @Step("Нажать на кнопку Войти")
    public LoginPage clickSignInBtn(){
        click(signInButton);
        return this;
    }

    public String getLoginFieldErrorMessageText() {
        return getText(loginFieldErrorMessage);
    }

    public String getPasswordFieldErrorMessageText() {
        return getText(passwordFieldErrorMessage);
    }

    @Step("Нажать на кнопку Регистрация")
    public LoginPage clickRegistrationLink() {
        click(registrationLink);
        return this;
    }

    public LoginPage becomeTricolorClientPopupIsVisible() {
        elementIsVisible(becomeTricolorClientPopup);
        return this;
    }

    public void clickHaveTricolorTVBoxBtn () {
        click(haveTricolorTVBoxBtn);
    }

    public void clickWatchViaInternetBtn() {
        click(watchViaInternetBtn);
    }

    public void closeBtn_becomeTricolorClientPopup () {
        click(closeBtn_becomeTricolorClientPopup);
    }

    public LoginPage loginInLka () {
        fillInLoginField();
        fillInPasswordField();
        clickSignInBtn();
        return this;
    }

    @Step("Заполнить поле Логин")
    public LoginPage fillInLoginField() {
        writeText(loginField, "23002300230157");
        return this;
    }

    @Step("Заполнить поле Пароль")
    public LoginPage fillInPasswordField() {
        writeText(passwordField, "12345678");
        return this;
    }

    @Step("Ввести неверный пароль")
    public LoginPage fillInWrongPassword() {
        writeText(passwordField, "12345679");
        return this;
    }

    @Step("Закрыть попап неверный логин/пароль")
    public LoginPage closeLoginErrorPopup() {
        click(closeWrongLoginPasswordErrorPopup);
        return this;
    }

    public String getWrongLoginPasswordErrorPopupTitle() {
        return getText(wrongLoginPasswordErrorPopupTitle);
    }

    public String getWrongLoginPasswordErrorPopupText() {
        return getText(wrongLoginPasswordErrorPopupText);
    }
}
