package expectations.xml;

import expectations.xml.failures.NoSuchXmlElement;
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

    public void andAttribute(String id, String value) throws NoSuchXmlElement {
        boolean isPresent = false;
        while(elementIterator.hasNext()){
            Element element = (Element) elementIterator.next();
            Attribute attribute = element.getAttribute(id);
            if(value.equals(attribute.getValue())){
                isPresent = true;      
                break;
            }
        }
        if(!isPresent){
            throw new NoSuchXmlElement(fieldName,id,value);
        }
    }
}
