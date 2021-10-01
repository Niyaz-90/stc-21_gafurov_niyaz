package lab.test.task.pattern.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {

    private WebDriver driver;
    public ProfilePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[contains(@class, 'ph-project__user-name svelte-1xjymf4')]")
    private WebElement username;

    @FindBy(xpath = "//*[contains(@class, 'compose-button__txt')]")
    private WebElement writeMessageButton;

    @FindBy(xpath = "//*[contains(@class, 'container--H9L5q size_s_compressed--2c-eV')]")
    private WebElement sendToField;

    @FindBy(xpath = "//*[contains(@]")
    public String getUsername(){
        return username.getText();
    }
}
