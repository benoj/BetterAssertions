package expectations.numeric.failures;

public class EqualityComparisonFailure extends ComparisonMismatchFailure {
    private static String OPERATOR = "==";
    public EqualityComparisonFailure(Number actual, Number expected) {
        super(actual, expected, OPERATOR);
    }
}
