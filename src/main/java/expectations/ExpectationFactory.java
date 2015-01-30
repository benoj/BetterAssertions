package expectations;

import expectations.exception.ExpectationExceptionBuilder;
import expectations.exception.RunnableWithException;
import expectations.numeric.NumericExpectation;

public class ExpectationFactory {
    public static ExpectationExceptionBuilder expect(RunnableWithException fn){
        return new ExpectationExceptionBuilder(fn);
    }

    public static  NumericExpectation expect(Number number){
        return new NumericExpectation<>(number);
    }
}
