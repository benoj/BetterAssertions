package expectations;

import expectations.exception.ExpectationExceptionBuilder;
import expectations.exception.TestWithExceptiohn;
import expectations.numeric.NumericExpectation;
import expectations.string.StringExpectation;

public class ExpectationFactory {
    public static ExpectationExceptionBuilder expect(TestWithExceptiohn fn){
        return new ExpectationExceptionBuilder(fn);
    }

    public static  NumericExpectation expect(Number number){
        return new NumericExpectation<>(number);
    }
    
    public static StringExpectation expect(String string){
        return new StringExpectation(string);
    }
}
