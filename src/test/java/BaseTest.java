import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected AndroidDriver<MobileElement> driver;

    @BeforeTest
    public void setupMuzmatch() {
        File fileSource = new File("src");
        File sourceApp = new File(fileSource, "muzmatch_com.muzmatch.muzmatchapp.apk");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel");
        cap.setCapability("platformName", "Android");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        cap.setCapability(MobileCapabilityType.APP, sourceApp.getAbsolutePath());
        cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.muzmatch.muzmatchapp");
        cap.setCapability("appWaitActivity ", "com.muzmatch.muzmatchapp.activities.RoutingActivity");
        cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.muzmatch.muzmatchapp.activities.RoutingActivity");

        try {
            driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void teardown(){
        driver.quit();
    }
}

