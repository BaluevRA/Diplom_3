package tests;

import data.User;
import io.qameta.allure.Step;
import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import data.UserGenerator;
import io.restassured.response.Response;
import pages.LoginPage;
import pages.ProfilePage;

public class ProfilePageTest extends Setup {
    LoginPage loginPage;
    ProfilePage profilePage;

    @Before
    @Step("Вход в аккаунт")
    public void login() {
        user = UserGenerator.generateUser();
        mainPage.clickOnLoginButton();
        Response response = User.createUser(user);
        token = response.then().extract().path("accessToken").toString();
        loginPage = new LoginPage(webDriver);
        loginPage.fillLoginForm(user.getEmail(), user.getPassword());
        loginPage.clickSignInButtonLocator();
        mainPage.isOrderButtonActive();
    }

    @Test
    @DisplayName("Переход в профиль по клику на 'Личный кабинет'")
    public void loginByMyProfileButtonTest() {
        profilePage = new ProfilePage(webDriver);
        mainPage.clickOnProfileButton();
        profilePage.checkProfilePage();
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на 'Конструктор'")
    public void goToConstructorTest() {
        profilePage = new ProfilePage(webDriver);
        mainPage.clickOnProfileButton();
        profilePage.checkProfilePage();
        profilePage.clickOnConstructorButton();
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на 'Логотип'")
    public void fromYourPersonalAccountToTheLogoTest() {
        profilePage = new ProfilePage(webDriver);
        mainPage.clickOnProfileButton();
        profilePage.checkProfilePage();
        profilePage.clickOnLogo();
    }

    @Test
    @DisplayName("Выход по кнопке «Выйти» в личном кабинете")
    public void exitPersonalAccountTest() {
        profilePage = new ProfilePage(webDriver);
        mainPage.clickOnProfileButton();
        profilePage.checkProfilePage();
        profilePage.clickOnExitButton();
    }
}