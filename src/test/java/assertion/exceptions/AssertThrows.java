package assertion.exceptions;

import assertions.exception.RunnableWithException;
import exceptions.ExceptionMismatch;
import exceptions.ExceptionNotThrown;
import org.junit.Test;

import java.io.IOException;
import java.util.EmptyStackException;

import static assertions.exception.Exceptions.assertThrows;
import static org.junit.Assert.assertEquals;

public class AssertThrows {

    @Test(expected = ExceptionNotThrown.class)
    public void whenNoExceptionThrownThenTestFailsWithExceptionNotThrown() throws Exception {
        assertThrows(()-> { int x = 1+1; },Exception.class);
    }


    @Test
    public void whenExceptionThrownAndExceptionMatchesThenTestPasses() throws Exception {
        assertThrows(() -> { throw new IOException();},IOException.class);
    }

    @Test(expected = ExceptionMismatch.class)
    public void whenExceptionThrownAndExceptionDoesNotMatchThenTestFailsWithExceptionDoesntMatch() throws Exception {
        assertThrows(() -> { throw new IOException();},Exception.class);
    }

    @Test
    public void whenExceptionMismatchThrownMessageIsMeaningfull(){
        try {
            RunnableWithException fn = new RunnableWithException() {
                @Override
                public void run() throws Exception {
                    throw new Exception();
                }
            };

            assertThrows(fn,EmptyStackException.class);
        }catch(ExceptionMismatch e){
            assertEquals(e.getMessage(), String.format("Expected: %s, Actual %s", EmptyStackException.class, Exception.class));
        } catch (ExceptionNotThrown exceptionNotThrown) {
            assertEquals(2,3);
        }
    }




}
