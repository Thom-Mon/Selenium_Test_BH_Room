package com.example.Selenium_Test_BH_Room;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;



public class ManageRoomPageTest {
    ManageRoomPage manageRoomPage = new ManageRoomPage();
    LoggedInMainPage loggedInMainPage = new LoggedInMainPage();
    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();

    @BeforeAll
    public static void setUpAll() {
        //Configuration.browserSize = "1280x1200";
        Configuration.startMaximized = true;
        SelenideLogger.addListener("allure", new AllureSelenide());
        //mainPage.navitemLogin.click();
        //loginPage.forceLoginButton.click();
    }
    @BeforeEach
    public void setUp() {
        open("http://localhost:4200/");
        mainPage.navitemLogin.click();
        loginPage.inputUsername.sendKeys("FlodinWiesret");
        loginPage.inputPassword.sendKeys("SicheresPasswort");
        loginPage.loginButton.click();


        loggedInMainPage.manageRoomButton.click();
    }
    @AfterEach
    public void tearDown(){
        loggedInMainPage.logoutButton.click();
    }



    //TAB-AVAIABILITY
    @Test
    public void isTabAddAvaiable(){manageRoomPage.addTab.click();}
    @Test
    public void isTabEditAvaiable(){
        manageRoomPage.editTab.click();
    }
    @Test
    public void isTabDeleteAvaiable(){
        manageRoomPage.deleteTab.click();
    }
    @Test
    public void isTabShowAvaiable(){
        manageRoomPage.showTab.click();
    }

    @Test
    public void addHotelroom(){
        manageRoomPage.radioButtonHotelroom.click();
        manageRoomPage.inputAreaInSqrMetre.sendKeys("165");
        manageRoomPage.inputPricePerUnit.sendKeys("95");
        manageRoomPage.inputBedCount.sendKeys("3");
        manageRoomPage.inputDropDownCategory.click();
        manageRoomPage.inputDropDownChooseHotel.click();

        manageRoomPage.checkBoxSpeedLan.click();
        manageRoomPage.checkBoxTV.click();
        manageRoomPage.checkBoxKitchen.click();
        manageRoomPage.checkBoxCoffeemaker.click();

        manageRoomPage.inputAreaInSqrMetre.shouldHave(attribute("value", "165"));
        manageRoomPage.inputPricePerUnit.shouldHave(attribute("value", "95"));
        manageRoomPage.inputBedCount.shouldHave(attribute("value", "3"));
        manageRoomPage.inputDropDownCategory.shouldHave(Condition.text("Einzelzimmer"));

        manageRoomPage.submitButton.click();

        $x("//div[@class='notificationArea']").shouldHave(Condition.text("Raum erfolgreich angelegt"));
    }

    @Test
    public void addConferenceRoom(){
        manageRoomPage.radioButtonConferenceRoom.click();
        manageRoomPage.inputAreaInSqrMetre.sendKeys("35");
        manageRoomPage.inputPricePerUnit.sendKeys("15");
        manageRoomPage.inputDropDownCategory.click();
        manageRoomPage.inputDropDownChooseConference.click();
        manageRoomPage.inputMaxUser.sendKeys("4");
        manageRoomPage.inputWhiteboard.sendKeys("2");
        manageRoomPage.inputBeamer.sendKeys("1");
        manageRoomPage.inputScreen.sendKeys("3");

        manageRoomPage.checkBoxProjectScreen.click();
        manageRoomPage.checkBoxComputerAvaiable.click();

        manageRoomPage.inputAreaInSqrMetre.shouldHave(attribute("value", "35"));
        manageRoomPage.inputPricePerUnit.shouldHave(attribute("value", "15"));
        manageRoomPage.inputMaxUser.shouldHave(attribute("value", "4"));
        manageRoomPage.inputWhiteboard.shouldHave(attribute("value", "2"));
        manageRoomPage.inputBeamer.shouldHave(attribute("value", "1"));
        manageRoomPage.inputScreen.shouldHave(attribute("value", "3"));
        manageRoomPage.inputDropDownCategory.shouldHave(Condition.text("Konferenzzimmer"));

        manageRoomPage.submitButton.click();
        $x("//div[@class='notificationArea']").shouldHave(Condition.text("Raum erfolgreich angelegt"));
    }


