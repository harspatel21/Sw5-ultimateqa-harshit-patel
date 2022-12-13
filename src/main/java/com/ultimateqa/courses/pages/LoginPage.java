package com.ultimateqa.courses.pages;

import com.ultimateqa.courses.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

/**
 * Created by Harshit Patel
 */
public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//a[@href='/users/sign_in']")
    WebElement signinLink;

    @CacheLookup
    @FindBy(xpath = "//h2[@class='page__heading']")
    WebElement verifyWelcomeBackText;

    @CacheLookup
    @FindBy(id = "user[email]")
    WebElement userNameField;
    @CacheLookup
    @FindBy(id = "user[password]")
    WebElement userPasswordField;

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement signinButton;

    @CacheLookup
    @FindBy(xpath = "//li[contains(text(),'Invalid email or password.')]")
    WebElement InvalidCredentialMessage;

    public void clickOnSigninLink() {
        Reporter.log("Clicking on Signing Link " + signinLink.toString());
        clickOnElement(signinLink);
    }
    public void clickOnSigninButton() {
        Reporter.log("Clicking on Signin Button " + signinButton.toString());
        clickOnElement(signinButton);
    }

    public String verifyWelcomeBackTextMessage() {
        Reporter.log("Verify Welcome Back Text " + verifyWelcomeBackText.toString());
        return getTextFromElement(verifyWelcomeBackText);
    }

    public void enterInvalidUserName(String userName) {
        Reporter.log("Entering "+ userName + " User Name " + userNameField.toString());
        sendTextToElement(userNameField, userName);
    }

    public void enterInvalidPassword(String password) {
        Reporter.log("Entering " + userPasswordField + " Password  " + userPasswordField.toString());
        sendTextToElement(userPasswordField, password);
    }

    public String verifyInvalidCredentialMessage() {
        Reporter.log("Verify Invalid Crendetial Message " + InvalidCredentialMessage.toString());
        return getTextFromElement(InvalidCredentialMessage);
    }

}
