import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity8 {

    WebDriver driver;

    @BeforeClass
   public void setUp()
    {
        System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
         driver = new FirefoxDriver();
  driver.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void testMethod(){
       driver.findElement(By.xpath("//a[contains(text(),'Contact')]")).click();
       driver.findElement(By.id("wpforms-8-field_0")).sendKeys("Kalai");
         driver.findElement(By.id("wpforms-8-field_1")).sendKeys("Kalai@ibm.com");
         driver.findElement(By.id("wpforms-8-field_3")).sendKeys("Selenium");
         driver.findElement(By.id("wpforms-8-field_2")).sendKeys("Good course");
driver.findElement(By.xpath("//button[@id='wpforms-submit-8']")).click();

String Message =driver.findElement(By.xpath("//p[contains(text(),'Thanks for contacting us! We will be in touch with')]")).getText();
System.out.println("Message displayed after submission :" + Message);
    }
    @AfterClass
    public void tearDown()
    {

        driver.close();
    }

}
