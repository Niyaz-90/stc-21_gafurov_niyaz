package ru.t1.software.login;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.t1.software.ConfProperties;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    
    private static LoginPage loginPage;
    private static UserPage userPage;
    private static WebDriver driver;

    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        userPage = new UserPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("url"));
    }

    @Test
    public void login(){
        loginPage.pressSignInButton();
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPassword(ConfProperties.getProperty("password"));
        loginPage.pressLoginButton();
        Assert.assertEquals(ConfProperties.getProperty("login"), userPage.getUsername());
    }

    @AfterClass
    public static void tearDown(){
        userPage.pressLogoutButton();
        driver.quit();
    }
}
