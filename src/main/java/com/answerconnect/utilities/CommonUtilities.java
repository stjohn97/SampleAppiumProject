package com.answerconnect.utilities;

import com.answerconnect.base.BaseClass;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommonUtilities extends BaseClass{
    protected static final WebDriverWait WAIT = new WebDriverWait(driver, Duration.ofSeconds(10));

    protected static void tapOn(String name, WebElement element) {
        try {
            wait(element).click();
            log("Tapped " + name + " successfully");
        } catch (Exception e) {
            System.out.println("Tapping Exception:::: " + e);
            log("Tapping failed");
        }
    }

    protected static WebElement wait(WebElement element) {
        return WAIT.until(ExpectedConditions.visibilityOf(element));
    }

    protected static void hideKeyboard() {
        driver.hideKeyboard();
    }

    protected static void goBack() {
        driver.navigate().back();
    }

    protected static void sendKeys(WebElement element, String input) {
        try {
            element.sendKeys(input);
            log("Entered \"" + input + "\" successfully");
        } catch (Exception e) {
            System.out.println("Send keys exception:::: " + e);
            log("\"" + input + "\"" + "fails to be entered");
        }

    }

    protected static void assertEqualsString(String actual, String expected) {
        try {
            Assert.assertEquals(actual.trim(), expected.trim());
            log("\"" + expected + "\"" + " validated successfully");
        } catch (Exception e) {
            log("\"" + expected + "\"" + " validation failed");
        }
    }

    protected static void clearField(WebElement element) {
        element.clear();
    }

    protected static void assertEquals(WebElement element, String input) {
        String getHeaderText = element.getText().trim();
        try {
            Assert.assertEquals(getHeaderText, input);
            log("\"" + input + "\"" + " validated successfully");
        } catch (Exception e) {
            log("\"" + input + "\"" + " validation failed");
        }
    }

    protected static void staticWait(long durationInSeconds) {
        long startTime = System.currentTimeMillis();
        long endTime = startTime + (durationInSeconds * 1000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
        wait.until((ExpectedCondition<Boolean>) driver -> System.currentTimeMillis() >= endTime);
    }

    protected static void assertEqualContains(WebElement element, String input) {
        String getHeaderText = element.getText().trim();
        try {
            Assert.assertTrue(getHeaderText.contains(input), input);
            log("\"" + input + "\"" + " validated successfully");
        } catch (Exception e) {
            log("\"" + input + "\"" + " validation failed");
        }
    }

    protected static WebElement findID(String element) {
        return driver.findElement(By.id(prop(element)));
    }

    protected static WebElement findXpath(String element) {
        return driver.findElement(By.xpath(prop(element)));
    }

    public static ExpectedCondition<WebElement> elementLocated(final String strategy, final String element) {
        return driver -> find(strategy, element);
    }

    protected static WebElement find(String strategy, String element) {
        switch (strategy) {
            case "id":
                return findID(element);
            case "xpath":
                return findXpath(element);
            case "accID":
                return findAccID(element);
            case "uiAutomator":
                return findUIAutomator(element);
            default:
                throw new IllegalArgumentException("Unsupported locator strategy: " + strategy);
        }
    }

    protected static WebElement explicitWait(int duration, String locator, String element){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        return wait.until(elementLocated(locator, element));
    }

    protected static WebElement findAccID(String element) {
        return driver.findElement(AppiumBy.accessibilityId(prop(element)));
    }

    protected static WebElement findUIAutomator(String element) {
        return driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"" + prop(element) + "\")"));
    }

    protected static void relaunch() {
        driver.terminateApp(getData("appPackage"));
        staticWait(1);
        driver.activateApp(getData("appPackage"));
        staticWait(3);
    }

    protected static void doubleTap(String ignoredName, WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript("mobile: doubleClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement) element).getId()));
        } catch (NullPointerException e) {
            System.out.println("Double tap exception:::: " + e);
        }
    }

    protected static void scrollDown() {
        Dimension screenSize = driver.manage().window().getSize();
        int screenWidth = screenSize.getWidth();
        int screenHeight = screenSize.getHeight();
        int left = screenWidth / 4;
        int top = screenHeight / 4;
        int width = screenWidth / 2;
        int height = screenHeight / 2;
        ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left", left, "top", top, "width", width, "height", height, "direction", "down", "percent", 3.0));
    }

    protected static void scrollUp() {
        Dimension screenSize = driver.manage().window().getSize();
        int screenWidth = screenSize.getWidth();
        int screenHeight = screenSize.getHeight();
        int left = screenWidth / 4;
        int top = screenHeight / 4;
        int width = screenWidth / 2;
        int height = screenHeight / 2;
        ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left", left, "top", top, "width", width, "height", height, "direction", "up", "percent", 3.0));
    }

    protected static void swipeLeft(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "left", 100, "top", 100, "width", 200, "height", 200, "direction", "left", "percent", 0.75));
    }

    protected static void longPress(String info, WebElement element) {
        Actions actions = new Actions(driver);
        try {
            actions.clickAndHold(element).pause(Duration.ofSeconds(2)).release().perform();
            log("Long-pressed " + info + " successfully");
        } catch (Exception e) {
            log("Long-press failed");
            System.out.println("LongPress exception:::: " + e);
        }
    }

    protected static void assertNotEquals(String actual, String expected){
        Assert.assertNotEquals(actual, expected);
    }

    protected static void alerts(String allowOrDeny) {
        boolean ifAlertExecuted = false;
        while (true) {
            try {
                if (findID("accessMessage").isDisplayed()) {
                    tapOn(allowOrDeny, findID(allowOrDeny));
                    ifAlertExecuted = true;
                } else {
                    break;
                }
            } catch (NoSuchElementException e) {
                if (ifAlertExecuted) {
                    break;
                } else {
                    log("Alert doesn't exist");
                }
            }
        }
    }

    protected static void validateMinutes(int minutes) {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm");
        LocalDateTime newTime = currentTime.plusMinutes(minutes);
        String formattedTime = newTime.format(formatter).trim();
        String subHeader = findXpath("currentStatusSubHeader").getText();
        assertEqualsString(subHeader.substring(0, 28).trim(), "Not taking calls until " + formattedTime);
    }

    protected static void validateHours(int hours) {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm");
        LocalDateTime newTime = currentTime.plusHours(hours);
        String formattedTime = newTime.format(formatter).trim();
        String subHeader = findXpath("currentStatusSubHeader").getText();
        assertEqualsString(subHeader.substring(0, 28).trim(), "Not taking calls until " + formattedTime);
    }

    protected static void validateDay(int day) {
        LocalDate today = LocalDate.now();
        LocalDate newDate = today.plusDays(day);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d, yyyy");
        String formattedNewDate = newDate.format(formatter);
        String subHeader = findXpath("currentStatusSubHeader").getText();
        assertEqualsString(subHeader, "Not taking calls until " + formattedNewDate);
    }

    public static void logPass(String comment) {
        extentLog("‣ " + comment + " validated successfully");
    }

    public static void logFail(String comment) {
        Assert.fail("‣ " + comment + " validation failed");
    }

    public static void log(String comment) {
        extentLog("‣ " + comment);
    }

    public static void error() {
        extentLog("Something went wrong");
    }

    public static void extentLog(String comment) {
        ExtentCucumberAdapter.addTestStepLog(comment);
    }

}