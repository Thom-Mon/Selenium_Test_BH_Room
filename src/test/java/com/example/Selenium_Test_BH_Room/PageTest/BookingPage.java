package com.example.Selenium_Test_BH_Room.PageTest;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class BookingPage {
    public SelenideElement inputName = $(By.name("lastName"));
    public SelenideElement inputSurname  = $(By.name("firstName"));
    public SelenideElement inputCompany  = $(By.name("company"));
    public SelenideElement inputMail = $x("//input[@formcontrolname='emailAddress']");
    public SelenideElement inputPhone = $x("//input[@formcontrolname='phoneNumber']");
    public SelenideElement submitButton = $(".btn-secondary");     //button[normalize-space(text()) = 'Jetzt Buchen']
    public SelenideElement buttonBusinessCustomer = $x("//label[text()='Geschäftskonto']");
    public SelenideElement inputStreet = $(By.name("street"));
    public SelenideElement inputStreetNo = $(By.name("streetNumber"));
    public SelenideElement inputZipcode = $(By.name("postalCode"));
    public SelenideElement inputCity = $(By.name("city"));
    public SelenideElement dropDownPaymentMethod = $(By.name("paymentMethod"));
    public SelenideElement inputIban = $(By.name("iban"));
    public SelenideElement inputSpecialWishes = $(By.name("extras"));
    public SelenideElement buttonBooking = $x("//*[@id='pills-bookings-tab']");

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

    public SelenideElement dateShowerStart = $x("//div[@class='card-body'][.//*[@id='btn-check-outlined']]");

    public SelenideElement bookingDetailsCard = $x("//div[@class='card booking-details-card']//div[@class='card-body']");



}
