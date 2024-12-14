package smit;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class drag_Drop extends BaseClass_1 {

    @Test
    public void drag_drop_demo() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement element=driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
        dragDrop(element,630,623);
        Thread.sleep(2000);
        String text=driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text")).getText();
        Assert.assertEquals(text,"Dropped!");

    }

}
