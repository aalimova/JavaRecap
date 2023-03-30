package seleniumRecap;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class WindowHandles extends TestBase {

    @Test
    public void windowHandleTest(){
        driver.get("https://the-internet.herokuapp.com/windows");
        String mainWindowId = driver.getWindowHandle();
        driver.findElement(By.linkText("Click Here")).click();


        Set<String> windowIds = driver.getWindowHandles();

        for(String windowId: windowIds){
            if(!windowId.equalsIgnoreCase(mainWindowId)){
                driver.switchTo().window(windowId);
            }
        }

        String newWindowText = driver.findElement(By.tagName("h3")).getText();

        Assert.assertEquals(newWindowText,"New Window");
    }
}
