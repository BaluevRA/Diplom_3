package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class BurgerConstructorTest extends Setup {

    @Test
    @DisplayName("Проверка перехода в раздел Булки")
    public void bunsButtonActivityTest() {
        // Уходим с булок
        // Открываем булки
        mainPage.clickOnBunsButton();
    }

    @Test
    @DisplayName("Проверка перехода в раздел Соусы")
    public void saucesButtonActivityTest() {
        mainPage.clickOnSaucesButton();
    }

    @Test
    @DisplayName("Проверка перехода в раздел Начинка")
    public void fillingsButtonActivityTest() {
        mainPage.clickOnFillingsButton();
    }
}