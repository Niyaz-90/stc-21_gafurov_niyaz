package lab.test.task.pattern.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[contains(@class, 'email-input svelte-1tib0qz')]")
    private WebElement usernameField;

    @FindBy(xpath = "//*[contains(@class, 'password-input svelte-1tib0qz')]")
    private WebElement passwordField;

    @FindBy(xpath = "//*[contains(@data-testid, 'login-to-mail')]")
    private WebElement loginButton;

    @FindBy(xpath = "//*[contains(@class, 'button svelte-1tib0qz')]")
    private WebElement enterPasswordButton;
    public void enterUsername(String username){
        usernameField.sendKeys(username);
    }

    public void pressPasswordButton(){
        enterPasswordButton.click();
    }

    public void enterPassword(String password){
        passwordField.sendKeys(password);
    }

    public void pressLoginButton(){
        loginButton.click();
    }
}
