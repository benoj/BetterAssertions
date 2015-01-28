package assertions.exception;

import exceptions.ExceptionNotThrown;
import exceptions.ExpectationMismatch;
import expectations.exception.Expectation;
import expectations.exception.RunnableWithException;

public class Exceptions {
    public static void assertThrows(RunnableWithException fn, Class exceptionClass) throws ExceptionNotThrown, ExpectationMismatch {
        Expectation expectation = new Expectation(fn);
        expectation.toThrow(exceptionClass);
    }
}
