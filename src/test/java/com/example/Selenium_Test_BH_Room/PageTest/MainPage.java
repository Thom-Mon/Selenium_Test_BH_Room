package com.example.Selenium_Test_BH_Room.PageTest;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    public SelenideElement navitemLogin = $x("//a[text()='Login']");
    public SelenideElement navitemRooms = $x("//*[@id='pills-rooms-tab']");
    public SelenideElement logoutButton= $x("//*[@id='pills-logout-tab']");
}
