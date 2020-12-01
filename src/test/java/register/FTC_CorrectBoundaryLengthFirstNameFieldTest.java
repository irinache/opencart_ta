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
import org.openqa.selenium.NoSuchElementException;
import pages.RegisterPage;

import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(Parameterized.class)
public class FTC_CorrectBoundaryLengthFirstNameFieldTest {

    private final String firstName;
    private DriverManager driverManager;

    public FTC_CorrectBoundaryLengthFirstNameFieldTest(String firstName) {
        this.firstName = firstName;
    }

    @Before
    public void setUp() {
        driverManager = new DriverManager("opera");
        driverManager.loadPage("site_register");
    }

    @Parameters
    public static Collection<String> firstNames() {
        return Arrays.asList(
                "K",
                "Lorem ipsum dolor sit amett cons"
                            );
    }

    @Test
    public void firstNameFieldVerifyBoundaryLengthTest() {
        RegisterPage registerPage = new RegisterPage(driverManager.getDriver());
        registerPage.setFirstName(firstName);
        registerPage.clickContinueExpectingFailure();

        RegisterPage updatedRegisterPage = new RegisterPage(driverManager.getDriver());

        assertThrows(NoSuchElementException.class,
                     () -> updatedRegisterPage.getErrorText(updatedRegisterPage.getFirstName()));
    }

    @After
    public void tearDown() {
        driverManager.driverClose();
    }
}
