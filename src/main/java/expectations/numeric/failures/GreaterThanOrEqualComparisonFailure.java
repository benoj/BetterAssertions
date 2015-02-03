package expectations.numeric.failures;

public class GreaterThanOrEqualComparisonFailure extends ComparisonMismatchFailure {
    private static String OPERATOR = ">=";
    public GreaterThanOrEqualComparisonFailure(Number actual, Number expected) {
        super(actual, expected, OPERATOR);
    }
}
