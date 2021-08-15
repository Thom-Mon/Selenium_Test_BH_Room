package com.example.Selenium_Test_BH_Room;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;

import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class RegisterPageTest {
    RegisterPage registerPage = new RegisterPage();
    String name = "Konquistator";
    String surname = "Selen";
    String company = "Register-Test Corp.";
    String mail = "register_me@googlemail.com";
    String phone = "0167 - 17 17 17";
    String username = "BennoGroß";
    String password = "signal714-";
    String passwordrepeat = "nomatch"; //für Falscheingabetests reserviert!

    @BeforeAll
    public static void setUpAll() {
        //Configuration.browserSize = "1280x900"; //Höhe wurde angepasst weil Elemente in Register -> Registrierung + Cancal nicht anklickbar waren
        Configuration.startMaximized = true;
        SelenideLogger.addListener("allure", new AllureSelenide());

    }

    @BeforeEach
    public void setUp() {
        open("http://localhost:4200/register");
    }

    @Test
    public void isErrorMessagePresentWithNoEntry() {
        //loginPage.loginButton.click();
        //loginPage.passwordErrorMessage.shouldBe(visible);
        //loginPage.usernameErrorMessage.shouldBe(visible);
    }

    @Test
    public void clickRegisterButton() { //TODO: Mit Regisrierung verbinden!!!
        registerPage.registerbutton.click();
        //$x("/html/body/app-root/app-registration").shouldBe(visible);
    }

    @Test
    public void clickCancelButton() {
        registerPage.cancelButton.click();
        $x("/html/body/app-root/div/div[2]/ng-component/div/div/h4[contains(text(),'Login')]").shouldBe(visible);
    }

    @Test
    public void loginToRoommanagerAsEmployee(){
        registerPage.inputName.sendKeys(name);
        registerPage.inputSurname.sendKeys(surname);
        registerPage.buttonBusinessCustomer.click();
        registerPage.inputCompany.sendKeys(company);
        registerPage.inputMail.sendKeys(mail);
        registerPage.inputPhone.sendKeys(phone);
        registerPage.inputUsername.sendKeys(username);
        registerPage.inputPassword.sendKeys(password);
        registerPage.inputPasswordRepeat.sendKeys(password);

        registerPage.inputName.shouldHave(attribute("value", name));
        registerPage.inputSurname.shouldHave(attribute("value",   surname));
        registerPage.inputCompany.shouldHave(attribute("value",   company));
        registerPage.inputMail.shouldHave(attribute("value",   mail));
        registerPage.inputPhone.shouldHave(attribute("value",   phone));
        registerPage.inputUsername.shouldHave(attribute("value",   username));
        registerPage.inputPassword.shouldHave(attribute("value",   password));
        registerPage.inputPasswordRepeat.shouldHave(attribute("value",   password));

        //registerPage.registerbutton.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
    //TODO: Login überwachen -> Zugang muss bei richtigen Daten gehen, ansonsten verweigert werden mit entsprechender Meldung
    //TODO: Allgemein noch die Fehlerabfragen auf Richtigkeit überprüfen!




}
