package seleniumRecap;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class WindowHandles2 extends TestBase {

    ChromeOptions options = new ChromeOptions();

    @Test
    public void windowHandles(){
        options.setHeadless(false);
        driver.get("https://www.amazon.com/");
        String mainWindow = driver.getWindowHandle();
        System.out.println(mainWindow);
        driver.findElement(By.xpath("//a[contains(text(),'Toys & Games')]")).click();

        Set<String> windowIds = driver.getWindowHandles();
        for (String windowsId: windowIds){
            System.out.println(windowsId);
        }
//            if(!windowsId.equalsIgnoreCase(mainWindow)){
//                driver.switchTo().window(windowsId);
//            }
//        }
//        System.out.println(windowIds);
//        String newWindowText = driver.findElement(By.tagName("h1")).getText();
//        Assert.assertEquals(newWindowText, "Toys & Games");

    }
}
