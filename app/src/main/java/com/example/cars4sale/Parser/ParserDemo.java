package com.example.cars4sale.Parser;

import com.example.cars4sale.Tokenizer.MyTokenizer;
import com.example.cars4sale.Tokenizer.Tokenizer;

import java.util.Map;

/**
 * Parser for grammar:
 *
 * <exp>        ::=   <term> | <term> ; <exp>
 * <term>       ::=   <keyword> <comparison> <value>
 * <value>      ::=   <unsigned string> | <unsigned integer>
 * <keyword>    ::=   "name" | "location" | "price" | "year"
 * <comparison> ::=   "=" | "<" | ">"
 */
public class ParserDemo {

    final static String text = "name=tesla; location = perth; price<200000; year>2008";

    public static void main(String[] args) {
        MyTokenizer _tokenizer = new MyTokenizer(text);
        Exp _exp = new Parser(_tokenizer).parseExp();
        Map searchResult = _exp.evaluate();
        System.out.println(searchResult);
    }
}
