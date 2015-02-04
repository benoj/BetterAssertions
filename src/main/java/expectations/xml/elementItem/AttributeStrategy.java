package expectations.xml.elementItem;

import org.jdom.Attribute;
import org.jdom.Element;

public class AttributeStrategy implements ElementItemStrategy {
    final private String id;

    public AttributeStrategy(String id) {
        this.id = id;
    }

    public String Find(Element element){
        Attribute attribute = element.getAttribute(id);
        String expectedValue = null;
        if (attribute != null) {
            expectedValue = attribute.getValue();
        }
        return expectedValue;
    }
}
