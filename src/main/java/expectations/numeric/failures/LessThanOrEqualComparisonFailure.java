package expectations.numeric.failures;

public class LessThanOrEqualComparisonFailure extends ComparisonMismatchFailure {
    private static String OPERATOR = "<=";
    public LessThanOrEqualComparisonFailure(Number actual, Number expected) {
        super(actual, expected, OPERATOR);
    }
}
