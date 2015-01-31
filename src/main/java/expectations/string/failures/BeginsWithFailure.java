package expectations.string.failures;

public class BeginsWithFailure extends StringExpectationFailure{
    private static final String FAILURE_CONDITION = "begin with";
    public BeginsWithFailure(String actual, String expected) {
        super(actual,expected, FAILURE_CONDITION);
    }
    
}
