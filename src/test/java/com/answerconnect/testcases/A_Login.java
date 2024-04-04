package com.answerconnect.testcases;

import com.answerconnect.utilities.CommonUtilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class A_Login extends CommonUtilities {
    private static final String VALID_EMAIL = getData("validEmail");
    private static final String INVALID_EMAIL = getData("invalidEmail");
    private static final String WRONG_EMAIL = getData("wrongEmail");
    private static final String VALID_PASSWORD = getData("validPassword");
    private static final String INVALID_PASSWORD = getData("invalidPassword");
    private static final String WRONG_PASSWORD = getData("wrongPassword");
    private static final String CALL_US = getData("callUs");
    private static final String TERMS_PRIVACY = getData("termsPrivacy");
    private static final String SIGN_IN_WITH_GOOGLE = getData("SIWG");

    public static void acLogo() {
        if (findAccID("acLogo").isDisplayed()) {
            logPass("AnswerConnect logo");
        } else {
            logFail("AnswerConnect logo");
        }
    }

    public static void forgetPasswordButtonText() {
        if (findAccID("forgetPasswordBtn").isDisplayed()) {
            logPass("Forget Password button");
        } else {
            logFail("Forget Password button");
        }
    }

    public static void signInWithGoogleLogo() {
        if (findAccID("signInWithGLogo").isDisplayed()) {
            logPass("Sign in with Google logo");
        } else {
            logFail("Sign in with Google logo");
        }
    }

    public static void signInWithGoogleText() {
        if (findXpath("signInWithGText").isDisplayed()) {
            assertEqualsString(findXpath("signInWithGText").getText(), SIGN_IN_WITH_GOOGLE);
        } else {
            logFail("Sign in with Google text");
        }
    }

    public static void callUSText() {
        if (findAccID("callUs").isDisplayed()) {
            assertEqualsString(findAccID("callUs").getText(), CALL_US);
        } else {
            logFail("Call Us");
        }
    }

    public static void termsAndPrivacyText() {
        if (findAccID("terms&Privacy").isDisplayed()) {
            assertEqualsString(findAccID("terms&Privacy").getText(), TERMS_PRIVACY);
        } else {
            logFail("Terms & Privacy");
        }
    }

    public static void forgetPasswordButton() {
        tapOn("Forget Password", findAccID("forgetPasswordBtn"));
    }

    public static void enterInvalidEmailIDFP() {
        clearField(findXpath("FPemailField"));
        sendKeys(findXpath("FPemailField"), INVALID_EMAIL);
    }

    public static void tapResetPassword() {
        tapOn("Reset password", findAccID("resetPassword"));
    }

    public static void validateInvalidToastMessage() {
        assertEquals(findXpath("ToastMessage"), getData("validEmailToast"));
    }

    public static void enterValidEmailIDFP() {
        staticWait(4);
        clearField(findXpath("FPemailField"));
        sendKeys(findXpath("FPemailField"), VALID_EMAIL);
    }

    public static void validateResetPassword() {
        assertEquals(findXpath("ToastMessage"), getData("resetPasswordToast"));
    }

    public static void enterWrongEmail() {
        staticWait(4);
        clearField(findXpath("emailField"));
        sendKeys(findXpath("emailField"), WRONG_EMAIL);
    }

    public static void enterWrongPassword() {
        clearField(findXpath("passwordField"));
        sendKeys(findXpath("passwordField"), WRONG_PASSWORD);
    }

    public static void validateWrongLoginToast() {
        assertEquals(findXpath("ToastMessage"), getData("invalidLoginToast"));
        logPass("Wrong credential toast");
    }

    public static void enterInvalidEmail() {
        staticWait(3);
        clearField(findXpath("emailField"));
        sendKeys(findXpath("emailField"), INVALID_EMAIL);
    }

    public static void enterInvalidPassword() {
        clearField(findXpath("passwordField"));
        sendKeys(findXpath("passwordField"), INVALID_PASSWORD);
    }

    public static void validateInvalidLoginToast() {
        assertEquals(findXpath("ToastMessage"), getData("correctEmailToast"));
        logPass("Invalid credential toast");
    }

    public static void enterEmailId() {
        clearField(findXpath("emailField"));
        sendKeys(findXpath("emailField"), VALID_EMAIL);
    }

    public static void enterPassword() {
        clearField(findXpath("passwordField"));
        sendKeys(findXpath("passwordField"), VALID_PASSWORD);
    }

    public static void tapLoginButton() {
        tapOn("Login button", findAccID("loginButton"));
    }

    public static void skipTourPage() {
        try {
            if (findAccID("skipTour").isDisplayed()) {
                tapOn("Skip", findAccID("skipTour"));
            }
        } catch (Exception e) {
            log("Tour page does not exist");
        }
    }

    public static void verifyPhonePage() {
        try {
            if (findXpath("verifyPhone").isDisplayed()) {
                tapOn("Back", findAccID("backButLogin"));
            }
        } catch (Exception e) {
            log("BID does not exist for " + VALID_EMAIL);
        }
    }

    public static void givePermission() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.invisibilityOf(findXpath("progressBar")));
        alerts("allow");
    }

    public static void validateSignIn() {
        try {
            assertEquals(findXpath("inboxHeader"), "Inbox");
            logPass("Sign in");
        } catch (Exception e) {
            logFail("Sign in");
        }
    }

}
