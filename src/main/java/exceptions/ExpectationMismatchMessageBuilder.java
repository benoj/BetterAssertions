package exceptions;

class ExpectationMismatchMessageBuilder {
    public static String build(Object actual, Object expected){
        return String.format("Expected: %s, Actual: %s", expected, actual);
    }
}
