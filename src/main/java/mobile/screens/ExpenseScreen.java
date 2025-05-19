package mobile.screens;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ExpenseScreen {

    @AndroidFindBy(id="com.monefy.app.lite:id/amount_text")
    public SelenideElement amountField;

    public ExpenseScreen clickNumber(int number) {
        $(By.id("com.monefy.app.lite:id/buttonKeyboard"+number)).click();
        return this;
    }
}
