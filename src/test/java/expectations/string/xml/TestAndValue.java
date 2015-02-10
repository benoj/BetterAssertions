package expectations.string.xml;

import expectations.exception.TestWithException;
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
    public void expectWithValueFailsWhenValueDoesNotMatch() throws Exception {
        String xml = "<record type=\"person\"><field id=\"2345\">Jane Doe</field></record>";
        TestWithException test = () -> expect(xml).isXml().withField("field").andValue("John Doe");
        expect(test).toThrow(NoXmlFieldWithValueFailure.class).withMessage("Expected XML element 'field' with value 'John Doe'");
    }

    @Test
    public void expectWithValueIsChainableBackToTheDocumentRoot() throws Exception {
        String xml = "<record type=\"person\"><home id=\"2345\">Jonnie Doe</home><work>John Doe</work></record>";
        expect(xml)
                .isXml()
                    .withField("work").andValue("John Doe")
                    .withField("home").andValue("Jonnie Doe");
    }
    
    
    
}
