package expectations.numeric;

import expectations.exception.TestWithException;
import expectations.numeric.failures.GreaterThanOrEqualComparisonFailure;
import org.junit.Test;

import static expectations.ExpectationFactory.expect;

public class TestToBeGreaterThanOrEqualTo {
    @Test
    public void expectToBeGreaterThanOrEqualToWithEqualNumberToPass() throws Exception {
        expect(1).toBeGreaterThanOrEqualTo(1);
    }

    @Test
    public void expectToBeGreaterThanOrEqualToWithBiggerNumberToFail() throws Exception {
        TestWithException test = () -> expect(1.0).toBeGreaterThanOrEqualTo(2.0);
        expect(test).toThrow(GreaterThanOrEqualComparisonFailure.class).withMessage("Expected: 1.0 >= 2.0");
    }

    @Test
    public void expectToBeGreaterThanOrEqualToWithSmallerNumberToPass() throws Exception {
        expect(2).toBeGreaterThanOrEqualTo(1);
    }
}
