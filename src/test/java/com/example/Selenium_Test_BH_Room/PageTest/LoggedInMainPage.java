package com.example.Selenium_Test_BH_Room.PageTest;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class LoggedInMainPage {
    public SelenideElement manageBookingButton= $x("//*[@id='pills-booking-tab']");
    public SelenideElement manageCustomerButton= $x("//*[@id='pills-customer-tab']");
    public SelenideElement manageRoomButton= $x("//*[@id='pills-room-tab']");
    public SelenideElement manageStaffButton= $x("//*[@id='pills-employee-tab']");
    public SelenideElement manageEmployeeButton= $x("//*[@id='pills-employees-tab']");
    public SelenideElement logoutButton= $x("//*[@id='pills-logout-tab']");
}


