package TestClass;

import Common.BaseWeb;
import Common.ProperyRead;
import Common.XLFileRead;
import PageClass.RegisterPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static Common.BaseWeb.driver;

public class RegisterTest extends BaseWeb {

    @Test(dataProvider = "Data.xlsx",priority = 1, description = "Verify user should be able to register to the system by filling required fields in Register form")
    public void RegWithValidData(String Email , String FirstName, String Lastname, String Passowrd, String Cpassowrd) throws InterruptedException {

        RegisterPage regobj = new RegisterPage(driver);

        regobj.registerd(Email, FirstName, Lastname, Passowrd, Cpassowrd);
    }

    @DataProvider(name = "Data.xlsx")
    String[][] getData() throws IOException {

        String path = System.getProperty("user.dir") + "/src/test/java/DataFiles/Data.xlsx";

        int rownum = XLFileRead.getRowCount(path, "sheet1");
        int colcount = XLFileRead.getCellCount(path, "sheet1", 1);

        String Data[][] = new String[rownum][colcount];

        for (int i = 1; i <= rownum; i++) {

            for (int j = 0; j < colcount; j++) {

                Data[i - 1][j] = XLFileRead.getCellData(path, "sheet1", i, j);

            }


        }

        return Data;
    }
}

