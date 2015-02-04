package expectations.string.xml;

import expectations.exception.TestWithException;
import expectations.xml.failures.NoXmlFieldWithAttributeFailure;
import org.junit.Test;

import static expectations.ExpectationFactory.expect;

public class TestAndAttribute {
    
    @Test
    public void expectAndAttributeToPassWhenXMLHasSingleElementWithAttribute() throws Exception {
        String xml = "<record type=\"person\"><field id=\"2345\">John Doe</field></record>";
        expect(xml).isXml().withField("field").andAttribute("id", "2345");
    }

    @Test
    public void expectAndAttributeToFailWhenXMLHasSingleElementWithoutCorrectAttribute() throws Exception {
        String xml = "<record type=\"person\"><field id=\"2345\">John Doe</field></record>";
        TestWithException test = () -> expect(xml).isXml().withField("field").andAttribute("id","123");
        expect(test).toThrow(NoXmlFieldWithAttributeFailure.class).withMessage("Expected XML element 'field' with attribute 'id=123'");
    }
    
    @Test
    public void expectAndAttributeToFailWhenXMLHasSingleElementWithoutAnyAttributes() throws Exception {
        String xml = "<record type=\"person\"><field>John Doe</field></record>";
        TestWithException test = () -> expect(xml).isXml().withField("field").andAttribute("id","123");
        expect(test).toThrow(NoXmlFieldWithAttributeFailure.class).withMessage("Expected XML element 'field' with attribute 'id=123'");
    }
}