package com.example.cars4sale;

import java.util.HashMap;
import java.util.Map;

public class ExpTerm extends Exp {
    private Exp key;
    private Exp symbol;
    private Exp str;

    public ExpTerm(Exp key, Exp symbol, Exp str) {
        this.key = key;
        this.symbol = symbol;
        this.str = str;
    }

    @Override
    public String show() {
        return "(" + key.show() + symbol.show() + str.show() + ")";
    }

    @Override
    public Map evaluate() {
        Map termEvaluate = new HashMap();
        if (key.equals("name")){
            if (symbol.equals("=")){
                return BSTSearch.getName(BSTSearch.map, str.toString());
            }
        }
        return null;
    }
}
