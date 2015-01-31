package expectations.numeric;

import expectations.exception.RunnableWithException;
import expectations.numeric.failures.ComparisonMismatch;
import org.junit.Test;

import static expectations.ExpectationFactory.expect;

public class TestIsLessThan {
    @Test
    public void expectIsLessThanWithSmallerNumberToFail() throws Exception {
        RunnableWithException test = () -> expect(2.0).toBeLessThan(1.0);
        expect(test).toThrow(ComparisonMismatch.class).withMessage("Expected: 2.0 < 1.0");
    }

    @Test
    public void expectIsLessThanWithEqualNumberToFail() throws Exception {
        RunnableWithException test = () -> expect(2.0).toBeLessThan(2.0);
        expect(test).toThrow(ComparisonMismatch.class).withMessage("Expected: 2.0 < 2.0");
    }

    @Test
    public void expectIsLessThanWithBiggerNumberToPass() throws Exception {
        expect(1).toBeLessThan(2);
    }

    @Test
    public void isLessThanAndIsChainable() throws Exception {
        expect(0).toBeLessThan(1).toBeGreaterThan(-1);
    }
}
