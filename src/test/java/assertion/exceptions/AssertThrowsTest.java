package assertion.exceptions;

import expectations.exception.RunnableWithException;
import expectations.exception.failures.ExpectationMismatch;
import expectations.exception.failures.ExceptionNotThrown;
import org.junit.Test;

import java.io.IOException;
import java.util.EmptyStackException;

import static assertions.exception.Exceptions.assertThrows;
import static org.junit.Assert.assertEquals;

public class AssertThrowsTest {

    @Test(expected = ExceptionNotThrown.class)
    public void whenNoExceptionThrownThenTestFailsWithExceptionNotThrown() throws Exception {
        assertThrows(()-> {
        },Exception.class);
    }

    @Test
    public void whenExceptionThrownAndExceptionMatchesThenTestPasses() throws Exception {
        assertThrows(() -> { throw new IOException();},IOException.class);
    }

    @Test(expected = ExpectationMismatch.class)
    public void whenExceptionThrownAndExceptionDoesNotMatchThenTestFailsWithExceptionDoesntMatch() throws Exception {
        assertThrows(() -> { throw new IOException();},Exception.class);
    }

    @Test
    public void whenExceptionMismatchThrownMessageIsMeaningfull(){
        try {
            RunnableWithException fn = () -> {
                throw new Exception();
            };

            assertThrows(fn,EmptyStackException.class);
        }catch(ExpectationMismatch e){
            assertEquals(e.getMessage(), String.format("Expected: %s, Actual: %s", EmptyStackException.class, Exception.class));
        } catch (ExceptionNotThrown exceptionNotThrown) {
            assertEquals(2,3);
        }
    }




}
