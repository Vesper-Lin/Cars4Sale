package com.example.cars4sale.Parser;

import com.example.cars4sale.DataStructure.BSTSearch;

import java.util.Map;

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
