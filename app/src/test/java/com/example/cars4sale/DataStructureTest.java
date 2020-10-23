package com.example.cars4sale;


import com.example.cars4sale.DataStructure.BST;

import static com.example.cars4sale.DataStructure.BST.find;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.util.Map;

import static com.example.cars4sale.DataStructure.BST.getHigherPrice;
import static com.example.cars4sale.DataStructure.BST.getLowerPrice;
import static com.example.cars4sale.DataStructure.BST.list_to_list;
import static com.example.cars4sale.DataStructure.BST.list_to_map;
import static com.example.cars4sale.DataStructure.BSTSearch.getLocation;
import static com.example.cars4sale.DataStructure.BSTSearch.getName;
import static com.example.cars4sale.DataStructure.BSTSearch.getYear;
import static com.example.cars4sale.DataStructure.BSTSearch.getYearAfter;
import static com.example.cars4sale.DataStructure.BSTSearch.getYearBefore;
import static com.example.cars4sale.DataStructure.BSTSearch.node;
import static com.example.cars4sale.DataStructure.BSTSearch.readData_map;
import static com.example.cars4sale.DataStructure.BSTSearch.readData_slist;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;


public class DataStructureTest {
    BST tree;

    @Before
    public void init() {
        tree = new BST();
        this.tree = new BST();
        this.tree.insert(50, "a");
        this.tree.insert(30, "b");
        this.tree.insert(25, "c");
        this.tree.insert(12, "d");
        this.tree.insert(35,"e");
        this.tree.insert(70, "f");
    }

    @Test(timeout=1000)
    public void testtree() {
        tree.insert(14,"b");
        Assert.assertEquals(true,find(tree.root,14));
    }


    Map car = readData_map();


    public static Integer size(Map map) {
        int i = map.size();
        return i;
    }

    @Test(timeout = 1000)
    public void testGetName() {
        assertSame(3, size(getName(car, "ARIEL Nomad")));
    }

    @Test(timeout = 1000)
    public void testGetLocation() {
        assertSame(48, size(getLocation(car, "Sydney")));
    }

    @Test(timeout = 1000)
    public void testGetYear() {
        assertSame(47, size(getYear(car, 2019)));
    }


    @Test(timeout = 1000)
    public void testGetYearBefore() {
        int i = size(getYearBefore(car, 2019));
        assertEquals(904, i);
    }

    @Test(timeout = 1000)
    public void testGetYearAfter() {
        int i = size(getYearAfter(car, 2019));
        assertEquals(49, i);
    }

    @Test(timeout = 1000)
    public void testGetHigherPrice() {
        int i = size(list_to_map(car, list_to_list(getHigherPrice(node(readData_slist()).root, 942445))));
        assertEquals(66, i);
    }

    @Test(timeout = 1000)
    public void testGetLowerPrice() {
        int i = size(list_to_map(car, list_to_list(getLowerPrice(node(readData_slist()).root, 942445))));
        assertEquals(933, i);
    }


}