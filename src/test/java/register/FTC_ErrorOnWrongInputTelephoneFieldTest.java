package register;

import drivers.DriverManager;
import java.util.Arrays;
import java.util.Collection;

import drivers.SitePaths;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import pages.RegisterPage;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class FTC_ErrorOnWrongInputTelephoneFieldTest {
    private final String telephone;
    private DriverManager driverManager;

    public FTC_ErrorOnWrongInputTelephoneFieldTest(String telephone) {
        this.telephone = telephone;
    }

    @Before
    public void setUp() {
        driverManager = new DriverManager();
        driverManager.configureDriver("opera");
        driverManager.loadPage(SitePaths.register);
    }

    @Parameters
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
