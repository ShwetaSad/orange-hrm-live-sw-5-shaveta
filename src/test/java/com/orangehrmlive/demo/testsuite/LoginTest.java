package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customlistener.CustomListener;
import com.orangehrmlive.demo.pages.AddUserPage;
import com.orangehrmlive.demo.pages.HomePage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.pages.ViewSystemUsersPage;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

@Listeners(CustomListener.class)
public class LoginTest extends BaseTest {
    AddUserPage addUserPage;
    ViewSystemUsersPage viewSystemUsersPage;
    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        addUserPage = new AddUserPage();
        viewSystemUsersPage = new ViewSystemUsersPage();
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    //1. verifyUserShouldLoginSuccessFully()
    @Test(groups = {"Sanity"})
    public void verifyUserShouldLoginSuccessFully() {

        //   Enter username
        loginPage.inputUsername();

        //   Enter password
        loginPage.inputPassword();

        //   Click on Login Button
        loginPage.clickonLoginButton();

        //   Verify "Welcome" Message


    }

    //2. VerifyThatTheLogoDisplayOnLoginPage()
    @Test(groups = {"Smoke"})
    public void VerifyThatTheLogoDisplayOnLoginPage() {

        //   Launch the application
        homePage.getCurrectPage();

        //   Verify Logo is Displayed
        Assert.assertEquals(homePage.getOrangeLogo(), "", "Wrong Page");
        //   Assert.assertEquals(homePage.getAnothreLogo(),"","Wrong Page");
        //
    }

    //3. VerifyUserShouldLogOutSuccessFully()
    @Test(groups = {"Smoke", "Regression"})
    public void VerifyUserShouldLogOutSuccessFully() {
        //   Login To The application
        loginPage.inputUsername();
        loginPage.inputPassword();
        loginPage.clickonLoginButton();

        //   Click on User Profile logo
        homePage.clickOnUserProfileLogo();

        //   Mouse hover on "Logout" and click
        homePage.mouseHoverAndClickOnLogoutButton();

        //   Verify the text "Login Panel" is displayed
        //   Assert.assertEquals(homePage.getLoginText(),"Login","Wrong Page");

    }

    //4. verifyErrorMessageWithInvalidCredentials()
    @Test(groups = {"Regression"}, dataProvider = "credentials", dataProviderClass = TestData.class)
    public void verifyErrorMessageWithInvalidCredentials(String Username, String Password, String errorMessage) {
        //Enter username <username>
        loginPage.inputUsername(Username);
        //Enter password <password>
        loginPage.inputPassword(Password);
        //Click on Login Button
        loginPage.clickonLoginButton();
        //Verify Error message <errorMessage>
        if(errorMessage == "Required"){
            loginPage.VerifyRequirederroeMsg(errorMessage);
        }else {
            loginPage.VerifyerrorMessage(errorMessage);

        }
    }

}

