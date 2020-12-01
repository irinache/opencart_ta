import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import register.*;

@RunWith(Suite.class)

@Suite.SuiteClasses({
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
        FTC_GetResistratioPageTest.class,
})
public class RegisterTestSuit {
}
