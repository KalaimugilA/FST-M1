import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity6 {

    WebDriver driver;

    @BeforeClass
   public void setUp()
    {
        System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
         driver = new FirefoxDriver();
  driver.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void testloginMethod(){
            driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();
        String browserTitle=driver.getTitle();
        String expectedTitle="My Account – Alchemy LMS";

        Assert.assertEquals(browserTitle,expectedTitle);

        driver.findElement(By.linkText("Login")).click();
driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("root");
driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//input[@id='wp-submit']")).click();
String displayName =driver.findElement(By.xpath("//body/div[@id='wpadminbar']/div[@id='wp-toolbar']/ul[@id='wp-admin-bar-top-secondary']/li[@id='wp-admin-bar-my-account']/a[1]/span[1]")).getText();
        Assert.assertEquals(displayName,"root");


    }

    @AfterClass
    public void tearDown()
    {

        driver.close();
    }

}
