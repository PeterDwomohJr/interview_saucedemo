import com.interview.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import static org.assertj.core.api.Assertions.*;

/**
 * This class represents the login test
 * @author Peter Dwomoh Junior
 * @version 0.0.0
 * @since 12th June 2023
 */
public class LoginTest {

    private WebDriver driver;
    private String username = System.getenv("username");
    private String accessKey = System.getenv("accessKey");
    private String host = "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
    private final String REMOTE_DRIVER_URI = "https://" + username + ":" + accessKey + host;



    @BeforeMethod
    public void setup() throws MalformedURLException {
        // create desired capabilities
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "ANDROID");
        desiredCapabilities.setCapability("browser", "chrome");

        // instantiate a new session of a remote driver
        driver = new RemoteWebDriver(new URL(REMOTE_DRIVER_URI), desiredCapabilities);

        // get the uri of the test target
        String uri = "https://saucedemo.com";
        driver.get(uri);
    }


    @Test
    public void loginTest() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.login();
        assertThat(driver.getTitle()).isEqualTo("Swag Labs");
    }


    @AfterMethod
    public void tearDown() {
        if (! driver.equals(null)) driver.quit();
    }
}
