package com.example.cars4sale.Parser;

import com.example.cars4sale.DataStructure.BSTSearch;

import java.util.Map;

import static com.example.cars4sale.DataStructure.BSTSearch.getYearBefore;

public class ExpYearBefore extends Exp {

    private int year;

    public ExpYearBefore(int year) {
        this.year = year;
    }

    @Override
    public Map evaluate() {
        Map result = getYearBefore(BSTSearch.readData_map(), year);
        return result;
    }
}
