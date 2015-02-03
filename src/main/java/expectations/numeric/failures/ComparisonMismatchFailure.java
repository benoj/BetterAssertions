package expectations.numeric.failures;

import expectations.numeric.failures.messageBuilder.NumericExceptionMessageBuilder;

abstract class ComparisonMismatchFailure extends Exception {
    public ComparisonMismatchFailure(Number actual, Number expected, String operator) {
        super(NumericExceptionMessageBuilder.build(actual, operator, expected));
    }
}

