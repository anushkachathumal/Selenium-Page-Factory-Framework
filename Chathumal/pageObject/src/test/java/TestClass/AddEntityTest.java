package TestClass;

import Common.BaseWeb;
import Common.ProperyRead;
import PageClass.AddEntityPage;
import PageClass.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddEntityTest extends BaseWeb {

    ProperyRead read = new ProperyRead();
    String email = read.getEmail();
    String password = read.getPassword();

    @Test(priority = 8, description ="Verify user should be able to navigate to New Entity page by click on Add new button in  entity page")
    public  void  TestNavigateEntity() throws InterruptedException{
        LoginPage logioobj = new LoginPage(driver);
        AddEntityPage entityobj = new AddEntityPage(driver);

        logioobj.login(email,password);
        entityobj.ClickEntity.click();
        String ExpectedDisplay ="Entity";
        String ActualDisplay = entityobj.navValidation.getText().toString();
        Assert.assertEquals(ExpectedDisplay,ActualDisplay);
        if (ActualDisplay.equals(ExpectedDisplay)){
            System.out.println("Test pass");
        }
        else {
            System.out.println("Test Fail");
        }
    }
    @Test(priority = 9, description ="Verify user should not be able to add new entity without giving Name")
    public  void  AddEntityWithoutName() throws InterruptedException {
        LoginPage logioobj = new LoginPage(driver);
        AddEntityPage entityobj = new AddEntityPage(driver);

        logioobj.login(email,password);
        entityobj.ClickEntity.click();
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='New']")));
        entityobj.ClickNewButton.click();

        Select dropdown1 = new Select(entityobj.SelectPEntity);
        dropdown1.selectByValue("78");

        Select dropdown2 = new Select(entityobj.SelectEntity);
        dropdown2.selectByValue("2");

        entityobj.ClickSave.click();

        String ExpectedMessage ="Please enter a name.";
        String ActualMessage= entityobj.NameValidation.getText().toString();
        Assert.assertEquals(ActualMessage,ExpectedMessage);
        if (ExpectedMessage.equals(ActualMessage)){
            System.out.println("Test pass");
        }
        else {
            System.out.println("Test Fail");
        }
    }
    @Test(priority = 10, description ="erify user should not be able to add new entity without giving Entity type")
    public  void  AddEntityWithoutEntityType() throws InterruptedException {
        LoginPage logioobj = new LoginPage(driver);
        AddEntityPage entityobj = new AddEntityPage(driver);

        logioobj.login(email,password);
        entityobj.ClickEntity.click();
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='New']")));
        entityobj.ClickNewButton.click();

        entityobj.EnterName.sendKeys("TEST");
        entityobj.ClickSave.click();

        String ExpectedMessage ="Please Select a Entity.";
        String ActualMessage= entityobj.NameValidation.getText().toString();
        Assert.assertEquals(ActualMessage,ExpectedMessage);
        if (ExpectedMessage.equals(ActualMessage)){
            System.out.println("Test pass");
        }
        else {
            System.out.println("Test Fail");
        }
    }
    }