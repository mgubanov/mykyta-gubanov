package tests.mobile;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exactText;


public class ExpenseTest extends BaseTest {

    @Test
    void testInputField() {
        completeOnboardingFlow()
                .openExpenseScreen()
                .clickNumber(1)
                .clickNumber(2)
                .clickNumber(3)
                .amountField
                .shouldHave(exactText("123"));
    }
}
