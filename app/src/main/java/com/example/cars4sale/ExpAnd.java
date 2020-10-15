package com.example.cars4sale;

import java.util.HashMap;
import java.util.Map;

public class ExpAnd extends Exp {
    private Exp term;
    private Exp exp;

    public ExpAnd(Exp term, Exp exp) {
        this.term = term;
        this.exp = exp;
    }

    @Override
    public String show() {
        return "(" + term.show() + " AND " + exp.show() + ")";
    }

    @Override
    public Map evaluate() {
        //return elements in both term.evaluate() and exp.evaluate();
        Map new_map = new HashMap();
        for (int i = 0; i < 1000; i++) {
            if (term.evaluate().containsKey(i) && exp.evaluate().containsKey(i)) {
                new_map.put(i, BSTSearch.map.get(i));
            }
        }
        return new_map;
    }
}
