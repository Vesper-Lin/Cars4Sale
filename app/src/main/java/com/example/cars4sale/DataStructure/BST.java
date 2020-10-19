package com.example.cars4sale.DataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BST {

    //list_price---String
    public static List<String> list_price = new ArrayList<>();

    //new_list--Integer
    public static List<Integer> new_list = new ArrayList<>();


    Node root;
    public BST() {
        this.root = null;
    }

    //get all id that its pirce is higher than user give
    public static List<String> getHigherPrice(Node t, Integer price) {

        if (null == t) {
            return list_price;

        } else if (t.left != null) {
            getHigherPrice(t.left, price); //  The middle order traverses the left subtree
        }
        if (t.key != 0) {

            if (t.key >= price) {
                list_price.add(t.value);//add higher
            }
            //System.out.println(t.value);
            //System.out.println("[" + t.key + "]"); //  Displays the data for the current node
        }

        if (t.right != null) {
            getHigherPrice(t.right, price); // Finally, traverse the right subtree
        }

        return list_price;
    }


    //get all id that its pirce is lower than user give
    public static List<String> getLowerPrice(Node t, Integer price) {

        if (null == t) {
            return list_price;
        } else if (t.left != null) {
            getHigherPrice(t.left, price);
        }

        if (t.key != 0) {

            if (t.key < price) {
                list_price.add(t.value);//add lower

            }
        }

        if (t.right != null) {
            getHigherPrice(t.right, price);
        }

        return list_price;
    }


    //get the price that same the user imput.
    public static List<String> getPrice(Node t, Integer price) {

        if (null == t) {
            return list_price;
        } else if (t.left != null) {
            getHigherPrice(t.left, price);
        }

        if (t.key != 0) {

            if (t.key == price) {
                list_price.add(t.value);//add same price

            }
        }

        if (t.right != null) {
            getHigherPrice(t.right, price);
        }

        return list_price;
    }

    //make List<String> to List<Integer>
    public static List<Integer> list_to_list(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            BST.new_list.add(Integer.parseInt(list.get(i)));
        }
        return BST.new_list;
    }

    //according to list<Integer> to generate a map
    public static Map list_to_map(Map map, List<Integer> list) {
        Map new_map = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            new_map.put(list.get(i), map.get(list.get(i)));
        }

        return new_map;
    }


    public Node insert(Integer key, String value) {
        Node parent = null;
        Node current = this.root;
        while (current != null) {
            if (current.key.compareTo(key) < 0) {
                parent = current;
                current = current.right;

            } else if (current.key.compareTo(key) > 0) {
                parent = current;
                current = current.left;
            } else {
                parent = current;
                break;
            }
        }
        if (parent == null) {
            this.root = new Node(key, value);  // no parent = root is empty
            return root;
        } else {
            Node newNode = new Node(key, value);

            if (parent.key.compareTo(key) < 0) {
                parent.right = newNode;
                newNode.parent = parent;
            } else if (parent.key.compareTo(key) > 0) {
                parent.left = newNode;
                newNode.parent = parent;
            } else {
                parent.value = value;
                return parent;
            }
            return newNode;
        }

    }

}