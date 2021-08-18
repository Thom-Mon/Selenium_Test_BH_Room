package com.example.Selenium_Test_BH_Room.PageTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;


import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LoggedInMainPageTest {
    LoggedInMainPage loggedInMainPage = new LoggedInMainPage();
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
        mainPage.navitemLogin.click();
        loginPage.inputUsername.sendKeys("FlodinWiesret");
        loginPage.inputPassword.sendKeys("SicheresPasswort");
        loginPage.loginButton.click();
    }



    //Avaiability-Tests for the Tabs
    @Test
    public void AllTabsAvaiable(){
        loggedInMainPage.manageBookingButton.click();
        $x("//h1[contains(text(),'Buchungsverwaltung')]").shouldBe(visible);
        loggedInMainPage.manageCustomerButton.click();
        $x("//h1[contains(text(),'Kundenverwaltung')]").shouldBe(visible);
        loggedInMainPage.manageRoomButton.click();
        $x("//h1[contains(text(),'Raumverwaltung')]").shouldBe(visible);
        loggedInMainPage.manageStaffButton.click();
        $x("//h1[contains(text(),'Personalverwaltung')]").shouldBe(visible);
        loggedInMainPage.manageEmployeeButton.click();
        $x("/html/body/app-root/div/div[2]/app-employee").shouldBe(visible);
        loggedInMainPage.logoutButton.click();
        $x("//h1[contains(text(),'Businesshotel Roomanger')]").shouldBe(visible);
    }



//TODO:---Kussi--kuss--kuss-longclick_clicki schnuff


}
