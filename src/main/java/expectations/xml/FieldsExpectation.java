package expectations.xml;

import expectations.xml.elementItem.AttributeStrategy;
import expectations.xml.elementItem.ElementItemFinder;
import expectations.xml.elementItem.ElementItemFinderFactory;
import expectations.xml.elementItem.ValueStrategy;
import expectations.xml.failures.NoXmlFieldFailure;
import expectations.xml.failures.NoXmlFieldWithAttributeFailure;
import expectations.xml.failures.NoXmlFieldWithValueFailure;
import org.jdom.Element;

import java.util.List;

public class FieldsExpectation {
    final private String fieldName;
    final private XMLExpectation xmlRoot;
    final private ElementItemFinderFactory elementItemFinderFactory;

    public FieldsExpectation(String fieldName, List elements, XMLExpectation xmlRoot) {
        this.fieldName = fieldName;
        this.xmlRoot = xmlRoot;
        this.elementItemFinderFactory = new ElementItemFinderFactory(elements);
    }
    
    public FieldsExpectation andAttribute(String id, String value) throws NoXmlFieldWithAttributeFailure {
        final AttributeStrategy strategy = new AttributeStrategy(id);
        final ElementItemFinder elementItemFinder = elementItemFinderFactory.create();
        Element element = elementItemFinder.getElement(value, strategy);
        if(element == null){
            throw new NoXmlFieldWithAttributeFailure(fieldName,id,value);
        }
        return this;
    }
    
    public FieldsExpectation withField(String fieldName) throws NoXmlFieldFailure {
        return xmlRoot.withField(fieldName);
    }

    public XMLExpectation andValue(String value) throws NoXmlFieldWithValueFailure {
        final ValueStrategy strategy = new ValueStrategy();
        final ElementItemFinder elementItemFinder = elementItemFinderFactory.create();
        Element actualElement = elementItemFinder.getElement(value, strategy);
        if(actualElement == null){
            throw new NoXmlFieldWithValueFailure(fieldName,value);
        }
        return xmlRoot;
    }
}


