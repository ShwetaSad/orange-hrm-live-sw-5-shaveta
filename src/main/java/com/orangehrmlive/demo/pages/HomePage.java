package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlistener.CustomListener;
import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class HomePage extends Utility {
    //- Store OrangeHRM logo, Admin, PIM, Leave,Dashboard, Welcome Text locatores
    //and create appropriate methods for it.

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()=\"Admin\"]")
    WebElement adminTab;

    @CacheLookup
    @FindBy(xpath = "//span[@class=\"oxd-text oxd-text--span oxd-main-menu-item--name\"][normalize-space()=\"PIM\"]")
    WebElement PIM;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder=\"Search\"]")
    WebElement searchLeft;

    @CacheLookup
    @FindBy(xpath = "//span[@class=\"oxd-text oxd-text--span oxd-main-menu-item--name\"][normalize-space()=\"Leave\"]")
    WebElement leave;

    @CacheLookup
    @FindBy(xpath = "//img[@alt=\"company-branding\"]")
    WebElement orangeLogo;

    @CacheLookup
    @FindBy(xpath = "//div[@class=\"orangehrm-login-logo\"]//img[@alt=\"orangehrm-logo\"]")
    WebElement anotherLogo;

    @CacheLookup
    @FindBy(xpath = "//p[@class=\"oxd-userdropdown-name\"]")
    WebElement userProfileLogo;


    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()=\"Logout\"]")
    WebElement logoutButton;

    @CacheLookup
    @FindBy(xpath = "//h5[@class=\"oxd-text oxd-text--h5 orangehrm-login-title\"]")
    WebElement loginText;


    public void clickOnAdmin() {
        clickOnElement(adminTab);
        CustomListener.test.log(Status.PASS,"clickOnAdmin");
        Reporter.log("clickOnAdmin");
    }

    public void getCurrectPage() {
        driver.getCurrentUrl();
        CustomListener.test.log(Status.PASS,"getCurrectPage");
        Reporter.log("getCurrectPage");
    }

    public String getOrangeLogo() {
        CustomListener.test.log(Status.PASS,"getOrangeLogo");
        Reporter.log("getOrangeLogo");
        return getTextFromElement(orangeLogo);
    }

    public String getAnothreLogo() {
        CustomListener.test.log(Status.PASS,"getAnothreLogo");
        Reporter.log("getAnothreLogo");
        return getTextFromElement(anotherLogo);
    }

    public void clickOnUserProfileLogo() {
        clickOnElement(userProfileLogo);
        CustomListener.test.log(Status.PASS,"clickOnUserProfileLogo");
        Reporter.log("clickOnUserProfileLogo");
    }

    public void mouseHoverAndClickOnLogoutButton() {
        mouseHoverToElementAndClick(logoutButton);
        CustomListener.test.log(Status.PASS,"mouseHoverAndClickOnLogoutButton");
        Reporter.log("mouseHoverAndClickOnLogoutButton");
    }

    public String getLoginText() {
        CustomListener.test.log(Status.PASS,"getLoginText");
        Reporter.log("getLoginText");
        return getTextFromElement(loginText);

    }


}
