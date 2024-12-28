package com.answerconnect.testcases;

import com.answerconnect.utilities.CommonUtilities;

public class B_StatusBar extends CommonUtilities {
    static String statHeader;
    static String statSubHeader;

    // To verify the current status set to Im available by default
    public static void isAvailableOrNot() {
        try {
            if (findXpath("currentStatusHeader").getText().equals("I'm Available") && findXpath("currentStatusSubHeader").getText().equals("I can take calls")) {
                log("I'm Available");
                log("I can take calls");
            }
        } catch (Exception e) {
            log(findXpath("currentStatusHeader").getText());
            log("Not taking calls");
        }
    }

    public static void validateAvailable() {
        try {
            if (findXpath("currentStatusHeader").getText().equals("I'm Available") && findXpath("currentStatusSubHeader").getText().equals("I can take calls")) {
                assertEquals(findXpath("currentStatusHeader"), "I'm Available");
                assertEquals(findXpath("currentStatusSubHeader"), "I can take calls");

            } else if (findXpath("currentStatusSubHeader").getText().contains("Not taking calls")) {
                logPass(findXpath("currentStatusHeader").getText());
                assertEqualContains(findXpath("currentStatusSubHeader"), "Not taking calls");
                doubleTap("Status", findXpath("currentStatusHeader"));
                assertEquals(findXpath("currentStatusHeader"), "I'm Available");
            }
        } catch (Exception e) {
            relaunch();
        }
    }

    // To verify the user can double tap on the status bar to change the status
    public static void checkCurrentStatus() {
        statHeader = findXpath("currentStatusHeader").getText();
        log(statHeader);
        statSubHeader = findXpath("currentStatusSubHeader").getText();
        log(statSubHeader);
    }

    public static void doubleTapStatus() {
        statHeader = findXpath("currentStatusHeader").getText();
        statSubHeader = findXpath("currentStatusSubHeader").getText();
        try {
            if (!statHeader.equals("I'm Available") && !statSubHeader.equals("I can take calls")) {
                doubleTap("Status Layout", findXpath("currentStatusHeader"));
            } else {
                log("It is already in available stat");
            }
        } catch (Exception ignored) {
        }
    }

    public static void validateStatusHeader() {
        String header = findXpath("currentStatusHeader").getText();
        String matchCase = null;
        switch (header) {
            case "I'm Available":
                matchCase = "I'm Available";
                break;
            case "I'm Unavailable":
                matchCase = "I'm Unavailable";
                break;
            case "In a meeting":
                matchCase = "In a meeting";
                break;
            case "At Lunch":
                matchCase = "At Lunch";
                break;
            case "On Vacation":
                matchCase = "On Vacation";
                break;
            default:
                log("Nothing matches with the header " + header);
        }
        assertEqualsString(matchCase, header);
    }

    public static void validateStatusSubHeader() {
        String subHeader = findXpath("currentStatusSubHeader").getText();
        assertEqualsString("I can take calls", subHeader);
    }

    // To verify the user can change the status to IN A MEETING, FURTHER NOTICE
    public static void tapMoreStatusIcon() {
        tapOn("more status", findAccID("openStatusOptions"));
    }

    public static void tapInAMeeting() {
        tapOn("In a meeting", findAccID("inAMeeting"));
    }

    public static void validateInAMeetingHeader() {
        assertEquals(findXpath("statusHeader"), "In a Meeting");
    }

    public static void tapFurtherNotice() {
        tapOn("Further notice", findAccID("furtherNotice"));
    }

    public static void tapDone() {
        tapOn("Done", findAccID("done"));
    }

    public static void validateSubHeaderFN() {
        String subHeader = findXpath("currentStatusSubHeader").getText();
        assertEqualsString("Not taking calls", subHeader);
    }

    // To verify the user can change the status to IN A MEETING, NEXT HOUR
    public static void tapNextHour() {
        tapOn("Next Hour", findAccID("nextHour"));
    }

    public static void validateSubHeaderNH() {
        validateHours(1);
    }

    // To verify the user can change the status to IN A MEETING, NEXT 2 HOURS
    public static void tapNext2Hours() {
        tapOn("Next 2 hours", findAccID("next2Hours"));
    }

    public static void validateSubHeaderN2H() {
        validateHours(2);
    }

    // To verify the user can change the status to AT LUNCH, 15 MINUTES
    public static void tapAtLunch() {
        tapOn("At Lunch", findAccID("atLunch"));
    }

    public static void validateLunchHeader() {
        assertEquals(findXpath("statusHeader"), "Lunch");
    }

    public static void tap15Minutes() {
        tapOn("15 minutes", findAccID("15Minutes"));
    }

    public static void validateSubHeader15M() {
        validateMinutes(15);
    }

    // To verify the user can change the status to AT LUNCH, 30 MINUTES
    public static void tap30Minutes() {
        tapOn("30 minutes", findAccID("30Minutes"));
    }

    public static void validateSubHeader30M() {
        validateMinutes(30);
    }

    // To verify the user can change the status to ON VACATION, 1 DAY
    public static void tapOnVacation() {
        tapOn("On vacation", findAccID("onVacation"));
    }

    public static void validateVacationHeader() {
        assertEquals(findXpath("statusHeader"), "Vacation");
    }

    public static void tap1Day() {
        tapOn("1 day", findAccID("1Day"));
    }

    public static void validateSubHeader1D() {
        validateDay(1);
    }

    // To verify the user can change the status to ON VACATION, 2 DAYS
    public static void tap2Days() {
        tapOn("2 days", findAccID("2Days"));
    }

    public static void validateSubHeader2D() {
        validateDay(2);
    }

    // To verify the user can change the status to ON VACATION, 1 Week
    public static void tap1Week() {
        tapOn("1 week", findAccID("1Week"));
    }

    public static void validateSubHeader1W() {
        validateDay(8);
    }

}
