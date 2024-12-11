package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlistener.CustomListener;
import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AddUserPage extends Utility {
    //User Role Drop Down, Employee Name, Username, Status Drop Down,
    //Password, Confirm Password,
    //Save and Cancle Button Locators and it's actions

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-select-text oxd-select-text--active']")
    WebElement userRoleDropdown;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder=\"Type for hints...\"]")
    WebElement employeename;


    @CacheLookup
    @FindBy(xpath = "//div[@class=\"oxd-form-row\"]//div[@class=\"oxd-grid-2 orangehrm-full-width-grid\"]//div[@class=\"oxd-grid-item oxd-grid-item--gutters\"]//div[@class=\"oxd-input-group oxd-input-field-bottom-space\"]//div//input[@class=\"oxd-input oxd-input--active\"]")
    WebElement username;


    @CacheLookup
    @FindBy(xpath = "//body/div[@id=\"app\"]/div[@class=\"oxd-layout orangehrm-upgrade-layout\"]/div[@class=\"oxd-layout-container\"]/div[@class=\"oxd-layout-context\"]/div[@class=\"orangehrm-background-container\"]/div[@class=\"orangehrm-card-container\"]/form[@class=\"oxd-form\"]/div[@class=\"oxd-form-row\"]/div[@class=\"oxd-grid-2 orangehrm-full-width-grid\"]/div[3]/div[1]/div[2]/div[1]/div[1]")
    WebElement stausDropdown;


    @CacheLookup
    @FindBy(xpath = "//div[@class=\"oxd-grid-item oxd-grid-item--gutters user-password-cell\"]//div[@class=\"oxd-input-group oxd-input-field-bottom-space\"]//div//input[@type=\"password\"]")
    WebElement password;


    @CacheLookup
    @FindBy(xpath = "//div[@class=\"oxd-grid-item oxd-grid-item--gutters\"]//div[@class=\"oxd-input-group oxd-input-field-bottom-space\"]//div//input[@type=\"password\"]")
    WebElement confirmPassword;


    @CacheLookup
    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement save;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()=\"Cancel\"]")
    WebElement cancel;

    @CacheLookup
    @FindBy(xpath = "//h6[@class=\"oxd-text oxd-text--h6 orangehrm-main-title\"]")
    WebElement addUserText;


    public void SelectByStatusDropdown(String role) {

        mouseHoverToElementAndClick(stausDropdown);
        typeKeysAndEnter(role.split("")[0]);
        Reporter.log("Select User roles " + role);
        CustomListener.test.log(Status.PASS, "Select the user role as " + role);
    }


    public void addEmployeeName(String name) {
        sendTextToElement(employeename, name);
        CustomListener.test.log(Status.PASS, "Add Employee Name");
        Reporter.log("Add Employee Name");


    }

    public void enterUsername(String Username) {
        sendTextToElement(username, Username);
        CustomListener.test.log(Status.PASS, "Enter UserName");
        Reporter.log("enter Username");

    }

    public void selectUserRoleDropdown(String role) {
        mouseHoverToElementAndClick(userRoleDropdown);
        typeKeysAndEnter(role.split("")[0]);
        Reporter.log("Select User roles " + role);
        CustomListener.test.log(Status.PASS, "Select the user role as " + role);
    }


    public void enterpassword(String Password) {
        sendTextToElement(password, Password);
        CustomListener.test.log(Status.PASS, "Enter Password");
        Reporter.log("Enter Password");

    }

    public void enterConfirmPassword(String Confirmpassword) {
        sendTextToElement(confirmPassword, Confirmpassword);
        CustomListener.test.log(Status.PASS, "Confirm Password");
        Reporter.log("Confirm Password");

    }

    public void clickOnSaveButton() {
        clickOnElement(save);
        CustomListener.test.log(Status.PASS, "Click on Save Button");
        Reporter.log("Click on Save Button");
    }

    public String setAddUserText() {
        CustomListener.test.log(Status.PASS, "Add User Text");
        Reporter.log("Add User Text");
        return getTextFromElement(addUserText);

    }

}
