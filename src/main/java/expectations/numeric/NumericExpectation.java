package expectations.numeric;

import expectations.numeric.failures.InclusiveIntervalFailure;
import expectations.numeric.failures.ComparisonMismatch;
import expectations.numeric.failures.ExclusiveIntervalFailure;


public class NumericExpectation<T extends Comparable<Number>> {
    private T actual = null;


    @SuppressWarnings("unchecked")
    public NumericExpectation(Number value) {
        actual = (T) value;
    }

    public void toEqual(Number expected) throws ComparisonMismatch {
        if (!this.actual.equals(expected)) {
            throw new ComparisonMismatch((Number) this.actual, expected, "==");
        }
    }

    public NumericExpectation<T> toBeGreaterThan(Number other) throws ComparisonMismatch {

        if (actual.compareTo(other) <= 0) {
            throw new ComparisonMismatch((Number) actual, other, ">");
        }
        return this;
    }

    public NumericExpectation<T> toBeLessThan(Number other) throws ComparisonMismatch {
        if (actual.compareTo(other) >= 0) {
            throw new ComparisonMismatch((Number) actual, other, "<");
        }
        return this;
    }

    public void toBeGreaterThanOrEqualTo(Number other) throws ComparisonMismatch {
        if (actual.compareTo(other) < 0) {
            throw new ComparisonMismatch((Number) actual, other, ">=");
        }
    }

    public void toBeLessThanOrEqualTo(Number other) throws ComparisonMismatch {
        if (actual.compareTo(other) > 0) {
            throw new ComparisonMismatch((Number) actual, other, "<=");
        }
    }

    public void toBeWithin(Number boundA, Number boundB) throws InclusiveIntervalFailure {
        Interval interval = new Interval(boundA, boundB);
        if (actual.compareTo(interval.getLowerBound()) < 0 || actual.compareTo(interval.getUpperBound()) > 0) {
            throw new InclusiveIntervalFailure(actual, interval);
        }
    }

    public void toBeBetween(Number boundA, Number boundB) throws ExclusiveIntervalFailure {
        Interval interval = new Interval(boundA, boundB);
        if (actual.compareTo(interval.getLowerBound()) <= 0 || actual.compareTo(interval.getUpperBound()) >= 0) {
            throw new ExclusiveIntervalFailure(actual, interval);
        }
    }
}


