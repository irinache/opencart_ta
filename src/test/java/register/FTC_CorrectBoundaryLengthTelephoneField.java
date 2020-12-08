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
import org.openqa.selenium.NoSuchElementException;
import pages.RegisterPage;


@RunWith(Parameterized.class)
public class FTC_CorrectBoundaryLengthTelephoneField {
    private final String telephone;
    private DriverManager driverManager;

    public FTC_CorrectBoundaryLengthTelephoneField(String telephone) {
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
                "941",
                "73847590347259045645678768786787"
                            );
    }

    @Test(expected = NoSuchElementException.class)
    public void telephoneFieldVerifyBoundaryLengthTest() {
        RegisterPage registerPage = new RegisterPage(driverManager.getDriver());
        registerPage.setTelephone(telephone);
        registerPage.clickContinueExpectingFailure();

        RegisterPage updatedRegisterPage = new RegisterPage(driverManager.getDriver());

        updatedRegisterPage.getErrorText(updatedRegisterPage.getTelephone());
    }

    @After
    public void tearDown() {
        driverManager.driverClose();
    }
}
