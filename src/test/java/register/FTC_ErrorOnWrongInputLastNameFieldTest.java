package register;

import drivers.DriverManager;
import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import pages.RegisterPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
public class FTC_ErrorOnWrongInputLastNameFieldTest {
    private final String lastName;
    private DriverManager driverManager;

    public FTC_ErrorOnWrongInputLastNameFieldTest(String lastName) {
        this.lastName = lastName;
    }

    @Before
    public void setUp() {
        driverManager = new DriverManager("opera");
        driverManager.loadPage("site_register");
    }

    @Parameters
    public static Collection lastNames() {
        return Arrays.asList(
                "435",
                "/.&@",
                "3453?';\\"
                            );
    }

    @Test
    public void errorOnWrongInputLastNameFieldTest() {
        RegisterPage registerPage = new RegisterPage(driverManager.getDriver());
        registerPage.setLastName(lastName);
        registerPage.clickContinueExpectingFailure();
        RegisterPage updatedRegisterPage = new RegisterPage(driverManager.getDriver());
        String expected = "Last Name must contain only letters or \"-\" sign!";

        String actual = updatedRegisterPage.getErrorText(updatedRegisterPage.getLastName());

        assertEquals(expected, actual);
    }

    @After
    public void tearDown() {
        driverManager.driverClose();
    }
}
