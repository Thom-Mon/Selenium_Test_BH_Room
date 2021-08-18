package com.example.Selenium_Test_BH_Room.PageTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

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
        //Configuration.browserSize="200x200";
        mainPage.navBarToogleButton.click();

    }


}
