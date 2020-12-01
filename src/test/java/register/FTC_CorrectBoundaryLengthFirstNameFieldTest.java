package register;

import drivers.DriverManager;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.NoSuchElementException;
import pages.RegisterPage;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(Parameterized.class)
public class FTC_CorrectBoundaryLengthFirstNameFieldTest {

    private DriverManager driverManager;
    private String firstName;

    public FTC_CorrectBoundaryLengthFirstNameFieldTest(String firstName) {
        this.firstName = firstName;

    }

    @Before
    public void setUp() {
        driverManager = new DriverManager("opera");
        driverManager.loadPage("site_register");
    }

    @Parameterized.Parameters
    public static Collection firstNames() {
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

        assertThrows(NoSuchElementException.class, () -> {
            updatedRegisterPage.getErrorText(updatedRegisterPage.getFirstName());
        });
    }

    @After
    public void tearDown() {
        driverManager.driverClose();
    }

}
