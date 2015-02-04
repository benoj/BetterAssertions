package expectations.xml.failures;

public class NoXmlFieldWithAttributeFailure extends Exception{
    public NoXmlFieldWithAttributeFailure(String field, String id, String value) {
        super("Expected XML element '"+ field + "' with attribute '"+ id +"="+ value+"'");
    }
}
