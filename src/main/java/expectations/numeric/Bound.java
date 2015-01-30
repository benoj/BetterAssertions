package expectations.numeric;

public class Bound {
    private  Number lowerBound ;
    private  Number upperBound;

    public Bound(Number boundA, Number boundB) {
        Comparable<Number> comparableBoundA = (Comparable<Number>) boundA;
        if(comparableBoundA.compareTo(boundB) < 0){
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