package com.example.administrator.xmljasondemo.xmlparse;

import android.util.Log;

import com.example.administrator.xmljasondemo.URLbeen.Employs;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * Created by Administrator on 2016/8/27.
 */
public class XMLParse {
    public  String XMLString;

    public XMLParse(String XMLString) {
        this.XMLString = XMLString;
    }
    //将XML字符串解析成XML
    public List<Employs> toXML(){
        List<Employs> employs=new ArrayList<>();
        DocumentBuilderFactory  factory=DocumentBuilderFactory.newInstance();
        try {

            DocumentBuilder documentBuilder=factory.newDocumentBuilder();
            //将字符串转化为xml
            Document document = documentBuilder.parse(new InputSource(new StringReader(XMLString)));
            /* 获取字符串的第一个节点 （employees）*/

            NodeList nodelist=document.getDocumentElement().getChildNodes();

         //   Log.d("xxx",  "我是节点长度"+nodelist.getLength());
                for(int i=0;i<nodelist.getLength();i++){
                    Node node=nodelist.item(i);

                    if(node instanceof Element){
                       Employs e=new Employs();
                        e.setId(Integer.parseInt(node.getAttributes().getNamedItem("id").getNodeValue()));
                        NodeList nls=node.getChildNodes();
                        for(int j=0;j<nls.getLength();j++){
                           Node n=nls.item(j);
                            if(n instanceof  Element){
                                String content=n.getLastChild().getTextContent().trim();
                                switch (n.getNodeName()){
                                    case "firstName":
                                        e.setFirstname(content);break;
                                    case "lastName":
                                        e.setLastname(content);break;
                                    case "location":
                                        e.setLocation(content);break;
                                }
                            }
                        }
                        employs.add(e);
                    }
            }
            for (Employs e:employs
                    ) {
                Log.d("xxx",e.getFirstname());
            }
           return  employs;
        } catch (Exception e) {

            e.printStackTrace();
        }

        return  null;
    }

//将list集合转化为xml字符串
    private String XMLto(List<Employs> employees) {


        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = factory.newDocumentBuilder();

            /* 创建空白的xml文件 */
            Document doc = docBuilder.newDocument();
            /*
            * 大节点 --》 Employees
            * */
            Element rootElement = doc.createElement("employees");
            doc.appendChild(rootElement);


            for (Employs e: employees
                    ) {

                Element elm = doc.createElement("employee");

                /*创建id参数*/
                Attr attr = doc.createAttribute("id");
                attr.setValue(""+e.getId());

                elm.setAttributeNode(attr); /* 把参数添加到employee标签上去 */

                Element firstName = doc.createElement("firstName");
                firstName.setTextContent(e.getFirstname());
                elm.appendChild(firstName);


                Element lastName = doc.createElement("lastName");
                lastName.setTextContent(e.getLastname());
                elm.appendChild(lastName);

                Element location = doc.createElement("location");
                location.setTextContent(e.getLocation());
                elm.appendChild(location);

                rootElement.appendChild(elm);
            }

            /* 把xml对象转成字符串 */
            TransformerFactory transformFactory = TransformerFactory.newInstance();
            Transformer transformer = transformFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            StringWriter sw = new StringWriter();
            StringBuffer sbuffer = new StringBuffer();

            StreamResult result = new StreamResult(sw);

            transformer.transform(source, result);
            sbuffer.append(sw.getBuffer());

            return sbuffer.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

}
