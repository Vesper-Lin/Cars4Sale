package com.example.cars4sale.Parser;

import com.example.cars4sale.DataStructure.BSTSearch;

import java.util.Map;

import static com.example.cars4sale.DataStructure.BSTSearch.getYear;

public class ExpYear extends Exp {

    private int year;

    public ExpYear(int year) {
        this.year = year;
    }

    @Override
    public Map evaluate() {
        Map result = getYear(BSTSearch.readData_map(), year);
        return result;
    }
}
