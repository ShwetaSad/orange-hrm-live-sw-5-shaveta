package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlistener.CustomListener;
import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class ViewSystemUsersPage extends Utility {

    //System Users Text, Username Field, User Roll dropDown,
    //Employee Name Field,
    //Status Drop Down, Search Button, Reset Button, Add Button and Delete Button locators and it's actions

    @CacheLookup
    @FindBy(xpath = "//h5[@class=\"oxd-text oxd-text--h5 oxd-table-filter-title\"]")
    WebElement systemUsersText;

    @CacheLookup
    @FindBy(xpath = "//div[@class=\"oxd-input-group oxd-input-field-bottom-space\"]//div//input[@class=\"oxd-input oxd-input--active\"]")
    WebElement Username;


    @CacheLookup
    @FindBy(xpath = "//body/div[@id=\"app\"]/div[@class=\"oxd-layout orangehrm-upgrade-layout\"]/div[@class=\"oxd-layout-container\"]/div[@class=\"oxd-layout-context\"]/div[@class=\"orangehrm-background-container\"]/div[@class=\"oxd-table-filter\"]/div[@class=\"oxd-table-filter-area\"]/form[@class=\"oxd-form\"]/div[@class=\"oxd-form-row\"]/div[@class=\"oxd-grid-4 orangehrm-full-width-grid\"]/div[2]/div[1]/div[2]/div[1]/div[1]")
            WebElement UserRollDropdown;


    @CacheLookup
    @FindBy(xpath = "//input[@placeholder=\"Type for hints...\"]")
    WebElement employeeNameField;


    @CacheLookup
    @FindBy(xpath = "//body/div[@id=\"app\"]/div[@class=\"oxd-layout orangehrm-upgrade-layout\"]/div[@class=\"oxd-layout-container\"]/div[@class=\"oxd-layout-context\"]/div[@class=\"orangehrm-background-container\"]/div[@class=\"oxd-table-filter\"]/div[@class=\"oxd-table-filter-area\"]/form[@class=\"oxd-form\"]/div[@class=\"oxd-form-row\"]/div[@class=\"oxd-grid-4 orangehrm-full-width-grid\"]/div[4]/div[1]/div[2]/div[1]/div[1]")
            WebElement statusDropdown;

    @CacheLookup
    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement search;


    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()=\"Reset\"]")
            WebElement resetButton;


    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()=\"Add\"]")
    WebElement addButton;

    @CacheLookup
    @FindBy(xpath = "//div[@role=\"table\"]//div[1]//div[1]//div[6]//div[1]//button[1]//i[1]")
            WebElement deleteButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class=\"oxd-table-card-cell-checkbox\"]//i[@class=\"oxd-icon bi-check oxd-checkbox-input-icon\"]")
    WebElement checkbox;


    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()=\"Yes, Delete\"]")
            WebElement OkOnPopup;


    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()=\"No Records Found\"]")
    WebElement noRecordfoText;


    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),\"shaveta\")]")
            WebElement shavetaText;


    public String VerfisystemUsersText() {
        CustomListener.test.log(Status.PASS,"VerfisystemUsersText");
        Reporter.log("VerfisystemUsersText");
        return getTextFromElement(systemUsersText);

    }

    public void clickOnAdd() {
        clickOnElement(addButton);
        CustomListener.test.log(Status.PASS,"clickOnAdd");
        Reporter.log("clickOnAdd");
    }

    public void enterUsername(String name) {
        sendTextToElement(Username, name);
        CustomListener.test.log(Status.PASS,"enterUsername");
        Reporter.log("enterUsername");
    }

    public void dropdown1(String role) {

            mouseHoverToElementAndClick(UserRollDropdown);
            typeKeysAndEnter(role.split("")[0]);
            Reporter.log("Select User roles "+ UserRollDropdown.toString()+" as "+role);
            CustomListener.test.log(Status.PASS,"Select the user role as "+role);

        }



    public void dropdown2(String role) {
        mouseHoverToElementAndClick(statusDropdown);
        typeKeysAndEnter(role.split("")[0]);
        Reporter.log("Select User roles "+ statusDropdown.toString()+" as "+role);
        CustomListener.test.log(Status.PASS,"Select the user role as "+role);


    }

    public void enterEmployee(String employeename) {
        sendTextToElement(employeeNameField, employeename);
        CustomListener.test.log(Status.PASS,"enterEmployee");
        Reporter.log("enterEmployee");
    }

    public void clickONSearch() {
        clickOnElement(search);
        CustomListener.test.log(Status.PASS,"clickONSearch");
        Reporter.log("clickONSearch");

    }

    public String verifyrecordPresent() {
        CustomListener.test.log(Status.PASS,"verifyrecordPresent");
        Reporter.log("verifyrecordPresent");
        return getTextFromElement(shavetaText);

    }

    public void clickOnDeleteButton() {
        clickOnElement(deleteButton);
        CustomListener.test.log(Status.PASS,"clickOnDeleteButton");
        Reporter.log("clickOnDeleteButton");
    }

    public void clickOnCheckbox() {
        clickOnElement(checkbox);
        CustomListener.test.log(Status.PASS,"clickOnCheckbox");
        Reporter.log("clickOnCheckbox");
    }

    public void clickOkOnPopup() {
        clickOnElement(OkOnPopup);
        CustomListener.test.log(Status.PASS,"clickOkOnPopup");
        Reporter.log("clickOkOnPopup");
    }

    // public void clickOKOnPopup(){
    // acceptAlert();
    // }

    public String NoRecordFound() {
        CustomListener.test.log(Status.PASS,"NoRecordFound");
        Reporter.log("NoRecordFound");
        return getTextFromElement(noRecordfoText);

    }


}
