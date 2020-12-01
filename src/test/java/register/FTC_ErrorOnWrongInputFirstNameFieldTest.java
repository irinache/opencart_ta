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
public class FTC_ErrorOnWrongInputFirstNameFieldTest {
    private final String firstName;
    private DriverManager driverManager;

    public FTC_ErrorOnWrongInputFirstNameFieldTest(String firstName) {
        this.firstName = firstName;
    }

    @Before
    public void setUp() {
        driverManager = new DriverManager("opera");
        driverManager.loadPage("site_register");
    }

    @Parameters
    public static Collection firstNames() {
        return Arrays.asList(
                "435",
                "/.&@",
                "3453?';\\"
                            );
    }

    @Test
    public void errorOnWrongInputFirstNameFieldTest() {
        RegisterPage registerPage = new RegisterPage(driverManager.getDriver());
        registerPage.setFirstName(firstName);
        registerPage.clickContinueExpectingFailure();
        RegisterPage updatedRegisterPage = new RegisterPage(driverManager.getDriver());
        String expected = "First Name must contain only letters or \"-\" sign!";

        String actual = updatedRegisterPage.getErrorText(updatedRegisterPage.getFirstName());

        assertEquals(expected, actual);
    }

    @After
    public void tearDown() {
        driverManager.driverClose();
    }
}
