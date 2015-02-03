package expectations.numeric.failures;

public class GreaterThanComparisonFailure extends ComparisonMismatchFailure {
    private static String OPERATOR = ">";
    public GreaterThanComparisonFailure(Number actual, Number expected) {
        super(actual, expected, OPERATOR);
    }
}
