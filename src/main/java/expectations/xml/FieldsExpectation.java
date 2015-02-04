package expectations.xml;

import expectations.xml.elementItem.AttributeStrategy;
import expectations.xml.elementItem.ElementItemFinder;
import expectations.xml.elementItem.ValueStrategy;
import expectations.xml.failures.NoXmlFieldWithAttributeFailure;
import expectations.xml.failures.NoXmlFieldWithValueFailure;
import org.jdom.Element;

import java.util.Iterator;

public class FieldsExpectation {
    final private String fieldName;
    final private Iterator elementIterator;
    final private ElementItemFinder elementItemFinder;

    public FieldsExpectation(String fieldName, Iterator elementIterator) {
        this.fieldName = fieldName;
        this.elementIterator = elementIterator;
        this.elementItemFinder = new ElementItemFinder(elementIterator);
    }
    
    public void andAttribute(String id, String value) throws NoXmlFieldWithAttributeFailure {
        final AttributeStrategy strategy = new AttributeStrategy(id);
        Element element = new ElementItemFinder(elementIterator).getElement(value, strategy);
        if(element == null){
            throw new NoXmlFieldWithAttributeFailure(fieldName,id,value);
        }
    }

    public void andValue(String value) throws NoXmlFieldWithValueFailure {
        final ValueStrategy strategy = new ValueStrategy();
        Element actualElement = elementItemFinder.getElement(value, strategy);
        if(actualElement == null){
            throw new NoXmlFieldWithValueFailure(fieldName,value);
        }
    }
}


