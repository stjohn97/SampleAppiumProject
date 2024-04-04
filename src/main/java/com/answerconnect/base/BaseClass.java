package com.answerconnect.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

import static com.answerconnect.utilities.CommonUtilities.log;

public class BaseClass extends ExcelRead {
    private static final Properties PROPERTY = new Properties();
    private static final String USER_NAME = getData("userName");
    private static final String ACCESS_KEY = getData("accessKey");
    private static final String GRID_URL = getData("gridURL");
    private static final int IMPLICIT_TIMEOUT = 25;
    static String device = "Yes";
    static String cloud = "No";

    public static AndroidDriver driver;

    public static void appLaunch() {
        try {
            System.out.println("App is launching");
            loadPropertyFiles();
            UiAutomator2Options capabilities = new UiAutomator2Options();
            if (getData("RealDevice").equalsIgnoreCase(device)) {
                startAppiumServer();
                setCommonCapabilities(capabilities);
                setLocalCapabilities(capabilities);
            } else if (getData("Cloud").equalsIgnoreCase(cloud)) {
                setCommonCapabilities(capabilities);
                setCloudCapabilities(capabilities);
            } else {
                System.out.println("Can't launch");
            }
            driver = new AndroidDriver(new URI(serverURL()).toURL(), capabilities);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_TIMEOUT));

        } catch (Exception e) {
            log("App Launch exception:::: " + e);
        }
        System.out.println("App launched");
        log("Application launched successfully");
    }

    private static void setCommonCapabilities(UiAutomator2Options capabilities) {
        capabilities.setPlatformName(getData("platformName"));
        capabilities.setAutomationName(getData("automationName"));
        capabilities.setAutoGrantPermissions(true);
        capabilities.setNoReset(true);
    }

    private static void setLocalCapabilities(UiAutomator2Options capabilities) {
        capabilities.setPlatformVersion(getData("platformVersion6a"));
        capabilities.setAppPackage(getData("appPackage"));
        capabilities.setAppActivity(getData("appActivity"));
        capabilities.setDeviceName(getData("deviceName6a"));
    }

    private static void setCloudCapabilities(UiAutomator2Options capabilities) {
        capabilities.setDeviceName(getData("C_DeviceName"));
        capabilities.setPlatformVersion(getData("C_OS14"));
        capabilities.setCapability("app", getData("C_appID"));
        capabilities.setCapability("deviceOrientation", "portrait");
        capabilities.setCapability("build", "AnswerConnect_Android");
        capabilities.setCapability("name", "Container");
        capabilities.setCapability("isRealMobile", true);
        capabilities.setCapability("w3c", true);
        capabilities.setCapability("devicelog", true);
        capabilities.setCapability("visual", true);
        capabilities.setCapability("video", true);
        capabilities.setCapability("timezone", "UTC+05:30");
    }

    private static void startAppiumServer() {
        AppiumDriverLocalService service = appiumServer();
        service.start();
    }

    protected static AppiumDriverLocalService appiumServer() {
        String androidHome = System.getenv("ANDROID_HOME");
        if (androidHome == null) {
            throw new RuntimeException("ANDROID_HOME environment variable not found. Please set it correctly.");
        }
        HashMap<String, String> environment = new HashMap<>();
        environment.put("ANDROID_HOME", androidHome);
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.usingPort(4723);
        builder.withEnvironment(environment);
        builder.usingDriverExecutable(new File("/usr/local/bin/node"));
        builder.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"));
        builder.withLogFile(new File("Logs.txt"));
        return AppiumDriverLocalService.buildService(builder);
    }

    private static void loadPropertyFiles() throws IOException {
        String[] propertyFiles = {"signIn.properties", "inbox.properties", "status.properties"};
        for (String file : propertyFiles) {
            try (InputStream input = Files.newInputStream(Paths.get("./src/main/resources/Locators/" + file))) {
                PROPERTY.load(input);
            }
        }
    }

    public static String prop(String element) {
        return PROPERTY.getProperty(element);
    }

    private static String serverURL() {
        if (getData("Cloud").equalsIgnoreCase(cloud)) {
            return "https://" + USER_NAME + ":" + ACCESS_KEY + GRID_URL;
        } else {
            return "http://0.0.0.0:4723";
        }
    }
}

