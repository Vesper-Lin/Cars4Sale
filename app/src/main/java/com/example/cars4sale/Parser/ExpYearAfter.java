package com.example.cars4sale.Parser;

import com.example.cars4sale.DataStructure.BSTSearch;

import java.util.Map;

import static com.example.cars4sale.DataStructure.BSTSearch.getYearAfter;

public class ExpYearAfter extends Exp {

    private int year;

    public ExpYearAfter(int year) {
        this.year = year;
    }

    @Override
    public Map evaluate() {
        Map result = getYearAfter(BSTSearch.readData_map(), year);
        return result;
    }
}
