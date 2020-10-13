package com.example.cars4sale;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Branchcomplete extends Bi_tree{
    static BST tree;

    public static HashMap<String,String> map = new HashMap<>();

    public static void main(String[] args) {
        map.put("Apple","美国");
    }



    public Branchcomplete() {

        this.tree = new BST();

        for(int i = 0;i<1001;i++){
            //key--price; value--id
           // tree.insert(Integer.parseInt(groupList(nodeList).get(i).toString().split(",")[3].trim()),groupList(nodeList).get(i).toString().charAt(1));
        }


    }

}
