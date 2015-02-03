package expectations.exception;

import expectations.exception.failures.ExceptionNotThrown;
import expectations.exception.failures.ExpectationMismatch;
import org.junit.Test;

import static expectations.ExpectationFactory.expect;
import static org.junit.Assert.assertEquals;

public class TestWithMessage {

    private final String exceptionMessage = "Hello World";
    private final TestWithException fn = () -> { throw new Exception(exceptionMessage);};

    @Test
    public void expectWithMessageToPassWhenMessageIsCorrect() throws Exception {
        expect(fn).toThrow(Exception.class).withMessage(exceptionMessage);
    }

    @Test
    public void expectWithMessageThrowsExpectationMismatchWhenMessagesDoNotMatch() throws Exception {
        TestWithException test = () -> expect(fn).toThrow(Exception.class).withMessage("Bonjour le monde");
        expect(test).toThrow(ExpectationMismatch.class);
    }


    @Test
    public void expectWithMessageToGiveNiceMessage() throws ExceptionNotThrown {
        String expectedmessage = "Bonjour le monde";
        try {
            expect(fn).toThrow(Exception.class).withMessage(expectedmessage);
        } catch (ExpectationMismatch e) {
            assertEquals(String.format("Expected: %s, Actual: %s", expectedmessage,exceptionMessage), e.getMessage());
        }
    }
}
