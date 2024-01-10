package Common;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ProperyRead {
    Properties properties;

    public ProperyRead() {

        File loaction = new File("./credintial/cr.properties");

        try {
            FileInputStream fis = new FileInputStream(loaction);
            properties = new Properties();
            properties.load(fis);
        } catch (Exception e) {
            System.out.printf("Exception is " + e.getMessage());
        }

    }

    public String getEmail() {

        String Emailname = properties.getProperty("Email");
        return Emailname;

    }
    public String getPassword() {

        String Passwordname = properties.getProperty("password");
        return Passwordname;
    }
}
