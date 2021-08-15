package com.example.Selenium_Test_BH_Room;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class BookingPage {
    public SelenideElement inputName = $x("/html/body/app-root/div/div[2]/app-booking/div/div/div/div/div[1]/div/div/form/div/input[1]");
    public SelenideElement inputSurname = $x("/html/body/app-root/div/div[2]/app-booking/div/div/div/div/div[1]/div/div/form/div/input[2]");
    public SelenideElement inputCompany = $x("/html/body/app-root/div/div[2]/app-booking/div/div/div/div/div[1]/div/div/form/div/input[3]");
    public SelenideElement inputMail = $x("/html/body/app-root/div/div[2]/app-booking/div/div/div/div/div[1]/div/div/form/div/input[4]");
    public SelenideElement inputPhone = $x("/html/body/app-root/div/div[2]/app-booking/div/div/div/div/div[1]/div/div/form/div/input[5]");
    public SelenideElement submitButton = $x("/html/body/app-root/div/div[2]/app-booking/div/div/div/div/div[1]/div/div/button");


    public SelenideElement leftArrowMonth = $x("/html/body/app-root/div/div[2]/app-booking/div/div/div/div/div[3]/div/div/ngb-datepicker/div[1]/ngb-datepicker-navigation/div[1]/button");
    public SelenideElement rightArrowMonth = $x("/html/body/app-root/div/div[2]/app-booking/div/div/div/div/div[3]/div/div/ngb-datepicker/div[1]/ngb-datepicker-navigation/div[2]/button");
    public SelenideElement monthPicker = $x("/html/body/app-root/div/div[2]/app-booking/div/div/div/div/div[3]/div/div/ngb-datepicker/div[1]/ngb-datepicker-navigation/ngb-datepicker-navigation-select/select[1]");
    public SelenideElement yearPicker = $x("/html/body/app-root/div/div[2]/app-booking/div/div/div/div/div[3]/div/div/ngb-datepicker/div[1]/ngb-datepicker-navigation/ngb-datepicker-navigation-select/select[2]");
    public SelenideElement startDate= $x("/html/body/app-root/div/div[2]/app-booking/div/div/div/div/div[3]/div/div/ngb-datepicker/div[2]/div/ngb-datepicker-month/div[3]/div[1]/div");
    public SelenideElement endDate= $x("/html/body/app-root/div/div[2]/app-booking/div/div/div/div/div[3]/div/div/ngb-datepicker/div[2]/div/ngb-datepicker-month/div[4]/div[5]/div");

    public SelenideElement inputHourStart = $x("/html/body/app-root/div/div[2]/app-booking/div/div/div/div/div[3]/div/div[2]/div/div[1]/ngb-timepicker/fieldset/div/div[1]/input");
    public SelenideElement inputMinuteStart = $x("/html/body/app-root/div/div[2]/app-booking/div/div/div/div/div[3]/div/div[2]/div/div[1]/ngb-timepicker/fieldset/div/div[3]/input");
    public SelenideElement inputHourEnd = $x("/html/body/app-root/div/div[2]/app-booking/div/div/div/div/div[3]/div/div[2]/div/div[2]/ngb-timepicker/fieldset/div/div[1]/input");
    public SelenideElement inputMinuteEnd = $x("/html/body/app-root/div/div[2]/app-booking/div/div/div/div/div[3]/div/div[2]/div/div[2]/ngb-timepicker/fieldset/div/div[3]/input");


    public SelenideElement upperArrowHoursStart = $x("/html/body/app-root/div/div[2]/app-booking/div/div/div/div/div[3]/div/div[2]/div/div[1]/ngb-timepicker/fieldset/div/div[1]/button[1]");
    public SelenideElement lowerArrowHoursStart = $x("/html/body/app-root/div/div[2]/app-booking/div/div/div/div/div[3]/div/div[2]/div/div[1]/ngb-timepicker/fieldset/div/div[1]/button[2]");
    public SelenideElement upperArrowMinutesStart = $x("/html/body/app-root/div/div[2]/app-booking/div/div/div/div/div[3]/div/div[2]/div/div[1]/ngb-timepicker/fieldset/div/div[3]/button[1]");
    public SelenideElement lowerArrowMinutesStart = $x("/html/body/app-root/div/div[2]/app-booking/div/div/div/div/div[3]/div/div[2]/div/div[1]/ngb-timepicker/fieldset/div/div[3]/button[2]");

    public SelenideElement upperArrowHoursEnd = $x("/html/body/app-root/div/div[2]/app-booking/div/div/div/div/div[3]/div/div[2]/div/div[2]/ngb-timepicker/fieldset/div/div[1]/button[1]");
    public SelenideElement lowerArrowHoursEnd = $x("/html/body/app-root/div/div[2]/app-booking/div/div/div/div/div[3]/div/div[2]/div/div[2]/ngb-timepicker/fieldset/div/div[1]/button[2]");
    public SelenideElement upperArrowMinutesEnd = $x("/html/body/app-root/div/div[2]/app-booking/div/div/div/div/div[3]/div/div[2]/div/div[2]/ngb-timepicker/fieldset/div/div[3]/button[1]");
    public SelenideElement lowerArrowMinutesEnd = $x("/html/body/app-root/div/div[2]/app-booking/div/div/div/div/div[3]/div/div[2]/div/div[2]/ngb-timepicker/fieldset/div/div[3]/button[2]");

    public SelenideElement dateShower = $x("/html/body/app-root/div/div[2]/app-booking/div/div/div/div/div[1]/div/div/div[2]/label");
    public SelenideElement clockShower = $x("/html/body/app-root/div/div[2]/app-booking/div/div/div/div/div[1]/div/div/div[2]/label[2]");



}
