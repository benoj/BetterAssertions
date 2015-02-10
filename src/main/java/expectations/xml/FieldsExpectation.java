package expectations.xml;

import expectations.xml.elementItem.AttributeStrategy;
import expectations.xml.elementItem.ElementItemFinder;
import expectations.xml.elementItem.ElementItemFinderFactory;
import expectations.xml.elementItem.ValueStrategy;
import expectations.xml.failures.NoChildElementException;
import expectations.xml.failures.NoXmlFieldFailure;
import expectations.xml.failures.NoXmlFieldWithAttributeFailure;
import expectations.xml.failures.NoXmlFieldWithValueFailure;
import org.jdom.Element;

import java.util.ArrayList;
import java.util.List;

public class FieldsExpectation {
    final private String fieldName;
    private List elements;
    final private XMLExpectation currentXmlElement;
    final private ElementItemFinderFactory elementItemFinderFactory;

    public FieldsExpectation(String fieldName, List elements, XMLExpectation xmlElement) {
        this.fieldName = fieldName;
        this.elements = elements;
        this.currentXmlElement = xmlElement;
        this.elementItemFinderFactory = new ElementItemFinderFactory(elements);
    }

    public FieldsExpectation andAttribute(String id, String value) throws NoXmlFieldWithAttributeFailure {
        final AttributeStrategy strategy = new AttributeStrategy(id);
        final ElementItemFinder elementItemFinder = elementItemFinderFactory.create();
        Element element = elementItemFinder.getElement(value, strategy);
        if (element == null) {
            throw new NoXmlFieldWithAttributeFailure(fieldName, id, value);
        }
        return this;
    }

    public XMLExpectation andValue(String value) throws NoXmlFieldWithValueFailure {
        final ValueStrategy strategy = new ValueStrategy();
        final ElementItemFinder elementItemFinder = elementItemFinderFactory.create();
        Element actualElement = elementItemFinder.getElement(value, strategy);
        if (actualElement == null) {
            throw new NoXmlFieldWithValueFailure(fieldName, value);
        }
        return currentXmlElement;
    }


    public FieldsExpectation andWithField(String name) throws NoXmlFieldFailure {
        return currentXmlElement.withField(name);
    }

    public FieldsExpectation withField(String fieldName) throws NoChildElementException {
        List<Element> matchingElements = new ArrayList<>();
        for (Object element1 : elements) {
            Element element = (Element) element1;
            for(Object e : element.getChildren(fieldName)){
                matchingElements.add((Element) e);
            }
        }
        if (matchingElements.isEmpty()) {
            throw new NoChildElementException(this.fieldName,fieldName);
        }
        
        return new FieldsExpectation(fieldName,matchingElements,null);
    }
}



