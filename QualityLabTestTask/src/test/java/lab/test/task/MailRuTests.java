package lab.test.task;

import lab.test.task.conf.ConfProperties;
import lab.test.task.page.MainPage;
import lab.test.task.page.ProfilePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MailRuTests {
    private static WebDriver driver;
    private static MainPage mainPage;
    private static ProfilePage profilePage;


    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        profilePage = new ProfilePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("url"));
    }

    @Test(priority = 1)
    public void login(){
        mainPage.enterUsername(ConfProperties.getProperty("username"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage.pressPasswordButton();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage.enterPassword(ConfProperties.getProperty("password"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage.pressLoginButton();
        Assert.assertEquals(ConfProperties.getProperty("username"), profilePage.getUsername());
    }

    @Test(priority=2)
    public void send(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Assert.assertEquals("OK", profilePage.writeMessage());
    }

}
