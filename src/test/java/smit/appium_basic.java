package smit;

import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class appium_basic extends BaseClass_1{

    @Test
    public void WifiSettingName() throws MalformedURLException, URISyntaxException, InterruptedException {

        /*
        ID.
        Class Name.
        Xpath.
        Accessibility ID.
        Android UI Automator.
        Android View Tag (Espresso Only)
        iOS UI Automation.
         */
       // ConfigeAppium(); //access parent class method
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();
        driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String wifiTitle=driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
        Assert.assertEquals(wifiTitle,"WiFi settings");

        driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("smit");
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();

       // tearDown();





    }
}
