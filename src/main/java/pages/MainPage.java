package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static constants.Endpoints.BASE_URL;

public class MainPage {
    //Локатор кнопки "Войти в аккаунт"
    private final By loginButton = By.xpath("//button[text()='Войти в аккаунт']");
    //Локатор кнопки "Личный кабинет"
    private final By personalButton = By.xpath(".//p[text()='Личный Кабинет']");
    //Локатор кнопки "Оформить заказ"
    private final By orderButton = By.xpath(".//button[contains(text(),'Оформить заказ')]");
    //Локатор кнопки "Булки" без фокуса на разделе
    private final By bunsButton = By.xpath("//div[span[text()='Булки']]");
    //Локатор кнопки "Булки" с фокусом на разделе
    private final By bunsButtonSelected = By.xpath("//*[@class=\"tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect\"]/span[text()='Булки']");
    //Локатор кнопки "Соусы" без фокуса на разделе
    private final By saucesButton = By.xpath("//div[span[text()='Соусы']]");
    //Локатор кнопки "Соусы" с фокусом на разделе
    private final By saucesButtonSelected = By.xpath("//*[@class=\"tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect\"]/span[text()='Соусы']");
    //Локатор кнопки "Начинки" без фокуса на разделе
    private final By fillingsButton = By.xpath("//*[text()='Начинки']");
    //Локатор кнопки "Начинки" с фокусом на разделе
    private final By fillingsButtonSelected = By.xpath("//*[@class=\"tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect\"]/span[text()='Начинки']");
    // Локатор логотипа "Stellar Burgers"
    private final By logo = By.xpath("//div[@class = 'AppHeader_header__logo__2D0X2']");

    WebDriver webDriver;
    boolean isDisplayed;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Открыть главную страницу")
    public void openMainPage() {
        webDriver.get(BASE_URL);
    }

    @Step("Проверка перехода на главную страницу кликом по лого")
    public void goToMainPage() {
        isDisplayed = webDriver.findElement(logo).isDisplayed();
        Assert.assertTrue(isDisplayed);
    }

    @Step("Перейти в личный кабинет")
    public void clickOnProfileButton() {
        webDriver.findElement(personalButton).click();
    }

    @Step("Войти в аккаунт")
    public void clickOnLoginButton() {
        webDriver.findElement(loginButton).click();
    }

    @Step("Проверка входа в аккаунт")
    public void isOrderButtonActive() {
        isDisplayed = webDriver.findElement(orderButton).isDisplayed();
        Assert.assertTrue(isDisplayed);
    }

    @Step("Перейти в раздел Булки")
    public void clickOnBunsButton() {
        webDriver.findElement(bunsButton).click();
    }

    @Step("Проверка перехода в булки")
    public void isBunsHeaderVisible() {
        isDisplayed = webDriver.findElement(bunsButtonSelected).isDisplayed();
        Assert.assertTrue(isDisplayed);
    }

    @Step("Перейти в раздел Соусы")
    public void clickOnSaucesButton() {
        webDriver.findElement(saucesButton).click();
    }

    @Step("Проверка перехода в булки")
    public void isSaucesHeaderVisible() {
        isDisplayed = webDriver.findElement(saucesButtonSelected).isDisplayed();
        Assert.assertTrue(isDisplayed);
    }

    @Step("Перейти в раздел Начинки")
    public void clickOnFillingsButton() {
        webDriver.findElement(fillingsButton).click();
    }

    @Step("Проверка перехода в булки")
    public void isFillingsHeaderVisible() {
        isDisplayed = webDriver.findElement(fillingsButtonSelected).isDisplayed();
        Assert.assertTrue(isDisplayed);
    }
}