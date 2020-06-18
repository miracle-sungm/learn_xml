package parse.dom;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * @author : sungm
 * @since : 2020-06-16 16:59
 */
public class Main {

    public static void main(String[] args) throws Exception {
        //获取一个xml解析器的文档构建者工厂实例（设计模式：工厂模式）
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //获取一个xml解析器的文档构建者实例（设计模式：Builder模式）
        DocumentBuilder builder = factory.newDocumentBuilder();
        //使用xml解析器builder解析文档，获取解析后的Document对象
        Document document = builder.parse("src/main/resources/student.xml");
        //获取根元素
        Element rootElement = document.getDocumentElement();
        //获取文档中student元素列表（也可以直接通过document.getElementsByTagName("student")获取所有的student元素）
        NodeList studentNodes = rootElement.getElementsByTagName("student");
        for (int index = 0, size = studentNodes.getLength(); index < size; index++) {
            Element element = (Element) studentNodes.item(index);
            //元素（备注：通过getElementsByTagName()方法获取指定的元素）
            Element nameElement = (Element) element.getElementsByTagName("name").item(0);
            Element ageElement = (Element) element.getElementsByTagName("age").item(0);
            Element sexElement = (Element) element.getElementsByTagName("sex").item(0);
            Element classElement = (Element) element.getElementsByTagName("className").item(0);

            //文本（备注：通过getNodeName()方法获取元素名称，通过getTextContent()方法获取文本内容）
            System.out.println(nameElement.getNodeName()  + " : " + nameElement.getTextContent());
            System.out.println(ageElement.getNodeName()   + " : " + ageElement.getTextContent());
            System.out.println(sexElement.getNodeName()   + " : " + sexElement.getTextContent());
            System.out.println(classElement.getNodeName() + " : " + classElement.getTextContent());

            //属性（备注：通过getAttributeNode(name)方法属性节点，通过getAttribute(name)方法获取属性内容）
            Attr nameAttr = nameElement.getAttributeNode("nameAttr");
            Attr ageAttr = ageElement.getAttributeNode("ageAttr");
            Attr sexAttr = sexElement.getAttributeNode("sexAttr");
            Attr classAttr = classElement.getAttributeNode("classAttr");
            System.out.println(nameAttr.getName()  + " : " + nameAttr.getValue());
            System.out.println(ageAttr.getName()   + " : " + ageAttr.getValue());
            System.out.println(sexAttr.getName()   + " : " + sexAttr.getValue());
            System.out.println(classAttr.getName()   + " : " + classAttr.getValue());
            System.out.println();
        }
    }
}
