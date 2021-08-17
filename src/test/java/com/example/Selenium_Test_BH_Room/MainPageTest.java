package com.example.Selenium_Test_BH_Room;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {
    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();



    @BeforeAll
    public static void setUpAll() {
        Configuration.startMaximized = true;
        SelenideLogger.addListener("allure", new AllureSelenide());

    }

    @BeforeEach
    public void setUp() {

        open("http://localhost:4200/");
        mainPage.logoutButton.click();
    }

    @AfterEach
    public void tearDown(){
        mainPage.navitemLogin.click();
        loginPage.inputUsername.sendKeys("FlodinWiesret");
        loginPage.inputPassword.sendKeys("SicheresPasswort");
        loginPage.loginButton.click();
    }


     @Test
    public void clickLoginButton() {
        mainPage.navitemLogin.click();
        //$("body > app-root > ng-component > div > div > h4").shouldBe(visible);
        $x("/html/body/app-root/div/div[2]/ng-component/div/div/h4[contains(text(),'Login')]").shouldBe(visible);
    }

    @Test
    public void clickRoomButton() {
        mainPage.navitemRooms.click();
        //$("body > app-root > ng-component > div > div > h4").shouldBe(visible);
        $x("/html/body/app-root/div/div[2]/app-room/div").shouldBe(visible);
    }

    @Test   //diesen Test auslagern für MobileDevices
    public void clickNavigationElementOnSmallDevices() {
        mainPage.navBarToogleButton.click();

    }


}
