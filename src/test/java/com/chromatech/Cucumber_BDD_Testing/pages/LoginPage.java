package com.chromatech.Cucumber_BDD_Testing.pages;

import com.chromatech.utils.CommonMethods;
import com.chromatech.utils.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(xpath = "//input[@id='form-username']" )
    WebElement username;

    @FindBy(xpath = "//input[@id='form-password']")
    WebElement password;

    @FindBy(xpath = "//button[@class='btn']")
    WebElement SignInButton;

    public void enterUsername(String username) {
        this.username.sendKeys(username);
    }
    public void enterPassword(String password) {
        this.password.sendKeys(password);
    }
    public void clickSignInButton() {
        this.SignInButton.click();
    }

    public LoginPage() {
        PageFactory.initElements(WebDriverUtils.driver, this);
    }
}