    @Test
    public void isSearchWorkingEditHotelroom(){
        manageRoomPage.editTab.click();
        manageRoomPage.inputEditRoomNo.clear();
        manageRoomPage.inputEditRoomNo.sendKeys("1");
        manageRoomPage.searchButtonEdit.click();

        manageRoomPage.inputEditAreaInSqrMetre.shouldHave(attribute("value","75"));
        manageRoomPage.inputEditPricePerUnit.shouldHave(attribute("value", "600"));
        manageRoomPage.inputEditBedCount.shouldHave(attribute("value", "5"));
        manageRoomPage.inputEditDropdownCategory.shouldHave(Condition.text("Suite"));

        manageRoomPage.checkBoxEditSpeedLan.shouldHave(attribute("ng-reflect-model", "true"));
        manageRoomPage.checkBoxEditTV.shouldHave(attribute("ng-reflect-model", "true"));
        manageRoomPage.checkBoxEditKitchen.shouldHave(attribute("ng-reflect-model", "false"));
        manageRoomPage.checkBoxEditCoffeemaker.shouldHave(attribute("ng-reflect-model", "true"));
    }

    @Test
    public void isSearchWorkingEditConferenceroom(){
        manageRoomPage.editTab.click();
        manageRoomPage.inputEditRoomNo.clear();
        manageRoomPage.inputEditRoomNo.sendKeys("7");
        manageRoomPage.searchButtonEdit.click();

        manageRoomPage.inputEditAreaInSqrMetre.shouldHave(attribute("value","50"));
        manageRoomPage.inputEditPricePerUnitConference.shouldHave(attribute("value", "35"));
        manageRoomPage.inputEditDropdownCategory.shouldHave(Condition.text("Konferenzsaal"));
        manageRoomPage.inputEditWhiteboard.shouldHave(attribute("value", "0"));
        manageRoomPage.inputEditBeamer.shouldHave(attribute("value", "3"));
        manageRoomPage.inputEditScreen.shouldHave(attribute("value", "1"));

        manageRoomPage.checkBoxEditProjectScreen.shouldHave(attribute("ng-reflect-model", "false"));
        manageRoomPage.checkBoxEditComputerAvaiable.shouldHave(attribute("ng-reflect-model", "false"));
    }

