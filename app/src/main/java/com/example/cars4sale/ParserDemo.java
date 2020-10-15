package com.example.cars4sale;

/**
 * Parser for grammar:
 *
 *  <exp>    ::= <term> ; <exp> | <term>
 *  <term>   ::= <key> <data>
 *  <key>    ::= "name=" | "location=" | "price=" | "price<" | "price>" | "year=" | "year<" | "year>"
 *  <data>   ::= <unsigned string>
 *
 */
public class ParserDemo {
    //final static String exp = "name=tesla; location=canberra; price<100000; year>2012";
    final static String exp = "name=tesla";

    public static void main(String[] args) {
        Tokenizer tok = new MyTokenizer(exp);

        Exp parsedExp = Parser.parseExp(tok);

        System.out.println(parsedExp.show());
        System.out.println(parsedExp.evaluate());
    }
}
