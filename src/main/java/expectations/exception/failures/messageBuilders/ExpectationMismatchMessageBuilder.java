package expectations.exception.failures.messageBuilders;

public class ExpectationMismatchMessageBuilder {
    public static String build(Object actual, Object expected){
        return "Expected: " + expected + ", Actual: " + actual;
    }
}
