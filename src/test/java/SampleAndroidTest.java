import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;


public class SampleAndroidTest extends BaseTest {

    String continueButton = "com.monefy.app.lite:id/buttonContinue";
    String closeButton = "com.monefy.app.lite:id/buttonClose";
    String expenseButton = "com.monefy.app.lite:id/expense_button";
    String keyboardBtnPartial = "com.monefy.app.lite:id/buttonKeyboard";
    String amountField = "com.monefy.app.lite:id/amount_text";

    void clickKey(int key){
        $(By.id(keyboardBtnPartial+key)).click();
    }

    @Test
    void testAndroidTap() {
        $(By.id(continueButton)).click();
        $(By.id(continueButton)).click();
        $(By.id(continueButton)).click();
        $(By.id(closeButton)).click();

        $(By.id(expenseButton)).click();

        clickKey(9);
        $(By.id(amountField)).shouldHave(exactText("9"));
    }
}
