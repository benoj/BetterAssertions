package expectations.numeric;

import expectations.exception.RunnableWithException;
import expectations.numeric.failures.ComparisonMismatch;
import expectations.numeric.failures.ExclusiveIntervalFailure;
import expectations.numeric.failures.InclusiveIntervalFailure;
import org.junit.Test;

import static expectations.ExpectationFactory.expect;

public class TestIsGreaterThan {
    @Test
    public void expectIsGreaterThatWithSmallerNumberToPass() throws Exception {
       expect(2).toBeGreaterThan(1);
    }

    @Test
    public void expectIsGreaterThanWithBiggerNumberToFail() throws Exception {
        RunnableWithException test = () -> expect(1.0).toBeGreaterThan(2.0);
        expect(test).toThrow(ComparisonMismatch.class).withMessage("Expected: 1.0 > 2.0");
    }

    @Test
    public void expectIsGreaterThanWithEqualNumberToFail() throws Exception {
        RunnableWithException test = () -> expect(1.0).toBeGreaterThan(1.0);
        expect(test).toThrow(ComparisonMismatch.class).withMessage("Expected: 1.0 > 1.0");
    }
    @Test
    public void isGreaterThanAndIsChainable() throws Exception {
        expect(0).toBeGreaterThan(-1).toBeLessThan(1);
    }
}
