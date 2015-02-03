package expectations.string;

import expectations.exception.TestWithExceptiohn;
import expectations.string.failures.ContainsFailure;
import org.junit.Test;

import static expectations.ExpectationFactory.expect;

public class TestContains {

    private final String actual = "This is a sentence.";

    @Test
    public void expectContainsWhenStringIsContainedToPass() throws Exception {
        expect(actual).contains("sent");
    }

    @Test
    public void expectContainsWhenStringInNotContainedToFail() throws Exception {
        String expected = "not";
        TestWithExceptiohn test = () -> expect(actual).contains(expected);
        String expectedFailureMessage = String.format("Expected: '%s' to contain '%s'", actual,expected);
        expect(test).toThrow(ContainsFailure.class).withMessage(expectedFailureMessage);
    }


}
