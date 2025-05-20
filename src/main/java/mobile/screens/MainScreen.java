package mobile.screens;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static com.codeborne.selenide.appium.ScreenObject.screen;

public class MainScreen {

    @AndroidFindBy(id="com.monefy.app.lite:id/expense_button")
    private SelenideElement expenseButton;
    @AndroidFindBy(id="com.monefy.app.lite:id/income_button")
    private SelenideElement incomeButton;
    @AndroidFindBy(id="com.monefy.app.lite:id/income_amount_text")
    public SelenideElement incomeAmount;
    @AndroidFindBy(id="com.monefy.app.lite:id/expense_amount_text")
    public SelenideElement expenseAmount;
    @AndroidFindBy(id="com.monefy.app.lite:id/balance_amount")
    public SelenideElement balanceAmount;
    @AndroidFindBy(xpath="//android.widget.FrameLayout[contains(@resource-id, \"piegraph\")]//android.widget.ImageView")
    public ElementsCollection quickCategories;

    public AddExpenseFromCategoryScreen openAddExpenseScreen(){
        expenseButton.click();
        return screen(AddExpenseFromCategoryScreen.class);
    }

    public AddExpenseFromCategoryScreen selectQuickCategory(int index){
        quickCategories.get(index).click();
        return screen(AddExpenseFromCategoryScreen.class);
    }

    public AddTransactionScreen openAddIncomeScreen(){
        incomeButton.click();
        return screen(AddTransactionScreen.class);
    }
}
