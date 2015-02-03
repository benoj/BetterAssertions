package expectations.xml.failures;

public class NoXmlElementFailure extends Exception {
    public NoXmlElementFailure(String fieldName) {
        super("Expected element '" + fieldName + "' to exist but it did not");
    }
}
