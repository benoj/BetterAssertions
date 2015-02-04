package expectations.xml.failures;

public class NoXmlFieldWithValueFailure extends Exception {
    public NoXmlFieldWithValueFailure(String field, String value) {
        super("Expected XML element '"+ field + "' with value '" + value +"'");
    }
}
