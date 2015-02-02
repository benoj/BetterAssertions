package expectations.exception.failures;

class ExpectationMismatchMessageBuilder {
    public static String build(Object actual, Object expected){
        return "Expected: " + expected + ", Actual: " + actual;
    }
}
