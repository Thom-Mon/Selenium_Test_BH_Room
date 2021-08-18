package com.example.Selenium_Test_BH_Room.PageTest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;


import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.*;



public class ManageStaffPageTest {
    LoggedInMainPage loggedInMainPage = new LoggedInMainPage();
    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();
    ManageStaffPage manageStaffPage = new ManageStaffPage();
    String surname = "Julius";
    String name = "Cäsar";
    String password = "SicheresPasswort";
    String username = "StabMeBrutus1";

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


        loggedInMainPage.manageStaffButton.click();
    }
    @AfterEach
    public void tearDown(){
        loggedInMainPage.logoutButton.click();
    }




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
        manageStaffPage.inputUsername.sendKeys(username);

        manageStaffPage.inputSurname.shouldHave(attribute("value",surname));
        manageStaffPage.inputName.shouldHave(attribute("value",name));
        manageStaffPage.inputPassword.shouldHave(attribute("value",password));
        manageStaffPage.inputPasswordRepeat.shouldHave(attribute("value",password));
        manageStaffPage.inputDropDownRole.shouldHave(Condition.text("Kundenmanager"));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        manageStaffPage.buttonSearchUsername.click();
        manageStaffPage.submitButton.click();
        $x("//div[@class='notificationArea']").shouldHave(Condition.text("Mitarbeiter erfolgreich angelegt"));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void isSearchWorkingOnEditTab(){
        manageStaffPage.editTab.click();
        manageStaffPage.inputEditEmployeeNo.clear();
        manageStaffPage.inputEditEmployeeNo.sendKeys("5");
        manageStaffPage.searchButtonEdit.click();

        manageStaffPage.inputEditSurname.shouldHave(attribute("value","Juri"));
        manageStaffPage.inputEditName.shouldHave(attribute("value"," Juhu"));
        manageStaffPage.inputEditPassword.shouldHave(attribute("value",""));
        manageStaffPage.inputEditPasswordRepeat.shouldHave(attribute("value",""));
        manageStaffPage.inputEditDropDownRole.shouldHave(Condition.text("Raummanager"));
    }

    @Test
    public void isEditingPossibleOnEmployee(){//TODO: Hier fehlt Funktionalität!!!!!!!!!!!!!!!!!!! auf Angularseite
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

        manageStaffPage.submitButtonEdit.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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
        manageStaffPage.inputDeleteEmployeeNo.sendKeys("5");
        manageStaffPage.searchButtonDelete.click();

        manageStaffPage.releaseToogleButton.click();
        manageStaffPage.deleteButton.click();
        $x("//div[@class='notificationArea']").shouldHave(Condition.text("Mitarbeiter erfolgreich gelöscht"));
    }

    @Test
    public void isSearchWorkingOnShowTab(){
        manageStaffPage.showTab.click();
        manageStaffPage.inputShowEmployeeNo.clear();
        manageStaffPage.inputShowEmployeeNo.sendKeys("3");
        manageStaffPage.searchButtonShow.click();

        manageStaffPage.staffInformationCardShow.shouldHave(
                Condition.text("Mitarbeiternummer 3"),
                Condition.text("Malignes Rau"),
                Condition.text("Rolle Hotelleiter"),
                Condition.text("AccountID 7"));
    }

    @Test
    public void isEmployeeListAvaiable(){//TODO: Füllen!

    }
}












