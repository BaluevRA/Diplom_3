package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.junit.Assert;

public class RegisterPage {
    //Локатор поле "Зарегистрироваться"
    private final By registerField = By.xpath("//a[(@class = 'Auth_link__1fOlj' and text()= 'Зарегистрироваться')]");
    //Поле "Восстановить пароль"
    private final By restorePasswordField = By.xpath("//a[(@class = 'Auth_link__1fOlj' and text()= 'Восстановить пароль')]");
    // Локатор поля "Имя"
    private final By nameField = By.xpath("//label[text()='Имя']/../input");
    // Локатор поле email
    private final By emailField = By.xpath("//label[text()='Email']/../input");
    //Локатор поле "Пароль"
    private final By passwordField = By.xpath("//label[text()='Пароль']/../input");
    //локатор поля "Регистрация"
    private final By registrationField = By.xpath("//h2[text()='Регистрация']");
    //Локатор кнопки "Зарегистрироваться" на странице "Регистрация"
    private final By submitRegistrationButton = By.xpath("//button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa' and text() = 'Зарегистрироваться']");
    //Локатор конпки "Войти" страницы "Регистрация"
    private final By signInButton = By.xpath("//button[text()='Войти']");
    //Локатор кнопки "Войти" на странице "Восстановление пароля"
    private final By signInButtonOnRecoveryPage = By.xpath("//a[@class = 'Auth_link__1fOlj' and text()='Войти']");
    //Локатор надписи "Некорректный пароль"
    private final By incorrectPasswordAlert = By.xpath("//p[@class='input__error text_type_main-default']");

    WebDriver webDriver;
    boolean isDisplayed;

    public RegisterPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Проверка перехода на страницу'Регистрация'")
    public void registrationPage() {
        isDisplayed = webDriver.findElement(registrationField).isDisplayed();
        Assert.assertTrue(isDisplayed);
    }

    @Step("Скролл до поля 'Зарегистрироваться' ")
    public void scrollToRegistrationInput() {
        WebElement element = webDriver.findElement(registerField);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
    }

    @Step("Переход к регистрации со страницы авторизации")
    public void clickRegisterFieldLocator() {
        webDriver.findElement(registerField).click();
    }

    @Step("Заполнение формы регистрации")
    public void fillRegistrationForm(String name, String email, String password) {
        webDriver.findElement(nameField).sendKeys(name);
        webDriver.findElement(emailField).sendKeys(email);
        webDriver.findElement(passwordField).sendKeys(password);
    }

    @Step("Зарегистрироваться")
    public void submitRegistrationInput() {
        webDriver.findElement(submitRegistrationButton).click();
    }

    @Step("Клик по кнопке вход на странице восстановления пароля")
    public void clickOnSignInButtonOnRecoveryPage() {
        webDriver.findElement(signInButtonOnRecoveryPage).click();
    }

    @Step("Проверка появления поля 'Некорректный пароль'")
    public void checkIncorrectPasswordAlert() {
        isDisplayed = webDriver.findElement(incorrectPasswordAlert).isDisplayed();
        Assert.assertTrue(isDisplayed);
    }

    @Step("Клик по кнопке «Восстановление пароля» на  странице регистрации ")
    public void clickRestorePasswordFieldLocator() {
        webDriver.findElement(restorePasswordField).click();
    }

    @Step("клик на  поле 'Войти' странице 'Восстановления пароля'")
    public void clickSignInFieldLocator() {
        webDriver.findElement(signInButton).click();

    }
}