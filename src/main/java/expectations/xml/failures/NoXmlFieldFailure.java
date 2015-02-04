package expectations.xml.failures;

public class NoXmlFieldFailure extends Exception {
    public NoXmlFieldFailure(String fieldName) {
        super("Expected element '" + fieldName + "' to exist but it did not");
    }
}
