package mobile.screens.onboarding;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class OnboardingScreen {
    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonContinue")
    public SelenideElement continueButton;
}
