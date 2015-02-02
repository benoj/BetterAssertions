package expectations.numeric.failures;

import expectations.numeric.Interval;

public class InclusiveIntervalFailure extends Exception {
    public InclusiveIntervalFailure(Comparable<Number> actual, Interval interval) {
        super(InclusiveIntervalExceptionMessageBuilder.build((Number) actual, interval));
    }
}
