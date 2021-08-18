package com.example.Selenium_Test_BH_Room;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;

import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class LoginPageTest {
    LoginPage loginPage = new LoginPage();
    LoggedInMainPage loggedInMainPage = new LoggedInMainPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.startMaximized = true;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("http://localhost:4200/login");
    }

    @Test
    public void isErrorMessagePresentWithNoEntry() {
        loginPage.loginButton.click();
        loginPage.passwordErrorMessage.shouldHave(Condition.text("Bitte Passswort eingeben")); //Passswort => !sic
        loginPage.usernameErrorMessage.shouldHave(Condition.text("Bitte Username eingeben"));
    }

    @Test
    public void clickRegisterButton() {
        loginPage.registerButton.click();
        $x("/html/body/app-root/div/div[2]/app-registration").shouldBe(visible);
    }

    @Test
    public void loginToRoommanagerAsEmployee(){
        loginPage.inputUsername.sendKeys("FlodinWiesret");
        loginPage.inputPassword.sendKeys("SicheresPasswort");
        loginPage.loginButton.click();
        loggedInMainPage.logoutButton.shouldBe(visible);
        loggedInMainPage.logoutButton.click();

        //TODO: Login überwachen -> Zugang muss bei richtigen Daten gehen, ansonsten verweigert werden mit entsprechender Meldung
    }

    @Test
    public void checkErrorMessageWrongInputs(){
        loginPage.inputUsername.sendKeys("FlodinWiesret");
        loginPage.inputPassword.sendKeys("falschesPasswort");
        loginPage.loginButton.click();
        $x("//div[text()='Username oder Passwort falsh']").shouldBe(visible); //TODO: falsh -> falsch !sic
    }

    //div[text()='Username oder Passwort falsh']





}
