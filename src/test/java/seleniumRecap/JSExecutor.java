package seleniumRecap;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class JSExecutor extends TestBase {

    String item = "web camera";

    @Test
    public void test(){
        driver.get("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(item+ Keys.ENTER);
        JavascriptExecutor js = ((JavascriptExecutor)driver);
        js.executeScript("window.scrollBy(0, 2500)");
        driver.findElement(By.xpath("//li[@id='p_n_availability/2661601011']//i")).click();
        js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
        js.executeScript("window.scrollBy(2500,0)");

    }

    @Test
    public void jsTest(){

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.location='https://www.amazon.com/'");
        WebElement customer = driver.findElement(By.xpath("//a[@data-csa-c-content-id='nav_cs_customerservice']"));
        js.executeScript("arguments[0].click()", customer);

       // Assert.assertEquals(driver.getTitle(), "Help & Contact Us - Amazon Customer Service");
        Assert.assertEquals(js.executeScript("return document.title;").toString(),
                "Help & Contact Us - Amazon Customer Service" );
       js.executeScript("alert('This is my alert')");

    }
}
