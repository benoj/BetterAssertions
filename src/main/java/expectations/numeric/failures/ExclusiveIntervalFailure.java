package expectations.numeric.failures;

import expectations.numeric.Interval;
import expectations.numeric.failures.messageBuilder.ExclusiveIntervalExceptionMessageBuilder;

public class ExclusiveIntervalFailure extends Exception {

    public ExclusiveIntervalFailure(Number actual, Interval interval) {
        super(ExclusiveIntervalExceptionMessageBuilder.build(actual, interval));
    }
}
