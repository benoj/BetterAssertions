package expectations.exception;

import exceptions.ExceptionNotThrown;
import exceptions.ExpectationMismatch;

public class Expectation {

    private Exception exception = null;

    public Expectation(RunnableWithException fn) {
        try {
            fn.run();
        } catch (Exception e) {
            exception = e;
        }
    }

    public ExceptionExpectation toThrow(Class expected) throws ExceptionNotThrown, ExpectationMismatch {
        guardAgainstNoExceptionThrown();
        if (exception.getClass() != expected) {
            throw new ExpectationMismatch(exception.getClass(),expected);
        }
        return new ExceptionExpectation(exception);
    }


    private void guardAgainstNoExceptionThrown() throws ExceptionNotThrown {
        if (exception == null) {
            throw new ExceptionNotThrown();
        }
    }
}
