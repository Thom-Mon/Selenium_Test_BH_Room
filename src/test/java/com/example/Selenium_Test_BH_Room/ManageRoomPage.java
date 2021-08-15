package com.example.Selenium_Test_BH_Room;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ManageRoomPage {
    public SelenideElement addTab = $x("//*[@id='mat-tab-label-0-0']/div");
    public SelenideElement editTab = $x("//*[@id='mat-tab-label-0-1']/div");
    public SelenideElement deleteTab = $x("//*[@id='mat-tab-label-0-2']/div");
    public SelenideElement showTab = $x("//*[@id='mat-tab-label-0-3']/div");

    public SelenideElement radioButtonHotelroom = $x("//*[@id='mat-radio-2']");
    public SelenideElement radioButtonConferenceRoom = $x("//*[@id='mat-radio-3']");
    public SelenideElement inputAreaInSqrMetre = $x("//*[@id='mat-input-0']");
    public SelenideElement inputDropDownCategory = $x("//*[@id='mat-tab-content-0-0']/div/div/div[1]/div/mat-form-field[2]/div/div[1]/div");
    public SelenideElement inputDropDownChooseSecond= $x("//*[@id='mat-option-2']");
    public SelenideElement inputPricePerUnit= $x("//*[@id='mat-input-4']");
    public SelenideElement inputBedCount = $x("//*[@id='mat-input-5']");//*[@id='mat-input-5']
    public SelenideElement inputMaxUser = $x("//*[@id='mat-input-5']");
    public SelenideElement inputWhiteboard= $x("//*[@id='mat-input-6']");
    public SelenideElement inputBeamer = $x("//*[@id='mat-input-7']");
    public SelenideElement inputScreen = $x("//*[@id='mat-input-8']");

    public SelenideElement checkBoxProjectScreen = $x("//*[@id='mat-checkbox-1']");
    public SelenideElement checkBoxComputerAvaiable = $x("//*[@id='mat-checkbox-2']");
    public SelenideElement checkBoxSpeedLan = $x("//*[@id='mat-checkbox-1']");
    public SelenideElement checkBoxTV = $x("//*[@id='mat-checkbox-2']");
    public SelenideElement checkBoxKitchen = $x("//*[@id='mat-checkbox-3']");
    public SelenideElement checkBoxCoffeemaker = $x("//*[@id='mat-checkbox-4']");

    public SelenideElement submitButton = $x("//*[@id='mat-tab-content-0-0']/div/div/div[1]/button");

    public SelenideElement inputEditRoomNo = $x("//*[@id='mat-input-1']");
    public SelenideElement searchButtonEdit = $x("//*[@id='mat-tab-content-0-1']/div/div/div[1]/button");

    public SelenideElement inputEditAreaInSqrMetre = $x("//*[@id='mat-input-4']");
    public SelenideElement inputEditPricePerUnitConference = $x("//*[@id='mat-input-10']");

    public SelenideElement inputEditCategory = $x("//*[@id='mat-select-value-7']/span/span");
    public SelenideElement inputEditPricePerUnit = $x("//*[@id='mat-input-7']");
    public SelenideElement inputEditBedCount = $x("//*[@id='mat-input-8']");
    public SelenideElement inputEditDropdownCategory = $x("//*[@id='mat-tab-content-0-1']/div/div/div[1]/div/div/mat-form-field[2]/div/div[1]/div");
    public SelenideElement inputEditDropDownChooseFirst= $x("//*[@id='mat-option-5']");//*[@id='mat-option-4']
    public SelenideElement inputEditDropDownChooseFirstConference= $x("//*[@id='mat-option-4']");

    public SelenideElement inputEditWhiteboard = $x("//*[@id='mat-input-12']");
    public SelenideElement inputEditBeamer = $x("//*[@id='mat-input-13']");
    public SelenideElement inputEditScreen = $x("//*[@id='mat-input-14']");
    public SelenideElement inputEditMaxUser = $x("//*[@id='mat-input-11']");

    public SelenideElement checkBoxEditSpeedLan = $x("//*[@id='mat-checkbox-5']");
    public SelenideElement checkBoxEditTV= $x("//*[@id='mat-checkbox-6']");
    public SelenideElement checkBoxEditKitchen= $x("//*[@id='mat-checkbox-7']");
    public SelenideElement checkBoxEditCoffeemaker = $x("//*[@id='mat-checkbox-8']");

    public SelenideElement checkBoxEditProjectScreen = $x("//*[@id='mat-checkbox-3']");
    public SelenideElement checkBoxEditComputerAvaiable = $x("//*[@id='mat-checkbox-4']");

    public SelenideElement inputDeleteRoomNo = $x("//*[@id='mat-input-2']");//*[@id='mat-tab-content-0-2']/div/div/div[1]/button[1]
    public SelenideElement searchButtonDelete = $x("//*[@id='mat-tab-content-0-2']/div/div/div[1]/button[1]");
    public SelenideElement roomInformationDeletionCard = $x("//*[@id='mat-tab-content-0-2']/div/div/div[1]/mat-card");//*[@id='mat-tab-content-0-2']/div/div/div[1]/button[1]
    public SelenideElement releaseButtonToogle = $x("//*[@id='mat-slide-toggle-1']/label/div/div/div[1]");
    public SelenideElement deleteButton = $x("//*[@id='mat-tab-content-0-2']/div/div/div[1]/button[2]");

    public SelenideElement inputShowRoomNo = $x("//*[@id='mat-input-3']");
    public SelenideElement searchButtonShow = $x("//*[@id='mat-tab-content-0-3']/div/div/div[1]/button");
    public SelenideElement roomInformationShowCard = $x("//*[@id='mat-tab-content-0-3']/div/div/div[1]/mat-card");//*[@id='mat-tab-content-0-2']/div/div/div[1]/button[1]


//*[@id='mat-input-10']



}

