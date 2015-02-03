package expectations.string.xml;

import expectations.exception.TestWithException;
import expectations.xml.failures.NoXmlElementFailure;
import org.junit.Test;

import static expectations.ExpectationFactory.expect;

public class TestHasElement {
    
    @Test
    public void expectHasElementToPassWhenXMLHasSingleElement() throws Exception {
        String xml = "<record type=\"person\"><field id=\"2345\">John Doe</field></record>";
        expect(xml).isXml().withField("field");
    }

    @Test
    public void expectHasElementToPassWhenXMLDoesNotHaveElement() throws Exception {
        String xml = "<record type=\"person\"><bob id=\"2345\">John Doe</bob></record>";
        TestWithException test = () -> expect(xml).isXml().withField("field");
        expect(test).toThrow(NoXmlElementFailure.class).withMessage("Expected element 'field' to exist but it did not");
    }
}