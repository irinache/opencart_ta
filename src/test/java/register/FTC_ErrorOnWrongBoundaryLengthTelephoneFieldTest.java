package register;

import drivers.DriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.RegisterPage;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
public class FTC_ErrorOnWrongBoundaryLengthTelephoneFieldTest {
    private DriverManager driverManager;
    private String telephone;

    public FTC_ErrorOnWrongBoundaryLengthTelephoneFieldTest(String telephone) {
        this.telephone = telephone;
    }

    @Before
    public void setUp() {
        driverManager = new DriverManager("opera");
        driverManager.loadPage("site_register");
    }

    @Parameterized.Parameters
    public static Collection telephones() {
        return Arrays.asList(
                "94",
                "738475903472590456456787687867873"
        );
    }

    @Test
    public void errorOnWrongBoundaryLengthTelephoneFieldTest() {
        RegisterPage registerPage = new RegisterPage(driverManager.getDriver());
        registerPage.setTelephone(telephone);
        registerPage.clickContinueExpectingFailure();
        RegisterPage updatedRegisterPage = new RegisterPage(driverManager.getDriver());
        String expected = "Telephone must be between 3 and 32 characters!";

        String actual = updatedRegisterPage.getErrorText(updatedRegisterPage.getTelephone());

        assertEquals(expected, actual);
    }

    @After
    public void tearDown() {
        driverManager.driverClose();
    }
}
