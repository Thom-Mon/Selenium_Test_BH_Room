package com.example.Selenium_Test_BH_Room.PageTest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;

import static com.codeborne.selenide.Selenide.*;

public class BookingPageTest {
    BookingPage bookingPage = new BookingPage();
    MainPage mainPage = new MainPage();
    RoomPage roomPage = new RoomPage();
    LoginPage loginPage = new LoginPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.startMaximized = true;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {

        open("http://localhost:4200");
        mainPage.navitemRooms.click();
        roomPage.hotelroomTab.click();
        roomPage.hotelRoomBookingButton.click();
    }




    @Test
    public void isBookingpossibleAsNewUser() {

        String name = "Lucyius";
        String surname = "Holger";
        String company= "Lange Industries GmbH" ;
        String mail = "Clownery@gmx.de";
        String phone = "+490190123456";
        String testMonth = "Feb";
        String testYear = "2022";
        String street = "Teststraße";
        String houseNo = "4";
        String zipcode = "99610";
        String city = "Sömmerda";
        String paymethod = "Debit";
        String iban = "DE12 2345 6789 1011";
        String specialWishes = "Buchung unangemeldet - als Test vom Holger Lucifer - DEV-Notes";

        bookingPage.buttonBusinessCustomer.click();

        bookingPage.monthPicker.selectOption(testMonth);
        bookingPage.yearPicker.selectOption(testYear);

        bookingPage.startDate.click();
        bookingPage.endDate.click();

        bookingPage.inputSurname.sendKeys(surname);
        bookingPage.inputName.clear();
        bookingPage.inputCompany.sendKeys(company);
        bookingPage.inputMail.sendKeys(mail);
        bookingPage.inputPhone.sendKeys(phone);
        bookingPage.inputName.sendKeys(name);
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

        bookingPage.inputName.click();
        bookingPage.submitButton.click();

    }

    @Test
    public void isBookingPossibleAsLoggedInUser(){
        String testMonth = "Mär";
        String testYear = "2022";

        mainPage.navitemLogin.click();
        loginPage.inputUsername.sendKeys("IggyPop");
        loginPage.inputPassword.sendKeys("SicheresPasswort");
        loginPage.loginButton.click();
        mainPage.navitemRooms.click();
        roomPage.hotelroomTab.click();
        roomPage.hotelRoomBookingButton.click();

        bookingPage.inputSpecialWishes.sendKeys("IggyPop möchte ganz vorne sitzen");
        bookingPage.monthPicker.selectOption(testMonth);
        bookingPage.yearPicker.selectOption(testYear);
        bookingPage.startDate.click();
        bookingPage.endDate.click();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bookingPage.submitButton.click();

        mainPage.logoutButton.click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void canUserSeeBooking(){
        mainPage.navitemLogin.click();
        loginPage.inputUsername.sendKeys("IggyPop");
        loginPage.inputPassword.sendKeys("SicheresPasswort");
        loginPage.loginButton.click();
        bookingPage.buttonBooking.click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        $x("//p").shouldHave(Condition.text("booking-viewer works!"));
        mainPage.logoutButton.click();
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

        bookingPage.dateShowerStart.shouldHave(Condition.text("07.02.2022"),Condition.text("19.02.2022"));

    }

}

