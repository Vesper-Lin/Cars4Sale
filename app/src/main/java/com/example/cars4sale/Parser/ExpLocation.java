package com.example.cars4sale.Parser;

import com.example.cars4sale.DataStructure.BSTSearch;

import java.util.Map;

public class ExpLocation extends Exp {
    String location;

    public ExpLocation(String location) {
        this.location = location;
    }


    @Override
    public Map evaluate() {
        return BSTSearch.getLocation(BSTSearch.readData_map(), location);
    }
}
