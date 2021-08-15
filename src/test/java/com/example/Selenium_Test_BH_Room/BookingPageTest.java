package com.example.Selenium_Test_BH_Room;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Condition.*;
import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Selenide.*;

public class BookingPageTest {
    BookingPage bookingPage = new BookingPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.startMaximized = true;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("http://localhost:4200/booking/1");
    }


    @Test
    public void isWritingPossibleToAllInput() {
        String name = "Lucifer";
        String surname = "Holger";
        String company= "Lange Industries GmbH" ;
        String mail = "Clownery@gmx.de";
        String phone = "0190123456";
        String testMonth = "Feb";
        String testYear = "2022";

        bookingPage.monthPicker.selectOption(testMonth);
        bookingPage.yearPicker.selectOption(testYear);

        bookingPage.startDate.click();
        bookingPage.endDate.click();

        bookingPage.inputName.sendKeys(name);
        bookingPage.inputSurname.sendKeys(surname);
        bookingPage.inputCompany.sendKeys(company);
        bookingPage.inputMail.sendKeys(mail);
        bookingPage.inputPhone.sendKeys(phone);

        bookingPage.inputName.shouldHave(attribute("value", name));
        bookingPage.inputSurname.shouldHave(attribute("value", surname));
        bookingPage.inputCompany.shouldHave(attribute("value", company));
        bookingPage.inputMail.shouldHave(attribute("value", mail));
        bookingPage.inputPhone.shouldHave(attribute("value", phone));

        //bookingPage.submitButton.click();
    }

    @Test
    public void clickPreviousAndNextMonth(){
        bookingPage.monthPicker.selectOption("Okt");

        bookingPage.leftArrowMonth.click();
        bookingPage.leftArrowMonth.click();

        bookingPage.monthPicker.shouldHave(Condition.text("Aug"));

        bookingPage.rightArrowMonth.click();

        bookingPage.monthPicker.shouldHave(Condition.text("Sep"));
    }

    @Test
    public void isCalendarValueSetAsSelected(){
        String testMonth = "Feb";
        String testYear = "2022";
        bookingPage.monthPicker.selectOption(testMonth);
        bookingPage.yearPicker.selectOption(testYear);

        //startDate ist immer die 2. Woche Montag -> endDate ist immer 3. Woche Donnerstag
        bookingPage.startDate.click();
        bookingPage.endDate.click();

        bookingPage.dateShower.shouldHave(Condition.text("07.02.2022"), Condition.text("18.02.2022"));
    }

}

