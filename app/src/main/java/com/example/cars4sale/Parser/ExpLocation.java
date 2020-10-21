package com.example.cars4sale.Parser;

import com.example.cars4sale.DataStructure.BSTSearch;

import org.w3c.dom.NodeList;

import java.util.Map;

/**
 * ExpLocation: it is extended from the abstract class Exp.
 * This class is used to represent the expression of location.
 *
 * @author: Yuxuan Lin
 * @UID: u6828533
 */
public class ExpLocation extends Exp {

    private String location;

    public ExpLocation(String location) {
        this.location = location;
    }

    @Override
    public Map evaluate(Map map, NodeList nodeList) {
        return BSTSearch.getLocation(map, location);
    }
}
