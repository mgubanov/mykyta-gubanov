package mobile.core;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.jspecify.annotations.NonNull;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.slf4j.helpers.CheckReturnValue;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AndroidDriver implements WebDriverProvider {

    @Override
    @CheckReturnValue
    @NonNull
    public WebDriver createDriver(Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setPlatformName("Android");
        options.setPlatformVersion("14.0");
        options.setDeviceName("R5CXA32PS6P");
        options.setNewCommandTimeout(Duration.ofSeconds(11));
//        options.setFullReset(false);
        options.setApp("/Users/mykyta.gubanov/IdeaProjects/mykyta-gubanov/src/main/resources/apps/com.monefy.app.lite_1.18.0.apk");
        options.setAppPackage("com.monefy.app.lite");
        options.setAppActivity("com.monefy.activities.main.MainActivity_");

        try {
            return new io.appium.java_client.android.AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
