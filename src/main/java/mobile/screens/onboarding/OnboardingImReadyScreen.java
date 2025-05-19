package mobile.screens.onboarding;

import mobile.screens.GetPremiumScreen;

import static com.codeborne.selenide.appium.ScreenObject.screen;

public class OnboardingImReadyScreen extends OnboardingScreen {

    public GetPremiumScreen clickContinue(){
        continueButton.click();
        return screen(GetPremiumScreen.class);
    }
}
