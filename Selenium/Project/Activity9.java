import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity9 {

    WebDriver driver;

    @BeforeClass
   public void setUp()
    {
        System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
         driver = new FirefoxDriver();
  driver.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void testMethod() throws Exception {
        driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();

        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("root");
        driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//input[@id='wp-submit']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'All Courses')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//body/div[@id='page']/div[@id='content']/div[1]/div[1]/main[1]/article[1]/div[1]/section[2]/div[2]/div[1]/div[1]/div[1]/div[1]/article[1]/div[2]/p[2]/a[1]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//body/div[@id='page']/div[@id='content']/div[1]/div[1]/main[1]/article[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/span[2]")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//body/div[@id='page']/div[@id='content']/div[1]/div[1]/main[1]/article[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/a[1]")).click();
        Thread.sleep(1000);

        String tile = driver.getTitle();
String Expectedtitle="This is the First Topic – Alchemy LMS";
        Assert.assertEquals(tile,Expectedtitle);


    }
    @AfterClass
    public void tearDown()
    {

        driver.close();
    }

}
