package PageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEntityPage {
    WebDriver driver_One;

    public AddEntityPage(WebDriver driver_Two) {

        driver_One = driver_Two;
        PageFactory.initElements(driver_Two, this);
    }
    @FindBy(xpath = "//div[@id='root']/div[2]/div/ul/div/div/div[2]/div/div/div/li[11]/a")// EntityClick
    @CacheLookup
    public WebElement ClickEntity;

    @FindBy(xpath = "//div[@class='card-header']")// navValidation
    @CacheLookup
    public WebElement navValidation;
    @FindBy(xpath = "//button[normalize-space()='New']")// clicknewbutton
    @CacheLookup
    public WebElement ClickNewButton;
    @FindBy(id = "name")// name
    @CacheLookup
    public WebElement EnterName;

    @FindBy(id = "entity")// Pentity
    @CacheLookup
    public WebElement SelectPEntity;
    @FindBy(id = "entityType")// entity
    @CacheLookup
    public WebElement SelectEntity;

    @FindBy(xpath = "//button[@type='submit']")// savebutton
    @CacheLookup
    public WebElement ClickSave;

    @FindBy(xpath = "//div[normalize-space()='Please enter a name.']")// name validation
    @CacheLookup
    public WebElement NameValidation;

    @FindBy(xpath = "//div[normalize-space()='Please Select a Entity.']")// Entity validation
    @CacheLookup
    public WebElement EntityValidation;
}

