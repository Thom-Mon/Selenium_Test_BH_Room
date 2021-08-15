package com.example.Selenium_Test_BH_Room;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.commons.lang3.builder.ToStringExclude;
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



public class ManageStaffPageTest {
    //ManageBookingPage manageBookingPage = new ManageBookingPage();
    //ManageRoomPage manageRoomPage = new ManageRoomPage();
    ManageStaffPage manageStaffPage = new ManageStaffPage();
    String surname = "Julius";
    String name = "Cäsar";
    String password = "Lukas-Jenkings14";

    @BeforeAll
    public static void setUpAll() {
        Configuration.startMaximized = true;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {open("http://localhost:4200/management/employee");}


    //TAB-AVAIABILITY
    @Test
    public void isTabAddAvaiable(){manageStaffPage.addTab.click();}
    @Test
    public void isTabEditAvaiable(){
        manageStaffPage.editTab.click();
    }
    @Test
    public void isTabDeleteAvaiable(){
        manageStaffPage.deleteTab.click();
    }
    @Test
    public void isTabShowAvaiable(){
        manageStaffPage.showTab.click();
    }


    @Test
    public void addEmployee(){
        manageStaffPage.inputDropDownRole.click();
        manageStaffPage.inputDropDownRoleCustomerManager.click();

        manageStaffPage.inputSurname.sendKeys(surname);
        manageStaffPage.inputName.sendKeys(name);
        manageStaffPage.inputPassword.sendKeys(password);
        manageStaffPage.inputPasswordRepeat.sendKeys(password);

        manageStaffPage.inputSurname.shouldHave(attribute("value",surname));
        manageStaffPage.inputName.shouldHave(attribute("value",name));
        manageStaffPage.inputPassword.shouldHave(attribute("value",password));
        manageStaffPage.inputPasswordRepeat.shouldHave(attribute("value",password));
        manageStaffPage.inputDropDownRole.shouldHave(Condition.text("Kundenmanager"));

        //manageStaffPage.submitButton.click();  //TODO Aktivieren!
    }

    @Test
    public void isSearchWorkingOnEditTab(){
        manageStaffPage.editTab.click();
        manageStaffPage.inputEditEmployeeNo.clear();
        manageStaffPage.inputEditEmployeeNo.sendKeys("2");
        manageStaffPage.searchButtonEdit.click();

        manageStaffPage.inputEditSurname.shouldHave(attribute("value","Peter"));
        manageStaffPage.inputEditName.shouldHave(attribute("value"," Quistgard"));
        manageStaffPage.inputEditPassword.shouldHave(attribute("value",""));
        manageStaffPage.inputEditPasswordRepeat.shouldHave(attribute("value",""));
        manageStaffPage.inputEditDropDownRole.shouldHave(Condition.text("Buchungsmanager"));

        //manageStaffPage.submitButton.click();  //TODO Aktivieren!
    }

    @Test
    public void isEditingPossibleOnEmployee(){
        manageStaffPage.editTab.click();
        manageStaffPage.inputEditEmployeeNo.clear();
        manageStaffPage.inputEditEmployeeNo.sendKeys("2");
        manageStaffPage.searchButtonEdit.click();

        manageStaffPage.inputEditDropDownRole.click();
        manageStaffPage.inputEditDropDownRoleHotelboss.click();
        manageStaffPage.inputEditSurname.clear();
        manageStaffPage.inputEditSurname.sendKeys("Petra");
        manageStaffPage.inputEditName.clear();
        manageStaffPage.inputEditName.sendKeys("Erik-Quistgard");
        manageStaffPage.inputEditPassword.sendKeys(password);
        manageStaffPage.inputEditPasswordRepeat.sendKeys(password);

        manageStaffPage.inputEditSurname.shouldHave(attribute("value","Petra"));
        manageStaffPage.inputEditName.shouldHave(attribute("value","Erik-Quistgard"));
        manageStaffPage.inputEditPassword.shouldHave(attribute("value",password));
        manageStaffPage.inputEditPasswordRepeat.shouldHave(attribute("value",password));
        manageStaffPage.inputEditDropDownRole.shouldHave(Condition.text("Hotelleiter"));

        //manageStaffPage.submitButtonEdit.click(); TODO: Aktivieren!

    }

    @Test
    public void isSearchWorkingOnDeleteTab(){
        manageStaffPage.deleteTab.click();
        manageStaffPage.inputDeleteEmployeeNo.clear();
        manageStaffPage.inputDeleteEmployeeNo.sendKeys("3");
        manageStaffPage.searchButtonDelete.click();

        manageStaffPage.staffInformationCardDeletion.shouldHave(
                Condition.text("Mitarbeiternummer 3"),
                Condition.text("Malignes Rau"),
                Condition.text("Rolle Hotelleiter"),
                Condition.text("AccountID 7"));


    }

    @Test
    public void isDeletionWorking(){
        manageStaffPage.deleteTab.click();
        manageStaffPage.inputDeleteEmployeeNo.clear();
        manageStaffPage.inputDeleteEmployeeNo.sendKeys("4");
        manageStaffPage.searchButtonDelete.click();

        manageStaffPage.releaseToogleButton.click();
        //manageStaffPage.deleteButton.click(); TODO: Aktivieren!
    }

    @Test
    public void isSearchWorkingOnShowTab(){
        manageStaffPage.deleteTab.click();
        manageStaffPage.inputDeleteEmployeeNo.clear();
        manageStaffPage.inputDeleteEmployeeNo.sendKeys("3");
        manageStaffPage.searchButtonDelete.click();

        manageStaffPage.staffInformationCardDeletion.shouldHave(
                Condition.text("Mitarbeiternummer 3"),
                Condition.text("Malignes Rau"),
                Condition.text("Rolle Hotelleiter"),
                Condition.text("AccountID 7"));
    }

    @Test
    public void isEmployeeListAvaiable(){

    }
}












