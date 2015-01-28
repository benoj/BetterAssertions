package expectations.exception;

import exceptions.ExpectationMismatch;
import exceptions.ExceptionNotThrown;

import java.util.Objects;

public class ExceptionExpectation {

    Exception exception = null;

    public ExceptionExpectation(RunnableWithException fn) {
        try {
            fn.run();
        } catch (Exception e) {
            exception = e;
        }
    }

    public ExceptionExpectation toThrow(Class exceptionClass) throws ExceptionNotThrown, ExpectationMismatch {
        guardAgainstNoExceptionThrown();

        if (exception.getClass() != exceptionClass) {
            throw new ExpectationMismatch(exception.getClass(),exceptionClass);
        }

        return this;
    }

    public void withMessage(String expectedMessage) throws ExpectationMismatch, ExceptionNotThrown {
        guardAgainstNoExceptionThrown();
        String actualMessage = exception.getMessage();
        if(!Objects.equals(actualMessage, expectedMessage)){
            throw new ExpectationMismatch(actualMessage,expectedMessage);
        }

    }

    private void guardAgainstNoExceptionThrown() throws ExceptionNotThrown {
        if(exception == null) {
            throw new ExceptionNotThrown();
        }
    }
}
