package tests;

import java.time.Duration;

import data.User;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

import static data.WebDrivers.createDriver;

public class Setup {

    WebDriver webDriver;
    public User user;
    public MainPage mainPage;
    public String token;

    @Before
    public void setUp() {
        webDriver = createDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        mainPage = new MainPage(webDriver);
        mainPage.openMainPage();
        mainPage.goToMainPage();
    }

    @After
    public void tearDown() {
        User.deleteUser(token);
        webDriver.quit();
    }
}