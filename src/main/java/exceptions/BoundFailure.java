package exceptions;

import expectations.numeric.Bound;

public class BoundFailure extends Exception{


    public BoundFailure(Comparable<Number> actual, Bound bound) {
        super(String.format("Expected: %s in (%s,%s)",actual,bound.getLowerBound(),bound.getUpperBound()));
    }
}
