package mobile.screens;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SearchResultsScreen {

    @AndroidFindBy(id="com.monefy.app.lite:id/category_type_image_view")
    public SelenideElement categoryImage;
    @AndroidFindBy(id="com.monefy.app.lite:id/title_text_view")
    public SelenideElement categoryName;
    @AndroidFindBy(id="com.monefy.app.lite:id/amount_text_view")
    public SelenideElement amount;
    @AndroidFindBy(id="com.monefy.app.lite:id/note_text_view")
    public SelenideElement note;
    @AndroidFindBy(id="com.monefy.app.lite:id/date_text_view")
    public SelenideElement date;

}
