package lab.test.task.page;

import lab.test.task.conf.ConfProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

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

    @FindBy(xpath = "//div[starts-with(@class, 'editable-') and contains(@class, 'cke_editable cke_editable_inline cke_contents_true cke_show_borders')]")
    private WebElement messageBody;

    @FindBy(xpath = "//*[contains(@class, 'button2 button2_base button2_primary button2_compact button2_hover-support js-shortcut')]")
    private WebElement sendButton;

    @FindBy(className = "layer__link")
    private WebElement sendingResult;

    @FindBy(xpath = "//*[contains(@title, 'niyazga-12345@mail.ru')]")
    private WebElement adressee;

    public String getUsername(){
        return username.getText();
    }

    public void writeMessage(){
        writeMessageButton.click();
        sendToField.sendKeys(ConfProperties.getProperty("addressee"));
        messageBody.sendKeys("message");
        sendButton.click();
    }

    public String sendResult(){
        return sendingResult.getText().trim();
    }
}
