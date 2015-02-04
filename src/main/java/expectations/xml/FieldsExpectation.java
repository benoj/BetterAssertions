package expectations.xml;

import expectations.xml.failures.NoXmlFieldWithAttributeFailure;
import expectations.xml.failures.NoXmlFieldFailure;
import expectations.xml.failures.NoXmlFieldWithValueFailure;
import org.jdom.Attribute;
import org.jdom.Element;

import java.util.Iterator;

public class FieldsExpectation {
    private String fieldName;
    private Iterator elementIterator;

    public FieldsExpectation(String fieldName, Iterator elementIterator) {
        this.fieldName = fieldName;
        this.elementIterator = elementIterator;
    }

    public void andAttribute(String id, String value) throws NoXmlFieldWithAttributeFailure {
        boolean isPresent = false;
        while(elementIterator.hasNext()){
            Element element = (Element) elementIterator.next();
            Attribute attribute = element.getAttribute(id);
            if(attribute != null && value.equals(attribute.getValue())){
                isPresent = true;      
                break;
            }
        }
        if(!isPresent){
            throw new NoXmlFieldWithAttributeFailure(fieldName,id,value);
        }
    }

    public void andValue(String value) throws NoXmlFieldWithValueFailure {
        boolean isPresent = false;
        while(elementIterator.hasNext()){
            Element element = (Element) elementIterator.next();
            if(value.equals(element.getValue())){
                isPresent = true;
                break;
            }
        }
        if(!isPresent){
            throw new NoXmlFieldWithValueFailure(fieldName,value);
        }
    }
}
