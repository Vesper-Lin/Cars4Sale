package com.example.cars4sale.Parser;

import com.example.cars4sale.DataStructure.BSTSearch;

import java.util.Map;

/**
 * ExpName: it is extended from the abstract class Exp.
 *         This class is used to represent the expression of string name (car name / location name).
 *
 * @author: Yuxuan Lin
 * @UID: u6828533
 */
public class ExpName extends Exp {

    private String name;

    public ExpName(String name) {
        this.name = name;
    }


    @Override
    public Map evaluate() {
        return BSTSearch.getName(BSTSearch.readData_map(), name);
    }
}
