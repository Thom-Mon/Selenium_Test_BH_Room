package com.example.Selenium_Test_BH_Room.PageTest;


import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class RegisterPage {
    public SelenideElement registerbutton = $x("/html/body/app-root/div/div[2]/app-registration/div/div/div/form/div[10]/button");
    public SelenideElement cancelButton = $x("/html/body/app-root/div/div[2]/app-registration/div/div/div/form/div[10]/a");
    public SelenideElement bookingButton = $x("//*[@id='pills-bookings-tab']");

    //INPUT-ELEMENTE - FORMULAR
    public SelenideElement buttonBusinessCustomer = $x("/html/body/app-root/div/div[2]/app-registration/div/div/div/form/div[1]/div/label");
    public SelenideElement inputName = $x("/html/body/app-root/div/div[2]/app-registration/div/div/div/form/div[2]/input");
    public SelenideElement inputSurname = $x("/html/body/app-root/div/div[2]/app-registration/div/div/div/form/div[3]/input");
    public SelenideElement inputCompany = $x("/html/body/app-root/div/div[2]/app-registration/div/div/div/form/div[4]/div/input");
    public SelenideElement inputMail = $x("/html/body/app-root/div/div[2]/app-registration/div/div/div/form/div[5]/input");
    public SelenideElement inputPhone = $x("/html/body/app-root/div/div[2]/app-registration/div/div/div/form/div[6]/input");
    public SelenideElement inputUsername = $x("/html/body/app-root/div/div[2]/app-registration/div/div/div/form/div[7]/input");
    public SelenideElement inputPassword = $x("/html/body/app-root/div/div[2]/app-registration/div/div/div/form/div[8]/input");
    public SelenideElement inputPasswordRepeat = $x("/html/body/app-root/div/div[2]/app-registration/div/div/div/form/div[9]/input");

}

