package com.example.Selenium_Test_BH_Room.PageTest;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ManageBookingPage {
    public SelenideElement addTab = $x("//*[@id='mat-tab-label-0-0']/div");
    public SelenideElement editTab = $x("//*[@id='mat-tab-label-0-1']/div");
    public SelenideElement deleteTab = $x("//div[text()='Löschen']");
    public SelenideElement showTab = $x("//*[@id='mat-tab-label-0-3']");
    public SelenideElement radioButtonHotel = $x("//*[@id='mat-radio-2']/label/span[2]");
    public SelenideElement radioButtonConference = $x("//*[@id='mat-radio-3']/label/span[2]");
    public SelenideElement inputCustomerNo = $x("//*[@id='mat-input-0']");
    public SelenideElement dropdownRoomNo = $x("//*[@id='mat-select-value-1']/span");//*[@id='mat-option-18']/span
    public SelenideElement dropdownRoomNoFour = $x("//span[text()='1']");

    public SelenideElement inputStartDate = $x("//*[@id='mat-input-1']");
    public SelenideElement inputEndDate = $x("//*[@id='mat-input-3']");
    public SelenideElement inputStartTime = $x("//*[@id='mat-input-2']");
    public SelenideElement inputEndTime = $x("//*[@id='mat-input-4']");
    public SelenideElement inputCustomerWishes = $x("//*[@id='mat-input-5']");
    public SelenideElement submitButton = $x("//button[@type='submit']");
    public SelenideElement inputBookingNo = $x("//*[@id='mat-input-6']");
    public SelenideElement searchButton = $x("//button[@type='submit']");

    public SelenideElement inputEditStartDate = $x("//*[@id='mat-input-10']");
    public SelenideElement inputEditEndDate = $x("//*[@id='mat-input-12']");
    public SelenideElement inputEditStartTime = $x("//*[@id='mat-input-11']");
    public SelenideElement inputEditEndTime = $x("//*[@id='mat-input-13']");
    public SelenideElement inputEditCustomerNo = $x("//*[@id='mat-input-9']");
    public SelenideElement inputEditRoomNo = $x("//*[@id='mat-select-2']/div");
    public SelenideElement inputEditCustomerWishes = $x("//*[@id='mat-input-14']");
    public SelenideElement submitEditButton = $x("//button[@type='submit']");
    //public SelenideElement buttonEditMagnifyingGlass = $x("//mat-icon");

    public SelenideElement inputBookingNoDeletion = $x("//*[@id='mat-input-7']");
    public SelenideElement searchButtonDeletion= $x("//button[@ng-reflect-disabled='false']");
    public SelenideElement bookingInformationDeletion = $x("//mat-card");
    public SelenideElement releaseButtonToogleDeletion= $x("//*[@id='mat-slide-toggle-1']/label/div/div/div[1]");
    public SelenideElement deletionButton= $x("//button[.//span[text()='Löschen']]");

    public SelenideElement inputBookingNoShow= $x("//*[@id='mat-input-8']");
    public SelenideElement searchButtonShow= $x("//*[@id='mat-tab-content-0-3']/div/div/div[1]/button");
    public SelenideElement bookingInformationShow = $x("//mat-card");



}

