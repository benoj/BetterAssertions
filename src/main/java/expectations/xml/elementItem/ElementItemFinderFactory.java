package expectations.xml.elementItem;

import java.util.Iterator;
import java.util.List;

public class ElementItemFinderFactory {
    private List elements;

    public ElementItemFinderFactory(List elements) {
        this.elements = elements;
    }

    public ElementItemFinder create(){
        Iterator elementIterator = elements.iterator();
        return new ElementItemFinder(elementIterator);
    }
}
