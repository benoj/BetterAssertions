package expectations.string.failures;

public class EndsWithFailure  extends StringExpectationFailure{

    public static final String FAILURE_CONDITION = "end with";

    public EndsWithFailure(String actual, String expected) {
        super(actual,expected, FAILURE_CONDITION);
    }
}
