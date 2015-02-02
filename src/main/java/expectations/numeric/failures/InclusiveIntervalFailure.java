package expectations.numeric.failures;

import expectations.numeric.Interval;

public class InclusiveIntervalFailure extends Exception {
    public InclusiveIntervalFailure(Comparable<Number> actual, Interval interval) {
        super(IntervalExceptionMessageBuilder.build((Number) actual, interval, IntervalType.INCLUSIVE));
    }
}
