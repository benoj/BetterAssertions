package expectations.numeric;

import expectations.exception.RunnableWithException;
import expectations.numeric.failures.ComparisonMismatch;
import org.junit.Test;

import static expectations.ExpectationFactory.expect;

public class TestToEqual {
    @Test
    public void expectToEqualWithEqualIntegersToPass() throws Exception {
        int value = 1;
        expect(value).toEqual(value);
    }

    @Test
    public void expectToEqualWithNonEqualIntegersToFail() throws Exception {
        RunnableWithException test = () -> expect(1).toEqual(2);
        expect(test).toThrow(ComparisonMismatch.class).withMessage("Expected: 1 == 2");
    }

    @Test
    public void expectToEqualWithEqualDoublesToPass() throws Exception {
        double value = 1.0;
        expect(value).toEqual(value);
    }

    @Test
    public void expectToEqualWithNonEqualIDoubleToFail() throws Exception {
        RunnableWithException test = () -> expect(1.0).toEqual(2.0);
        expect(test).toThrow(ComparisonMismatch.class).withMessage("Expected: 1.0 == 2.0");
    }
}
