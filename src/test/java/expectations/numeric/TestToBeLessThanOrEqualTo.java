package expectations.numeric;

import expectations.exception.RunnableWithException;
import expectations.numeric.failures.ComparisonMismatch;
import org.junit.Test;

import static expectations.ExpectationFactory.expect;

public class TestToBeLessThanOrEqualTo {
    @Test
    public void expectToBeLessThanOrEqualToWithEqualNumberToPass() throws Exception {
        expect(1).toBeLessThanOrEqualTo(1);
    }

    @Test
    public void expectToBeLessThanOrEqualToWithSmallerNumberToFail() throws Exception {
        RunnableWithException test = () -> expect(1.0).toBeLessThanOrEqualTo(0.0);
        expect(test).toThrow(ComparisonMismatch.class).withMessage("Expected: 1.0 <= 0.0");
    }

    @Test
    public void expectToBeLessThanOrEqualToWithBiggerNumberToPass() throws Exception {
        expect(2).toBeLessThanOrEqualTo(3);
    }
}
