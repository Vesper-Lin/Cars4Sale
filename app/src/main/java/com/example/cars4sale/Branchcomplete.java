package com.example.cars4sale;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Branchcomplete extends Bi_tree{
    BST tree;

    public static HashMap<String,String> map = new HashMap<>();

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
    }

    public Branchcomplete() {
        this.tree = new BST();
        for(int i = 0;i<1001;i++){
            tree.insert(Integer.parseInt(groupList(nodeList).get(i).toString().split(",")[3].trim()),groupList(nodeList).get(i).toString().charAt(1));
        }
    }
}
