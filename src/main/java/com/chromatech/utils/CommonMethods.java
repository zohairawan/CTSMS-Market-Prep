package com.chromatech.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods extends WebDriverUtils {

    /**
     * THIS CLASS CONTAINS COMMON METHODS
     */

    /**
     * Selects a value from a dropdown menu by matching the visible text of an option.
     *
     * @param VisibleTextOfDD The exact visible text of the dropdown option to be selected.
     * @param dropDownWebEl   The WebElement representing the dropdown menu.
     */
    public static void selectDropDownValue(String VisibleTextOfDD, WebElement dropDownWebEl) {
        Select select = new Select(dropDownWebEl);
        select.selectByVisibleText(VisibleTextOfDD);
    }

    /**
     * Selects a value from a dropdown menu based on the given value attribute.
     *
     * @param element The WebElement representing the dropdown menu.
     * @param value   The value attribute of the option to be selected.
     */
    public static void selectDropDownValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    /**
     * Selects a value from a dropdown menu based on its index position.
     *
     * @param dropDownElement The WebElement representing the dropdown menu.
     * @param index           The zero-based index of the option to be selected
     *                        from the dropdown.
     */
    public static void selectDropDownValue(WebElement dropDownElement, int index) {
        Select select = new Select(dropDownElement);
        select.selectByIndex(index);
    }

    /**
     * Retrieves the text of the first selected option from a dropdown menu.
     *
     * @param dropDown The WebElement representing the dropdown menu.
     * @return A string containing the text of the first selected option.
     */
    public static String getFirstSelectedOption(WebElement dropDown) {
        Select select = new Select(dropDown);
        WebElement firstSelectedOption = select.getFirstSelectedOption();
        return firstSelectedOption.getText();
    }

    /**
     * Determines if the given dropdown WebElement allows multiple selections.
     *
     * @param element The WebElement representing the dropdown to be checked.
     * @return A boolean indicating whether the dropdown supports multiple selections.
     * Returns true if it allows multiple selections, otherwise false.
     */
    public static boolean isMultiple(WebElement element) {
        Select select = new Select(element);
        return select.isMultiple();
    }

    /**
     * Retrieves a list of all text values from the options in a dropdown element.
     * Converts the options from WebElement to String.
     *
     * @param element The WebElement representing the dropdown from which options need to be fetched.
     * @return A List of Strings containing the text of all options in the dropdown.
     */
    public static List<String> getOptions(WebElement element) {
        Select select = new Select(element);
        List<WebElement> allOptions = select.getOptions();
        List<String> optionTexts = new ArrayList<>();

        for (WebElement option : allOptions) {
            optionTexts.add(option.getText());
        }
        return optionTexts;
    }

    /**
     * Accepts the currently active alert dialog.
     * This method switches the WebDriver context to the active alert
     * and accepts it, which is equivalent to clicking the "OK" button
     * on the alert.
     */
    public static void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    /**
     * Retrieves the text displayed on the currently active alert dialog.
     * This method switches the WebDriver context to the active alert and retrieves its content.
     *
     * @return The text contained in the alert dialog as a String.
     */
    public static String getAlertText() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    /**
     * Switches the WebDriver's context to a specified frame using its name or ID.
     * If the frame with the given name or ID is not found, a NoSuchFrameException
     * is caught and a message is printed indicating that the frame is not present.
     *
     * @param nameOrId The name or ID of the frame to switch to. Pass the identifier
     *                 of the desired frame as a String.
     */
    public static void switchToFrame(String nameOrId) {
        driver.switchTo().frame(nameOrId);
    }

    /**
     * Use this method to switch the WebDriver's context to a specific frame using a WebElement.
     * If the frame is not found, a NoSuchFrameException is caught, and an appropriate message is logged.
     *
     * @param element The WebElement representing the frame to switch to.
     */
    public static void switchToFrame(WebElement element) {
        driver.switchTo().frame(element);
    }

    /**
     * Switches the WebDriver's context to a specified frame based on its index position.
     * If the frame with the given index is not found, a NoSuchFrameException is caught
     * and a message is printed indicating the frame is not present.
     *
     * @param index The zero-based index of the frame to switch to.
     *              Pass the position of the frame in the DOM starting at 0.
     */
    public static void switchToFrame(int index) {
        driver.switchTo().frame(index);

    }

    /**
     * Use this method in need of waiting for 30s for an element based on
     * availability of elementToBeSelected.
     *
     * @param element Pass the WebElement on which synchronization to be applied.
     * @return This method will return boolean type either True or False.
     */
    public static WebElement waitForThePresenceOfElement(String element, Duration timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        return wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath(element))));
    }

    /**
     * This method will create an Object of WebDriverWait
     *
     * @return WebDriverWait
     */
    public static WebDriverWait getWaitObject() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait;
    }

    /**
     * This method will wait until element becomes clickable
     *
     * @param element
     */
    public static void waitForClickability(WebElement element) {
        getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * This method will wait until element becomes visible
     *
     * @param element
     */
    public static void waitForVisibility(WebElement element) {
        getWaitObject().until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Use this method to pass an email concatenated with current date and time into
     * an email text box
     */
    public static String getEmail() {
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String email = formatter.format(ts).toString();
        email = email.replaceAll("[^A-Za-z0-9]", "");
        email = ("test") + email + ("@email.com");
        return email;
    }

    /**
     * Use this String to pass an email concatenated with current date and time into
     * an email text box and you can pass same value (email+date+time) in another
     * steps.
     */
    public static String email = getEmail();

    /**
     * Use this method to pass date as a string. You can concatenate with any String
     * and get unique name
     */
    public static String getDateAsString() {
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateAsString = formatter.format(ts).toString();
        dateAsString = dateAsString.replaceAll("[^A-Za-z0-9]", "");
        return dateAsString;
    }

    public static String date = getDateAsString();

    /**
     * Use this method to switch to the next open window
     */
    public static void switchToNextWindow() {
        Set<String> handlingAllOpenWindows = WebDriverUtils.driver.getWindowHandles();
        for (String nextWindow : handlingAllOpenWindows) {
            WebDriverUtils.driver.switchTo().window(nextWindow);
        }
    }

    /**
     * Use this method to hover over element
     *
     * @param element
     */
    public static void hoverOverElement(WebElement element) {
        Actions action = new Actions(WebDriverUtils.driver);
        action.moveToElement(element);
        action.perform();
    }

    public static void sleep(long milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method will read a .json file and return it in a String type written in
     * json format - for passing REST payloads
     */
    public static String readJson(String fileName) {

        String jsonFile = null;
        try {
            jsonFile = new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonFile;
    }
}