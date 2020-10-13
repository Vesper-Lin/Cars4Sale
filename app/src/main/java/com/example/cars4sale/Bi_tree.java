package com.example.cars4sale;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Bi_tree extends BST{

    static List nodeList;
    static Map aa = new HashMap();

    public static BST node(NodeList list) {
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
        Map aa = new HashMap();
        aa = groupList(nodeList);
        BST tree = new BST();


        //System.out.println(aa.get(10).toString().substring(1).split(",")[0].trim());


        for(int i = 0;i<1000;i++){
            //key--price; value--id
            tree.insert(Integer.parseInt(aa.get(i).toString().split(",")[3].trim()),aa.get(i).toString().substring(1).split(",")[0].trim());
        }
        return tree;
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




    public static Map returnname(Map map, String s){
        Map new_map = new HashMap();
        for(int i =0;i<1000;i++){
            if (map.get(i).toString().split(",")[1].trim().equals(s)){
                //map.get(i).toString().split(",")[0].trim();
                new_map.put(i,map.get(i));
            }
        }

        return new_map;
    }

    public static Map returnlocation(Map map, String s){
        Map new_map = new HashMap();
        for(int i =0;i<1000;i++){
            if (map.get(i).toString().split(",")[2].trim().equals(s)){
                //map.get(i).toString().split(",")[0].trim();
                new_map.put(i,map.get(i));
            }
        }

        return new_map;
    }

    public static Map return_beforeyear(Map map, Integer year){
        Map new_map = new HashMap();
        for(int i =0;i<1000;i++){
            if (Integer.parseInt(map.get(i).toString().split(",")[4].trim().substring(0,4))<=year){
                //map.get(i).toString().split(",")[0].trim();
                new_map.put(i,map.get(i));
            }
        }
        return new_map;

    }

    public static Map return_afteryear(Map map, Integer year){
        Map new_map = new HashMap();
        for(int i =0;i<1000;i++){
            if (Integer.parseInt(map.get(i).toString().split(",")[4].trim().substring(0,4))>=year){
                //map.get(i).toString().split(",")[0].trim();
                new_map.put(i,map.get(i));
            }
        }
        return new_map;
    }





    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document d = builder.parse("app/src/main/assets/carData.xml");
            NodeList sList = d.getElementsByTagName("car");
            node(sList);
            aa=groupList(nodeList);




            //System.out.println(list_to_map(aa,list_to_list(returnoverprice(node(sList).root,988934))));
            //System.out.println(list_to_map(aa,list_to_list(returnsmallprice(node(sList).root,537))).size());
            //System.out.println(returnlocation(aa,"Toowoomba"));
            // System.out.println(returnname(aa,"SATURN Outlook"));
            // System.out.println(return_beforeyear(aa,2010));
            








        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}