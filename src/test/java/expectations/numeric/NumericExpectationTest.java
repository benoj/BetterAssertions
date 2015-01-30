package expectations.numeric;

import exceptions.ComparisonMismatch;
import exceptions.ExpectationMismatch;
import expectations.exception.RunnableWithException;
import org.junit.Test;

import static expectations.ExpectationFactory.expect;

public class NumericExpectationTest {
    @Test
    public void expectToEqualWithEqualIntegersToPass() throws Exception {
        int value = 1;
        expect(value).toEqual(value);
    }

    @Test
    public void expectToEqualWithNonEqualIntegersToFail() throws Exception {
        RunnableWithException test = () -> expect(1).toEqual(2);
        expect(test).toThrow(ExpectationMismatch.class).withMessage("Expected: 2, Actual: 1");
    }

    @Test
    public void expectToEqualWithEqualDoublesToPass() throws Exception {
        double value = 1.0;
        expect(value).toEqual(value);
    }

    @Test
    public void expectToEqualWithNonEqualIDoubleToFail() throws Exception {
        RunnableWithException test = () -> expect(1.0).toEqual(2.0);
        expect(test).toThrow(ExpectationMismatch.class).withMessage("Expected: 2.0, Actual: 1.0");
    }

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

    @Test
    public void isGreaterThanAndIsChainable() throws Exception {
        expect(0).toBeGreaterThan(-1).toBeLessThan(1);
    }

    @Test
    public void expectToBeGreaterThanOrEqualToWithEqualNumberToPass() throws Exception {
        expect(1).toBeGreaterThanOrEqualTo(1);
    }

    @Test
    public void expectToBeGreaterThanOrEqualToWithBiggerNumberToFail() throws Exception {
        RunnableWithException test = () -> expect(1.0).toBeGreaterThanOrEqualTo(2.0);
        expect(test).toThrow(ComparisonMismatch.class).withMessage("Expected: 1.0 >= 2.0");
    }

    @Test
    public void expectToBeGreaterThanOrEqualToWithSmallerNumberToPass() throws Exception {
        expect(2).toBeGreaterThanOrEqualTo(1);
    }

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
    public void expectToBeSmallerThanOrEqualToWithBiggerNumberToPass() throws Exception {
        expect(2).toBeLessThanOrEqualTo(3);
    }
}
