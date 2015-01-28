package exceptions;

public class ComparisonMismatch extends Exception {
    public ComparisonMismatch(Number actual, Number expected, String operator) {
        super(String.format("Expected: %s %s %s",actual,operator,expected));
    }
}
