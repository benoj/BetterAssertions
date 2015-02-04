package expectations.string.xml;

import expectations.exception.TestWithException;
import expectations.xml.failures.NoXmlFieldFailure;
import expectations.xml.failures.NoXmlFieldWithValueFailure;
import org.junit.Test;

import static expectations.ExpectationFactory.expect;

public class TestAndValue {
    @Test
    public void expectWithValuePassesWhenValueMatches() throws Exception {
        String xml = "<record type=\"person\"><field id=\"2345\">John Doe</field></record>";
        expect(xml).isXml().withField("field").andValue("John Doe");
    }
    
    @Test
    public void expectWithValueFailsWhenValueDoesNotMatc() throws Exception {
        String xml = "<record type=\"person\"><field id=\"2345\">Jane Doe</field></record>";
        TestWithException test = () -> expect(xml).isXml().withField("field").andValue("John Doe");
        expect(test).toThrow(NoXmlFieldWithValueFailure.class).withMessage("Expected XML element 'field' with value 'John Doe'");
        
    }
}
