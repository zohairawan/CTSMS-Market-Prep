package com.chromatech.Cucumber_BDD_Testing.stepDefinitions;

import com.chromatech.Cucumber_BDD_Testing.appsCommon.PageInitializer;
import com.chromatech.utils.WebDriverUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginSteps extends PageInitializer {

    @Given("the user is on the login page {string}")
    public void the_user_is_on_the_login_page(String url) {
        WebDriverUtils.driver.get(url);
    }

    @When("the user enters the correct username {string} into the username box")
    public void the_user_enters_the_correct_username_into_the_username_box(String username) {
       loginPage.enterUsername(username);
    }

}