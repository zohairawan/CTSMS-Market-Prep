package com.chromatech.Cucumber_BDD_Testing.stepDefinitions;

import com.chromatech.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class LoginSteps {

    @Test
    public void testLoginWithValidCredentials() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://mexil.it/chroma/site/login/");

        WebElement username = driver.findElement(By.xpath("//input[@id='form-username']"));
        username.sendKeys("general@teacher.com");

        WebElement password = driver.findElement(By.xpath("//input[@id='form-password']"));
        password.sendKeys("123456");

        WebElement signInButton = driver.findElement(By.xpath("//button[@class='btn']"));
        signInButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://mexil.it/chroma/admin/admin/dashboard");
        driver.quit();
    }

    @Test
    public void testLoginWithInvalidCredentials() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://mexil.it/chroma/site/login/");

        WebElement username = driver.findElement(By.xpath("//input[@id='form-username']"));
        username.sendKeys(CommonMethods.randomStringGenerator(5) + "@teacher.com");

        WebElement password = driver.findElement(By.xpath("//input[@id='form-password']"));
        password.sendKeys(CommonMethods.randomStringGenerator(7));

        WebElement SignInButton = driver.findElement(By.xpath("//button[@class='btn']"));
        SignInButton.click();

        String actualInvalidLoginMessage = driver.findElement(By.xpath("//div[normalize-space()='Invalid Username or Password']")).getText();
        String expectedInvalidLoginMessage = "Invalid Username or Password";
        Assert.assertEquals(actualInvalidLoginMessage, expectedInvalidLoginMessage);
    }
}