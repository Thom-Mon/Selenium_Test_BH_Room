package com.example.Selenium_Test_BH_Room.PageTest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;


import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.*;



public class ManageCustomerPageTest {
    ManageCustomerPage manageCustomerPage = new ManageCustomerPage();
    LoggedInMainPage loggedInMainPage = new LoggedInMainPage();
    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();
    //Testdaten
    String surname = "Hans";
    String name = "Glöckner";
    String street = "Bauernweg";
    String houseNo = "9";
    String zipcode = "99610";
    String city = "Danzig";
    String phone = "+490190767676";
    String mail = "derBuckelglöckner@gmx.de";
    String paymethod = "PayPal";
    String strongPassword = "SicheresPasswort"; //HASH weil Funktion noch nicht implementiert

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


        loggedInMainPage.manageCustomerButton.click();
    }
    @AfterEach
    public void tearDown(){
        loggedInMainPage.logoutButton.click();
    }


    //TAB-AVAIABILITY
    @Test
    public void isTabAddAvaiable(){
        manageCustomerPage.addTab.click();
    }
    @Test
    public void isTabEditAvaiable(){
        manageCustomerPage.editTab.click();
    }
    @Test
    public void isTabDeleteAvaiable(){
        manageCustomerPage.deleteTab.click();
    }
    @Test
    public void isTabShowAvaiable(){
        manageCustomerPage.showTab.click();
    }

    @Test
    public void addCustomerInformation(){
        manageCustomerPage.checkboxBusinessCustomer.click();
        manageCustomerPage.inputSurname.sendKeys(surname);
        manageCustomerPage.inputName.sendKeys(name);
        manageCustomerPage.inputStreet.sendKeys(street);
        manageCustomerPage.inputHouseNo.sendKeys(houseNo);
        manageCustomerPage.inputZipcode.sendKeys(zipcode);
        manageCustomerPage.inputCity.sendKeys(city);
        manageCustomerPage.inputPhone.sendKeys(phone);
        manageCustomerPage.inputMail.sendKeys(mail);

        manageCustomerPage.inputPaymethod.click();
        manageCustomerPage.inputPaymethodPayPal.click();
        manageCustomerPage.inputPaymethodPayPalAdressField.sendKeys(mail);

        //Checking ng-reflect-model for true -> weil dort der Checkbox-Status abrufbar ist
        $x("//*[@id='mat-checkbox-1']").shouldHave(attribute("ng-reflect-model", "true"));

        manageCustomerPage.inputSurname.shouldHave(attribute("value", surname));
        manageCustomerPage.inputName.shouldHave(attribute("value", name));
        manageCustomerPage.inputStreet.shouldHave(attribute("value", street));
        manageCustomerPage.inputHouseNo.shouldHave(attribute("value", houseNo));
        manageCustomerPage.inputZipcode.shouldHave(attribute("value", zipcode));
        manageCustomerPage.inputCity.shouldHave(attribute("value", city));
        manageCustomerPage.inputPhone.shouldHave(attribute("value", phone));
        manageCustomerPage.inputMail.shouldHave(attribute("value", mail));
        manageCustomerPage.inputPaymethodPayPalAdressField.shouldHave(attribute("value", mail));
        manageCustomerPage.inputPaymethod.shouldHave(Condition.text("PayPal"));

        manageCustomerPage.submitButton.click();
    }
    @Test
    public void isSearchWorkingInEditTab(){
        manageCustomerPage.editTab.click();
        manageCustomerPage.inputEditCustomerNo.clear();
        manageCustomerPage.inputEditCustomerNo.sendKeys("6");
        manageCustomerPage.searchButtonEdit.click();

        manageCustomerPage.inputEditSurname.shouldHave(attribute("value","Shigeru"));
        manageCustomerPage.inputEditMail.shouldHave(attribute("value","MarioMaker@shin.jp"));
        manageCustomerPage.inputEditStreet.shouldHave(attribute("value","Nintendoweg"));
    }

    @Test
    public void isEditingPossibleOnEditTab(){
        manageCustomerPage.editTab.click();
        manageCustomerPage.inputEditCustomerNo.clear();
        manageCustomerPage.inputEditCustomerNo.sendKeys("6");
        manageCustomerPage.searchButtonEdit.click();

        manageCustomerPage.inputEditName.clear();
        manageCustomerPage.inputEditName.sendKeys("Selachii");
        manageCustomerPage.inputEditPaymethod.click();
        manageCustomerPage.inputEditPaymethodEC.click();
        manageCustomerPage.inputEditPaymethodECField.clear();
        manageCustomerPage.inputEditPaymethodECField.sendKeys("DE90 1100 10000 4010");

        manageCustomerPage.inputEditSurname.shouldHave(attribute("value", "Shigeru"));
        manageCustomerPage.inputEditName.shouldHave(attribute("value", "Selachii"));
        manageCustomerPage.inputEditPaymethodECField.shouldHave(attribute("value", "DE90 1100 10000 4010"));
        manageCustomerPage.inputEditPaymethod.shouldHave(Condition.text("EC-Karte"));

        manageCustomerPage.inputEditPassword.sendKeys(strongPassword);
        manageCustomerPage.inputEditPasswordRepeat.sendKeys(strongPassword);

        manageCustomerPage.inputEditPassword.shouldHave(attribute("value",strongPassword));
        manageCustomerPage.inputEditPasswordRepeat.shouldHave(attribute("value",strongPassword));

        manageCustomerPage.submitButtonEdit.click();
    }
    @Test
    public void isSearchWorkingOnDeleteTab(){
        manageCustomerPage.deleteTab.click();
        manageCustomerPage.inputDeleteCustomerNo.clear();
        manageCustomerPage.inputDeleteCustomerNo.sendKeys("5");
        manageCustomerPage.searchButtonDelete.click();

        manageCustomerPage.customerInformationDeletion.shouldHave(
                Condition.text("Jonas"),
                Condition.text("Stenberg"),
                Condition.text("Gewinnerstraße"),
                Condition.text("bill"),
                Condition.text("Business-Kunde? Nein"),
                Condition.text("Kekslieferant400"));
    }
    @Test
    public void isDeletionWorking(){
        manageCustomerPage.deleteTab.click();
        manageCustomerPage.inputDeleteCustomerNo.clear();
        manageCustomerPage.inputDeleteCustomerNo.sendKeys("8");
        manageCustomerPage.searchButtonDelete.click();

        manageCustomerPage.releaseButtonToogleDeletion.click();

        manageCustomerPage.deletionButton.click();
    }

    @Test
    public void isSearchWorkingOnShowTab(){
        manageCustomerPage.showTab.click();
        manageCustomerPage.inputShowCustomerNo.clear();
        manageCustomerPage.inputShowCustomerNo.sendKeys("6");
        manageCustomerPage.searchButtonShow.click();

        manageCustomerPage.customerInformationShow.shouldHave(
                Condition.text("Shigeru"),
                Condition.text("MarioMaker@shin.jp"),
                Condition.text("Nintendoweg"),
                Condition.text("Hausnummer 14"),
                Condition.text("debit"),
                Condition.text("Business-Kunde? Ja"),
                Condition.text("FlodinWiesret"));
    }
}
