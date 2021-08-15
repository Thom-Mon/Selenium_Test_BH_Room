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

public class conferenceRoomBookingPageTest {
    BookingPage bookingPage = new BookingPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.startMaximized = true;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("http://localhost:4200/booking/6");
    }


    @Test
    public void isWritingPossibleToAllInput() { //TODO: Werte ergänzen um wirklich Buchung zu testen
        String name = "Lucifer";
        String surname = "Holger";
        String company= "Lange Industries GmbH" ;
        String mail = "Clownery@gmx.de";
        String phone = "0190123456";

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
    public void isWritingPossibleToClock(){
        bookingPage.inputHourStart.clear();
        bookingPage.inputMinuteStart.clear();
        bookingPage.inputHourEnd.clear();
        bookingPage.inputMinuteEnd.clear();

        bookingPage.inputHourStart.sendKeys("12");
        bookingPage.inputMinuteStart.sendKeys("15");
        bookingPage.inputHourEnd.sendKeys("15");
        bookingPage.inputMinuteEnd.sendKeys("30");

        bookingPage.inputHourStart.shouldHave(attribute("value", "12"));
        bookingPage.inputMinuteStart.shouldHave(attribute("value", "15"));
        bookingPage.inputHourEnd.shouldHave(attribute("value", "15"));
        bookingPage.inputMinuteEnd.shouldHave(attribute("value", "30"));

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
    public void isDateSetAsSelected(){
        String testMonth = "Feb";
        String testYear = "2022";
        bookingPage.submitButton.click();
        bookingPage.monthPicker.selectOption(testMonth);
        bookingPage.yearPicker.selectOption(testYear);

        //startDate ist immer die 2. Woche Montag
        bookingPage.startDate.click();

        bookingPage.dateShower.shouldHave(Condition.text("07.02.2022"));
    }

    @Test
    public void isTimeSetAsSelected(){
        bookingPage.inputHourStart.clear();
        bookingPage.inputMinuteStart.clear();
        bookingPage.inputHourEnd.clear();
        bookingPage.inputMinuteEnd.clear();

        bookingPage.inputHourStart.sendKeys("12");
        bookingPage.inputMinuteStart.sendKeys("15");
        bookingPage.inputHourEnd.sendKeys("15");
        bookingPage.inputMinuteEnd.sendKeys("30");
        bookingPage.clockShower.click(); //dieser Click ist notwendig um die neue Eingabe zu übernehmen in die Anzeige bei Buchungsdetails


        bookingPage.clockShower.shouldHave(Condition.text("12:15"), Condition.text("15:30"));
    }

    @Test
    public void isClockChangingWithArrows(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bookingPage.inputHourStart.clear();
        bookingPage.inputMinuteStart.clear();
        bookingPage.inputHourEnd.clear();
        bookingPage.inputMinuteEnd.clear();

        bookingPage.inputHourStart.sendKeys("12");
        bookingPage.inputMinuteStart.sendKeys("15");
        bookingPage.inputHourEnd.sendKeys("15");
        bookingPage.inputMinuteEnd.sendKeys("30");
        bookingPage.clockShower.click();

        bookingPage.lowerArrowHoursStart.click();
        bookingPage.inputHourStart.shouldHave(attribute("value", "11"));
        bookingPage.lowerArrowMinutesStart.click();
        bookingPage.inputMinuteStart.shouldHave(attribute("value", "00"));

        bookingPage.upperArrowHoursStart.click();
        bookingPage.inputHourStart.shouldHave(attribute("value", "12"));
        bookingPage.upperArrowMinutesStart.click();
        bookingPage.inputMinuteStart.shouldHave(attribute("value", "15"));

        bookingPage.lowerArrowHoursEnd.click();
        bookingPage.inputHourEnd.shouldHave(attribute("value", "14"));
        bookingPage.lowerArrowMinutesEnd.click();
        bookingPage.inputMinuteEnd.shouldHave(attribute("value", "15"));

        bookingPage.upperArrowHoursEnd.click();
        bookingPage.inputHourEnd.shouldHave(attribute("value", "15"));
        bookingPage.upperArrowMinutesEnd.click();
        bookingPage.inputMinuteEnd.shouldHave(attribute("value", "30"));
    }




    //HELPER FUNCTIONS
    public String extractDateFromCalender(String startDate,String testYear){

        int i = 0;
        while (i < startDate.length() && !Character.isDigit(startDate.charAt(i))) i++;
        int j = i;
        while (j < startDate.length() && Character.isDigit(startDate.charAt(j))) j++;

        return Integer.parseInt(startDate.substring(i, j)) + ".02."+ testYear;
    }
}

