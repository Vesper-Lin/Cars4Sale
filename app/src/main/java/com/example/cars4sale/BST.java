package com.example.cars4sale;

import java.util.List;

public class BST {
    Node root;
    List l =null;


    public BST() {
        this.root = null;
    }


    public Node insert(Integer key, Character value) {
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


    public static void preOrderTraverse(Node t) {

        if (null == t) {
            return;
        }
        if (t.left != null) {
            preOrderTraverse(t.left); // 中序遍历左子树
        }
        if (t.key!= 0) {

            System.out.println("[" + t.key + "]"); // 显示当前节点的数据
        }

        if (t.right != null) {
            preOrderTraverse(t.right); // 最后遍历右子树
        }
    }
}
