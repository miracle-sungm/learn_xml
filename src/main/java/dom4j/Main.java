package dom4j;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.Iterator;

/**
 * @author : sungm
 * @since : 2020-06-18 11:27
 */
public class Main {

    public static void main(String[] args) throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read("src/main/resources/student.xml");
        Element element = document.getRootElement();
        System.out.println("根节点：名称 = " + element.getName());
        //递归解析
        parseElement(element);
    }

    @SuppressWarnings("unchecked")
    private static void parseElement(Element element) {
        System.out.println("节点：名称 = " + element.getName() + ", value = " + element.getTextTrim());
        Iterator iterator = element.elementIterator();
        while (iterator.hasNext()) {
            Element childElement = (Element) iterator.next();
            //解析属性
            if (childElement.attributeCount() > 0) {
                childElement.attributes().forEach(Main::parseAttribute);
            }
            //解析元素
            parseElement(childElement);
        }
    }

    private static void parseAttribute(Object attribute) {
        System.out.println("属性：" + ((Attribute) attribute).getName() + " : " + ((Attribute) attribute).getValue());
    }

}
