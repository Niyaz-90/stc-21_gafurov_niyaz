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

    @FindBy(xpath = "//*[contains(@role, 'textbox')]")
    private WebElement messageBody;

    @FindBy(xpath = "//*[contains(@class, 'button2 button2_base button2_primary button2_compact button2_hover-support js-shortcut')]")
    private WebElement sendButton;

    @FindBy(xpath = "//*[contains(@class, 'layer_link')]")
    private WebElement sendingResult;

    @FindBy(xpath = "//*[contains(@title, 'niyazga-12345@mail.ru')]")
    private WebElement adressee;

    @FindBy(partialLinkText = "/sent/")
    private WebElement shippedMessagesButton;

//    @FindBy(xpath = )

    public String getUsername(){
        return username.getText();
    }

    public String writeMessage(){
        writeMessageButton.click();
        sendToField.sendKeys(ConfProperties.getProperty("addressee"));
        messageBody.sendKeys("message");
        sendButton.click();
        return "OK";
    }

    public String sendResult(){
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        shippedMessagesButton.click();
       return adressee.getText();

    }
}
