package com.example.cars4sale.Parser;

import com.example.cars4sale.DataStructure.BSTSearch;

import java.util.Map;

import static com.example.cars4sale.DataStructure.BSTSearch.getYearBefore;

/**
 * ExpYearBefore: it is extended from the abstract class Exp.
 *         This class is used to represent the expression of getting years before.
 *
 * @author: Yuxuan Lin
 * @UID: u6828533
 */
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
