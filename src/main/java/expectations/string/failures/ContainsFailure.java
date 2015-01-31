package expectations.string.failures;

public class ContainsFailure extends StringExpectationFailure{
    
    private static final String FAILURE_CONDITION = "contain";
    
    public ContainsFailure(String actual, String expected) {
        super(actual,expected, FAILURE_CONDITION);

    }
}
