package mobile.screens;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.appium.ScreenObject.screen;

public class AddExpenseFromCategoryScreen extends AddTransactionScreen<AddExpenseFromCategoryScreen> {

    @AndroidFindBy(id="com.monefy.app.lite:id/keyboard_action_button")
    private SelenideElement addExpenseToCategoryButton;

    public MainScreen addExpenseToCategory() {
        addExpenseToCategoryButton.click();
        return screen(MainScreen.class);
    }
}
