package expectations.string.failures;

public class EndsWithFailure extends Exception{
    public EndsWithFailure(String actual, String expected) {
        super(String.format("Expected: '%s' to end with '%s'", actual, expected));
    }
}
