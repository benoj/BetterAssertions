package expectations.string.failures;

import expectations.string.failures.messageBuilders.StringExpectationFailureMessageBuilder;

abstract class StringExpectationFailure extends Exception {
    public StringExpectationFailure(String actual, String expected, String condition) {
        super(StringExpectationFailureMessageBuilder.build(actual, expected, condition));
    }
}


