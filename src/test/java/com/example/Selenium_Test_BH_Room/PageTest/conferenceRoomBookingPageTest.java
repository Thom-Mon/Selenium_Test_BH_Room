package com.example.Selenium_Test_BH_Room.PageTest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;

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
    public void isBookingPossibleAsNewUser() { //TODO: Funktion muss noch implementiert werden
        String name = "Luciferius";
        String surname = "Hogland";
        String company= "Lange Industries GmbH" ;
        String mail = "Clownery@gmx.de";
        String phone = "+490190123456";
        String testMonth = "Jan";
        String testYear = "2022";
        String street = "Teststraße";
        String houseNo = "4";
        String zipcode = "99610";
        String city = "Sömmerda";
        String paymethod = "Debit";
        String iban = "DE12 2345 6789 1011";
        String specialWishes = "Buchung Konferenzraum - unangemeldet - als Test vom Holger Lucifer - DEV-Notes";

        bookingPage.buttonBusinessCustomer.click();

        bookingPage.monthPicker.selectOption(testMonth);
        bookingPage.yearPicker.selectOption(testYear);

        bookingPage.startDate.click();


        bookingPage.inputSurname.sendKeys(surname);
        bookingPage.inputName.sendKeys(name);
        bookingPage.inputCompany.sendKeys(company);
        bookingPage.inputMail.sendKeys(mail);
        bookingPage.inputPhone.sendKeys(phone);

        bookingPage.inputStreet.sendKeys(street);
        bookingPage.inputStreetNo.sendKeys(houseNo);
        bookingPage.inputZipcode.sendKeys(zipcode);
        bookingPage.inputCity.sendKeys(city);
        bookingPage.dropDownPaymentMethod.selectOption(paymethod);
        bookingPage.inputIban.sendKeys(iban);
        bookingPage.inputSpecialWishes.sendKeys(specialWishes);

        bookingPage.inputName.shouldHave(attribute("value", name));
        bookingPage.inputSurname.shouldHave(attribute("value", surname));
        bookingPage.inputCompany.shouldHave(attribute("value", company));
        bookingPage.inputMail.shouldHave(attribute("value", mail));
        bookingPage.inputPhone.shouldHave(attribute("value", phone));
        bookingPage.inputStreet.shouldHave(attribute("value", street));
        bookingPage.inputStreetNo.shouldHave(attribute("value", houseNo));
        bookingPage.inputZipcode.shouldHave(attribute("value", zipcode));
        bookingPage.inputCity.shouldHave(attribute("value", city));
        bookingPage.dropDownPaymentMethod.shouldHave(attribute("value", "debit"));
        bookingPage.inputIban.shouldHave(attribute("value", iban));
        bookingPage.inputSpecialWishes.shouldHave(attribute("value", specialWishes));

        bookingPage.submitButton.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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

        bookingPage.dateShowerStart.shouldHave(Condition.text("07.02.2022"));
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
        bookingPage.bookingDetailsCard.click(); //dieser Click ist notwendig um die neue Eingabe zu übernehmen in die Anzeige bei Buchungsdetails


        bookingPage.bookingDetailsCard.shouldHave(Condition.text("12:15"), Condition.text("15:30"));
    }

    @Test
    public void isClockChangingWithArrows(){

        bookingPage.inputHourStart.clear();
        bookingPage.inputMinuteStart.clear();
        bookingPage.inputHourEnd.clear();
        bookingPage.inputMinuteEnd.clear();

        bookingPage.inputHourStart.sendKeys("12");
        bookingPage.inputMinuteStart.sendKeys("15");
        bookingPage.inputHourEnd.sendKeys("15");
        bookingPage.inputMinuteEnd.sendKeys("30");
        bookingPage.bookingDetailsCard.click();

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

}

