package expectations.numeric.failures;

import expectations.numeric.Interval;

class InclusiveIntervalExceptionMessageBuilder {

    public static String build(Number actual, Interval interval) {
        return "Expected: " + actual +
                " in (" + interval.getLowerBound() + ","
                + interval.getUpperBound() + ")";
    }
}

class ExclusiveIntervalExceptionMessageBuilder {
    public static String build(Number actual, Interval interval) {
        return "Expected: " + actual +
                " in [" + interval.getLowerBound() + ","
                + interval.getUpperBound() + "]";
    }
}
