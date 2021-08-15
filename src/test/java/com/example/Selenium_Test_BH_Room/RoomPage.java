package com.example.Selenium_Test_BH_Room;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RoomPage {
    public SelenideElement hotelroomTab = $x("//*[@id='myTab']/li[1]");
    public SelenideElement conferenceRoomTab = $x("//*[@id='myTab']/li[2]");
    public SelenideElement hotelRoomBookingButton = $x("//*[@id='hotelRoom']/div[1]/div[1]/div/div/button");
    public SelenideElement conferenceRoomBookingButton = $x("//*[@id='conferencRoom']/div[1]/div[1]/div/div/button");
}