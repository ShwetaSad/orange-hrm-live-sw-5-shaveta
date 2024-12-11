package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlistener.CustomListener;
import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class DashBoardPage extends Utility {
    //- Dashboard text Locator
    //and create appropriate methods for it.

    @CacheLookup
            @FindBy(xpath = "//h6[@class=\"oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module\"]")
    WebElement dashboardText;

    public String getDashBoardText() {
        CustomListener.test.log(Status.PASS,"Dashboard Text");
        Reporter.log("Dashboard Text");
        return getTextFromElement(dashboardText);
    }



}
