package com.example.cars4sale.Parser;

import com.example.cars4sale.Tokenizer.MyTokenizer;
import com.example.cars4sale.Tokenizer.Tokenizer;

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
    //final static String exp = "name=tesla; location=canberra; price<100000; year>2012";
    final static String exp = "name=tesla";

    /*
    public static void main(String[] args) {
        Tokenizer tok = new MyTokenizer(exp);

        Exp parsedExp = Parser.parseExp();

        System.out.println(parsedExp.evaluate());
    }*/
}
