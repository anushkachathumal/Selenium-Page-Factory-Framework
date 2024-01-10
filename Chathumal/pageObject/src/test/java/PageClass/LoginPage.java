package PageClass;

import Common.XLFileRead;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static Common.BaseWeb.driver;

public class LoginPage {

    WebDriver driver_One;

    public LoginPage(WebDriver driver_Two){

        driver_One = driver_Two;
        PageFactory.initElements(driver_Two,this);

    }

    @FindBy(name = "email")// userName
    @CacheLookup
    public WebElement Input_Email;

    @FindBy(name = "password") //password
    @CacheLookup
    public WebElement Input_Password;


    @FindBy(xpath = "//button[normalize-space()='Login']") // sing in button
    @CacheLookup
    public WebElement button_Login;

    @FindBy(xpath = "//div[@class='notification notification-error notification-enter-done']")
    @CacheLookup
    public WebElement incorrectMessage;

    @FindBy(xpath = "//p[@class='hidden md:block mt-3']")
    @CacheLookup
    public WebElement logvalidate;
    @FindBy(xpath = "//div[normalize-space()='Email is required!']")
    @CacheLookup
    public WebElement EmailValidte;

    @FindBy(xpath = "//div[normalize-space()='Password is required!']")
    @CacheLookup
    public WebElement PasswordValidate;

    @FindBy(xpath = "//a[@class='relative z-10 font-semibold text-transparent bg-gradient-to-tl from-blue-700 to-purple-500 bg-clip-text']")
    @CacheLookup
    public WebElement RegisterButton;

    @FindBy(xpath = "//div[@id='root']/div[2]/div[2]/div/div/div/div/div/div/div/div/form/h5")
    @CacheLookup
    public WebElement RegisterPageVerification;

public void login(String email, String password){
    Input_Email.sendKeys(email);
    Input_Password.sendKeys(password);
    button_Login.click();


    //button_Login2.click();
   // button_Login2.click();
}

      }




