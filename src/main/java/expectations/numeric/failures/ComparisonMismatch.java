package expectations.numeric.failures;

public class ComparisonMismatch extends Exception {
    public ComparisonMismatch(Number actual, Number expected, String operator) {
        super(NumericExceptionMessageBuilder.build(actual,operator,expected));
    }
}

