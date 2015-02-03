package expectations.numeric.failures.messageBuilder;

public class NumericExceptionMessageBuilder {

    public static String build(Number actual,String operator,Number expected){
        return "Expected: " + actual + " " + operator + " " + expected;
    }
}
