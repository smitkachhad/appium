package smit;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ass_1 extends BaseClass_1{

    @BeforeMethod
    public void exp_1()
    {
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='App']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Alert Dialogs']")).click();

    }

    @Test
    public void test_1()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='Text Entry dialog']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='io.appium.android.apis:id/username_edit']")).sendKeys("smit");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='io.appium.android.apis:id/password_edit']")).sendKeys("pass");
        driver.findElement(AppiumBy.id("android:id/button1")).click();
        driver.findElement(AppiumBy.id("io.appium.android.apis:id/checkbox_button")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='Every Wednesday']")).click();


    }

 /*   @Test
    public void test_2()
    {
        driver.findElement(AppiumBy.id("io.appium.android.apis:id/checkbox_button")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='Every Wednesday']")).click();
    }*/
}
