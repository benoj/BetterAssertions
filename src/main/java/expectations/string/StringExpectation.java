package expectations.string;

import expectations.string.failures.BeginsWithFailure;
import expectations.string.failures.ContainsFailure;
import expectations.string.failures.EndsWithFailure;
import expectations.string.failures.MalformedXmlFailure;
import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.DOMBuilder;
import org.jdom.input.SAXBuilder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StringExpectation {
    private String actual;

    public StringExpectation(String actual) {
        this.actual = actual;
    }

    public void beginsWith(String expected) throws BeginsWithFailure {
        if(!actual.startsWith(expected)){
            throw new BeginsWithFailure(actual, expected);
        }
    }

    public void endsWith(String expected) throws EndsWithFailure {
        if(!actual.endsWith(expected)){
            throw new EndsWithFailure(actual,expected);
        }
    }

    public void contains(String expected) throws ContainsFailure {
        if(!actual.contains(expected)){
            throw new ContainsFailure(actual,expected);
        }
    }

    public void isXml() throws MalformedXmlFailure {
        SAXBuilder builder = new SAXBuilder();
        InputStream stream = new ByteArrayInputStream(actual.getBytes());
        try {
            Document document = (Document) builder.build(stream);
        } catch (JDOMException e) {
           throw new MalformedXmlFailure();
        } catch (IOException ignored) {
        }
    }
}
