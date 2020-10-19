package com.example.cars4sale;

import java.util.HashMap;
import java.util.Map;

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

        Exp term = parseTerm(tok);

        if (tok.hasNext() && tok.current().equals(";")) {
            tok.next();
            Exp exp = parseExp(tok);
            return new ExpAnd(term, exp);
        } else {
            return term;
        }
    }

    public static Exp parseTerm(Tokenizer tok) {
        Exp exp1 = (Exp) tok.current();
        tok.next();
        Exp exp2 = (Exp) tok.current();
        tok.next();
        Exp exp3 = (Exp) tok.current();
        Exp test = new ExpTerm(exp1, exp2, exp3);
        tok.next();
        return test;
    }


}
