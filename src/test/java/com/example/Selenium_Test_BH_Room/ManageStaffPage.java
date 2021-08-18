package com.example.Selenium_Test_BH_Room;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ManageStaffPage {
    public SelenideElement addTab = $x("//*[@id='mat-tab-label-0-0']/div");
    public SelenideElement editTab = $x("//*[@id='mat-tab-label-0-1']/div");
    public SelenideElement deleteTab = $x("//*[@id='mat-tab-label-0-2']/div");
    public SelenideElement showTab = $x("//*[@id='mat-tab-label-0-3']/div");

    public SelenideElement inputDropDownRole = $(By.name("givenRole"));
    public SelenideElement inputDropDownRoleCustomerManager= $x("//*[@id='mat-option-2']");

    public SelenideElement inputSurname= $x("//*[@id='mat-input-0']");
    public SelenideElement inputName= $x("//*[@id='mat-input-1']");
    public SelenideElement inputPassword= $x("//*[@id='mat-input-2']");
    public SelenideElement inputPasswordRepeat= $x("//*[@id='mat-input-3']");//*[@id='mat-input-193']
    public SelenideElement inputUsername = $(By.name("username"));//username    //button[contains(@class, 'mat-icon-button')]
    public SelenideElement buttonSearchUsername = $x("//button[contains(@class, 'mat-icon-button')]");


    public SelenideElement submitButton= $x("//button[@type='submit']");

    public SelenideElement inputEditEmployeeNo= $x("//*[@id='mat-input-5']");
    public SelenideElement searchButtonEdit= $x("//button[@color='primary']");

    public SelenideElement inputEditSurname= $x("//*[@id='mat-input-8']");
    public SelenideElement inputEditName= $x("//*[@id='mat-input-9']");
    public SelenideElement inputEditPassword= $x("//*[@id='mat-input-10']");
    public SelenideElement inputEditPasswordRepeat= $x("//*[@id='mat-input-11']");

    public SelenideElement inputEditDropDownRole= $(By.name("givenRole"));
    public SelenideElement inputEditDropDownRoleHotelboss= $x("//*[@id='mat-option-9']");

    public SelenideElement submitButtonEdit= $x("//button[@type='submit']");

    public SelenideElement inputDeleteEmployeeNo= $x("//*[@id='mat-input-6']");
    public SelenideElement searchButtonDelete= $x("//button[@ng-reflect-disabled='false']");
    public SelenideElement releaseToogleButton = $x("//*[@id='mat-slide-toggle-1']/label/div/div/div[1]");
    public SelenideElement deleteButton = $x("//button[.//span[text()='Löschen']]");
    public SelenideElement staffInformationCardDeletion= $x("//mat-card");

    public SelenideElement inputShowEmployeeNo = $(By.name("empNo"));
    public SelenideElement searchButtonShow= $x("//button[@type='submit']");
    public SelenideElement staffInformationCardShow= $x("//mat-card");














}

