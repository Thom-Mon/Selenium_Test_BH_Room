package com.example.Selenium_Test_BH_Room.PageTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

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
    @AfterEach
    public void tearDown() {
        loggedInMainPage.logoutButton.click();
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
    }

    @Test
    public void RoleCustomerManagerCanOnlySeeCustomerManagement(){
        //Kundenmanager 12 -> UnheardLove400
        loggedInMainPage.logoutButton.click();
        mainPage.navitemLogin.click();
        loginPage.inputUsername.sendKeys("UnheardLove400");
        loginPage.inputPassword.sendKeys("SicheresPasswort");
        loginPage.loginButton.click();
        loggedInMainPage.manageBookingButton.shouldNotBe(visible);
        loggedInMainPage.manageStaffButton.shouldNotBe(visible);
        loggedInMainPage.manageRoomButton.shouldNotBe(visible);
        loggedInMainPage.manageCustomerButton.shouldBe(visible);
    }

    @Test
    public void RoleRoomManagerCanOnlySeeRoomManagement(){
        //Roommanager 11 -> FramePerfekt
        loggedInMainPage.logoutButton.click();
        mainPage.navitemLogin.click();
        loginPage.inputUsername.sendKeys("FramePerfekt");
        loginPage.inputPassword.sendKeys("SicheresPasswort");
        loginPage.loginButton.click();
        loggedInMainPage.manageBookingButton.shouldNotBe(visible);
        loggedInMainPage.manageStaffButton.shouldNotBe(visible);
        loggedInMainPage.manageRoomButton.shouldBe(visible);
        loggedInMainPage.manageCustomerButton.shouldNotBe(visible);
    }

    @Test
    public void RoleStaffManagerCanOnlySeeStaffManagement(){
        //Roommanager 10 -> FramePerfekt
        loggedInMainPage.logoutButton.click();
        mainPage.navitemLogin.click();
        loginPage.inputUsername.sendKeys("Marius Mac Mac");
        loginPage.inputPassword.sendKeys("SicheresPasswort");
        loginPage.loginButton.click();
        loggedInMainPage.manageBookingButton.shouldNotBe(visible);
        loggedInMainPage.manageStaffButton.shouldBe(visible);
        loggedInMainPage.manageRoomButton.shouldNotBe(visible);
        loggedInMainPage.manageCustomerButton.shouldNotBe(visible);
    }

    @Test
    public void RoleHotelbossCanSeeAll(){
        //Hotelboss -> FlodinWiesret
        loggedInMainPage.manageBookingButton.shouldBe(visible);
        loggedInMainPage.manageStaffButton.shouldBe(visible);
        loggedInMainPage.manageRoomButton.shouldBe(visible);
        loggedInMainPage.manageCustomerButton.shouldBe(visible);
    }
}
