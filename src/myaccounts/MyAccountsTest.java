package myaccounts;

import Utilities.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.UUID;

public class MyAccountsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";
    String email;

    @Before
    public void setUp() {
        // Open browser and launch url
        openBrowser(baseUrl);
    }

    @After
    public void tearDown() {
        // close all windows
        closeBrowser();
    }

    /**
     * This method is used to click on any tab of my account dropdown
     *
     * @param option
     */
    public void selectMyAccountOptions(String option) {
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        clickOnElement(By.xpath("(//a[normalize-space()='" + option + "'])[1]"));
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() throws InterruptedException {
        String option = "Register";
        //  Call the method “selectMyAccountOptions” method and pass the parameter“Register”
        selectMyAccountOptions(option);
        Thread.sleep(1000);
        // Verify the text “Register Account”.
        String expectedMessage = "Register Account";
        String actualMessage = getTextFromElement(By.xpath("//h1[normalize-space()='Register Account']"));
        verifyTwoTextMessage(expectedMessage, actualMessage);

    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() throws InterruptedException {
        String option = "Login";
        // Call the method “selectMyAccountOptions” method and pass the parameter“Login”
        selectMyAccountOptions(option);
        Thread.sleep(1000);
        // Verify the text “Returning Customer”.
        String expectedMessage = "Returning Customer";
        String actualMessage = getTextFromElement(By.xpath("//h2[normalize-space()='Returning Customer']"));
        verifyTwoTextMessage(expectedMessage, actualMessage);
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        String name = UUID.randomUUID().toString();
        email = name + "@gmail.com";
        String option = "Register";
        //  Call the method “selectMyAccountOptions” method and pass the parameter“Register”
        selectMyAccountOptions(option);
        Thread.sleep(1000);
        // Enter first name
        sendTextToElement(By.xpath("//input[@id='input-firstname']"), "Prime");
        // Enter Last name
        sendTextToElement(By.xpath("//input[@id='input-lastname']"), "Testing");
        // Enter email
        sendTextToElement(By.xpath("//input[@id='input-email']"), email);
        // Enter mobile number
        sendTextToElement(By.xpath("//input[@id='input-telephone']"), "9898989898");
        // Enter password
        sendTextToElement(By.xpath("//input[@id='input-password']"), "Admin@123");
        // Enter confirm password
        sendTextToElement(By.xpath("//input[@id='input-confirm']"), "Admin@123");
        // Select Subscribe Yes radio button
        selectRadioButton(By.xpath("//label[normalize-space()='Yes']"));
        // Click on Privacy Policy check box
        selectCheckBox(By.xpath("//input[@name='agree']"));
        // Click on Continue button
        clickOnElement(By.xpath("//input[@value='Continue']"));
        // Verify the message “Your Account Has Been Created!”
        String expectedMessage = "Your Account Has Been Created!";
        String actualMessage = getTextFromElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"));
        verifyTwoTextMessage(expectedMessage, actualMessage);
        // Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));

        option = "Logout";
        // Call the method “selectMyAccountOptions” method and pass the parameter“Logout”
        selectMyAccountOptions(option);
        // Verify the text “Account Logout”
        expectedMessage = "Account Logout";
        actualMessage = getTextFromElement(By.xpath("//h1[normalize-space()='Account Logout']"));
        verifyTwoTextMessage(expectedMessage, actualMessage);
        // Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));

    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        String option = "Login";
        //  Call the method “selectMyAccountOptions” method and pass the parameter“Login”
        selectMyAccountOptions(option);
        // Enter Email address
        sendTextToElement(By.xpath("//input[@id='input-email']"), "admin123456@gmail.com");
        // Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"), "Admin@123");
        // Click on Login button
        clickOnElement(By.xpath("//input[@value='Login']"));
        // Verify text “My Account”
        String expectedMessage = "My Account";
        String actualMessage = getTextFromElement(By.xpath("//h2[normalize-space()='My Account']"));
        verifyTwoTextMessage(expectedMessage, actualMessage);
        option = "Logout";
        // Call the method “selectMyAccountOptions” method and pass the parameter Logout”
        selectMyAccountOptions(option);
        // Verify the text “Account Logout”
        expectedMessage = "Account Logout";
        actualMessage = getTextFromElement(By.xpath("//h1[normalize-space()='Account Logout']"));
        verifyTwoTextMessage(expectedMessage, actualMessage);
        // Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));

    }
}
