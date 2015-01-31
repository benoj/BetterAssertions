package expectations.string;

import expectations.string.failures.BeginsWithFailure;
import expectations.string.failures.EndsWithFailure;

public class StringExpectation {
    private String actual;

    public StringExpectation(String actual) {
        this.actual = actual;
    }

    public void beginsWith(String expected) throws BeginsWithFailure {
        if(!actual.startsWith(expected)){
            throw new BeginsWithFailure(actual, expected);
        }
    }

    public void endsWith(String expected) throws EndsWithFailure {
        if(!actual.endsWith(expected)){
            throw new EndsWithFailure(actual,expected);
        }
    }
}
