package com.example.cars4sale.Parser;

import java.util.HashMap;
import java.util.Map;

/**
 * ExpAnd: it is extended from the abstract class Exp.
 * This class is used to represent the expression of intersection.
 *
 * @author: Yuxuan Lin
 * @UID: u6828533
 */
public class ExpAnd extends Exp {

    private Exp term;
    private Exp exp;

    public ExpAnd(Exp term, Exp exp) {
        this.term = term;
        this.exp = exp;
    }

    @Override
    public Map evaluate() {
        Map termMap = term.evaluate();
        Map expMap = exp.evaluate();
        Map commonMap = new HashMap();
        for (Object i : termMap.keySet()) {
            if (expMap.get(i) != null) {
                if (expMap.get(i).equals(termMap.get(i))) {
                    commonMap.put(i, termMap.get(i));
                }
            }
        }
        return commonMap;
    }
}
