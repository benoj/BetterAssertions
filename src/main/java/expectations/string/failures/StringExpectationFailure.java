package expectations.string.failures;

class StringExpectationFailure extends Exception {
    public StringExpectationFailure(String actual, String expected, String condition) {
        super(String.format("Expected: '%s' to %s '%s'", actual,condition, expected));
    }
}
