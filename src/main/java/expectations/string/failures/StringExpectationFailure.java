package expectations.string.failures;

import expectations.string.failures.messageBuilders.StringFailureMessageBuilder;

abstract class StringExpectationFailure extends Exception {
    public StringExpectationFailure(String actual, String expected, String condition) {
        super(StringFailureMessageBuilder.build(actual, expected, condition));
    }
}


