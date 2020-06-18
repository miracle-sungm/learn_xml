package parse.jdom;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.util.List;

/**
 * @author : sungm
 * @since : 2020-06-18 10:46
 */
public class Main {

    interface Constants {

        String EMPTY = "";

    }

    public static void main(String[] args) throws Exception{
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = saxBuilder.build("src/main/resources/student.xml");
        Element rootElement = document.getRootElement();
        System.out.println("根节点：" + rootElement.getName());
        parseElement(rootElement);
    }

    private static void parseElement(Element element) {
        //元素内容
        if (element.getText() != null && !Constants.EMPTY.equals(element.getTextTrim())) {
            System.out.println(element.getName() + ":" + element.getTextTrim());
        }
        //元素属性
        if (element.hasAttributes()) {
            element.getAttributes().forEach(Main::parseAttribute);
        }
        //解析子元素
        List<Element> childrenElement = element.getChildren();
        if (childrenElement != null && childrenElement.size() > 0) {
            childrenElement.forEach(Main::parseElement);
        }
    }

    private static void parseAttribute(Attribute attribute) {
        System.out.println(attribute.getName() + " : " + attribute.getValue());
    }

}
