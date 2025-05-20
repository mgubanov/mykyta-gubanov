package mobile.core;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import mobile.utils.Config;
import org.jspecify.annotations.NonNull;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.slf4j.helpers.CheckReturnValue;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AndroidDriverSetup implements WebDriverProvider {

    @Override
    @CheckReturnValue
    @NonNull
    public WebDriver createDriver(Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setPlatformName(Config.platformName());
        options.setPlatformVersion(Config.platformVersion());
        options.setDeviceName(Config.deviceName());
        options.setNewCommandTimeout(Duration.ofSeconds(10));
        options.setApp(Config.appPath());
        options.setAppPackage(Config.appPackage());
        options.setAppActivity(Config.appActivity());

        try {
            return new AndroidDriver(new URL(Config.appiumServerUrl()), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
