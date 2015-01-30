package expectations.numeric.failures;

import expectations.numeric.Interval;

public class InclusiveIntervalFailure extends Exception{
    public InclusiveIntervalFailure(Comparable<Number> actual, Interval interval) {
        super(String.format("Expected: %s in (%s,%s)",actual, interval.getLowerBound(), interval.getUpperBound()));
    }
}
