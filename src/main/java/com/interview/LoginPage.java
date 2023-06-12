package com.interview;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

/**
 * This class represents the login page of https://saucedemo.com
 * @author Kwadwo Dwomo II
 * @version 0.0.0
 * @since 12th June 2023
 */
public class LoginPage extends LoadableComponent<LoginPage> {

    private WebDriver driver;
    @FindBy(id = "user-name")
    private WebElement username;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "login-button")
    private WebElement loginButton;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public void login() {
        username.sendKeys("bizle.dwomoh@gmail.com");
        password.sendKeys("Mummylovia1@");
        loginButton.click();
    }

    @Override
    protected void load() {
        driver.get("https://saucedemo.com");
    }

    @Override
    protected void isLoaded() throws Error {
        Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo.com"));
    }
}
