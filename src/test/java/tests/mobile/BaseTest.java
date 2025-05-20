package tests.mobile;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.appium.AppiumDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.appium.java_client.android.nativekey.KeyEvent;
import mobile.core.AndroidDriver;
import mobile.screens.MainScreen;
import mobile.screens.SearchResultsScreen;
import mobile.screens.onboarding.OnboardingGetStartedScreen;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;


import static com.codeborne.selenide.appium.ScreenObject.screen;
import static com.codeborne.selenide.appium.SelenideAppium.*;
import static io.appium.java_client.android.nativekey.AndroidKey.ENTER;

public class BaseTest {

    @AfterMethod
    public void tearDown() {
        AppiumDriverRunner.getAndroidDriver().removeApp(AndroidDriver.APP_PACKAGE);
        AppiumDriverRunner.getAndroidDriver().installApp(AndroidDriver.APP_PATH);
        relaunchApp(AndroidDriver.APP_PACKAGE);
    }

    @BeforeSuite
    public void beforeSuite() {
        Configuration.browser = AndroidDriver.class.getName();
        launchApp();
    }

    protected MainScreen completeOnboardingFlow(){
        return screen(OnboardingGetStartedScreen.class)
                .clickContinue()
                .clickContinue()
                .clickContinue()
                .closePremiumScreenAt(MainScreen.class);
    }

    protected SearchResultsScreen submitSearch(){
        AppiumDriverRunner.getAndroidDriver().pressKey(new KeyEvent(ENTER));
        return screen(SearchResultsScreen.class);
    }
}
