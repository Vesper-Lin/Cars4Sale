package com.example.cars4sale;

import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Bi_tree {

    public static void node(NodeList list){
        List nodeList = new ArrayList<>();
        for (int i = 0; i <list.getLength() ; i++) {
            Node node = list.item(i);
            NodeList childtext = node.getChildNodes();
            for (int j = 0; j <childtext.getLength() ; j++) {
                if (childtext.item(j).getNodeType()==Node.ELEMENT_NODE) {
                    nodeList.add(childtext.item(j).getFirstChild().getNodeValue());
                }
            }
        }
        groupList(nodeList);
        Map aa = groupList(nodeList);
        System.out.println(aa.get(0));
    }
    public static Map groupList(List list){
        int listSize=list.size();
        int toIndex=5;
        Map map = new HashMap();
        int keynub = 0;
        for(int i = 0;i<list.size();i+=5){
            if(i+4>listSize){
                toIndex=listSize-i;
            }
            List newList = list.subList(i,i+toIndex);
            map.put(keynub, newList);
            keynub++;
        }
        return map;
    }


    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document d = builder.parse(".idea/cardata.xml");
            NodeList sList = d.getElementsByTagName("car");
            node(sList);

        } catch (Exception e) {
            e.printStackTrace();
        }
        String string1="";
        String string2="";
        String string3="";
        String string4="";


        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] as = input.split(";");
        for (int i = 0; i < as.length; i++) {
            System.out.println(as[i]);
            if(i==0){
                string1 = as[i];
            }else if(i==1){
                string2 = as[i];
            }else if(i==2){
                string3 = as[i];
            }else {
                string4 = as[i];
            }
        }









    }

}
