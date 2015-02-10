package expectations.xml.failures;

public class NoChildElementException extends Exception {
    public NoChildElementException(String parent, String childElement) {
        super("Expected node '"+parent + "' to have element '" + childElement +"'");
    }
}
