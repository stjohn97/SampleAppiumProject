package com.answerconnect.stepdefinitions;

import com.answerconnect.testcases.B_StatusBar;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StatusBar {

    @Given("check whether the status is available or not")
    public void isAvailableOrNot() {
        B_StatusBar.isAvailableOrNot();
    }

    @Then("validate the Im available status")
    public void validateAvailable() {
        B_StatusBar.validateAvailable();
    }

    @Given("check the current status")
    public void checkCurrentStatus() {
        B_StatusBar.checkCurrentStatus();
    }

    @When("double tap on the status layout")
    public void doubleTapStatus() {
        B_StatusBar.doubleTapStatus();
    }

    @Then("validate the updated status header")
    public void validateStatusHeader() {
        B_StatusBar.validateStatusHeader();
    }

    @Then("validate the updated status sub header")
    public void validateStatusSubHeader() {
        B_StatusBar.validateStatusSubHeader();
    }

    @When("tap on more status icon")
    public void tapMoreStatusIcon() {
        B_StatusBar.tapMoreStatusIcon();
    }

    @And("tap on In a Meeting")
    public void tapInAMeeting() {
        B_StatusBar.tapInAMeeting();
    }

    @Then("validate the In a Meeting header")
    public void validateInAMeetingHeader() {
        B_StatusBar.validateInAMeetingHeader();
    }

    @And("tap on Further Notice")
    public void tapFurtherNotice() {
        B_StatusBar.tapFurtherNotice();
    }

    @And("tap on Done")
    public void tapDone() {
        B_StatusBar.tapDone();
    }

    @Then("validate the updated status sub header for further notice")
    public void validateSubHeaderFN() {
        B_StatusBar.validateSubHeaderFN();
    }

    @And("tap on Next Hour")
    public void tapNextHour() {
        B_StatusBar.tapNextHour();
    }

    @Then("validate the updated status sub header for next hour")
    public void validateSubHeaderNH() {
        B_StatusBar.validateSubHeaderNH();
    }

    @And("tap on Next 2 Hours")
    public void tapNext2Hours() {
        B_StatusBar.tapNext2Hours();
    }

    @Then("validate the updated status sub header for next 2 hours")
    public void validateSubHeaderN2H() {
        B_StatusBar.validateSubHeaderN2H();
    }

    @And("tap on At Lunch")
    public void tapAtLunch() {
        B_StatusBar.tapAtLunch();
    }

    @Then("validate the Lunch header")
    public void validateLunchHeader() {
        B_StatusBar.validateLunchHeader();
    }

    @And("tap on 15 Minutes")
    public void tap15Minutes() {
        B_StatusBar.tap15Minutes();
    }

    @Then("validate the updated status sub header for 15 minutes")
    public void validateSubHeader15M() {
        B_StatusBar.validateSubHeader15M();
    }

    @And("tap on 30 Minutes")
    public void tap30Minutes() {
        B_StatusBar.tap30Minutes();
    }

    @Then("validate the updated status sub header for 30 minutes")
    public void validateSubHeader30M() {
        B_StatusBar.validateSubHeader30M();
    }

    @And("tap on On Vacation")
    public void tapOnVacation() {
        B_StatusBar.tapOnVacation();
    }

    @Then("validate the Vacation header")
    public void validateVacationHeader() {
        B_StatusBar.validateVacationHeader();
    }

    @And("tap on 1 Day")
    public void tap1Day() {
        B_StatusBar.tap1Day();
    }

    @Then("validate the updated status sub header for 1 day")
    public void validateSubHeader1D() {
        B_StatusBar.validateSubHeader1D();
    }

    @And("tap on 2 Days")
    public void tap2Days() {
        B_StatusBar.tap2Days();
    }

    @Then("validate the updated status sub header for 2 days")
    public void validateSubHeader2D() {
        B_StatusBar.validateSubHeader2D();
    }

    @And("tap on 1 Week")
    public void tap1Week() {
        B_StatusBar.tap1Week();
    }

    @Then("validate the updated status sub header for 1 week")
    public void validateSubHeader1W() {
        B_StatusBar.validateSubHeader1W();
    }
}
