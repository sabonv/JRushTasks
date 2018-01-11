package com.javarush.task.task33.task3309;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.StringWriter;

/*
Комментарий внутри xml
*/
public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws IOException, JAXBException {
        StringWriter writer = new StringWriter();
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            //marshaller.marshal(obj, writer);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            document.setXmlStandalone(false);

            marshaller.marshal(obj, document);

            changeTextToCDATA(document, document);

            NodeList nodeList = document.getElementsByTagName(tagName);
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node element = nodeList.item(i);
                //System.out.println(element.getTextContent());
                //if(!element.getTextContent().contains("CDATA"))
                element.getParentNode().insertBefore(document.createComment(comment), element);
            }

            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(writer);

            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);


        } catch (ParserConfigurationException | TransformerException e) {
            System.out.println(e.getMessage());
        }     finally {
            writer.close();
        }

        return writer.toString();
    }

    private static void changeTextToCDATA(Node mainNode, Document document){

        if (mainNode.hasChildNodes()){
            NodeList children = mainNode.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                Node node = children.item(i);
                if (node.getNodeType() == Node.TEXT_NODE){
                    if (node.getTextContent().matches(".*[<>&'\\\"].*")) {
                        Node newNode = document.createCDATASection(node.getTextContent());
                        node.getParentNode().replaceChild(newNode, node);
                    }
                }
                else
                    changeTextToCDATA(node, document);
            }
        }

    }

    public static void main(String[] args) throws IOException, JAXBException{

        First firstSecondObject = new First();

        System.out.println(toXmlWithComment(firstSecondObject, "second", "it's a comment"));
    }
    @XmlRootElement(name = "first")
    public static class First {
        @XmlElement(name = "second")
        public String item1 = " item1 some string";
        @XmlElement(name = "second")
        public String item11 = "item11 some string";
        @XmlElement(name = "second")
        public String item2 = "item2 need CDATA because of <second>";
        //
        @XmlElement(name = "second")
        public String item3 = "";
        //
        @XmlElement(name = "third")
        public String item4;
        @XmlElement(name = "forth")
        public Second[] third = new Second[]{new Second()};

        @XmlElement(name = "fifth")
        public String item5 = "item5 need CDATA because of <";
    }

    public static class Second {
        @XmlElement(name = "second")
        public String item1 = "item4 item1 some string";
        @XmlElement(name = "second")
        public String item2 = "item4 item2 need CDATA because of <second>";
    }
}
