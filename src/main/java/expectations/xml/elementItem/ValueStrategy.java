package expectations.xml.elementItem;

import org.jdom.Element;

public class ValueStrategy implements ElementItemStrategy {
    public String Find(Element element){
        return element.getValue();
    }
}
