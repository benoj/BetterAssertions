package expectations.numeric.failures;

import expectations.numeric.Interval;

enum IntervalType{
    INCLUSIVE,EXCLUSIVE
}

class IntervalExceptionMessageBuilder {
    
    public static String build(Number actual,Interval interval, IntervalType intervalType){
        return "Expected: " + actual + " in " + getLowerBoundParenthenisis(intervalType) + interval.getLowerBound() + "," + interval.getUpperBound() + getUpperBoundParenthenisis(intervalType);
    }
    
    private static String getLowerBoundParenthenisis(IntervalType intervalType){
        if(intervalType == IntervalType.INCLUSIVE){
            return "(";
        }else{
            return "[";
        }
    }

    private static String getUpperBoundParenthenisis(IntervalType intervalType){
        if(intervalType == IntervalType.INCLUSIVE){
            return ")";
        }else{
            return "]";
        }
    }
}
