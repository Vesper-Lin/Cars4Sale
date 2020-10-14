package com.example.cars4sale;

import java.util.Map;

/**
 * Abstract class Exp to represent expressions
 */
public abstract class Exp {

    // returns parsed expression of the current expression
    public abstract String show();

    // returns evaluated search result map of the current expression
    public abstract Map evaluate();

}
