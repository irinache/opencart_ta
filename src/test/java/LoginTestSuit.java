import login.FTC_ErrorMessageOnWrongCredentialsTest;
import login.FTC_GetLoginPageTest;
import login.FTC_LoginWithCorrectCredentialsTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)

@SuiteClasses({
        FTC_ErrorMessageOnWrongCredentialsTest.class,
        FTC_GetLoginPageTest.class,
        FTC_LoginWithCorrectCredentialsTest.class,
})
public class LoginTestSuit {
}
