package com.example.cars4sale;


import org.junit.Test;

import java.util.Map;

import static com.example.cars4sale.DataStructure.BST.getHigherPrice;
import static com.example.cars4sale.DataStructure.BST.list_to_list;
import static com.example.cars4sale.DataStructure.BST.list_to_map;
import static com.example.cars4sale.DataStructure.BSTSearch.getLocation;
import static com.example.cars4sale.DataStructure.BSTSearch.getName;
import static com.example.cars4sale.DataStructure.BSTSearch.getYear;
import static com.example.cars4sale.DataStructure.BSTSearch.getYearAfter;
import static com.example.cars4sale.DataStructure.BSTSearch.getYearBefore;
import static com.example.cars4sale.DataStructure.BSTSearch.node;
import static com.example.cars4sale.DataStructure.BSTSearch.readData_map;
import static com.example.cars4sale.DataStructure.BSTSearch.sList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class BSTSearchTest {

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
        int i = size(getYearBefore(car, 2001));
        assertEquals(94, i);
    }

    @Test(timeout = 1000)
    public void testGetYearAfter() {
        int i = size(getYearAfter(car, 2019));
        assertEquals(96, i);
    }

    @Test(timeout = 1000)
    public void testGetHigherPrice() {
        int i = size(list_to_map(car,list_to_list(getHigherPrice(node(sList).root, 988934))));
        assertEquals(7, i);
    }


}
