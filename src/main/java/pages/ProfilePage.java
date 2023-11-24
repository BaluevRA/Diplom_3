package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
    // Локатор логотипа "Stellar Burgers"
    private final By logo = By.xpath("//div[@class = 'AppHeader_header__logo__2D0X2']");
    // Локатор кнопки "Конструктор"
    private final By constructorButton = By.xpath("//p[text()='Конструктор']");
    // Локатор кнопки "Выход"
    private final By exitButton = By.xpath(".//button[text()='Выход']");
    // Локатор поле "Соберите бургер"
    private final By createBurgerHeader = By.xpath("//h1[@class='text text_type_main-large mb-5 mt-10']");
    WebDriver webDriver;
    boolean isDisplayed;

    public ProfilePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Проверка перехода на страницу профиля")
    public void checkProfilePage() {
        isDisplayed = webDriver.findElement(exitButton).isDisplayed();
        Assert.assertTrue(isDisplayed);
    }

    @Step("клик на кнопку 'Stellar Burgers', проверка перехода на главную страницу")
    public void clickOnLogo() {
        webDriver.findElement(logo).click();
        isDisplayed = webDriver.findElement(createBurgerHeader).isDisplayed();
        Assert.assertTrue(isDisplayed);
    }

    @Step("клик на кнопку 'Конструктор', проверка перехода на главную страницу ")
    public void clickOnConstructorButton() {
        webDriver.findElement(constructorButton).click();
        isDisplayed = webDriver.findElement(createBurgerHeader).isDisplayed();
        Assert.assertTrue(isDisplayed);
    }

    @Step("клик на кнопку 'Выход', проверка перехода на главную страницу")
    public void clickOnExitButton() {
        webDriver.findElement(exitButton).click();
        isDisplayed = webDriver.findElement(logo).isDisplayed();
        Assert.assertTrue(isDisplayed);
    }
}
