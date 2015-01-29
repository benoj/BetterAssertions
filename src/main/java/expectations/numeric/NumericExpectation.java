package expectations.numeric;

import exceptions.ComparisonMismatch;
import exceptions.ExpectationMismatch;

public class NumericExpectation<T extends Number & Comparable> {
    private T actual;

    public NumericExpectation(T value) {
        actual = value;
    }

    public void toEqual(T expected) throws ExpectationMismatch {
        if(!this.actual.equals(expected)) {
            throw new ExpectationMismatch(this.actual, expected);
        }
    }

    public NumericExpectation<T> toBeGreaterThan(T other) throws ComparisonMismatch {
        if(actual.compareTo(other) <= 0 ){
            throw new ComparisonMismatch(actual,other,">");
        }
        return this;
    }

    public NumericExpectation<T> toBeLessThan(T other) throws ComparisonMismatch {
        if(actual.compareTo(other) >= 0 ){
            throw new ComparisonMismatch(actual,other,"<");
        }
        return this;
    }

    public void toBeGreaterThanOrEqualTo(T other) throws ComparisonMismatch {
        if(actual.compareTo(other) < 0){
            throw new ComparisonMismatch(actual,other,">=");
        }
    }

    public void toBeLessThanOrEqualTo(T other) throws ComparisonMismatch {
        if(actual.compareTo(other) > 0){
            throw new ComparisonMismatch(actual,other,"<=");
        }
    }
}
