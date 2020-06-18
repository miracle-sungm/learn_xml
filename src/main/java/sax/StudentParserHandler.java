package sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author : sungm
 * @since : 2020-06-17 17:42
 */
public class StudentParserHandler extends DefaultHandler {

    interface Constants {

        String ROOT_ELEMENT = "class";

        String EMPTY = "";

    }

    //方法执行顺序：startDocument -> startElement -> characters -> endElement -> characters -> endDocument
    //执行次数        只执行一次      元素循环执行    元素循环执行   元素循环执行   元素循环执行    只执行一次

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("开始解析XML文档");
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("解析XML文档结束");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        System.out.println(Constants.ROOT_ELEMENT.equals(qName) ? "开始解析根节点" : "节点名称 ： " + qName);
        //获取元素的属性
        for (int index = 0, size = attributes.getLength(); index < size; index++) {
            String attrName = attributes.getLocalName(index);
            String attrValue = attributes.getValue(index);
            System.out.println("attrName = " + attrName + ", attrValue = " + attrValue);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if (Constants.ROOT_ELEMENT.equals(qName)) {
            System.out.println("解析根节点结束");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        String value = new String(ch, start, length).trim();
        if (!Constants.EMPTY.equals(value)) {
            System.out.println("节点值：" + value);
        }
    }
}