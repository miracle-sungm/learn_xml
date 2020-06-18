package parse.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * @author : sungm
 * @since : 2020-06-17 17:33
 */
public class Main {

    public static void main(String[] args) throws Exception {
        //获取一个Sax解析工厂实例
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        //获取一个Sax解析器实例
        SAXParser saxParser = saxParserFactory.newSAXParser();
        //创建一个Handel实例
        StudentParserHandler handler = new StudentParserHandler();
        //解析文件
        saxParser.parse("src/main/resources/student.xml", handler);
    }
}
