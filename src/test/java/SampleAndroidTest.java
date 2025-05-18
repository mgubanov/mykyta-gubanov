import mobile.core.DriverManager;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static mobile.core.DriverManager.*;
import static org.testng.Assert.*;


public class SampleAndroidTest extends BaseTest {

    @Test
    public void testAppLaunch() throws InterruptedException {
        getDriver().findElement(By.id("com.monefy.app.lite:id/buttonContinue")).click();//get started button
        Thread.sleep(500);
        getDriver().findElement(By.id("com.monefy.app.lite:id/buttonContinue")).click();//amazing
        Thread.sleep(500);
        getDriver().findElement(By.id("com.monefy.app.lite:id/buttonContinue")).click();//i'm ready
        Thread.sleep(500);
        getDriver().findElement(By.id("com.monefy.app.lite:id/buttonClose")).click();//close buy premium
        Thread.sleep(500);
        getDriver().findElement(By.id("com.monefy.app.lite:id/expense_button")).click();//open expences screen
        Thread.sleep(500);

        getDriver().findElement(By.id("com.monefy.app.lite:id/buttonKeyboard1")).click();//click 0-9
        getDriver().findElement(By.id("com.monefy.app.lite:id/buttonKeyboard2")).click();//click 0-9
        getDriver().findElement(By.id("com.monefy.app.lite:id/buttonKeyboard3")).click();//click 0-9
        getDriver().findElement(By.id("com.monefy.app.lite:id/buttonKeyboard4")).click();//click 0-9
        getDriver().findElement(By.id("com.monefy.app.lite:id/buttonKeyboard5")).click();//click 0-9
        getDriver().findElement(By.id("com.monefy.app.lite:id/buttonKeyboard6")).click();//click 0-9

        Thread.sleep(500);

        assertEquals(getDriver().findElement(By.id("com.monefy.app.lite:id/amount_text")).getText(), "123456");








    }
}
