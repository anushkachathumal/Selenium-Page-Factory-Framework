package PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
    WebDriver driver_One;

    public RegisterPage(WebDriver driver_Two){

        driver_One = driver_Two;
        PageFactory.initElements(driver_Two,this);

    }

    @FindBy(name = "email")// email
    @CacheLookup
    public WebElement EnterEmail;
    @FindBy(name = "firstName")// fname
    @CacheLookup
    public WebElement EnterFirstName;
    @FindBy(name = "lastName")// lastname
    @CacheLookup
    public WebElement EnterLastName;
    @FindBy(name = "password")// password
    @CacheLookup
    public WebElement EnterPassword;

    @FindBy(name = "passwordAgain")// Cpassword
    @CacheLookup
    public WebElement EnterComformPassword;
    @FindBy(id = "usePurposePersonal")// usePurpose
    @CacheLookup
    public WebElement selectPersonalUser;
    @FindBy(id = "usePurposeCorporate")// usePurposeCorporate
    @CacheLookup
    public WebElement selectCoperateUser;
    @FindBy(id = "flexCheckDefaultCheckbox")//flexCheckDefaultCheckbox
    @CacheLookup
    public WebElement selectAcceptTearm;

    @FindBy(id = "recaptcha-anchor")// recpat
    @CacheLookup
    public WebElement selectrecaptcha;
    @FindBy(id = "//*[@id=\"root\"]/div[2]/div[2]/div/div[1]/div/div/div/div/div/div/form/div[17]/div/button")// Button
    @CacheLookup
    public WebElement ClickButton;
    @FindBy(xpath = "//a[@class='relative z-10 font-semibold text-transparent bg-gradient-to-tl from-blue-700 to-purple-500 bg-clip-text']")
    @CacheLookup
    public WebElement RegisterButton;

    public void registerd(String mail,String faname, String Lname, String password, String Cpassword){
        WebDriverWait wait = new WebDriverWait(driver_One,60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='relative z-10 font-semibold text-transparent bg-gradient-to-tl from-blue-700 to-purple-500 bg-clip-text']")));
        RegisterButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
        EnterEmail.sendKeys(mail);
        EnterFirstName.sendKeys(faname);
        EnterLastName.sendKeys(Lname);
        EnterPassword.sendKeys(password);
        EnterComformPassword.sendKeys(Cpassword);
        selectPersonalUser.click();
        selectAcceptTearm.click();
        selectrecaptcha.click();
        ClickButton.click();
    }
}
