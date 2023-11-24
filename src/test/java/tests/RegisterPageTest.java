package tests;

import data.User;
import data.UserGenerator;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import pages.LoginPage;
import pages.RegisterPage;

public class RegisterPageTest extends Setup {

    RegisterPage registerPage;
    LoginPage loginPage;
    User user;

    @Test
    @DisplayName("Регистрация с паролем не менее 8 символов (позитивный сценарий)")
    public void registrationTest() throws InterruptedException {
        mainPage.clickOnProfileButton();
        user = UserGenerator.generateUser();
        registerPage = new RegisterPage(webDriver);
        loginPage = new LoginPage(webDriver);
        registerPage.scrollToRegistrationInput();
        registerPage.clickRegisterFieldLocator();
        registerPage.registrationPage();
        String email = user.getEmail();
        String password = user.getPassword();
        registerPage.fillRegistrationForm(user.getName(), email, password);
        registerPage.submitRegistrationInput();
        loginPage.waitUntilLoginFormVisible();
        loginPage.fillLoginForm(email, password);
        loginPage.clickSignInButtonLocator();
        // Костыль, но токен подтягивается не сразу :(
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        token = (String) js.executeScript("let token = localStorage.accessToken;" + "if (token != null) {return token;}");
    }

    @Test
    @DisplayName("Регистрация с паролем <8 символов (негативный сценарий)")
    public void invalidDataRegistrationTest() {
        mainPage.clickOnProfileButton();
        user = UserGenerator.generateUserWithInvalidData();
        registerPage = new RegisterPage(webDriver);
        registerPage.scrollToRegistrationInput();
        registerPage.clickRegisterFieldLocator();
        registerPage.registrationPage();
        registerPage.fillRegistrationForm(user.getName(), user.getEmail(), user.getPassword());
        registerPage.submitRegistrationInput();
        registerPage.checkIncorrectPasswordAlert();
    }
}