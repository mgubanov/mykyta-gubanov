import mobile.core.DriverManager;
import mobile.core.capabilities.AndroidCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setUp() throws Exception {
        DriverManager.setDriver(AndroidCapabilities.createDriver());
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
