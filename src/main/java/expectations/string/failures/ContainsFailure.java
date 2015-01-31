package expectations.string.failures;

public class ContainsFailure extends Exception {
    public ContainsFailure(String actual, String expected) {
        super(String.format("Expected: '%s' to contain '%s'", actual, expected));

    }
}
