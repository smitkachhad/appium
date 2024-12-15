package smit;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class miscellaneous extends BaseClass_1{

    @Test
    public void miscellaneous() throws MalformedURLException, URISyntaxException, InterruptedException {


        // app activity
        //  adb shell dumpsys window | grep -E 'mCurrentFocus'  --EXTCUTE THIS COMMAND TO GET APP ACTIVITY
        //  mCurrentFocus=Window{2d75e14 u0 io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies} after "/" activtiy name

        Activity activity=new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");

        ((JavascriptExecutor) driver).executeScript("mobile: startActivity",
                ImmutableMap.of("intent","io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));

       /* ConfigeAppium(); //access parent class method
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        */

        driver.findElement(AppiumBy.id("android:id/checkbox")).click();

        //rotation
    /*    DeviceRotation rot= new DeviceRotation(0,0,90); //landscape mode
        driver.rotate(rot);*/

        driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String wifiTitle=driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
        Assert.assertEquals(wifiTitle,"WiFi settings");

        //copy -past
        driver.setClipboardText("smit");

        driver.findElement(AppiumBy.id("android:id/edit")).sendKeys(driver.getClipboardText());
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        driver.findElement(AppiumBy.id("android:id/edit")).sendKeys(driver.getClipboardText());


        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();

        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Thread.sleep(2000);
        driver.pressKey(new KeyEvent(AndroidKey.HOME));




        // tearDown();





    }
}
