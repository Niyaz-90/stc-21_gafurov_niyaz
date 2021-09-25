package ru.t1.software.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[contains(@title, 'Выход')]")
    private WebElement logoutButton;

    @FindBy(xpath = "//*[contains(@id, 'user_link')]")
    private WebElement username;

    public UserPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void pressLogoutButton(){
        logoutButton.click();
    }

    public String getUsername(){
        return this.username.getText().trim();
    }


}
