package expectations;

import exceptions.ExceptionMismatch;
import exceptions.ExceptionNotThrown;
import expectations.exception.RunnableWithException;
import org.junit.Test;

import java.io.IOException;
import java.util.EmptyStackException;

import static expectations.exception.Expect.expect;
import static org.junit.Assert.assertEquals;

public class ExceptionExcpectation {

    @Test
    public void expectToThrowPassesWhenExpectationMatches() throws Exception {
        expect(() -> {
            throw new Exception();
        }).toThrow(Exception.class);
    }

    @Test(expected = ExceptionNotThrown.class)
    public void whenNoExceptionThrownThenTestFailsWithExceptionNotThrown() throws Exception {
        expect(() -> {
        }).toThrow(Exception.class);
    }

    @Test(expected = ExceptionMismatch.class)
    public void whenExceptionThrownAndExceptionDoesNotMatchThenTestFailsWithExceptionDoesntMatch() throws Exception {
        expect(() -> {
            throw new IOException();
        }).toThrow(Exception.class);
    }

    @Test
    public void whenExceptionMismatchThrownMessageIsMeaningfull() throws ExceptionNotThrown {
        try {
            expect(() -> {
                throw new Exception();
            }).toThrow(EmptyStackException.class);
        } catch (ExceptionMismatch e) {
            assertEquals(e.getMessage(), String.format("Expected: %s, Actual %s", EmptyStackException.class, Exception.class));
        }
    }



}
