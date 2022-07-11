import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity4 {

    WebDriver driver;

    @BeforeClass
   public void setUp()
    {
        System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
         driver = new FirefoxDriver();
  driver.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void testsecondpopularMethod(){
    String browserspTitle=
            driver.findElement(By.xpath("//h3[contains(text(),'Email Marketing Strategies')]")).getText();
        String expectedspTitle="Email Marketing Strategies";

        Assert.assertEquals(browserspTitle,expectedspTitle);
    }

    @AfterClass
    public void tearDown()
    {

        driver.close();
    }

}
