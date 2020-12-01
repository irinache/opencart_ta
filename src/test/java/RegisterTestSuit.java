import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import register.*;

@RunWith(Suite.class)

@SuiteClasses({
        FTC_CorrectBoundaryLengthFirstNameFieldTest.class,
        FTC_CreateNewUserAccountTest.class,
        FTC_CorrectBoundaryLengthLastNameFieldTest.class,
        FTC_CorrectBoundaryLengthPasswordTest.class,
        FTC_CorrectBoundaryLengthTelephoneField.class,
        FTC_ErrorMessageOnDifferentPasswordAndPasswordConfirmTest.class,
        FTC_ErrorMessageOnUncheckedPrivacyPolicyTest.class,
        FTC_ErrorOnWrongBoundaryLengthFirstNameFieldTest.class,
        FTC_ErrorOnWrongBoundaryLengthLastNameFieldTest.class,
        FTC_ErrorOnWrongBoundaryLengthPasswordTest.class,
        FTC_ErrorOnWrongBoundaryLengthTelephoneFieldTest.class,
        FTC_ErrorOnWrongInputEmailFieldTest.class,
        FTC_ErrorOnWrongInputFirstNameFieldTest.class,
        FTC_ErrorOnWrongInputLastNameFieldTest.class,
        FTC_ErrorOnWrongInputTelephoneFieldTest.class,
        FTC_GetRegistrationPageTest.class,
})
public class RegisterTestSuit {
}
