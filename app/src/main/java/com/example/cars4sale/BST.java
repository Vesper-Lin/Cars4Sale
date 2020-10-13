package com.example.cars4sale;

import java.util.ArrayList;
import java.util.List;

public class BST {
    Node root;
    List l =null;


    public BST() {
        this.root = null;
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

    public static List<String> return_over_id(Node t,Integer price) {
        List<String> list = new ArrayList<String>();
        if(null == t){
            return list;
        }

        if (t.key>=price){
            list.add(t.value);
            if(t.left.key==null){

            }
            if(t.left.key>=price){
                return_over_id(t.left,price);
            }else {
                return_over_id(t.right,price);
            }

        }else {
            return_over_id(t.right,price);
        }
        return list;
    }




    public static List<String> list = new ArrayList<String>();
    public static List<String> preOrderTraverse(Node t) {

        if (null == t) {
            return list;
        }
        else if (t.left != null) {

            preOrderTraverse(t.left); // 中序遍历左子树
        }
        if (t.key!= 0) {

            list.add(t.value);
            //System.out.println(t.value);
           //System.out.println("[" + t.key + "]"); // 显示当前节点的数据
        }

        if (t.right != null) {
            preOrderTraverse(t.right); // 最后遍历右子树
        }

        return list;
    }
}
