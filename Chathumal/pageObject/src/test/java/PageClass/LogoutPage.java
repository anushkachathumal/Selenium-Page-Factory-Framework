package PageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
    WebDriver driver_One;

    public LogoutPage(WebDriver driver_Two){

        driver_One = driver_Two;
        PageFactory.initElements(driver_Two,this);

    }

    @FindBy(id= "logged-user-name")
    @CacheLookup
    public WebElement ClickArrow;

    @FindBy(xpath = "//a[@id='signout-dropdown-item']")
    @CacheLookup
    public WebElement Logout;

    @FindBy(xpath = "//h3[@id='h3AccountLogin']")
    @CacheLookup
    public WebElement logvalidate;

//    public void logout (){
//        ClickArrow.click();
//        Logout.click();
//    }


}
