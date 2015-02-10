package expectations.string.xml;

import expectations.exception.TestWithException;
import expectations.xml.failures.NoChildElementException;
import org.junit.Test;

import static expectations.ExpectationFactory.expect;

public class TestWithField {
    
    @Test
    public void expectWithNodePassesWhenSubNodeIsPresent() throws Exception {
        String xml =
                "<record type=\"person\">" +
                    "<address type=\"home\">" +
                        "<street>Some Street</street>" +
                        "<postCode>WE1 NER</postCode>" +
                    "</address>"+ 
                "</record>";
        expect(xml).isXml()
                   .withField("address")
                        .withField("street");
    }

    @Test
    public void expectWithNodeFailsWhenNodeIsNotDirectChild() throws Exception {
        String xml =
                "<record type=\"person\">" +
                "<contactDetails>" +
                        "<address type=\"home\">" +
                        "<street>Some Street</street>" +
                        "<postCode>WE1 NER</postCode>" +
                        "</address>"+
                "</contactDetails>" +
                "<birthDate>02/04/1980</birthDate>" +
                "</record>";
        TestWithException test = () -> expect(xml).isXml().withField("contactDetails").withField("birthDate");
        expect(test).toThrow(NoChildElementException.class).withMessage("Expected node 'contactDetails' to have element 'birthDate'");
    }
}
