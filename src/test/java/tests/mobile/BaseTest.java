package tests.mobile;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import mobile.core.AndroidDriver;
import mobile.screens.MainScreen;
import mobile.screens.onboarding.OnboardingGetStartedScreen;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import static com.codeborne.selenide.appium.ScreenObject.screen;
import static com.codeborne.selenide.appium.SelenideAppium.launchApp;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        Configuration.browser = AndroidDriver.class.getName();
        launchApp();
    }

    @BeforeSuite
    public void beforeSuite() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    protected MainScreen completeOnboardingFlow(){
        return screen(OnboardingGetStartedScreen.class)
                .clickContinue()
                .clickContinue()
                .clickContinue()
                .closePremiumScreenAt(MainScreen.class);
    }
}
