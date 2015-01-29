package assertions.exception;

import exceptions.ExceptionNotThrown;
import exceptions.ExpectationMismatch;
import expectations.exception.ExpectationExceptionBuilder;
import expectations.exception.RunnableWithException;

public class Exceptions {
    public static void assertThrows(RunnableWithException fn, Class exceptionClass) throws ExceptionNotThrown, ExpectationMismatch {
        ExpectationExceptionBuilder expectationExceptionBuilder = new ExpectationExceptionBuilder(fn);
        expectationExceptionBuilder.toThrow(exceptionClass);
    }
}