    @Test
    public void isEditingPossibleHotelroom(){
        manageRoomPage.editTab.click();
        manageRoomPage.inputEditRoomNo.clear();
        manageRoomPage.inputEditRoomNo.sendKeys("1");
        manageRoomPage.searchButtonEdit.click();

        manageRoomPage.inputEditAreaInSqrMetre.clear();
        manageRoomPage.inputEditAreaInSqrMetre.sendKeys("70");
        manageRoomPage.inputEditPricePerUnit.clear();
        manageRoomPage.inputEditPricePerUnit.sendKeys("550");

        manageRoomPage.inputEditBedCount.clear();
        manageRoomPage.inputEditBedCount.sendKeys("7");


        manageRoomPage.inputEditDropdownCategory.click();
        manageRoomPage.inputEditDropDownChooseFirst.click();

        manageRoomPage.checkBoxEditSpeedLan.click();
        manageRoomPage.checkBoxEditTV.click();
        manageRoomPage.checkBoxEditKitchen.click();
        manageRoomPage.checkBoxEditCoffeemaker.click();

        manageRoomPage.inputEditAreaInSqrMetre.shouldHave(attribute("value","70"));
        manageRoomPage.inputEditPricePerUnit.shouldHave(attribute("value", "550"));
        manageRoomPage.inputEditBedCount.shouldHave(attribute("value", "7"));

        manageRoomPage.inputEditDropdownCategory.shouldHave(Condition.text("Doppelzimmer"));

        manageRoomPage.checkBoxEditSpeedLan.shouldHave(attribute("ng-reflect-model", "false"));
        manageRoomPage.checkBoxEditTV.shouldHave(attribute("ng-reflect-model", "false"));
        manageRoomPage.checkBoxEditKitchen.shouldHave(attribute("ng-reflect-model", "true"));
        manageRoomPage.checkBoxEditCoffeemaker.shouldHave(attribute("ng-reflect-model", "false"));

        manageRoomPage.submitButtonEdit.click();
        $x("//div[@class='notificationArea']").shouldHave(Condition.text("Raum erfolgreich geändert"));

    }
    @Test
    public void isEditingPossibleConferenceroom(){
        manageRoomPage.editTab.click();
        manageRoomPage.inputEditRoomNo.clear();
        manageRoomPage.inputEditRoomNo.sendKeys("6");
        manageRoomPage.searchButtonEdit.click();

        manageRoomPage.inputEditAreaInSqrMetre.clear();
        manageRoomPage.inputEditAreaInSqrMetre.sendKeys("50");
        manageRoomPage.inputEditPricePerUnitConference.clear();
        manageRoomPage.inputEditPricePerUnitConference.sendKeys("30");
        manageRoomPage.inputEditMaxUser.clear();
        manageRoomPage.inputEditMaxUser.sendKeys("15");

        manageRoomPage.inputEditDropdownCategory.click();
        manageRoomPage.inputEditDropDownChooseFirstConference.click();

        manageRoomPage.inputEditWhiteboard.clear();
        manageRoomPage.inputEditWhiteboard.sendKeys("1");
        manageRoomPage.inputEditBeamer.clear();
        manageRoomPage.inputEditBeamer.sendKeys("1");
        manageRoomPage.inputEditScreen.clear();
        manageRoomPage.inputEditScreen.sendKeys("1");

        manageRoomPage.checkBoxEditProjectScreen.click();
        manageRoomPage.checkBoxEditComputerAvaiable.click();


        manageRoomPage.inputEditAreaInSqrMetre.shouldHave(attribute("value","50"));
        manageRoomPage.inputEditPricePerUnitConference.shouldHave(attribute("value", "30"));
        manageRoomPage.inputEditMaxUser.shouldHave(attribute("value","15"));
        manageRoomPage.inputEditWhiteboard.shouldHave(attribute("value","1"));
        manageRoomPage.inputEditBeamer.shouldHave(attribute("value","1"));
        manageRoomPage.inputEditScreen.shouldHave(attribute("value","1"));

        manageRoomPage.checkBoxEditProjectScreen.shouldHave(attribute("ng-reflect-model", "false"));
        manageRoomPage.checkBoxEditComputerAvaiable.shouldHave(attribute("ng-reflect-model", "false"));

        manageRoomPage.submitButtonEdit.click();
        $x("//div[@class='notificationArea']").shouldHave(Condition.text("Raum erfolgreich geändert"));
    }

    @Test
    public void isSearchWorkingOnDelete(){
        manageRoomPage.deleteTab.click();
        manageRoomPage.inputDeleteRoomNo.clear();
        manageRoomPage.inputDeleteRoomNo.sendKeys("5");
        manageRoomPage.searchButtonDelete.click();

        manageRoomPage.roomInformationDeletionCard.shouldHave(
                Condition.text("40"),
                Condition.text("Hotelzimmer"),
                Condition.text("Doppelzimmer"),
                Condition.text("95"),
                Condition.text("Bettenanzahl 1"),
                Condition.text("Fernseher vorhanden Nein"),
                Condition.text("Highspeed Internet vorhanden Ja"),
                Condition.text("Kaffeemaschine vorhanden Nein"),
                Condition.text("Küchenzeile vorhanden Nein"));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void isDeletionWorking(){
        manageRoomPage.deleteTab.click();
        manageRoomPage.inputDeleteRoomNo.clear();
        manageRoomPage.inputDeleteRoomNo.sendKeys("8");
        manageRoomPage.searchButtonDelete.click();
        manageRoomPage.releaseButtonToogle.click();


        manageRoomPage.deleteButton.click();
        $x("//div[@class='notificationArea']").shouldHave(Condition.text("Raum erfolgreich gelöscht"));
    }

    @Test
    public void isSearchWorkingOnShow(){
        manageRoomPage.showTab.click();
        manageRoomPage.inputShowRoomNo.clear();
        manageRoomPage.inputShowRoomNo.sendKeys("5");
        manageRoomPage.searchButtonShow.click();

        manageRoomPage.roomInformationShowCard.shouldHave(
                Condition.text("40"),
                Condition.text("Hotelzimmer"),
                Condition.text("Doppelzimmer"),
                Condition.text("95"),
                Condition.text("Bettenanzahl 1"),
                Condition.text("Fernseher vorhanden Nein"),
                Condition.text("Highspeed Internet vorhanden Ja"),
                Condition.text("Kaffeemaschine vorhanden Nein"),
                Condition.text("Küchenzeile vorhanden Nein"));
    }
}
