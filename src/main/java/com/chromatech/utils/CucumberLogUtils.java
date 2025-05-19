package com.chromatech.utils;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
public class CucumberLogUtils extends WebDriverUtils{

    public static Scenario scenario;

    /**
     * USE BELOW METHOD TO ATTACH SCREENSHOTS TO CUCUMBER REPORT
     */
    public static void logScreenShot() {
            final byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Attaching screenshots to reports"); // attach to the report
    }
}
