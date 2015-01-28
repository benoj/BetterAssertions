package assertions.exception;

import exceptions.ExpectationMismatch;
import exceptions.ExceptionNotThrown;
import expectations.exception.ExceptionExpectation;
import expectations.exception.RunnableWithException;

public class Exceptions {
    public static void assertThrows(RunnableWithException fn, Class exceptionClass) throws ExceptionNotThrown, ExpectationMismatch {
        ExceptionExpectation expectation = new ExceptionExpectation(fn);
        expectation.toThrow(exceptionClass);
    }
}
