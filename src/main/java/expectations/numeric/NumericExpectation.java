package expectations.numeric;

import exceptions.ComparisonMismatch;
import exceptions.ExpectationMismatch;


public class NumericExpectation<T extends Comparable<Number>> {
    private T actual = null;


    @SuppressWarnings("unchecked")
    public NumericExpectation(Number value) {
        actual = (T) value;
    }

    public void toEqual(Number expected) throws ExpectationMismatch {
        if(!this.actual.equals(expected)) {
            throw new ExpectationMismatch(this.actual, expected);
        }
    }

    public NumericExpectation<T> toBeGreaterThan(Number other) throws ComparisonMismatch {

        if(actual.compareTo(other) <= 0 ){
            throw new ComparisonMismatch((Number) actual,other,">");
        }
        return this;
    }

    public NumericExpectation<T> toBeLessThan(Number other) throws ComparisonMismatch {
        if(actual.compareTo(other) >= 0 ){
            throw new ComparisonMismatch((Number) actual,other,"<");
        }
        return this;
    }

    public void toBeGreaterThanOrEqualTo(Number other) throws ComparisonMismatch {
        if(actual.compareTo(other) < 0){
            throw new ComparisonMismatch((Number) actual,other,">=");
        }
    }

    public void toBeLessThanOrEqualTo(Number other) throws ComparisonMismatch {
        if(actual.compareTo(other) > 0){
            throw new ComparisonMismatch((Number) actual,other,"<=");
        }
    }
}
