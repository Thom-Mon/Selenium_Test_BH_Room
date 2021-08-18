package com.example.Selenium_Test_BH_Room.PageTest;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ManageCustomerPage {
    public SelenideElement addTab = $x("//*[@id='mat-tab-label-0-0']/div");
    public SelenideElement editTab = $x("//div[text()='Bearbeiten']");
    public SelenideElement deleteTab = $x("//*[@id='mat-tab-label-0-2']/div");
    public SelenideElement showTab = $x("//*[@id='mat-tab-label-0-3']/div");

    public SelenideElement input = $x("");


    public SelenideElement checkboxBusinessCustomer = $x("//*[@id='mat-checkbox-1']/label/span[1]");
    public SelenideElement inputSurname = $x("//*[@id='mat-input-0']");
    public SelenideElement inputName = $x("//*[@id='mat-input-1']");
    public SelenideElement inputStreet = $x("//*[@id='mat-input-2']");
    public SelenideElement inputHouseNo = $x("//*[@id='mat-input-3']");
    public SelenideElement inputZipcode = $x("//*[@id='mat-input-4']");
    public SelenideElement inputCity = $x("//*[@id='mat-input-5']");
    public SelenideElement inputPhone = $x("//*[@id='mat-input-6']");
    public SelenideElement inputMail = $x("//*[@id='mat-input-7']");
    public SelenideElement inputPaymethod = $x("//*[@id='mat-select-value-1']");
    public SelenideElement inputPaymethodPayPal = $x("//*[@id='mat-option-2']");
    public SelenideElement inputPaymethodPayPalAdressField = $x("//*[@id='mat-input-11']");




    public SelenideElement submitButton = $x("//button[@type='submit']");

    public SelenideElement inputEditCustomerNo = $x("//*[@id='mat-input-8']");
    public SelenideElement searchButtonEdit = $x("//button[.//span[text()='Suchen']]");

    public SelenideElement checkboxEditBusinessCustomer = $x("//*[@id='mat-checkbox-2-input']");
    public SelenideElement inputEditSurname = $(By.name("firstName"));
    public SelenideElement inputEditName = $(By.name("lastName"));
    public SelenideElement inputEditStreet = $(By.name("streetName"));
    public SelenideElement inputEditHouseNo = $(By.name("streetNumber"));
    public SelenideElement inputEditZipcode = $(By.name("postalCode"));
    public SelenideElement inputEditCity  = $(By.name("cityName"));
    public SelenideElement inputEditPhone  = $(By.name("phone"));
    public SelenideElement inputEditMail  = $(By.name("mailAddress"));
    public SelenideElement inputEditPaymethod = $x("//*[@id='mat-select-value-3']");
    public SelenideElement inputEditPaymethodEC = $x("//*[@id='mat-option-4']");
    public SelenideElement inputEditPaymethodECField = $x("//*[@id='mat-input-23']");
    public SelenideElement submitButtonEdit = $x("//button[@type='submit']");
    public SelenideElement inputEditPassword = $(By.name("password"));
    public SelenideElement inputEditPasswordRepeat= $(By.name("repeatedPassword"));
    public SelenideElement inputEditUsername = $x("//*[@id='mat-input-21']");

    public SelenideElement inputDeleteCustomerNo = $x("//*[@id='mat-input-9']");
    public SelenideElement searchButtonDelete = $x("//button[@ng-reflect-disabled='false']");
    public SelenideElement customerInformationDeletion = $x("//mat-card");
    public SelenideElement releaseButtonToogleDeletion= $x("//*[@id='mat-slide-toggle-1']/label/div/div");
    public SelenideElement deletionButton= $x("//*[@id='mat-tab-content-0-2']/div/div/div[1]/button[2]");

    public SelenideElement inputShowCustomerNo = $x("//*[@id='mat-input-10']");
    public SelenideElement searchButtonShow = $x("//*[@id='mat-tab-content-0-3']/div/div/div[1]/button");
    public SelenideElement customerInformationShow= $x("//mat-card");

}

