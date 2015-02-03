package expectations.numeric;

class NumericComparison {
    private Comparable<Number> comparator;
    private static final int GREATER_THAN = 1;
    private static final int LESS_THAN = -1;
    private static final int EQUIVALENT = 0;

    public NumericComparison(Comparable<Number> comparator) {
        this.comparator = comparator;
    }

    public boolean equalTo(Number other){
        return comparator.compareTo(other) == EQUIVALENT;
     }

    public boolean lessThan(Number other){
        return comparator.compareTo(other) == LESS_THAN;
    }

    public boolean lessThanOrEqualTo(Number other) {
        return comparator.compareTo(other) != GREATER_THAN;
    }

    public boolean greaterThan(Number other){
        return comparator.compareTo(other) == GREATER_THAN;
    }

    public boolean greaterThanOrEqualTo(Number other){
        return comparator.compareTo(other) != LESS_THAN;
    }
}
