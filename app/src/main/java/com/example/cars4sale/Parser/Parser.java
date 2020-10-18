package com.example.cars4sale.Parser;

import com.example.cars4sale.Tokenizer.Tokenizer;

/**
 * The main objective of this class is to implement a parser for the search query.
 * It should be able to parser the following grammar rule:
 * <exp>    ::= <term> ; <exp> | <term>
 * <term>   ::= <key> <data>
 * <key>    ::= "name=" | "location=" | "price<" | "price>" | "year=" | "year<" | "year>"
 * <data>   ::= <unsigned string>
 */
public class Parser {

    /**
     * Parser for <exp>.
     * <exp> has two production rules: <term> ; <exp> | <term>
     * If there's ; token after parsing term, the parser return an and expression
     * otherwise it returns parsed term.
     *
     * @param tok Tokenizer
     * @return parsed expression for <exp>
     */
    public static Exp parseExp(Tokenizer tok) {
        return null;
    }
}
