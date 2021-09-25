package ru.t1.software.search;

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

public class SearchTest {
    private static WebDriver driver;
    private static MainPage mainPage;

    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("url"));
    }

    @Test
    public void searching(){
        mainPage.pressSearchField();
        mainPage.enterText(ConfProperties.getProperty("searching_text"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage.optionMembers();
        mainPage.pressSearchButton();
        List<WebElement> result = mainPage.getResult().findElements(By.tagName("strong"));
        Assert.assertEquals(ConfProperties.getProperty("searching_text"), result.get(0).getText());
        Assert.assertNotNull(result.get(1));
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
