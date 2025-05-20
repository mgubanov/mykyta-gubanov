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
import static mobile.utils.Config.*;

public class AndroidDriverSetup implements WebDriverProvider {

    @Override
    @CheckReturnValue
    @NonNull
    public WebDriver createDriver(Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setPlatformName(getPlatformName());
        options.setPlatformVersion(getPlatformVersion());
        options.setDeviceName(getDeviceName());
        options.setNewCommandTimeout(getCommandTimeout());
        options.setApp(Config.getAppPath());
        options.setAppPackage(getAppPackage());
        options.setAppActivity(getAppActivity());

        try {
            return new AndroidDriver(new URL(getAppiumServerUrl()), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
