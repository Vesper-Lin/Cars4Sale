package com.example.cars4sale;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Bi_tree{

    static List nodeList;
    public static BST tree;

    public static void node(NodeList list) {
        nodeList = new ArrayList<>();
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            NodeList childtext = node.getChildNodes();
            for (int j = 0; j < childtext.getLength(); j++) {
                if (childtext.item(j).getNodeType() == Node.ELEMENT_NODE) {
                    nodeList.add(childtext.item(j).getFirstChild().getNodeValue());
                }
            }
        }
        Map aa = groupList(nodeList);
        //for(int i = 0;i<1001;i++){
          //  tree.insert(Integer.parseInt(aa.get(i).toString().split(",")[3].trim()),aa.get(i).toString().charAt(1));
        //}



       // String a = aa.get(0).toString().split(",")[3];


       //System.out.println(aa);
    }

    public static Map groupList(List list) {
        int listSize = list.size();
        int toIndex = 5;
        Map map = new HashMap();
        int keynub = 0;
        for (int i = 0; i < list.size(); i += 5) {
            if (i + 4 > listSize) {
                toIndex = listSize - i;
            }
            List newList = list.subList(i, i + toIndex);
            map.put(keynub, newList);
            keynub++;
        }
        return map;
    }


    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document d = builder.parse("app/src/main/assets/carData.xml");
            NodeList sList = d.getElementsByTagName("car");
            node(sList);


        } catch (Exception e) {
            e.printStackTrace();
        }

        //for(int i = 0;i<1001;i++){
        //    tree.insert(Integer.parseInt(groupList(nodeList).get(i).toString().split(",")[3].trim()),groupList(nodeList).get(i).toString().charAt(1));
        //}




    }

}
