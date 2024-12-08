package smit;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class scrollDemo extends BaseClass_1{

    @Test
    public void scroll() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        //when we know the word till where we have to scroll
        //uiautomator method
       //driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));

        //methiod in main class and pass word in method
       // uiSccroll("\"WebView\"");

        //javascript method where we don't have idea till where we have to scroll
        scrollAct();


       Thread.sleep(2000);
    }
}
