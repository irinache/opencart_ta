import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import login.*;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        FTC_ErrorMessageOnWrongCredentialsTest.class,
        FTC_GetLoginPageTest.class,
        FTC_LoginWithCorrectCredentialsTest.class,
})
public class LoginTestSuit {
}
