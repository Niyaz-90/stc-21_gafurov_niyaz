package lab.test.task.pattern.pageObject;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {
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

    @Test
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
}
