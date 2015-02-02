package expectations.string.failures;

public class MalformedXmlFailure extends Exception {
    public MalformedXmlFailure() {
        super("Supplied XML is invalid");
    }
}
