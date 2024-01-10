package TestClass;

import Common.BaseWeb;
import Common.ProperyRead;
import Common.XLFileRead;
import PageClass.LoginPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;


public class LoginTest extends BaseWeb {

ProperyRead read = new ProperyRead();
String email = read.getEmail();
String password =read.getPassword();
    @Test(priority = 1, description = "Verify user can Login with valid user name and valid password")
   public void ValidUsernameWithPassword() throws InterruptedException {

        LoginPage loginObj = new LoginPage(driver);

        loginObj.login(email, password);

        String ExpectedDisplay = "Welcome Remotly Qa";
        String ActualDisplay = loginObj.logvalidate.getText().toString();
        Assert.assertEquals(ExpectedDisplay, ActualDisplay);
        if (ActualDisplay.equals(ExpectedDisplay)) {
            System.out.println("Test pass");
        } else {
            System.out.println("Test Fail");
        }

    }

    @Test(priority = 2, description = "Verify user Unable Login with Invalid user name and Invalid password")
    public void InValidUsernameWithPassword() throws InterruptedException {

        LoginPage loginObj = new LoginPage(driver);

        loginObj.Input_Email.sendKeys("ttttttt");
        loginObj.Input_Password.sendKeys("555555");
        loginObj.button_Login.click();

        String ExpectedMessage ="An invalid email and password combination was entered, please try again.";
        String ActualMessage= loginObj.incorrectMessage.getText().toString();
        Assert.assertEquals(ActualMessage,ExpectedMessage);
        if (ExpectedMessage.equals(ActualMessage)){
            System.out.println("Test pass");
       }
        else {
            System.out.println("Test Fail");
        }


    }
    @Test(priority = 3, description = "Verify user Unable Login with Invalid user name and valid password")
    public void InValidUsernameWithvalidPassword() throws InterruptedException {

        LoginPage loginObj = new LoginPage(driver);

        loginObj.Input_Email.sendKeys("ttttttt");
        loginObj.Input_Password.sendKeys("Chathumnal@123");
        loginObj.button_Login.click();

        String ExpectedMessage = "An invalid email and password combination was entered, please try again.";
        String ActualMessage = loginObj.incorrectMessage.getText().toString();
        Assert.assertEquals(ActualMessage, ExpectedMessage);
        if (ExpectedMessage.equals(ActualMessage)) {
            System.out.println("Test pass");
        } else {
            System.out.println("Test Fail");
        }
    }
    @Test(priority = 4, description = "Verify user Unable Login  Without Entering UserName and Password ")
    public void WithoutUsernameAndPassword() throws InterruptedException {

        LoginPage loginObj = new LoginPage(driver);


        loginObj.button_Login.click();

        String ExpectedMessage1 = "Email is required!";
        String ExpectedMessage2 ="Password is required!";
        String ActualMessage1 = loginObj.EmailValidte.getText().toString();
        String ActualMessage2 = loginObj.PasswordValidate.getText().toString();
        Assert.assertEquals(ActualMessage1, ExpectedMessage1);
        Assert.assertEquals(ActualMessage2, ExpectedMessage2);

        if (ExpectedMessage1.equals(ActualMessage1) || ExpectedMessage2.equals(ActualMessage2)) {
            System.out.println("Test pass");

        } else {
            System.out.println("Test Fail");
        }
    }

    @Test(priority = 5, description = "Verify user Unable Login  Without Entering Password ")
    public void WithoutPassword() throws InterruptedException {

        LoginPage loginObj = new LoginPage(driver);

        loginObj.Input_Email.sendKeys("anutest1452@outlook.com");
        loginObj.button_Login.click();

        String ExpectedMessage1 = "Password is required!";
        String ActualMessage = loginObj.PasswordValidate.getText().toString();
        Assert.assertEquals(ActualMessage, ExpectedMessage1);

        if (ExpectedMessage1.equals(ActualMessage) ) {
            System.out.println("Test pass");
        } else {
            System.out.println("Test Fail");
        }
    }

    @Test(priority = 6, description = "Verify user Unable Login  Without Entering Email ")
    public void WithoutEmail() throws InterruptedException {

        LoginPage loginObj = new LoginPage(driver);

        loginObj.Input_Password.sendKeys("Chathumnal@123");
        loginObj.button_Login.click();

        String ExpectedMessage2 ="Email is required!";
        String ActualMessage1 = loginObj.EmailValidte.getText().toString();
        Assert.assertEquals(ActualMessage1, ExpectedMessage2);

        if (ExpectedMessage2.equals(ActualMessage1) ) {
            System.out.println("Test pass");

        } else {
            System.out.println("Test Fail");
        }
    }
    @Test(priority = 7, description = "Verify user should be able to navigate to Register page by click on Register link")
    public void NavigteToTheRegisterPage() throws InterruptedException {

        LoginPage loginObj = new LoginPage(driver);


        loginObj.RegisterButton.click();

        String ExpectedMessage2 ="Welcome";
        String ActualMessage = loginObj.RegisterPageVerification.getText().toString();
        Assert.assertEquals(ActualMessage, ExpectedMessage2);

        if (ExpectedMessage2.equals(ActualMessage) ) {
            System.out.println("Test pass");

        } else {
            System.out.println("Test Fail");
        }
    }
//this is xl data importer code.
//    @DataProvider(name = "Login")
//    String[][] getData() throws IOException{
//
//        String path = System.getProperty("user.dir")+"/src/test/java/DataFiles/Data.xlsx";
//
//        int rownum = XLFileRead.getRowCount(path,"sheet1");
//        int colcount = XLFileRead.getCellCount(path,"sheet1",1);
//
//        String Data[][] = new String[rownum][colcount];
//
//        for (int i=1;i<=rownum;i++){
//
//            for (int j=0;j<colcount;j++){
//
//                Data[i-1][j] = XLFileRead.getCellData(path,"sheet1",i,j);
//
//            }


}

//        return Data;

//    }

//}
