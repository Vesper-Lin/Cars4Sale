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

public class BSTSearch extends BST {

    static List nodeList;
    static Map map = new HashMap();
    public static NodeList sList;


    public static BST node(NodeList list) {
        nodeList = new ArrayList<>();
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            NodeList childText = node.getChildNodes();
            for (int j = 0; j < childText.getLength(); j++) {
                if (childText.item(j).getNodeType() == Node.ELEMENT_NODE) {
                    nodeList.add(childText.item(j).getFirstChild().getNodeValue());
                }
            }
        }
        map = groupList(nodeList);

        BST tree = new BST();
        for (int i = 0; i < 1000; i++) {
            //key--price; value--id
            tree.insert(
                    Integer.parseInt(map.get(i).toString().split(",")[3].trim()),
                    map.get(i).toString().substring(1).split(",")[0].trim()
            );
        }
        return tree;
    }

    public static Map groupList(List list) {
        int listSize = list.size();
        int toIndex = 5;
        Map map = new HashMap();
        int keyNum = 0;
        for (int i = 0; i < list.size(); i += 5) {
            if (i + 4 > listSize) {
                toIndex = listSize - i;
            }
            List newList = list.subList(i, i + toIndex);
            map.put(keyNum, newList);
            keyNum++;
        }
        return map;
    }

    public static Map getName(Map map, String s) {
        Map new_map = new HashMap();
        for (int i = 0; i < 1000; i++) {
            if (map.get(i).toString().split(",")[1].trim().toLowerCase().contains(s.toLowerCase())) {
                new_map.put(i, map.get(i));
            }
        }
        return new_map;
    }

    public static Map getLocation(Map map, String s) {
        Map new_map = new HashMap();
        for (int i = 0; i < 1000; i++) {
            if (map.get(i).toString().split(",")[2].trim().equals(s)) {
                new_map.put(i, map.get(i));
            }
        }
        return new_map;
    }

    public static Map getYear(Map map, Integer year) {
        Map new_map = new HashMap();
        for (int i = 0; i < 1000; i++) {
            if (Integer.parseInt(map.get(i).toString().split(",")[4].trim().substring(0, 4)) == year) {
                new_map.put(i, map.get(i));
            }
        }
        return new_map;
    }

    public static Map getYearBefore(Map map, Integer year) {
        Map new_map = new HashMap();
        for (int i = 0; i < 1000; i++) {
            if (Integer.parseInt(map.get(i).toString().split(",")[4].trim().substring(0, 4)) <= year) {
                new_map.put(i, map.get(i));
            }
        }
        return new_map;
    }

    public static Map getYearAfter(Map map, Integer year) {
        Map new_map = new HashMap();
        for (int i = 0; i < 1000; i++) {
            if (Integer.parseInt(map.get(i).toString().split(",")[4].trim().substring(0, 4)) >= year) {
                new_map.put(i, map.get(i));
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
            System.out.println(sList.getClass());
            map = groupList(nodeList);

            //System.out.println(map.get(695));
            //System.out.println(getHigherPrice(node(sList).root,537072));
            //System.out.println(list_to_map(map, list_to_list(getHigherPrice(node(sList).root, 988934))));
            //System.out.println(list_to_map(map,list_to_list(getLowerPrice(node(sList).root,537))).size());
            //System.out.println(getLocation(map,"Toowoomba"));
            // System.out.println(getName(map,"SATURN Outlook"));
            // System.out.println(getYearBefore(map,2010));
            // System.out.println(getName(map, "SaTuRn"));
            //System.out.println(BSTSearch.map);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}