package com.example.Selenium_Test_BH_Room.PageTest;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class RoomPage {
    public SelenideElement hotelroomTab = $x("//*[@id='hotelRoom-tab']");
    public SelenideElement conferenceRoomTab = $x("//*[@id='conferencRoom-tab']");
    public SelenideElement hotelRoomBookingButton = $x("//button[@ng-reflect-router-link='/booking,1']");
    public SelenideElement conferenceRoomBookingButton = $x("//*[@id='conferencRoom']/div[1]/div[1]/div/div/button");
}