package tests.mobile;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static mobile.utils.MoneyFormater.formatToUSD;


public class ExpenseTest extends BaseTest {

    @Test
    void addExpenseTest() {
        var expenseAmount = "321";

        var addExpenseScreen = completeOnboardingFlow()
                .openAddExpenseScreen()
                .inputAmount(expenseAmount);

        addExpenseScreen.amountField
                .shouldHave(exactText(expenseAmount));
        var mainScreen = addExpenseScreen.chooseCategory()
                .selectCategory(0);
        mainScreen.expenseAmount
                .shouldHave(exactText(formatToUSD(expenseAmount)));
        mainScreen.balanceAmount
                .shouldHave(text("-" + formatToUSD(expenseAmount)));
    }

    @Test
    void addExpenseByQuickCategoryTest() {
        var expenseAmount = "321";

        var addExpenseScreen = completeOnboardingFlow()
                .selectQuickCategory(0)
                .inputAmount(expenseAmount);
        addExpenseScreen.amountField
                .shouldHave(exactText(expenseAmount));
        var mainScreen = addExpenseScreen.addExpenseToCategory();
        mainScreen.expenseAmount
                .shouldHave(exactText(formatToUSD(expenseAmount)));
        mainScreen.balanceAmount
                .shouldHave(text("-" + formatToUSD(expenseAmount)));
    }
}
