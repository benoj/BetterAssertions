package expectations;

import exceptions.ExpectationMismatch;
import exceptions.ExceptionNotThrown;
import expectations.exception.RunnableWithException;
import org.junit.Test;

import java.io.IOException;
import java.util.EmptyStackException;

import static expectations.exception.Expect.expect;
import static org.junit.Assert.assertEquals;

public class ExceptionException {

    @Test
    public void expectToThrowPassesWhenExpectationMatches() throws Exception {
        expect(() -> {
            throw new Exception();
        }).toThrow(Exception.class);
    }

    @Test(expected = ExceptionNotThrown.class)
    public void expectToThrowFailsWithExceptionNotThrownWhenNoException() throws Exception {
        expect(() -> {
        }).toThrow(Exception.class);
    }

    @Test(expected = ExpectationMismatch.class)
    public void expectToThrowFailsWithExceptionMismatchWhenExpectedExceptionIsNotEqual() throws Exception {
        expect(() -> {
            throw new IOException();
        }).toThrow(Exception.class);
    }

    @Test
    public void exoectToThrowExceptionMismatchShowsTheExpectedAndActualExceptionTypes() throws ExceptionNotThrown {
        try {
            expect(() -> {
                throw new Exception();
            }).toThrow(EmptyStackException.class);
        } catch (ExpectationMismatch e) {
            assertEquals(e.getMessage(), String.format("Expected: %s, Actual %s", EmptyStackException.class, Exception.class));
        }
    }

    @Test
    public void expectWithMessageToPassWhenMessageIsCorrect() throws Exception {
        String expectationMessage = "Hello World";
        RunnableWithException fn = () -> {
            throw new Exception(expectationMessage);
        };
        expect(fn).toThrow(Exception.class).withMessage(expectationMessage);
    }

    @Test(expected = ExpectationMismatch.class)
    public void expectWithMessageThrowsExpectationMismatchWhenMessagesDoNotMatch() throws Exception {
        String expectationMessage = "Hello World";
        RunnableWithException fn = () -> {
            throw new Exception(expectationMessage);
        };
        expect(fn).toThrow(Exception.class).withMessage("Bonjour le monde");
    }

    @Test(expected = ExceptionNotThrown.class)
    public void expectwithMessageFailsWithExceptionNotThrownWhenNoException() throws Exception {
        expect(() -> {
        }).withMessage("");
    }

    @Test
    public void expectWithMessageToGiveNiceMessage() throws ExceptionNotThrown {
        String expectationMessage = "Hello World";
        String actualMessage = "Bonjour le monde";
        try {
            expect(() -> {
                throw new Exception(actualMessage);
            }).withMessage(expectationMessage);
        } catch (ExpectationMismatch e) {
            assertEquals(String.format("Expected: %s, Actual %s", expectationMessage, actualMessage),e.getMessage());
        }
    }
}
