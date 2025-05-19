package mobile.screens.onboarding;

import static com.codeborne.selenide.appium.ScreenObject.screen;

public class OnboardingGetStartedScreen extends OnboardingScreen {

    public OnboardingAmazingScreen clickContinue(){
        continueButton.click();
        return screen(OnboardingAmazingScreen.class);
    }
}
