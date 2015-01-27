package assertions.exception;

import exceptions.ExceptionMismatch;
import exceptions.ExceptionNotThrown;

public class Exceptions {
    public static void assertThrows(RunnableWithException fn, Class exceptionClass) throws ExceptionNotThrown, ExceptionMismatch {
        Exception exception = null;
        try {
            fn.run();
        } catch (Exception e) {
            exception = e;
        }finally {
            if(exception == null){
                throw new ExceptionNotThrown();
            }
            if (exception.getClass() != exceptionClass) {
                throw new ExceptionMismatch(exception.getClass(),exceptionClass);
            }

        }
    }
}
