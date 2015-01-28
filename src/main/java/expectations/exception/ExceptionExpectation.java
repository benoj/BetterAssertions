package expectations.exception;

import exceptions.ExceptionMismatch;
import exceptions.ExceptionNotThrown;

public class ExceptionExpectation {

    Exception exception = null;

    public ExceptionExpectation(RunnableWithException fn) {
        try {
            fn.run();
        } catch (Exception e) {
            exception = e;
        }
    }

    public void toThrow(Class exceptionClass) throws ExceptionNotThrown, ExceptionMismatch {
        if(exception == null) {
            throw new ExceptionNotThrown();
        }
        if (exception.getClass() != exceptionClass) {
            throw new ExceptionMismatch(exception.getClass(),exceptionClass);
        }
    }
}
