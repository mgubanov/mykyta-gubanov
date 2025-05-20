package mobile.utils;

import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

@UtilityClass
public class Config {
    private static final Properties props = new Properties();

    static {
        try (InputStream input = Config.class.getResourceAsStream("/config.properties")) {
            props.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getAppPath() { return props.getProperty("app.path"); }
    public static String getAppPackage() { return props.getProperty("app.package"); }
    public static String getAppActivity() { return props.getProperty("app.activity"); }
    public static String getDeviceName() { return props.getProperty("device.name"); }
    public static String getPlatformName() { return props.getProperty("platform.name"); }
    public static String getPlatformVersion() { return props.getProperty("platform.version"); }
    public static String getAppiumServerUrl() { return props.getProperty("appium.server.url"); }
    public static Duration getCommandTimeout() { return Duration.ofSeconds(Long.parseLong(props.getProperty("command.timeout.seconds"))); }
}
