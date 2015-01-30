package expectations.exception;

import expectations.exception.failures.ExceptionNotThrown;
import expectations.exception.failures.ExpectationMismatch;

public class ExpectationExceptionBuilder {

    private Exception exception = null;

    public ExpectationExceptionBuilder(RunnableWithException fn) {
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
