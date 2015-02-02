package expectations.xml;

import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import java.io.IOException;
import java.io.InputStream;

public class XMLExpectation {
    private final SAXBuilder builder = new SAXBuilder();
    public XMLExpectation(InputStream xml) throws JDOMException, IOException {
        builder.build(xml);
    }
}