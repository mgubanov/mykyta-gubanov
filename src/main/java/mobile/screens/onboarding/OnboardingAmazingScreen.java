package mobile.screens.onboarding;

import static com.codeborne.selenide.appium.ScreenObject.screen;

public class OnboardingAmazingScreen extends OnboardingScreen {

    public OnboardingImReadyScreen clickContinue(){
        continueButton.click();
        return screen(OnboardingImReadyScreen.class);
    }
}
