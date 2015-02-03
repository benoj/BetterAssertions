package expectations.string.failures.messageBuilders;

public class StringFailureMessageBuilder {
    public static String build(String actual, String expected, String condition){
        return "Expected: '" + actual + "' to " + condition + " '" + expected + "'";
    }
}
