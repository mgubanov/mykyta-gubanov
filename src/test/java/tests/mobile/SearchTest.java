package tests.mobile;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static mobile.utils.MoneyFormater.formatToUSD;

public class SearchTest extends BaseTest {

    @Test(dataProvider = "searchValue")
    void searchSingleExpenseByDifferentValues(String searchValue) {
        var expenseAmount = "321";
        var testNote = "test note";
        var category = "Food";

        var addExpenseScreen = completeOnboardingFlow()
                .selectQuickCategory(0)
                .inputAmount(expenseAmount);
        addExpenseScreen.noteInputField.setValue(testNote);
        addExpenseScreen.amountField
                .shouldHave(exactText(expenseAmount));
        var mainScreen = addExpenseScreen.addExpenseToCategory();
        mainScreen.expenseAmount
                .shouldHave(exactText(formatToUSD(expenseAmount)));
        mainScreen.search.click();
        mainScreen.searchBar.setValue(searchValue);
        var searchResultsScreen = submitSearch();
        searchResultsScreen.categoryImage.shouldBe(visible);
        searchResultsScreen.categoryName.shouldHave(exactText(category));
        searchResultsScreen.note.shouldHave(exactText(testNote));
        searchResultsScreen.amount.shouldHave(exactText(formatToUSD(expenseAmount)));
        searchResultsScreen.date.shouldBe(visible);
    }

    @DataProvider(name = "searchValue")
    public Object[][] stringProvider() {
        return new Object[][]{
                {"Food"},
                {"test note"},
                {"321"}
        };
    }
}
