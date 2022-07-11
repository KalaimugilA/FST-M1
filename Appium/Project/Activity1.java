package LiveProject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Activity1 {

    AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "DY798HTS8LR4HIFU");
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
    }

    @Test
    public void addCompleteTask() throws IOException, InterruptedException {

        String string1="Complete Activity with Google Tasks";
        String string2="Complete Activity with Google Keep";
        String string3="Complete the second Activity Google Keep";
    MobileElement taskButton =driver.findElement(By.id("tasks_fab"));
    taskButton.click();
    Thread.sleep(1000);
       MobileElement addTaskBox =driver.findElement(By.id("add_task_title"));
        addTaskBox.sendKeys(string1);
        MobileElement taskDoneButton =driver.findElement(By.id("add_task_done"));
        taskDoneButton.click();
        takeScreenshot();
        taskButton.click();
        Thread.sleep(1000);
        MobileElement addTaskBox1 =driver.findElement(By.id("add_task_title"));
        addTaskBox1.sendKeys(string2);
        MobileElement taskDoneButton1 =driver.findElement(By.id("add_task_done"));
        taskDoneButton1.click();
        takeScreenshot();
        taskButton.click();
        Thread.sleep(1000);

        MobileElement addTaskBox2 =driver.findElement(By.id("add_task_title"));
        addTaskBox2.sendKeys(string3);
        MobileElement taskDoneButton2 =driver.findElement(By.id("add_task_done"));
        taskDoneButton2.click();
        takeScreenshot();
      String  xpath1="//android.widget.FrameLayout[@content-desc="+'"'+"Complete the second Activity Google Keep"+'"'+"]/android.view.ViewGroup/android.widget.TextView";
        String  xpath2="//android.widget.FrameLayout[@content-desc="+'"'+"Complete Activity with Google Keep"+'"'+"]/android.view.ViewGroup/android.widget.TextView";
        String  xpath3="//android.widget.FrameLayout[@content-desc="+'"'+"Complete Activity with Google Tasks"+'"'+"]/android.view.ViewGroup/android.widget.TextView";
        String result1= driver.findElement(By.xpath(xpath3)).getText();
        Assert.assertEquals(result1,string1);
        String result2= driver.findElement(By.xpath(xpath2)).getText();
        Assert.assertEquals(result2,string2);
        String result3= driver.findElement(By.xpath(xpath1)).getText();
        Assert.assertEquals(result3,string3);


    }

    public void takeScreenshot() throws IOException {
        // Take screenshot
        File scrShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String datetime = String.valueOf(System.currentTimeMillis());

        // This specifies the location the screenshot will be saved
        File screenShotName = new File("src/test/resources/screenshot"+ datetime+".jpg");

        // This will copy the screenshot to the file created
        FileUtils.copyFile(scrShot, screenShotName);

        // Set filepath for image
        String filePath = "../" + screenShotName;

        // Set image HTML in the report
        String path = "<img src='" + filePath + "'/>";

        // Show image in report
        Reporter.log(path);
    }

    @AfterClass
    public void tearDown()
    {

        driver.quit();
    }


}
