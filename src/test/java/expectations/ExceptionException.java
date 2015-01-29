package expectations;

import exceptions.ExpectationMismatch;
import exceptions.ExceptionNotThrown;
import org.junit.Test;

import java.io.IOException;
import java.util.EmptyStackException;

import static expectations.ExpectationFactory.expect;
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
    public void expectToThrowExceptionMismatchShowsTheExpectedAndActualExceptionTypes() throws ExceptionNotThrown {
        try {
            expect(() -> {
                throw new Exception();
            }).toThrow(EmptyStackException.class);
        } catch (ExpectationMismatch e) {
            assertEquals(e.getMessage(), String.format("Expected: %s, Actual: %s", EmptyStackException.class, Exception.class));
        }
    }
}
