package com.example.Selenium_Test_BH_Room.DatabaseTest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.example.Selenium_Test_BH_Room.PageTest.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;

public class Z_DatabaseTest{
    ManageRoomPage manageRoomPage = new ManageRoomPage();
    ManageBookingPage manageBookingPage = new ManageBookingPage();
    ManageStaffPage manageStaffPage = new ManageStaffPage();
    ManageCustomerPage manageCustomerPage = new ManageCustomerPage();
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
    public void tearDown(){
        loggedInMainPage.logoutButton.click();
    }

    @Test
    public void isBookingAddedToDatabase(){
        loggedInMainPage.manageBookingButton.click();
        manageBookingPage.showTab.click();
        manageBookingPage.inputBookingNoShow.sendKeys("11");
        manageBookingPage.searchButtonShow.click();
        manageBookingPage.bookingInformationShow.shouldHave(
                Condition.text("empNo 3"),
                Condition.text("customerID 4"),
                Condition.text("2023-12-23 10:00:00"),
                Condition.text("2023-12-29 11:00:00"),
                Condition.text("specialWishes Jeden Tag eine Kugel Eis...auf die Hand...und Cola...verdammt ja...Cola!!!"),
                Condition.text("pricing 3300"));
    }
    @Test
    public void isCustomerAddedToDatabase(){
        loggedInMainPage.manageCustomerButton.click();
        manageCustomerPage.showTab.click();
        manageCustomerPage.inputShowCustomerNo.sendKeys("10");
        manageCustomerPage.searchButtonShow.click();
        manageCustomerPage.customerInformationShow.shouldHave(
                Condition.text("Holger"),
                Condition.text("Lucyius"),
                Condition.text("+490190123456"),
                Condition.text("debit"),
                Condition.text("Clownery@gmx.de"),
                Condition.text("Business-Kunde? Ja"),
                Condition.text("Hol2952Lucy"));
    }

    @Test
    public void isCustomerUpdated(){
        loggedInMainPage.manageCustomerButton.click();
        manageCustomerPage.showTab.click();
        manageCustomerPage.inputShowCustomerNo.sendKeys("6");
        manageCustomerPage.searchButtonShow.click();
        manageCustomerPage.customerInformationShow.shouldNotHave(
                Condition.text("Miyamoto"),
                Condition.text("BergeLiebhabber@gmx.net"),
                Condition.text("paypal"));

        manageCustomerPage.customerInformationShow.shouldHave(
                Condition.text("Selachii"),
                Condition.text("DE90 1100 10000 4010"),
                Condition.text("debit"));
    }


    @Test
    public void isHotelroomAddedToDatabase(){
        loggedInMainPage.manageRoomButton.click();
        manageRoomPage.showTab.click();
        manageRoomPage.inputShowRoomNo.sendKeys("11");
        manageRoomPage.searchButtonShow.click();
        manageRoomPage.roomInformationShowCard.shouldHave(
                Condition.text("165"),
                Condition.text("Hotelzimmer"),
                Condition.text("Einzelzimmer"),
                Condition.text("95"),
                Condition.text("Bettenanzahl 3"),
                Condition.text("Fernseher vorhanden Ja"),
                Condition.text("Highspeed Internet vorhanden Ja"),
                Condition.text("Kaffeemaschine vorhanden Ja"),
                Condition.text("Küchenzeile vorhanden Ja"));
    }

    @Test
    public void isHotelroomUpdated(){
        loggedInMainPage.manageRoomButton.click();
        manageRoomPage.showTab.click();
        manageRoomPage.inputShowRoomNo.sendKeys("1");
        manageRoomPage.searchButtonShow.click();
        manageRoomPage.roomInformationShowCard.shouldNotHave(
                Condition.text("75"),
                Condition.text("Suite"),
                Condition.text("600"),
                Condition.text("Bettenanzahl 5"),
                Condition.text("Fernseher vorhanden Ja"),
                Condition.text("Highspeed Internet vorhanden Ja"),
                Condition.text("Kaffeemaschine vorhanden Ja"),
                Condition.text("Küchenzeile vorhanden Nein"));
    }
    @Test
    public void isConferenceRoomAddedToDatabase(){
        loggedInMainPage.manageRoomButton.click();
        manageRoomPage.showTab.click();
        manageRoomPage.inputShowRoomNo.sendKeys("10");
        manageRoomPage.searchButtonShow.click();
        manageRoomPage.roomInformationShowCard.shouldHave(
                Condition.text("35"),
                Condition.text("Konferenzraum"),
                Condition.text("Konferenzzimmer"),
                Condition.text("15"),
                Condition.text("Anzahl Beamer 1"),
                Condition.text("Anzahl Bildschirme 3"),
                Condition.text("Anzahl Whiteboards 2"),
                Condition.text("Computer vorhanden Ja"),
                Condition.text("Projektionsfläche vorhanden Ja"),
                Condition.text("Maximale Teilnehmeranzahl 4"));
    }
    @Test
    public void isConferenceroomUpdated(){
        loggedInMainPage.manageRoomButton.click();
        manageRoomPage.showTab.click();
        manageRoomPage.inputShowRoomNo.sendKeys("6");
        manageRoomPage.searchButtonShow.click();
        manageRoomPage.roomInformationShowCard.shouldNotHave(
                Condition.text("40"),
                Condition.text("Konferenzzimmer"),
                Condition.text("25"),
                Condition.text("Anzahl Beamer 2"),
                Condition.text("Anzahl Bildschirme 0"),
                Condition.text("Anzahl Whiteboards 0"),
                Condition.text("Computer vorhanden Ja"),
                Condition.text("Projektionsfläche vorhanden Ja"),
                Condition.text("Maximale Teilnehmeranzahl 11"));
    }
    @Test
    public void isEmployeeAddedToDatabase(){
        loggedInMainPage.manageStaffButton.click();
        manageStaffPage.showTab.click();
        manageStaffPage.inputShowEmployeeNo.sendKeys("9");
        manageStaffPage.searchButtonShow.click();
        manageStaffPage.staffInformationCardShow.shouldHave(
                Condition.text("Julius Cäsar"),
                Condition.text("Rolle Kundenmanager"),
                Condition.text("AccountID 16"));
    }
    @Test
    public void isEmployeeUpdated(){
        loggedInMainPage.manageStaffButton.click();
        manageStaffPage.showTab.click();
        manageStaffPage.inputShowEmployeeNo.sendKeys("2");
        manageStaffPage.searchButtonShow.click();
        manageStaffPage.staffInformationCardShow.shouldHave(
                Condition.text("Petra"),
                Condition.text("Erik-Quistgard"),
                Condition.text("Hotelleiter"),
                Condition.text("AccountID 3"));
    }
}

