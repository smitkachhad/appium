package smit;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class BaseClass_1 {

    public AppiumDriverLocalService service;
    public AndroidDriver driver;

    @BeforeClass //it load device and start appium service
    public void ConfigeAppium() throws URISyntaxException, MalformedURLException {
        //start appium server from code
       service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();


       // System.out.println("ANDROID_HOME: " + System.getenv("ANDROID_HOME"));
        //create object of uiautomator to intract with android device
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel");
        options.setApp("//Users//smitk//IdeaProjects//Appium_u//appium_basic//src//test//java//resources//ApiDemos-debug.apk");

        //options.setApp("/Users/smitk/IdeaProjects/Appium_u/appium_basic/src/test/java/resources/ApiDemos-debug.apk");

        //options.setDeviceName("emulator-5554");
        driver = new AndroidDriver( new URI("http://127.0.0.1:4723/").toURL(), options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    //Long press
    public void longPress(WebElement element)
    {
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of(
                        "elementId", ((RemoteWebElement) element).getId(),
                        "duration",2000

                ));
    }


    //UI sutomator scroll || when we know the word till where we have to scroll
    public void uiSccroll(String ele)
    {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text("+ele+"))"));

    }

    //scroll action javascript || javascript method where we don't have idea till where we have to scroll
    public void scrollAct()
    {
        boolean canScrollMore;
        do
        {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 1.0
            ));
        }while (canScrollMore);
        }


    @AfterClass
    public void tearDown()
    {
        driver.quit();
        service.stop();

    }
}
