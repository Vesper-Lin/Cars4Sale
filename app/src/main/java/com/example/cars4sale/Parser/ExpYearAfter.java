package com.example.cars4sale.Parser;

import com.example.cars4sale.DataStructure.BSTSearch;

import java.util.Map;

import static com.example.cars4sale.DataStructure.BSTSearch.getYearAfter;

/**
 * ExpYearAfter: it is extended from the abstract class Exp.
 *         This class is used to represent the expression of getting years after.
 *
 * @author: Yuxuan Lin
 * @UID: u6828533
 */
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
