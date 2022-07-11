package LiveProject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
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
import java.util.List;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public class Activity2 {

    AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "DY798HTS8LR4HIFU");
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
    }

    public void tapByCoordinates(int x, int y) {
        new TouchAction(driver)
                .tap(point(x, y))
                .waitAction(waitOptions(ofMillis(250))).perform();
    }


    @Test
    public void addNote() throws IOException, InterruptedException {

        String title = "My title";
        String string2 = "Complete Activity with Google Keep";
        tapByCoordinates(595, 1293);

        Thread.sleep(1000);
        MobileElement addTaskBox = driver.findElement(By.id("editable_title"));
        addTaskBox.sendKeys(title);
        MobileElement addTaskBox1 = driver.findElement(By.id("edit_note_text"));
        addTaskBox1.sendKeys(string2);
        takeScreenshot();
        MobileElement taskDoneButton1 = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=" + '"' + "Open navigation drawer" + '"' + "]"));
        taskDoneButton1.click();
        takeScreenshot();
        Thread.sleep(1000);

        String xpath ="//androidx.cardview.widget.CardView[@content-desc="+'"'+"My title. Complete Activity with Google Keep."+'"'+"]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView[1]";
         String result1= driver.findElement(By.xpath(xpath)).getText();

        Assert.assertTrue(result1.contains(title),result1);

    }

    public void takeScreenshot() throws IOException {
        // Take screenshot
        File scrShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String datetime = String.valueOf(System.currentTimeMillis());

        // This specifies the location the screenshot will be saved
        File screenShotName = new File("src/test/resources/screenshot" + datetime + ".jpg");

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
    public void tearDown() {

        driver.quit();
    }


}
