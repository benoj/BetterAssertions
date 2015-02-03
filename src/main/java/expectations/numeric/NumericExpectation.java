package expectations.numeric;

import expectations.numeric.failures.*;


public class NumericExpectation<T extends Comparable<Number>> {
    private NumericComparison comparison;
    private Number actual;
    
    @SuppressWarnings("unchecked")
    public NumericExpectation(Number value) {
        actual =  value;
        comparison = new NumericComparison((T) actual);
    }

    public void toEqual(Number expected) throws EqualityComparisonFailure {
        if (!comparison.equalTo(expected)) {
            throw new EqualityComparisonFailure(actual, expected);
        }
    }

    public NumericExpectation<T> toBeGreaterThan(Number other) throws GreaterThanComparisonFailure {

        if (comparison.lessThanOrEqualTo(other)){
            throw new GreaterThanComparisonFailure(actual, other);
        }
        return this;
    }

    public NumericExpectation<T> toBeLessThan(Number other) throws LessThanComparisonFailure {
        if (comparison.greaterThanOrEqualTo(other)) {
            throw new LessThanComparisonFailure(actual, other);
        }
        return this;
    }

    public void toBeGreaterThanOrEqualTo(Number other) throws GreaterThanOrEqualComparisonFailure {
        if (comparison.lessThan(other)) {
            throw new GreaterThanOrEqualComparisonFailure(actual, other);
        }
    }

    public void toBeLessThanOrEqualTo(Number other) throws LessThanOrEqualComparisonFailure {
        if (comparison.greaterThan(other)) {
            throw new LessThanOrEqualComparisonFailure(actual, other);
        }
    }

    public void toBeWithin(Number boundA, Number boundB) throws InclusiveIntervalFailure {
        Interval interval = new Interval(boundA, boundB);
        if (comparison.lessThan(interval.getLowerBound()) || comparison.greaterThan(interval.getUpperBound())) {
            throw new InclusiveIntervalFailure(actual, interval);
        }
    }

    public void toBeBetween(Number boundA, Number boundB) throws ExclusiveIntervalFailure {
        Interval interval = new Interval(boundA, boundB);
        if (comparison.lessThanOrEqualTo(interval.getLowerBound()) || comparison.greaterThanOrEqualTo(interval.getUpperBound())) {
            throw new ExclusiveIntervalFailure(actual,interval);
        }
    }
}


