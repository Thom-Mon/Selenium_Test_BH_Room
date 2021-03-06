package com.example.Selenium_Test_BH_Room.PageTest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.*;


public class ManageBookingPageTest {
    ManageBookingPage manageBookingPage = new ManageBookingPage();
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();
    LoggedInMainPage loggedInMainPage = new LoggedInMainPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.startMaximized = true;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
    @BeforeEach
    public void setUp() {
        open("http://localhost:4200/");
        mainPage.navitemLogin.click();
        loginPage.inputUsername.sendKeys("FlodinWiesret");
        loginPage.inputPassword.sendKeys("SicheresPasswort");
        loginPage.loginButton.click();
        loggedInMainPage.manageBookingButton.click();
    }
    @AfterEach
    public void tearDown(){
        loggedInMainPage.logoutButton.click();
    }

    //TAB-AVAIABILITY
    @Test
    public void isTabAddAvaiable(){
       manageBookingPage.addTab.click();
    }
    @Test
    public void isTabEditAvaiable(){
       manageBookingPage.editTab.click();
    }
    @Test
    public void isTabDeleteAvaiable(){manageBookingPage.deleteTab.click();}
    @Test
    public void isTabShowAvaiable(){manageBookingPage.showTab.click();}

    @Test
    public void isRadioButtonWorking(){
        manageBookingPage.radioButtonHotel.click();
        manageBookingPage.radioButtonConference.click();
    }

    @Test
    public void addBookingInformation(){ //TODO: KLick auf Element in Dropdown geht nicht!!!
        manageBookingPage.addTab.click();
        manageBookingPage.inputCustomerNo.sendKeys("4");
        manageBookingPage.inputStartDate.sendKeys("23122023");
        manageBookingPage.inputEndDate.sendKeys("29122023");
        manageBookingPage.inputStartTime.sendKeys("1100");
        manageBookingPage.inputEndTime.sendKeys("1200");
        manageBookingPage.inputCustomerWishes.sendKeys("Jeden Tag eine Kugel Eis...auf die Hand...und Cola...verdammt ja...Cola!!!");
        manageBookingPage.radioButtonHotel.click();

        manageBookingPage.dropdownRoomNo.click();
        manageBookingPage.dropdownRoomNoFour.click();
        manageBookingPage.inputEndDate.click();

        manageBookingPage.submitButton.click();
    }
    @Test
    public void isSearchWorkingEditTab(){
        manageBookingPage.editTab.click();
        manageBookingPage.inputBookingNo.sendKeys("1");
        manageBookingPage.searchButton.click();
        manageBookingPage.inputEditCustomerNo.shouldHave(attribute("value", "2"));

        manageBookingPage.inputEditStartDate.shouldHave(attribute("value", "2021-04-01"));
        manageBookingPage.inputEditEndDate.shouldHave(attribute("value", "2021-04-04"));
        manageBookingPage.inputEditStartTime.shouldHave(attribute("value", "10:30"));
        manageBookingPage.inputEditEndTime.shouldHave(attribute("value", "10:30"));
        manageBookingPage.inputEditCustomerWishes.shouldHave(attribute("value", "Cola so viel und so oft wie geht"));
    }

    @Test
    public void isEditingPossibleOnEditTab(){
        manageBookingPage.editTab.click();
        manageBookingPage.inputBookingNo.sendKeys("2");
        manageBookingPage.searchButton.click();

        manageBookingPage.inputEditCustomerWishes.clear();
        manageBookingPage.inputEditCustomerNo.clear();
        manageBookingPage.inputEditCustomerNo.sendKeys("3");
        manageBookingPage.inputEditCustomerWishes.sendKeys("Oder doch lieber Fanta!");

        manageBookingPage.inputEditCustomerNo.click();

        manageBookingPage.inputEditCustomerWishes.shouldHave(attribute("value", "Oder doch lieber Fanta!"));
        manageBookingPage.inputEditCustomerNo.shouldHave(attribute("value", "3"));

        manageBookingPage.submitEditButton.click();

    }

    @Test
    public void isSearchWorkingDeleteTab(){
        manageBookingPage.deleteTab.click();
        manageBookingPage.inputBookingNoDeletion.clear();
        manageBookingPage.inputBookingNoDeletion.sendKeys("1");
        manageBookingPage.searchButtonDeletion.click();

        manageBookingPage.bookingInformationDeletion.shouldHave(
                Condition.text("Cola so viel und so oft wie geht"),
                Condition.text("1111.99"),
                Condition.text("2021-04-01 10:30:00"),
                Condition.text("2021-04-04 10:30:00"),
                Condition.text("customerID 2"),
                Condition.text("empNo 4"));
    }

    @Test
    public void isDeletionWorking(){
        manageBookingPage.deleteTab.click();
        manageBookingPage.inputBookingNoDeletion.clear();
        manageBookingPage.inputBookingNoDeletion.sendKeys("5");
        manageBookingPage.searchButtonDeletion.click();

        manageBookingPage.releaseButtonToogleDeletion.click();
        manageBookingPage.deletionButton.click();
    }

    @Test
    public void isSearchWorkingShowTab(){
        manageBookingPage.showTab.click();
        manageBookingPage.inputBookingNoShow.clear();
        manageBookingPage.inputBookingNoShow.sendKeys("1");
        manageBookingPage.searchButtonShow.click();

        manageBookingPage.bookingInformationShow.shouldHave(
                Condition.text("Cola so viel und so oft wie geht"),
                Condition.text("1111.99"),
                Condition.text("2021-04-01 10:30:00"),
                Condition.text("2021-04-04 10:30:00"),
                Condition.text("customerID 2"),
                Condition.text("empNo 4"));
    }
}
