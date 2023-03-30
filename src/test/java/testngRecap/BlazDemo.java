package testngRecap;

import org.testng.annotations.Test;
import utilities.TestBase;
import utilities.ConfigReader;

public class BlazDemo extends TestBase {


    @Test
    public void verifyBlazeDemo(){
        driver.get(ConfigReader.getProperty("URL"));
    }


}
