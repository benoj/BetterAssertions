package expectations.numeric;

import exceptions.ComparisonMismatch;
import exceptions.ExpectationMismatch;
import expectations.exception.RunnableWithException;
import org.junit.Test;

import static expectations.ExpectationFactory.expect;

public class NumericExpectationTests {
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
        RunnableWithException fn = () -> new NumericExpectation<>(1.0).toEqual(2.0);
        expect(fn).toThrow(ExpectationMismatch.class).withMessage("Expected: 2.0, Actual: 1.0");
    }

    @Test
    public void expectIsGreaterThatWithSmallerNumberToPass() throws Exception {
        RunnableWithException fn = () -> new NumericExpectation<>(2).toBeGreaterThan(1);
        fn.run();
    }

    @Test
    public void expectIsGreaterThanWithBiggerNumberToFail() throws Exception {
        RunnableWithException fn = () -> new NumericExpectation<>(1.0).toBeGreaterThan(2.0);
        expect(fn).toThrow(ComparisonMismatch.class).withMessage("Expected: 1.0 > 2.0");
    }

    @Test
    public void expectIsGreaterThanWithEqualNumberToFail() throws Exception {
        RunnableWithException fn = () -> new NumericExpectation<>(1.0).toBeGreaterThan(1.0);
        expect(fn).toThrow(ComparisonMismatch.class).withMessage("Expected: 1.0 > 1.0");
    }

    @Test
    public void expectIsLessThanWithSmallerNumberToFail() throws Exception {
        RunnableWithException fn = () -> new NumericExpectation<>(2.0).toBeLessThan(1.0);
        expect(fn).toThrow(ComparisonMismatch.class).withMessage("Expected: 2.0 < 1.0");
    }

    @Test
    public void expectIsLessThanWithEqualNumberToFail() throws Exception {
        RunnableWithException fn = () -> new NumericExpectation<>(2.0).toBeLessThan(2.0);
        expect(fn).toThrow(ComparisonMismatch.class).withMessage("Expected: 2.0 < 2.0");
    }

    @Test
    public void expectIsLessThanWithBiggerNumberToPass() throws Exception {
        RunnableWithException fn = () -> new NumericExpectation<>(1).toBeLessThan(2);
        fn.run();
    }

    @Test
    public void isLessThanAndIsChainable() throws Exception {
        RunnableWithException fn = () -> new NumericExpectation<>(0).toBeLessThan(1).toBeGreaterThan(-1);
        fn.run();
    }

    @Test
    public void isGreaterThanAndIsChainable() throws Exception {
        RunnableWithException fn = () -> new NumericExpectation<>(0).toBeGreaterThan(-1).toBeLessThan(1);
        fn.run();
    }

    @Test
    public void expectToBeGreaterThanOrEqualToWithEqualNumberToPass() throws Exception {
        RunnableWithException fn = () -> new NumericExpectation<>(1).toBeGreaterThanOrEqualTo(1);
        fn.run();
    }

    @Test
    public void expectToBeGreaterThanOrEqualToWithBiggerNumberToFail() throws Exception {
        RunnableWithException fn = () -> new NumericExpectation<>(1.0).toBeGreaterThanOrEqualTo(2.0);
        expect(fn).toThrow(ComparisonMismatch.class).withMessage("Expected: 1.0 >= 2.0");
    }

    @Test
    public void expectToBeGreaterThanOrEqualToWithSmallerNumberToPass() throws Exception {
        RunnableWithException fn = () -> new NumericExpectation<>(2).toBeGreaterThanOrEqualTo(1);
        fn.run();
    }

    @Test
    public void expectToBeLessThanOrEqualToWithEqualNumberToPass() throws Exception {
        RunnableWithException fn = () -> new NumericExpectation<>(1).toBeLessThanOrEqualTo(1);
        fn.run();
    }

    @Test
    public void expectToBeLessThanOrEqualToWithSmallerNumberToFail() throws Exception {
        RunnableWithException fn = () -> new NumericExpectation<>(1.0).toBeLessThanOrEqualTo(0.0);
        expect(fn).toThrow(ComparisonMismatch.class).withMessage("Expected: 1.0 <= 0.0");
    }

    @Test
    public void expectToBeSmallerThanOrEqualToWithBiggerNumberToPass() throws Exception {
        RunnableWithException fn = () -> new NumericExpectation<>(2).toBeLessThanOrEqualTo(3);
        fn.run();
    }
}
