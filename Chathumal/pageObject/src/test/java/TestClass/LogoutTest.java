package TestClass;

import Common.BaseWeb;
import Common.ProperyRead;
import PageClass.LoginPage;
import PageClass.LogoutPage;
import org.testng.annotations.Test;

public class LogoutTest extends BaseWeb {
    ProperyRead read = new ProperyRead();
    String email = read.getEmail();
    String password =read.getPassword();
    @Test(description = "Verify user can logout the system.")
    public void LogoutTheSystem() throws InterruptedException {

        LogoutPage logoutObj = new LogoutPage(driver);
        LoginPage  loginObj = new LoginPage(driver);

        loginObj.login(email,password);
        logoutObj.ClickArrow.click();
        logoutObj.Logout.click();
        String ExpectedDisplay ="Account Login";
        String ActualDisplay = logoutObj.logvalidate.getText().toString();
        if (ActualDisplay.equals(ExpectedDisplay)){
            System.out.println("Test pass");
        }
        else {
            System.out.println("Test Fail");
        }



    }
}