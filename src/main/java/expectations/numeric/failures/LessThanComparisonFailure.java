package expectations.numeric.failures;

public class LessThanComparisonFailure extends ComparisonMismatchFailure {
    private static String OPERATOR = "<";
    public LessThanComparisonFailure(Number actual, Number expected) {
        super(actual, expected, OPERATOR);
    }
}
