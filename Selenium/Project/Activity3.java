import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {

    WebDriver driver;

    @BeforeClass
   public void setUp()
    {
        System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
         driver = new FirefoxDriver();
  driver.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void testinfotitleMethod(){
    String browserinfoTitle=
            driver.findElement(By.xpath("//h3[contains(text(),'Actionable Training')]")).getText();
        String expectedinfoTitle="Actionable Training";

        Assert.assertEquals(browserinfoTitle,expectedinfoTitle);
    }

    @AfterClass
    public void tearDown()
    {

        driver.close();
    }

}
