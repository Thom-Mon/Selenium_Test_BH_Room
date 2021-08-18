package com.example.Selenium_Test_BH_Room.PageTest;

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
    LoggedInMainPage loggedInMainPage = new LoggedInMainPage();
    String name = "Konquistator";
    String surname = "Selen";
    String company = "Register-Test Corp.";
    String mail = "register_me@googlemail.com";
    String phone = "+490167171717";
    String username = "BennoGroß4";
    String usernameInUse= "IggyPop";
    String password = "SicheresPasswort";
    String invalidMail= "asd";


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
    public void clickCancelButton() {
        registerPage.cancelButton.click();
        $x("/html/body/app-root/div/div[2]/ng-component/div/div/h4[contains(text(),'Login')]").shouldBe(visible);
    }

    @Test
    public void registerNewUser(){
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

        registerPage.registerbutton.click();

        registerPage.bookingButton.shouldBe(visible);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        loggedInMainPage.logoutButton.click();
    }
    //TODO: Login überwachen -> Zugang muss bei richtigen Daten gehen, ansonsten verweigert werden mit entsprechender Meldung
    //TODO: Allgemein noch die Fehlerabfragen auf Richtigkeit überprüfen!
    @Test
    public void sameUserNameShouldBeImpossible(){
        registerPage.inputName.sendKeys(name);
        registerPage.inputSurname.sendKeys(surname);
        registerPage.buttonBusinessCustomer.click();
        registerPage.inputCompany.sendKeys(company);
        registerPage.inputMail.sendKeys(mail);
        registerPage.inputPhone.sendKeys(phone);
        registerPage.inputUsername.sendKeys(usernameInUse);
        registerPage.inputPassword.sendKeys(password);
        registerPage.inputPasswordRepeat.sendKeys(password);

        registerPage.registerbutton.click();

        $x("//div[text()='Username bereits vergeben']").shouldBe(visible);

    }

    @Test
    public void checkErrorMessagesOnEmpty(){
        registerPage.registerbutton.click();
        $x("//div[text()='Bitte Vorname angeben']").shouldBe(visible);
        $x("//div[text()='Bitte Nachname angeben']").shouldBe(visible);
        $x("//div[text()='Bitte Email-Adresse angeben']").shouldBe(visible);
        $x("//div[text()='Bitte Username angeben']").shouldBe(visible);
        $x("//div[text()='Bitte Passwort angeben']").shouldBe(visible);
        $x("//div[text()='Bitte Passwort wiederholen']").shouldBe(visible);
    }

    @Test
    public void checkErrorMessageOnInvalidEntries(){
        registerPage.inputMail.sendKeys(invalidMail);
        registerPage.registerbutton.click();
        $x("//div[text()='Ungültiges Emailformat']").shouldBe(visible);
        registerPage.inputPassword.sendKeys("asd");
        $x("//div[text()='Passwort muss mindesten 10 Zeichen lang sein']").shouldBe(visible);
        registerPage.inputPasswordRepeat.sendKeys("as");
        $x("//div[text()='Passwort nicht identisch']").shouldBe(visible);
    }


}
