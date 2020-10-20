package com.example.cars4sale;



import com.example.cars4sale.DataStructure.Node;

import static com.example.cars4sale.DataStructure.BST.getHigherPrice;
import static com.example.cars4sale.DataStructure.BST.getLowerPrice;
import static com.example.cars4sale.DataStructure.BST.getPrice;
import static com.example.cars4sale.DataStructure.BST.list_to_list;
import static com.example.cars4sale.DataStructure.BST.list_to_map;
import static com.example.cars4sale.DataStructure.BSTSearch.getLocation;
import static com.example.cars4sale.DataStructure.BSTSearch.groupList;
import static com.example.cars4sale.DataStructure.BSTSearch.return_list;
import static com.example.cars4sale.DataStructure.BSTSearch.getName;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.*;
import java.io.IOException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;



import static com.example.cars4sale.DataStructure.BSTSearch.node;
import static org.junit.Assert.assertEquals;

public class BSTTest {

    static Map map = new HashMap();

    public static NodeList sList;
    public static Map readData(){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document d = builder.parse("/Users/lixinxin/Desktop/comp2100_6442_s2_2020_group_project/app/src/main/assets/carData.xml");
            NodeList sList = d.getElementsByTagName("car");
            node(sList);
            System.out.println(sList.getClass());
            map = groupList(return_list(sList));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }



}