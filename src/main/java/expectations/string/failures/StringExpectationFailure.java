package expectations.string.failures;

class StringExpectationFailure extends Exception {
    public StringExpectationFailure(String actual, String expected, String condition) {
        super(StringFailureMessageBuilder.build(actual,expected,condition));
    }
}


