package com;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class OnboardPage {

    private AndroidDriver<MobileElement> driver;
    private WebDriverWait wait;

    public OnboardPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
        this.wait = new WebDriverWait(driver, 30);
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AndroidFindBy(id = "com.muzmatch.muzmatchapp:id/welcome_email_input")
    private AndroidElement emailField;
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Email']")
    private AndroidElement emailFieldClick;
    @AndroidFindBy(className = "android.widget.Button")
    private AndroidElement submitBtn;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Female']")
    private AndroidElement femaleBtn;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Male']")
    private AndroidElement maleBtn;
    @AndroidFindBy(xpath = "//android.widget.Button[@text='11']")
    private AndroidElement datePicker;
    @AndroidFindBy(id = "com.muzmatch.muzmatchapp:id/birthday_continue_btn")
    private AndroidElement continueBirthdayBtn;
    @AndroidFindBy(id = "com.muzmatch.muzmatchapp:id/fragment_enter_pin_instruction")
    private AndroidElement verificationText;
    @AndroidFindBy(id = "com.muzmatch.muzmatchapp:id/welcome_help")
    private AndroidElement onboardHelpBtn;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Contact Help']")
    private AndroidElement verificationContactText;
    @AndroidFindBy(id = "com.muzmatch.muzmatchapp:id/baseAlertDismissText")
    private AndroidElement closeHelpModal;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Forgot email?']")
    private AndroidElement forgotEmail;

    public void enterEmailAddress(String email) {
        emailFieldClick.click();
        emailField.sendKeys(email);
        submitBtn.click();
    }

    public void genderSelect(String gender) {
        wait.until(ExpectedConditions.visibilityOf(this.femaleBtn));
        if (gender.equals("Male")) {
            maleBtn.click();
        } else
            femaleBtn.click();
    }

    public void datePickerSelect() {
        wait.until(ExpectedConditions.visibilityOf(this.datePicker));
        datePicker.click();
        driver.pressKeyCode(66);
        continueBirthdayBtn.click();
    }

    public Boolean visibleVerificationText() {
        return verificationText.isDisplayed();
    }

    public void selectOnboardingHelp() {
        onboardHelpBtn.click();
    }

    public Boolean visibleContactHelp() {
        return verificationContactText.isDisplayed();
    }

    public Boolean visibleForgotEmail() {
        return forgotEmail.isDisplayed();
    }

    public void clickCloseHelpModal() {
        closeHelpModal.click();
    }
}
