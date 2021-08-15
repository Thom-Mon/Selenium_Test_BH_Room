package com.example.Selenium_Test_BH_Room;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    public SelenideElement navitemLogin = $x("//*[@id='pills-tab']/li[2]");
    public SelenideElement navitemRooms = $x("//*[@id='pills-rooms-tab']");
    public SelenideElement navBarToogleButton = $x("/html/body/app-root/app-navigation/nav/div/button");
}
