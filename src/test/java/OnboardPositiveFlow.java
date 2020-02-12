import com.OnboardPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class OnboardPositiveFlow extends BaseTest {


    /**
     * Scenario: User can open the help modal
     *
     * Given I am on the onboarding splash screen
     * When I select the question mark icon
     * Then I will be able to see the Contact Help option
     * And I can see the Forgot Email option
     */
    @Test
    public void selectOnboardingHelp() {
        OnboardPage onboard = new OnboardPage(driver);
        onboard.selectOnboardingHelp();
        Assert.assertTrue(onboard.visibleForgotEmail());
        Assert.assertTrue(onboard.visibleContactHelp());
        onboard.clickCloseHelpModal();
    }

    /**
     * Scenario: User can enter a valid email address
     *
     * Given I am on the onboarding splash screen
     * When I click on the Email field
     * And I enter a valid email address
     * And I click Submit
     * Then the email will pass validation checks
     * And I will be directed to the Gender Select page
     */
    @Test(dependsOnMethods = "selectOnboardingHelp")
    public void enterValidEmailAddress() {
        OnboardPage onboard = new OnboardPage(driver);
        onboard.enterEmailAddress("johnny+75@laundrapp.com");
    }

    /**
     * Scenario: User can select their gender
     *
     * Given I am on the onboarding flow
     * And I have entered a valid email address
     * And I am on the Gender Select screen
     * When I select Male
     * Then I will be directed to the D.O.B screen
     *
     * Scenario: User can select a valid D.O.B
     * Given I am on the D.O.B screen
     * When I select a valid D.O.B
     * And I select the Submit button
     * Then I will be directed to the verification code screen
     */
    @Test(dependsOnMethods = "enterValidEmailAddress")
    public void selectGenderAndDate() {
        OnboardPage onboard = new OnboardPage(driver);
        onboard.genderSelect("Male");
        onboard.datePickerSelect();
        Assert.assertTrue(onboard.visibleVerificationText());
    }
}
