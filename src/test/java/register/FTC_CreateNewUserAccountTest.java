package register;

import drivers.DriverManager;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import pages.Page;
import pages.RegisterPage;
import pages.SuccessfulRegistrationPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FTC_CreateNewUserAccountTest {
    private DriverManager driverManager;

    @Before
    public void setUp() {
        driverManager = new DriverManager("opera");
        driverManager.loadPage("site_register");
    }

    @Test
    public void createNewAccountTest() {
        RegisterPage registerPage = new RegisterPage(driverManager.getDriver());
        registerPage.setFirstName("Kate");
        registerPage.setLastName("Mikelson");
        registerPage.setEmail("kateri2353@gmail.com");
        registerPage.setTelephone("+380666600941");
        registerPage.setPassword("12345");
        registerPage.setPasswordConfirm("12345");
        registerPage.setSubscribeRadioButton(true);
        registerPage.clickPrivacyPolicy();

        Page actual = registerPage.clickContinue();

        Page expected = new SuccessfulRegistrationPage(driverManager.getDriver());

        assertEquals(expected, actual);
    }

    @After
    public void tearDown() {
        SuccessfulRegistrationPage srp = new SuccessfulRegistrationPage(driverManager.getDriver());
        srp.logout();
        //delete user using admin?
        driverManager.driverClose();
    }
}
