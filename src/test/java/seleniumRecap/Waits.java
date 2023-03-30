package seleniumRecap;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Waits {

WebDriver driver;

    @BeforeMethod
    public void setUp(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
   // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://the-internet.herokuapp.com/dynamic_controls");
}

    @Test
    public void implicitlyWaitTest(){
    WebElement msg = driver.findElement(By.id("message"));
    System.out.println(msg);
}

    @Test
    public void explicitlyWaitTest(){
        WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        WebElement removeBtn = driver.findElement(By.xpath("//button[contains(text(),'Remove')]"));

        checkbox.click();
        removeBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        String message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message"))).getText();

       // WebElement msg = driver.findElement(By.id("message"));
        Assert.assertEquals(message,"It's gone!");
    }

    @Test
    public void fluentWaitTest(){
        WebElement enableBtn = driver.findElement(By.xpath("//button[contains(text(),'Enable']"));
        enableBtn.click();

        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(20,TimeUnit.SECONDS)
                .pollingEvery(5,TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

     //   WebElement acutalMessage = fluentWait.until(new Function<WebDriver, WebElement>())
    }
    @AfterMethod
    public void tearDown(){
    driver.quit();
}

}
