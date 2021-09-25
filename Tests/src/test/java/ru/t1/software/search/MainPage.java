package ru.t1.software.search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[contains(@id, 'main_search')]")
    private WebElement mainSearch;

    @FindBy(xpath = "//*[contains(@id, 'search_options')]")
    private WebElement searchOptions;

    @FindBy(xpath = "//*[contains(@id, 's_forums')]")
    private WebElement forumsRadioButton;

    @FindBy(xpath = "//*[contains(@id, 's_members')]")
    private WebElement membersRadioButton;

    @FindBy(xpath = "//*[contains(@id, 's_core')]")
    private WebElement helpRadioButton;

    @FindBy(xpath = "//*[contains(@id, 's_calendar')]")
    private WebElement calendarRadioButton;

    @FindBy(xpath = "//*[contains(@class, 'submit_input clickable')]")
    private WebElement searchButton;

    @FindBy(xpath = "//*[contains(@class, 'ipsType_pagedesc')]")
    private WebElement searchResult;

    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void pressSearchField(){
        mainSearch.click();
    }

    public void enterText(String text){
        mainSearch.sendKeys(text);
    }

    private void setSearchOption(){
        searchOptions.click();
    }

    public void optionForums(){
        setSearchOption();
        forumsRadioButton.click();
    }

    public void optionMembers(){
        setSearchOption();
        membersRadioButton.click();
    }

    public void optionHelp(){
        setSearchOption();
        helpRadioButton.click();
    }

    public void optionCalendar(){
        setSearchOption();
        calendarRadioButton.click();
    }

    public void pressSearchButton(){
        searchButton.click();
    }

    public WebElement getResult(){
        return searchResult;
    }
}
