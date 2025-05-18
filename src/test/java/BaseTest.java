import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import mobile.core.AndroidDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;


import static com.codeborne.selenide.appium.SelenideAppium.launchApp;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        Configuration.browser = AndroidDriver.class.getName();
        launchApp();
    }

    @BeforeSuite
    public void beforeSuite() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
}
