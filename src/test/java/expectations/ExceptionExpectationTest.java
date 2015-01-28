package expectations;

import exceptions.ExceptionNotThrown;
import exceptions.ExpectationMismatch;
import expectations.exception.ExceptionExpectation;
import expectations.exception.RunnableWithException;
import org.junit.Test;

import static expectations.exception.Expect.expect;
import static org.junit.Assert.assertEquals;

public class ExceptionExpectationTest {


    @Test
    public void expectWithMessageToPassWhenMessageIsCorrect() throws Exception {
        String expectationMessage = "Hello World";
        Exception exception = new Exception(expectationMessage);
        new ExceptionExpectation(exception).withMessage(expectationMessage);
    }

    @Test
    public void expectWithMessageThrowsExpectationMismatchWhenMessagesDoNotMatch() throws Exception {
        String expectationMessage = "Hello World";
        String actualMessage = "Bonjour le monde";
        Exception exception = new Exception(actualMessage);
        RunnableWithException fn = () -> {
            new ExceptionExpectation(exception).withMessage(expectationMessage);
        };
        expect(fn).toThrow(ExpectationMismatch.class);
    }


    @Test
    public void expectWithMessageToGiveNiceMessage() throws ExceptionNotThrown {
        String expectedMessage = "Hello World";
        String actualMessage = "Bonjour le monde";
        Exception exception = new Exception(actualMessage);
        try {
            new ExceptionExpectation(exception).withMessage(expectedMessage);
        } catch (ExpectationMismatch e) {
            assertEquals(String.format("Expected: %s, Actual %s", expectedMessage, actualMessage), e.getMessage());
        }
    }
}
