package expectations.numeric.failures;

import expectations.numeric.Interval;

public class ExclusiveIntervalFailure extends Exception {

    public ExclusiveIntervalFailure(Comparable<Number> actual, Interval interval) {
        super(String.format("Expected: %s in [%s,%s]",actual, interval.getLowerBound(), interval.getUpperBound()));
    }
}
