package com.answerconnect.stepdefinitions;

import com.answerconnect.utilities.CommonUtilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class AfterScenario extends CommonUtilities {

    @After
    public static void getScreenshot(Scenario scenario) {

        if (scenario.isFailed()) {
            try {
                TakesScreenshot ts = driver;
                String screenshot = ts.getScreenshotAs(OutputType.BASE64);
                screenshot = screenshot.replaceAll("[^A-Za-z0-9+/]", "");
                byte[] ss = Base64.getDecoder().decode(screenshot);
                scenario.attach(ss, "image/png", "Refer");
            } catch (Exception e) {
                System.out.println("Screenshot exception:::: " + e);
            }
        } else {
            try {
                TakesScreenshot ts = driver;
                String screenshot = ts.getScreenshotAs(OutputType.BASE64);
                screenshot = screenshot.replaceAll("[^A-Za-z0-9+/]", "");
                byte[] ss = Base64.getDecoder().decode(screenshot);
                scenario.attach(ss, "image/png", "Refer");
            } catch (Exception e) {
                System.out.println("Screenshot exception:::: " + e);
            }
        }
    }

    @AfterAll
    public static void openReport() throws IOException {
        ExtentReports extent = ExtentService.getInstance();
        if (extent != null) {
            extent.flush();
        }
        Desktop.getDesktop().browse(new File("Extent-Report/Report/AC_Android.html").toURI());
        driver.quit();
        appiumServer().stop();
    }

}
