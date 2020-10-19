package com.example.cars4sale.Parser;

/**
 * The main objective of this class is to implement a parser for the search query.
 * It should be able to parser the following context-free grammar rule:
 * <exp>        ::=   <term> | <term> ; <exp>
 * <term>       ::=   <keyword> <comparison> <value>
 * <value>      ::=   <unsigned string> | <unsigned integer>
 * <keyword>    ::=   "name" | "location" | "price" | "year"
 * <comparison> ::=   "=" | "<" | ">"
 *
 * @author: Yuxuan Lin
 * @UID: u6828533
 */
public class Parser {

    /**
     * Parse the queries with the form of
     * <exp> ::= <term> | <term> ; <exp>
     */
    public static Exp parseExp() {
        return null;
    }
}
