package com.hmtmcse.advanced.parser.tomcatxml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;

/**
 * Created by touhid on 7/03/2016.
 */
public class ServerXMLParser {

    public static void main(String[] args) {
        ServerXMLParser serverXMLParser = new ServerXMLParser();
        try {
            serverXMLParser.parseFromFile("D:\\touhid\\java\\hmtmcse\\ServerApp-server.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public ServerData parseFromFile(String fileLocation) throws Exception {
        File file = new File(fileLocation);

        ServerData serverData = new ServerData();
        ConnectorData connectorData;

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(file);
        document.getDocumentElement().normalize();


        NodeList serverList = document.getElementsByTagName("Server");
        Element element;
        if (serverList.getLength() != 0){
            element = (Element) serverList.item(0);
            serverData.setShutdown(element.getAttribute("port"));
        }

        NodeList connectorList = document.getElementsByTagName("Connector");
        for (int temp = 0; temp < connectorList.getLength(); temp++) {
            Node node = connectorList.item(temp);
            connectorData = new ConnectorData();
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                element = (Element) node;
                connectorData.setPort(element.getAttribute("port"));
                connectorData.setProxyPort(element.getAttribute("proxyPort"));
                connectorData.setScheme(element.getAttribute("scheme"));
                connectorData.setConnectionTimeout(element.getAttribute("connectionTimeout"));
                connectorData.setRedirectPort(element.getAttribute("redirectPort"));
                connectorData.setMaxHttpHeaderSize(element.getAttribute("maxHttpHeaderSize"));
            }
        }









        NodeList hostList = document.getElementsByTagName("Host");
        for (int temp = 0; temp < hostList.getLength(); temp++) {
            Node node = hostList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                element = (Element) node;
                System.out.println("name : " + element.getAttribute("name"));
                System.out.println("appBase : " + element.getAttribute("appBase"));
                System.out.println("unpackWARs : " + element.getAttribute("unpackWARs"));
                System.out.println("autoDeploy : " + element.getAttribute("autoDeploy"));

                NodeList aliasList = element.getElementsByTagName("Alias");

                System.out.println("size : " + aliasList.getLength());
                for (int i = 0; i < aliasList.getLength(); i++){
                    System.out.println("Alias : " + aliasList.item(i).getTextContent());
                }



            }


        }

return null;



//        for (int temp = 0; temp < nodeList.getLength(); temp++) {
//            Node node = nodeList.item(temp);
//
//            System.out.println("Current Element :" + node.getNodeName());
//            if (node.getNodeType() == Node.ELEMENT_NODE) {
//                Element element = (Element) node;
//                System.out.println("name : " + element.getAttribute("name"));
//                System.out.println("Connector : " + element.getElementsByTagName("Connector").getLength());
//                System.out.println("Host : " + element.getElementsByTagName("Host").getLength());
//                System.out.println("Alias : " + element.getElementsByTagName("Alias").getLength());
//            }
//        }


    }

}
