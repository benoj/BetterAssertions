package expectations.numeric;

public class Interval {
    private  Number lowerBound ;
    private  Number upperBound;

    
    public Interval(Number boundA, Number boundB) {
        Comparable<Number> comparableBoundA = (Comparable<Number>) boundA;
        if(comparableBoundA.compareTo(boundB) == -1){
            lowerBound = boundA;
            upperBound = boundB;
        }else{
            lowerBound = boundB;
            upperBound = boundA;
        }
    }

    public Number getLowerBound() {
        return lowerBound;
    }

    public Number getUpperBound() {
        return upperBound;
    }

}