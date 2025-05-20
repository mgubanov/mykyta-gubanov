package tests.mobile;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static mobile.utils.MoneyFormater.formatToUSD;


public class IncomeTest extends BaseTest {

    @Test
    void addIncomeTest() {
        var inputAmount = "123";

        var addIncomeScreen = completeOnboardingFlow()
                .openAddIncomeScreen()
                .inputAmount(inputAmount);
        addIncomeScreen.amountField
                .shouldHave(exactText(inputAmount));
        var mainScreen = addIncomeScreen.chooseCategory()
                .selectCategory(0);
        mainScreen.incomeAmount
                .shouldHave(exactText(formatToUSD(inputAmount)));
        mainScreen.balanceAmount
                .shouldHave(text(formatToUSD(inputAmount)));
    }

    @Test
    void addExpenseAndIncomeTest() {
        var expenseAmount = "100";
        var incomeAmount = "150";
        var balance = "50";

        var addIncomeScreen = completeOnboardingFlow()
                .openAddIncomeScreen();
        addIncomeScreen.inputAmount(incomeAmount);

        var mainScreen = addIncomeScreen.chooseCategory()
                .selectCategory(0);
        var addExpenseScreen = mainScreen.selectQuickCategory(0);
        addExpenseScreen.inputAmount(expenseAmount);

        addExpenseScreen.addExpenseToCategory()
                .balanceAmount.shouldHave(text(formatToUSD(balance)));
    }
}
