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

public class RoomPageTest {
    RoomPage roomPage = new RoomPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.startMaximized = true;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("http://localhost:4200/rooms");
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

        $x("/html/body/app-root/div/div[2]/app-booking/div/div/div/div/div[1]/div/div/div[1]/h3[contains(text(),'Buchungs Details')]").shouldBe(visible);
        $x("/html/body/app-root/div/div[2]/app-booking/div/div/h4[contains(text(),'HOTELROOM')]").shouldBe(visible);
    }

    @Test
    public void clickBookingButtonConferenceroom(){
        roomPage.conferenceRoomTab.click();
        roomPage.conferenceRoomBookingButton.click();

        $x("/html/body/app-root/div/div[2]/app-booking/div/div/div/div/div[1]/div/div/div[1]/h3[contains(text(),'Buchungs Details')]").shouldBe(visible);
        $x("/html/body/app-root/div/div[2]/app-booking/div/div/h4[contains(text(),'CONFERENCEROOM')]").shouldBe(visible);
    }








}
