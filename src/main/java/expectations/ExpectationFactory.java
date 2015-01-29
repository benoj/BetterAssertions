package expectations;

import expectations.exception.ExpectationExceptionBuilder;
import expectations.exception.RunnableWithException;

public class ExpectationFactory {
    public static ExpectationExceptionBuilder expect(RunnableWithException fn){
        return new ExpectationExceptionBuilder(fn);
    }
}
