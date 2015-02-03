package expectations.numeric.failures;

import expectations.numeric.Interval;
import expectations.numeric.failures.messageBuilder.InclusiveIntervalExceptionMessageBuilder;

public class InclusiveIntervalFailure extends Exception {
    public InclusiveIntervalFailure(Number actual, Interval interval) {
        super(InclusiveIntervalExceptionMessageBuilder.build(actual, interval));
    }
}
