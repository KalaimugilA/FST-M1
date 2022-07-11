import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {

    WebDriver driver;

    @BeforeClass
   public void setUp()
    {
        System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
         driver = new FirefoxDriver();
  driver.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void testHeadingMethod(){
    String browserHeading=
            driver.findElement(By.xpath("//h1[contains(text(),'Learn from Industry Experts')]")).getText();
        String expectedHeading="Learn from Industry Experts";

        Assert.assertEquals(browserHeading,expectedHeading);
    }

    @AfterClass
    public void tearDown()
    {

        driver.close();
    }

}
