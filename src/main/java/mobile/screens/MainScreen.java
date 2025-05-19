package mobile.screens;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static com.codeborne.selenide.appium.ScreenObject.screen;

public class MainScreen {

    @AndroidFindBy(id="com.monefy.app.lite:id/expense_button")
    private SelenideElement expenseButton;

    public ExpenseScreen openExpenseScreen(){
        expenseButton.click();
        return screen(ExpenseScreen.class);
    }
}
