package expectations.xml.elementItem;

import org.jdom.Element;

import java.util.Iterator;

public class ElementItemFinder {
    final private Iterator elementIterator;

    public ElementItemFinder(Iterator elementIterator) {
        this.elementIterator = elementIterator;
    }

    public Element getElement(String value, ElementItemStrategy strategy){
        while(elementIterator.hasNext()){
            Element element = (Element) elementIterator.next();
            String expectedValue = strategy.Find(element);
            if(value.equals(expectedValue)){
                return element;
            }
        }
        return null;
    }
}
