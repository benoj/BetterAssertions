package expectations.numeric;

import expectations.exception.TestWithExceptiohn;
import expectations.numeric.failures.InclusiveIntervalFailure;
import org.junit.Test;

import static expectations.ExpectationFactory.expect;

public class TestToBeWithin {
    @Test
    public void expectToBeWithinWithNumberInsideRangeToPass() throws Exception {
        expect(2).toBeWithin(1, 3);
    }

    @Test
    public void expectToBeWithinWithNumberOnIntervalAToPass() throws Exception {
        expect(2).toBeWithin(2, 3);
    }

    @Test
    public void expectToBeWithinWithNumberOnIntervalBToPass() throws Exception {
        expect(3.1).toBeWithin(3.0, 3.1);
    }

    @Test
    public void expectToBeWithinWithNumberBelowIntervalToFail() throws Exception {
        TestWithExceptiohn test = () -> expect(3.1).toBeWithin(3.2, 3.3);
        expect(test).toThrow(InclusiveIntervalFailure.class).withMessage("Expected: 3.1 in (3.2,3.3)");
    }

    @Test
    public void expectToBeWithinWithNumberAboveIntervalToFail() throws Exception {
        TestWithExceptiohn test = () -> expect(6).toBeWithin(4, 5);
        expect(test).toThrow(InclusiveIntervalFailure.class).withMessage("Expected: 6 in (4,5)");
    }

    @Test
    public void expectToBeWithinWithNegativeIntervalAndNumberInIntervalToPass() throws Exception {
        expect(1).toBeWithin(1, -1);
    }
}
