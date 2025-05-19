package mobile.screens;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static com.codeborne.selenide.appium.ScreenObject.screen;

public class GetPremiumScreen {

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonClose")
    public SelenideElement closeButton;

    public <T> T closePremiumScreenAt(Class<T> returnType) {
        closeButton.click();
        return screen(returnType);
    }
}
