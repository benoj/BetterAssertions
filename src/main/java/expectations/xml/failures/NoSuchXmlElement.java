package expectations.xml.failures;

public class NoSuchXmlElement extends Exception{
    public NoSuchXmlElement(String field,String id, String value) {
        super("Expected XML element '"+ field + "' with attribute '"+ id +"="+ value+"'");
    }
}
