package expectations.numeric;

import expectations.exception.RunnableWithException;
import expectations.numeric.failures.ExclusiveIntervalFailure;
import org.junit.Test;

import static expectations.ExpectationFactory.expect;

public class TestToBeBetween {
    @Test
    public void expectToBeBetweenWithNumberInsideRangeToPass() throws Exception {
        expect(2).toBeBetween(1, 3);
    }

    @Test
    public void expectToBeBetweenNumberOnIntervalAToFail() throws Exception {
        RunnableWithException test = () -> expect(2).toBeBetween(2, 3);
        expect(test).toThrow(ExclusiveIntervalFailure.class).withMessage("Expected: 2 in [2,3]");
    }

    @Test
    public void expectToBeBetweenWithNumberOnIntervalBToFail() throws Exception {
        RunnableWithException test = () -> expect(3.5).toBeBetween(3.0, 3.5);
        expect(test).toThrow(ExclusiveIntervalFailure.class).withMessage("Expected: 3.5 in [3.0,3.5]");
    }

    @Test
    public void expectToBeBetweenWithNumberBelowIntervalToFail() throws Exception {
        RunnableWithException test = () -> expect(3.1).toBeBetween(3.2, 3.3);
        expect(test).toThrow(ExclusiveIntervalFailure.class).withMessage("Expected: 3.1 in [3.2,3.3]");
    }

    @Test
    public void expectToBeBetweenWithNumberAboveIntervalToFail() throws Exception {
        RunnableWithException test = () -> expect(6).toBeBetween(4, 5);
        expect(test).toThrow(ExclusiveIntervalFailure.class).withMessage("Expected: 6 in [4,5]");
    }

    @Test
    public void expectToBeBetweenWithNegativeIntervalAndNumberInIntervalToPass() throws Exception {
        expect(0).toBeBetween(1, -1);
    }
}
