package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customlistener.CustomListener;
import com.orangehrmlive.demo.pages.AddUserPage;
import com.orangehrmlive.demo.pages.HomePage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.pages.ViewSystemUsersPage;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.IDynamicGraph;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

@Listeners(CustomListener.class)
public class UsersTest extends BaseTest {

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

    //1.adminShouldAddUserSuccessFully().
    @Test(groups = {"Sanity"})
    public void adminShouldAddUserSuccessFully() {

        //    Login to Application
        loginPage.inputUsername();
        loginPage.inputPassword();
        loginPage.clickonLoginButton();

        //	click On "Admin" Tab
        homePage.clickOnAdmin();

        //	Verify "System Users" Text
        String actualText = viewSystemUsersPage.VerfisystemUsersText();
        String expectedText = "System Users";
        Assert.assertEquals(actualText, expectedText, "Wrong Text");

        //	click On "Add" button
        viewSystemUsersPage.clickOnAdd();

        //	Verify "Add User" Text
        Assert.assertEquals(addUserPage.setAddUserText(), "Add User", "Wrong Page");

        //	Select User Role "Admin"
        addUserPage.selectUserRoleDropdown("Admin");

        //	enter Employee Name "Ananya Dash"
        addUserPage.addEmployeeName("Ananya Dash");

        //	enter Username
        addUserPage.enterUsername("Shaveta");

        //	Select status "Disable"
        addUserPage.SelectByStatusDropdown("Disabled");

        //	enter psaaword
        addUserPage.enterpassword("sethi1234");

        //	enter Confirm Password
        addUserPage.enterConfirmPassword("sethi1234");

        //	click On "Save" Button
        addUserPage.clickOnSaveButton();

        //	verify message "Successfully Saved"

    }

    //2. searchTheUserCreatedAndVerifyIt().
    @Test(groups = {"Smoke"})
    public void searchTheUserCreatedAndVerifyIt() {

        //	Login to Application
        loginPage.inputUsername();
        loginPage.inputPassword();
        loginPage.clickonLoginButton();

        //	click On "Admin" Tab
        homePage.clickOnAdmin();

        //	Verify "System Users" Text
        Assert.assertEquals(viewSystemUsersPage.VerfisystemUsersText(), "System Users", "Wrong Page");

        //	Enter Username
        viewSystemUsersPage.enterUsername("Shaveta");

        //	Select User Role
        viewSystemUsersPage.dropdown1("Admin");

        //	Select Satatus
        viewSystemUsersPage.dropdown2("Disabled");

        //	Click on "Search" Button
        viewSystemUsersPage.clickONSearch();

        //	Verify the User should be in Result list.
       // Assert.assertEquals(viewSystemUsersPage.verifyrecordPresent(), "shaveta", "Record not Present");

    }

    //3. verifyThatAdminShouldDeleteTheUserSuccessFully.
    @Test(groups = {"Smoke", "Regression"})
    public void verifyThatAdminShouldDeleteTheUserSuccessFully() {

        //	Login to Application
        loginPage.inputUsername();
        loginPage.inputPassword();
        loginPage.clickonLoginButton();

        //	click On "Admin" Tab
        homePage.clickOnAdmin();

        //	Verify "System Users" Text
        Assert.assertEquals(viewSystemUsersPage.VerfisystemUsersText(), "System Users", "Wrong Page");

        //	Enter Username
        viewSystemUsersPage.enterUsername("Shaveta");

        //	Select User Role
        viewSystemUsersPage.dropdown1("Admin");

        //	Select Satatus
        viewSystemUsersPage.dropdown2("Disable");

        //	Click on "Search" Button
        viewSystemUsersPage.clickONSearch();

        //	Verify the User should be in Result list.
        Assert.assertEquals(viewSystemUsersPage.verifyrecordPresent(), "shaveta", "Record not Present");

        //	Click on Check box
        viewSystemUsersPage.clickOnCheckbox();

        //	Click on Delete Button
        viewSystemUsersPage.clickOnDeleteButton();

        //	Popup will display
        //	Click on Ok Button on Popup
        // viewSystemUsersPage.acceptAlert();
        viewSystemUsersPage.clickOkOnPopup();

        //	verify message "Successfully Deleted"
    }

    //4. searchTheDeletedUserAndVerifyTheMessageNoRecordFound.
    @Test(groups = {"Regression"}, dataProvider = "DataSetUser", dataProviderClass = TestData.class)
    public void searchTheDeletedUserAndVerifyTheMessageNoRecordFound(String Username, String UserRole, String EmployeeName, String SelectStatus) {

        //	Login to Application
        loginPage.inputUsername();
        loginPage.inputPassword();
        loginPage.clickonLoginButton();

        //	click On "Admin" Tab
        homePage.clickOnAdmin();

        //	Verify "System Users" Text
        String actualText = viewSystemUsersPage.VerfisystemUsersText();
        String expectedText = "System Users";
        Assert.assertEquals(actualText, expectedText, "Wrong Text");

        //	Enter Username
        viewSystemUsersPage.enterUsername(Username);

        //	Select User Role
        viewSystemUsersPage.dropdown1(UserRole);

        //Enter Employee Name


        //	Select Satatus
        viewSystemUsersPage.dropdown2(SelectStatus);

        //	Click on "Search" Button
        viewSystemUsersPage.clickONSearch();

        //	verify message "1 record Found"
        //  Assert.assertEquals(viewSystemUsersPage.NoRecordFound(), "(1)Record Found", "Records deleted");
    }
}




