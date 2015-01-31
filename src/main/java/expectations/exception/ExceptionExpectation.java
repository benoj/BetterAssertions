package expectations.exception;

import expectations.exception.failures.ExpectationMismatch;

public class ExceptionExpectation {

    private Exception exception;

    public ExceptionExpectation(Exception exception) {
        this.exception = exception;
    }

    public void withMessage(String expectedMessage) throws ExpectationMismatch {
        String actualMessage = exception.getMessage();
        if(!expectedMessage.equals(actualMessage)){
            throw new ExpectationMismatch(actualMessage,expectedMessage);
        }
    }

}
