import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity7 {

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
    driver.findElement(By.xpath("//a[contains(text(),'All Courses')]")).click();
    int courses=driver.findElements( By.xpath("//div[@class='ld-course-list-items row']//div[@class='ld_course_grid col-sm-8 col-md-4 ']")).size();
 System.out.println("Number of courses :"+ courses);
         }
    @AfterClass
    public void tearDown()
    {

        driver.close();
    }

}
