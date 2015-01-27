package exceptions;

import java.util.EmptyStackException;
import java.util.IllegalFormatException;

public class ExceptionMismatch extends Exception {
    public ExceptionMismatch(Class actualClass, Class expectedClass) {
        super(String.format("Expected: %s, Actual %s", expectedClass, actualClass));
    }
}
