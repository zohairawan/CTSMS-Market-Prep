package com.chromatech.Cucumber_BDD_Testing.stepDefinitions;

import com.chromatech.Cucumber_BDD_Testing.appsCommon.PageInitializer;
import com.chromatech.Cucumber_BDD_Testing.pages.LoginPage;
import com.chromatech.utils.CommonMethods;
import com.chromatech.utils.CucumberLogUtils;
import com.chromatech.utils.WebDriverUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginSteps extends PageInitializer {

    @Given("the user is on the login page {string}")
    public void the_user_is_on_the_login_page(String url) {
        WebDriverUtils.driver.get(url);
    }

    @When("the user enters the correct username {string} into the username box")
    public void the_user_enters_the_correct_username_into_the_username_box(String username) {
        loginPage.enterUsername(username);
    }

    @When("the user enters the correct passwords {string} into the password box")
    public void the_user_enters_the_correct_passwords_into_the_password_box(String password) {
        loginPage.enterPassword(password);
    }

    @When("the user clicks on the Sign In button")
    public void the_user_clicks_on_the_sign_in_button() {
        loginPage.clickSignInButton();
    }

    @Then("the user is successfully logged in and redirected to a Dashboard page {string}")
    public void the_user_is_successfully_logged_in_and_redirected_to_a_dashboard_page(String expectedURL) {
        String actualURL = WebDriverUtils.driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
    }

    @When("the user enters the incorrect username {string} into the username box")
    public void the_user_enters_the_incorrect_username_into_the_username_box(String username) {
        loginPage.enterUsername(CommonMethods.randomStringGenerator(5) + username);
    }

    @When("the user enters the incorrect passwords {string} into the password box")
    public void the_user_enters_the_incorrect_passwords_into_the_password_box(String password) {
        loginPage.enterPassword(password);
    }

    @Then("the user sees the invalid login credentials message {string}")
    public void the_user_sees_the_invalid_login_credentials_message(String expectedInvalidCredenitalsMessage) {
        Assert.assertTrue(loginPage.isInvalidLoginCredentialsMessageDisplayed());
        Assert.assertEquals(loginPage.getInvalidLoginCredentialsMessage(), expectedInvalidCredenitalsMessage);
    }
}