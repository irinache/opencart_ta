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
public class FTC_ErrorOnWrongInputTelephoneFieldTest {
    private DriverManager driverManager;
    private String telephone;

    public FTC_ErrorOnWrongInputTelephoneFieldTest(String telephone) {
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
                "hello",
                "/.&@",
                "hello?';\\"
        );
    }

    @Test
    public void errorOnWrongInputTelephoneFieldTest() {
        RegisterPage registerPage = new RegisterPage(driverManager.getDriver());
        registerPage.setTelephone(telephone);
        registerPage.clickContinueExpectingFailure();
        RegisterPage updatedRegisterPage = new RegisterPage(driverManager.getDriver());
        String expected = "Last Name must contain only letters or \"-\" sign!";

        String actual = updatedRegisterPage.getErrorText(updatedRegisterPage.getTelephone());

        assertEquals(expected, actual);
    }

    @After
    public void tearDown() {
        driverManager.driverClose();
    }
}
