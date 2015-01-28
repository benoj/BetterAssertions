package assertions.exception;

import exceptions.ExceptionMismatch;
import exceptions.ExceptionNotThrown;
import expectations.exception.ExceptionExpectation;
import expectations.exception.RunnableWithException;

public class Exceptions {
    public static void assertThrows(RunnableWithException fn, Class exceptionClass) throws ExceptionNotThrown, ExceptionMismatch {
        ExceptionExpectation expectation = new ExceptionExpectation(fn);
        expectation.toThrow(exceptionClass);
    }
}
