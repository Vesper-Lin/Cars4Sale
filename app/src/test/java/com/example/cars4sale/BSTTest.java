package com.example.cars4sale;

import com.example.cars4sale.DataStructure.BST;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BSTTest {
    BST tree;

    @Before
    public void init() {
        this.tree = new BST();

        this.tree.insert(50, "a");

        this.tree.insert(30, "b");
        this.tree.insert(25, "c");
        this.tree.insert(12, "d");
        this.tree.insert(35,"e");
        this.tree.insert(70, "f");
    }




}