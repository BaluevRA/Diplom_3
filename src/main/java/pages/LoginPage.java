package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    // Кнопка "Войти"
    private final By signInButton = By.xpath("//button[text()='Войти']");
    // Инпут email
    private final By emailField = By.xpath("//input[@name='name']");
    // Инпут password
    private final By passwordField = By.xpath("//input[@name='Пароль']");
    // Заголовок "Вход"
    private final By enterHeader = By.xpath("//div[@class='Auth_login__3hAey']");

    WebDriver webDriver;
    boolean isDisplayed;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Проверка заголовка страницы логина")
    public void inputPage() {
        isDisplayed = webDriver.findElement(enterHeader).isDisplayed();
        Assert.assertTrue(isDisplayed);
    }

    @Step("Заполнение полей email и пароль")
    public void fillLoginForm(String email, String password) {
        webDriver.findElement(emailField).sendKeys(email);
        webDriver.findElement(passwordField).sendKeys(password);
    }

    @Step("Нажать на кнопку Войти")
    public void clickSignInButtonLocator() {
        webDriver.findElement(signInButton).click();
    }


    @Step("Проверка перехода на страницу Вход")
    public void passwordRecoveryPage() {
        isDisplayed = webDriver.findElement(enterHeader).isDisplayed();
        Assert.assertTrue(isDisplayed);
    }

    @Step("Ожидание загрузки формы логина")
    public void waitUntilLoginFormVisible() {
        new WebDriverWait(webDriver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(signInButton));
    }
}

