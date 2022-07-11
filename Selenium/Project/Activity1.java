import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {

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
    String browserTitle=driver.getTitle();
        String expectedTitle="Alchemy LMS – An LMS Application";

        Assert.assertEquals(browserTitle,expectedTitle);
    }

    @AfterClass
    public void tearDown()
    {

        driver.close();
    }

}
