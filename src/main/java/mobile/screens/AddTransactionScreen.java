package mobile.screens;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.appium.ScreenObject.screen;

public class AddTransactionScreen <T extends AddTransactionScreen<T>> {

    @AndroidFindBy(id="com.monefy.app.lite:id/amount_text")
    public SelenideElement amountField;
    @AndroidFindBy(id="com.monefy.app.lite:id/keyboard_action_button")
    public SelenideElement chooseCategory;
    @AndroidFindBy(id="com.monefy.app.lite:id/textViewNote")
    public SelenideElement noteInputField;
    @AndroidFindBy(xpath = "//*[contains(@resource-id, \"com.monefy.app.lite:id/buttonKeyboard\")]")
    public ElementsCollection keyboardButton;

    public CategoryScreen chooseCategory() {
        chooseCategory.click();
        return screen(CategoryScreen.class);
    }

    @SuppressWarnings("unchecked")
    public T inputAmount(String amount) {
        amount.chars()
                .mapToObj(ch -> String.valueOf((char) ch))
                .forEach(chStr -> keyboardButton.findBy(text(chStr)).click());
        return (T) this;
    }
}
