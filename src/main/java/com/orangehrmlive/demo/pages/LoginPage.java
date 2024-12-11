package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlistener.CustomListener;
import com.orangehrmlive.demo.utilities.Utility;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import java.security.cert.X509Certificate;

public class LoginPage extends Utility {
    //- Store username, password, Login Button and LOGIN Panel text Locators
    //and create appropriate methods for it.

    @CacheLookup
    @FindBy(xpath = "//body/div[@id='app']/div[@class='orangehrm-login-layout']/div[@class='orangehrm-login-layout-blob']/div[@class='orangehrm-login-container']/div[@class='orangehrm-login-slot-wrapper']/div[@class='orangehrm-login-slot']/div[@class='orangehrm-login-form']/form[@class='oxd-form']/div[1]/div[1]/div[2]/input[1]")
    WebElement usernamefield;

    @CacheLookup
    @FindBy(xpath = "//input[@type='password']")
    WebElement passwordfield;

    @CacheLookup
    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//p[@class=\"oxd-text oxd-text--p oxd-alert-content-text\"]")
    WebElement InvalidCredentials;

    @CacheLookup
    @FindBy(xpath = "//div[@class=\"orangehrm-login-slot-wrapper\"]//div[1]//div[1]//span[1]")
    WebElement requiredErrorMessg;

    public void inputUsername() {
        sendTextToElement(usernamefield, "Admin");
        CustomListener.test.log(Status.PASS, "inputUsername");
        Reporter.log("inputUsername");
    }

    public void inputPassword() {
        sendTextToElement(passwordfield, "admin123");
        CustomListener.test.log(Status.PASS, "inputPassword");
        Reporter.log("inputPassword");
    }

    public void inputUsername(String Usename) {
        sendTextToElement(usernamefield, Usename);
        CustomListener.test.log(Status.PASS, "inputUsername");
        Reporter.log("inputUsername");
    }

    public void inputPassword(String Password) {
        sendTextToElement(passwordfield, Password);
        CustomListener.test.log(Status.PASS, "inputPassword");
        Reporter.log("inputPassword");
    }

    public void clickonLoginButton() {
        clickOnElement(loginButton);
        CustomListener.test.log(Status.PASS, "clickonLoginButton");
        Reporter.log("clickonLoginButton");
    }

    public void VerifyerrorMessage(String errormessage) {
        Assert.assertEquals(getTextFromElement(InvalidCredentials), errormessage, " InValid errorMessage");
    }

    public void VerifyRequirederroeMsg(String required) {
        Assert.assertEquals(getTextFromElement(requiredErrorMessg), required, " InValid errorMessage");
    }
}



