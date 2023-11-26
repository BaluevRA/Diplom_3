package tests;

import data.User;
import data.UserGenerator;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import pages.LoginPage;
import pages.RegisterPage;

public class UserRegistrationTest extends Setup {
    LoginPage loginPage;
    RegisterPage registerPage;

    @Before
    public void createUser() {
        user = UserGenerator.generateUser();
        Response response = User.createUser(user);
        token = response.then().extract().path("accessToken").toString();
    }

    @Test
    @DisplayName("Вход в аккаунт по кнопке Войти на главной странице")
    public void LoginButtonOnTheMainPageTest() {
        mainPage.clickOnLoginButton();
        loginPage = new LoginPage(webDriver);
        loginPage.passwordRecoveryPage();
        loginPage.fillLoginForm(user.getEmail(), user.getPassword());
        loginPage.clickSignInButtonLocator();
        mainPage.isOrderButtonActive();
    }

    @Test
    @DisplayName("Вход по кнопке Личный кабинет на главной странице")
    public void LoginUsingThePersonalAccountButtonTest() {
        mainPage.clickOnProfileButton();
        loginPage = new LoginPage(webDriver);
        loginPage.fillLoginForm(user.getEmail(), user.getPassword());
        loginPage.clickSignInButtonLocator();
        mainPage.isOrderButtonActive();
    }

    @Test
    @DisplayName("Вход по кнопке Войти на странице регистрации")
    public void LoginViaButtonOnRegistrationPageTest() {
        mainPage.clickOnProfileButton();
        registerPage = new RegisterPage(webDriver);
        registerPage.scrollToRegistrationInput();
        registerPage.clickSignInFieldLocator();
        loginPage = new LoginPage(webDriver);
        loginPage.fillLoginForm(user.getEmail(), user.getPassword());
        loginPage.clickSignInButtonLocator();
        mainPage.isOrderButtonActive();
    }

    @Test
    @DisplayName("Вход со страницы восстановления пароля")
    public void loginUsingThePasswordRecoveryButtonTest() {
        mainPage.clickOnProfileButton();
        registerPage = new RegisterPage(webDriver);
        registerPage.scrollToRegistrationInput();
        registerPage.clickRestorePasswordFieldLocator();
        registerPage.clickOnSignInButtonOnRecoveryPage();
        loginPage = new LoginPage(webDriver);
        loginPage.fillLoginForm(user.getEmail(), user.getPassword());
        loginPage.clickSignInButtonLocator();
        mainPage.isOrderButtonActive();
    }
}