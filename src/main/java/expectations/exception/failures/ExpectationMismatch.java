package expectations.exception.failures;

public class ExpectationMismatch extends Exception {

    public ExpectationMismatch(Class actual, Class expected) {
        super(ExpectationMismatchMessageBuilder.build(actual, expected));
    }

    public ExpectationMismatch(String actual, String expected) {
        super(ExpectationMismatchMessageBuilder.build(actual,expected));
    }

}