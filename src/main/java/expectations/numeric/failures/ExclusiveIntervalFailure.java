package expectations.numeric.failures;

import expectations.numeric.Interval;

public class ExclusiveIntervalFailure extends Exception {

    public ExclusiveIntervalFailure(Comparable<Number> actual, Interval interval) {
        super(IntervalExceptionMessageBuilder.build((Number) actual, interval, IntervalType.EXCLUSIVE));
    }
}
