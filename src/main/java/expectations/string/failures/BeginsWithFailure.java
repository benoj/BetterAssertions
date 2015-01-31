package expectations.string.failures;

public class BeginsWithFailure extends Exception{
    public BeginsWithFailure(String actual, String expected) {
        super(String.format("Expected: '%s' to begin with '%s'", actual, expected));
    }
}
