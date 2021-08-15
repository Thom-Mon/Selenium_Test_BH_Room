package com.example.Selenium_Test_BH_Room;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
public class LoginPage {
    public SelenideElement loginButton = $x("/html/body/app-root/div/div[2]/ng-component/div/div/div/form/div/button");
    public SelenideElement forceLoginButton = $x("/html/body/app-root/div/div[2]/ng-component/div/div/div/button");

    public SelenideElement registerButton = $x("/html/body/app-root/div/div[2]/ng-component/div/div/div/form/div/a");
    public SelenideElement usernameErrorMessage = $x("/html/body/app-root/div/div[2]/ng-component/div/div/div/form/div[1]");
    public SelenideElement passwordErrorMessage = $x("/html/body/app-root/div/div[2]/ng-component/div/div/div/form/div[2]");
    public SelenideElement inputUsername = $x("/html/body/app-root/div/div[2]/ng-component/div/div/div/form/div/input[1]");
    public SelenideElement inputPassword = $x("/html/body/app-root/div/div[2]/ng-component/div/div/div/form/div[2]/input");

}
