package expectations.numeric.failures.messageBuilder;

import expectations.numeric.Interval;

public class InclusiveIntervalExceptionMessageBuilder {

    public static String build(Number actual, Interval interval) {
        return "Expected: " + actual +
                " in (" + interval.getLowerBound() + ","
                + interval.getUpperBound() + ")";
    }
}
