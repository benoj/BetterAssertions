package expectations.exception;

import exceptions.ExpectationMismatch;

import java.util.Objects;

public class ExceptionExpectation {


    private Exception exception;

    public ExceptionExpectation(Exception exception) {
        this.exception = exception;
    }

    public static Expectation expect(RunnableWithException fn){
        return new Expectation(fn);
    }

    public void withMessage(String expectedMessage) throws ExpectationMismatch {
        String actualMessage = exception.getMessage();
        if(!Objects.equals(actualMessage, expectedMessage)){
            throw new ExpectationMismatch(actualMessage,expectedMessage);
        }
    }
}
