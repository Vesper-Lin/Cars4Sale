package com.example.cars4sale;

import java.util.Map;

public class Node {
    Integer key;
    String value;
    Node parent;
    Node left;
    Node right;

    public Node(Integer key, String value) {
        this.key = key;
        this.value = value;
        this.parent = null;
        this.left = null;
        this.right = null;
    }
}
