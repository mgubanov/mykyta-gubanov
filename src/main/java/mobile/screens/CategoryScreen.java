package mobile.screens;

import com.codeborne.selenide.ElementsCollection;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static com.codeborne.selenide.appium.ScreenObject.screen;

public class CategoryScreen {

    @AndroidFindBy(id="com.monefy.app.lite:id/textCategoryName")
    public ElementsCollection categoryNames;

    public MainScreen selectCategory(int index) {
        categoryNames.get(index).click();
        return screen(MainScreen.class);
    }

}
