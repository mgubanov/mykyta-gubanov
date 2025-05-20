package mobile.core;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.jspecify.annotations.NonNull;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.slf4j.helpers.CheckReturnValue;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidDriver implements WebDriverProvider {

    public static final String APP_PATH = "/Users/mykyta.gubanov/IdeaProjects/mykyta-gubanov/src/main/resources/apps/com.monefy.app.lite_1.18.0.apk";
    public static final String APP_PACKAGE = "com.monefy.app.lite";
    public static final String DEVICE_NAME = "R5CXA32PS6P";

    @Override
    @CheckReturnValue
    @NonNull
    public WebDriver createDriver(Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setPlatformName("Android");
        options.setPlatformVersion("14.0");
        options.setDeviceName(DEVICE_NAME);
//        options.setNewCommandTimeout(Duration.ofSeconds(11));
//        options.setFullReset(false);
        options.setApp(APP_PATH);
        options.setAppPackage(APP_PACKAGE);
        options.setAppActivity("com.monefy.activities.main.MainActivity_");

        try {
            return new io.appium.java_client.android.AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
