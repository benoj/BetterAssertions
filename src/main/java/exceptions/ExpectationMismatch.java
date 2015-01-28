package exceptions;

public class ExpectationMismatch extends Exception {

    public ExpectationMismatch(Class actual, Class expected) {
        super(ExpectationMismatchMessageBuilder.build(actual,expected));
    }

    public ExpectationMismatch(String actual, String expected) {
        super(ExpectationMismatchMessageBuilder.build(actual,expected));
    }

    public ExpectationMismatch(Object actual, Object expected) {
        super(ExpectationMismatchMessageBuilder.build(actual,expected));
    }
}