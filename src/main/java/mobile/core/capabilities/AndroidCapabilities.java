package mobile.core.capabilities;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class AndroidCapabilities {
    public static AndroidDriver createDriver() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "R5CXA32PS6P"); // or device ID from `adb devices`
        caps.setCapability("app", "/Users/mykyta.gubanov/IdeaProjects/mykyta-gubanov/src/main/resources/apps/com.monefy.app.lite_1.18.0.apk");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.monefy.app.lite");
        caps.setCapability("appActivity", "com.monefy.activities.main.MainActivity_");
        return new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
    }
}
