package ru.t1.software.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[contains(@id, 'ips_username')]")
    private WebElement loginField;

    @FindBy(xpath = "//*[contains(@class, 'ipsButton')]")
    private WebElement loginButton;

    @FindBy(css = "input[id= 'ips_password']")
    private WebElement passwordField;

    @FindBy(xpath = "//*[contains(@id, 'sign_in')]")
    private WebElement signInButton;

    public void inputLogin(String login){
        loginField.sendKeys(login);
    }

    public void inputPassword(String password){
        passwordField.sendKeys(password);
    }

    public void pressLoginButton(){
        loginButton.click();
    }
    public void pressSignInButton(){
        signInButton.click();
    }
}
