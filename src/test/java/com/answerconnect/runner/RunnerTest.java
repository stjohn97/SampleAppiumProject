package com.answerconnect.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@LoginPage", glue = {"com.answerconnect.stepdefinitions"}, features = {
        "src/test/resources/Features"}, plugin = {
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, dryRun = false, monochrome = true)

public class RunnerTest {

}
