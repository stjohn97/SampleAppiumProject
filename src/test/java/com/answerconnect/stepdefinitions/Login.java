package com.answerconnect.stepdefinitions;

import com.answerconnect.base.BaseClass;
import com.answerconnect.testcases.A_Login;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {

    @Given("open the application")
    public void openApp() {
        BaseClass.appLaunch();
    }

    @Given("validate the AnswerConnect logo")
    public void acLogo() {
        A_Login.acLogo();
    }

    @And("validate the Forgot Password button text")
    public void forgetPasswordButtonText() {
        A_Login.forgetPasswordButtonText();
    }

    @And("validate the Sign in with Google logo")
    public void signInWithGoogleLogo() {
        A_Login.signInWithGoogleLogo();
    }

    @Then("validate the Sign in with Google text")
    public void signInWithGoogleText() {
        A_Login.signInWithGoogleText();
    }

    @And("validate the text in Call Us")
    public void callUSText() {
        A_Login.callUSText();
    }

    @Then("validate the text in Terms & Privacy")
    public void termsAndPrivacyText() {
        A_Login.termsAndPrivacyText();
    }

    @Given("tap on forget password button")
    public void forgetPasswordButton() {
        A_Login.forgetPasswordButton();
    }

    @When("enter the invalid email ID in FP")
    public void enterInvalidEmailIDFP() {
        A_Login.enterInvalidEmailIDFP();
    }

    @And("tap on Reset password button")
    public void tapResetPassword() {
        A_Login.tapResetPassword();
    }

    @Then("validate the invalid toast message")
    public void validateInvalidToastMessage() {
        A_Login.validateInvalidToastMessage();
    }

    @When("enter the valid email ID in FP")
    public void enterValidEmailIDFP() {
        A_Login.enterValidEmailIDFP();
    }

    @Then("validate the Reset password link")
    public void validateResetPassword() {
        A_Login.validateResetPassword();
    }

    @When("enter the wrong email ID")
    public void enterWrongEmail() {
        A_Login.enterWrongEmail();
    }

    @When("enter the wrong password")
    public void enterWrongPassword() {
        A_Login.enterWrongPassword();
    }

    @Then("validate the wrong login toast message")
    public void validateWrongLoginToast() {
        A_Login.validateWrongLoginToast();
    }

    @When("enter the invalid email ID")
    public void enterInvalidEmail() {
        A_Login.enterInvalidEmail();
    }

    @When("enter the invalid password")
    public void enterInvalidPassword() {
        A_Login.enterInvalidPassword();
    }

    @Then("validate the invalid login toast message")
    public void validateInvalidToast() {
        A_Login.validateInvalidLoginToast();
    }

    @When("enter the email ID")
    public void enterEmail() {
        A_Login.enterEmailId();
    }

    @When("enter the password")
    public void enterPassword() {
        A_Login.enterPassword();
    }

    @And("tap on login button")
    public void tapLogin() {
        A_Login.tapLoginButton();
    }

    @And("skip tour page")
    public void skipTour() {
        A_Login.skipTourPage();
    }

    @And("verify your phone number")
    public void verifyPhonePage() {
        A_Login.verifyPhonePage();
    }

    @And("give access permission")
    public void givePermission() {
        A_Login.givePermission();
    }

    @Then("validate signIn page")
    public void validateSignIn() {
        A_Login.validateSignIn();
    }

}
