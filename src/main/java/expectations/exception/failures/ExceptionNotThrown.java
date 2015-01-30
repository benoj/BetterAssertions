package expectations.exception.failures;

public class ExceptionNotThrown extends Exception {
    public ExceptionNotThrown() {
        super("No Exception Thrown");
    }
}
