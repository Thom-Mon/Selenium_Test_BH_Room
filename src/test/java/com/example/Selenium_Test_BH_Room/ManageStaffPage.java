package com.example.Selenium_Test_BH_Room;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ManageStaffPage {
    public SelenideElement addTab = $x("//*[@id='mat-tab-label-0-0']/div");
    public SelenideElement editTab = $x("//*[@id='mat-tab-label-0-1']/div");
    public SelenideElement deleteTab = $x("//*[@id='mat-tab-label-0-2']/div");
    public SelenideElement showTab = $x("//*[@id='mat-tab-label-0-3']/div");

    public SelenideElement inputDropDownRole= $x("//*[@id='mat-tab-content-0-0']/div/div/div[1]/mat-form-field/div/div[1]");
    public SelenideElement inputDropDownRoleCustomerManager= $x("//*[@id='mat-option-2']");

    public SelenideElement inputSurname= $x("//*[@id='mat-input-0']");
    public SelenideElement inputName= $x("//*[@id='mat-input-1']");
    public SelenideElement inputPassword= $x("//*[@id='mat-input-2']");
    public SelenideElement inputPasswordRepeat= $x("//*[@id='mat-input-3']");

    public SelenideElement submitButton= $x("//*[@id='mat-tab-content-0-0']/div/div/div[1]/button");

    public SelenideElement inputEditEmployeeNo= $x("//*[@id='mat-input-5']");
    public SelenideElement searchButtonEdit= $x("//*[@id='mat-tab-content-0-1']/div/div/div[1]/button");

    public SelenideElement inputEditSurname= $x("//*[@id='mat-input-8']");
    public SelenideElement inputEditName= $x("//*[@id='mat-input-9']");
    public SelenideElement inputEditPassword= $x("//*[@id='mat-input-10']");
    public SelenideElement inputEditPasswordRepeat= $x("//*[@id='mat-input-11']");

    public SelenideElement inputEditDropDownRole= $x("//*[@id='mat-tab-content-0-1']/div/div/div[1]/div/mat-form-field/div/div[1]");
    public SelenideElement inputEditDropDownRoleHotelboss= $x("//*[@id='mat-option-9']");

    public SelenideElement submitButtonEdit= $x("//*[@id='mat-tab-content-0-1']/div/div/div[1]/div/button");

    public SelenideElement inputDeleteEmployeeNo= $x("//*[@id='mat-input-6']");
    public SelenideElement searchButtonDelete= $x("//*[@id='mat-tab-content-0-2']/div/div/div[1]/button");
    public SelenideElement releaseToogleButton = $x("//*[@id='mat-slide-toggle-1']/label/div/div/div[1]");
    public SelenideElement deleteButton = $x("//*[@id='mat-tab-content-0-2']/div/div/div[1]/button[2]");
    public SelenideElement staffInformationCardDeletion= $x("//*[@id='mat-tab-content-0-2']/div/div/div[1]/mat-card");

    public SelenideElement inputShowEmployeeNo= $x("//*[@id='mat-input-6']");
    public SelenideElement searchButtonShow= $x("//*[@id='mat-tab-content-0-3']/div/div/div[1]/button");
    public SelenideElement staffInformationCardShow= $x("//*[@id='mat-tab-content-0-3']/div/div/div[1]/mat-card");














}

