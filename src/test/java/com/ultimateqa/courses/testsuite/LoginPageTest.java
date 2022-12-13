package com.ultimateqa.courses.testsuite;

import com.ultimateqa.courses.customlisteners.CustomListeners;
import com.ultimateqa.courses.pages.LoginPage;
import com.ultimateqa.courses.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by Harshit Patel
 */
@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
    }


    @Test(groups = {"sanity","regression"})
    public void userShouldNavigateToLoginPageSuccessfully() {
        loginPage.clickOnSigninLink();
        String expectedMessage = "Welcome Back!";
        Assert.assertEquals(loginPage.verifyWelcomeBackTextMessage(), expectedMessage, "User Not Logged In");
    }

    @Test(groups = {"smoke","regression"})
    public void verifyTheErrorMessage() {

        loginPage.clickOnSigninLink();
        loginPage.enterInvalidUserName("Test123545@Gmail.com");
        loginPage.enterInvalidPassword("Test123254");
        loginPage.clickOnSigninButton();
        String expectedMessage = "Invalid email or password.";
        Assert.assertEquals(loginPage.verifyInvalidCredentialMessage(), expectedMessage, "User Logged In");
    }
}
