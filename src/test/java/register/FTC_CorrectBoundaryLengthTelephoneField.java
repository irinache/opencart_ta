package register;

import drivers.DriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.NoSuchElementException;
import pages.RegisterPage;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(Parameterized.class)
public class FTC_CorrectBoundaryLengthTelephoneField {
    private DriverManager driverManager;
    private String telephone;

    public FTC_CorrectBoundaryLengthTelephoneField(String telephone) {
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
                "941",
                "73847590347259045645678768786787"
        );
    }

    @Test
    public void telephoneFieldVerifyBoundaryLengthTest() {
        RegisterPage registerPage = new RegisterPage(driverManager.getDriver());
        registerPage.setTelephone(telephone);
        registerPage.clickContinueExpectingFailure();

        RegisterPage updatedRegisterPage = new RegisterPage(driverManager.getDriver());

        assertThrows(NoSuchElementException.class, () -> {
            updatedRegisterPage.getErrorText(updatedRegisterPage.getTelephone());
        });
    }

    @After
    public void tearDown() {
        driverManager.driverClose();
    }
}
