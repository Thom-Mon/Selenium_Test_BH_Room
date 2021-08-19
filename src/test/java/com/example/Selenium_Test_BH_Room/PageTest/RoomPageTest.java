package com.example.Selenium_Test_BH_Room.PageTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class RoomPageTest {
    RoomPage roomPage = new RoomPage();
    MainPage mainPage = new MainPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.startMaximized = true;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("http://localhost:4200");
        mainPage.navitemRooms.click();
    }

    @Test
    public void clickRoomButton() {
        roomPage.conferenceRoomTab.click();
        $x("//*[@id='conferencRoom']").shouldBe(visible);
        roomPage.hotelroomTab.click();
        $x("//*[@id='hotelRoom']").shouldBe(visible);
    }

    @Test
    public void isRoomVisibleForCustomer() {
        roomPage.conferenceRoomTab.click();
        $x("//*[@id='conferencRoom']/div[2]").shouldBe(visible);
        roomPage.hotelroomTab.click();
        $x("//*[@id='hotelRoom']/div[2]").shouldBe(visible);
    }

    @Test
    public void clickBookingButtonHotelroom(){
        roomPage.hotelRoomBookingButton.click();
        $x("//h3[contains(text(),'Buchungs Details')]").shouldBe(visible);
        $x("//h4[contains(text(),'HOTELROOM')]").shouldBe(visible);
    }

    @Test
    public void clickBookingButtonConferenceroom(){
        roomPage.conferenceRoomTab.click();
        roomPage.conferenceRoomBookingButton.click();
        $x("//h3[contains(text(),'Buchungs Details')]").shouldBe(visible);
        $x("//h4[contains(text(),'CONFERENCEROOM')]").shouldBe(visible);
    }








}
