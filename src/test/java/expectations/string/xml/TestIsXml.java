package expectations.string.xml;

import expectations.exception.TestWithException;
import expectations.string.failures.MalformedXmlFailure;
import org.junit.Test;

import static expectations.ExpectationFactory.expect;

public class TestIsXml {

    @Test
    public void expectIsXmlToPassWhenValidXml() throws Exception {
        String xml = "<record type=\"person\"><field id=\"2345\">John Doe</field></record>";
        expect(xml).isXml();
    }
    
    @Test
    public void expectIsXmlToFailWhenMalformedXml() throws Exception {
        String xml = "<record type=\"person\"><field id=\"2345\">John Doe</field>";
        TestWithException test = () -> expect(xml).isXml();
        expect(test).toThrow(MalformedXmlFailure.class).withMessage("Supplied XML is invalid");
    }
    
    
    
    
    
}
