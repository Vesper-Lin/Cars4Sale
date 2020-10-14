package com.example.cars4sale;

/**
 * Name: Parser.java
 *
 *  The main objective of this class is to implement a simple parser.
 *  It should be able to parser the following grammar rule:
 *  <exp>    ::= <term> | <term> + <exp> | <term> - <exp>
 *  <term>   ::=  <factor> | <factor> * <term> | <factor> / <term>
 *  <factor> ::= <unsigned integer> | ( <exp> )
 *
 */
public class Parser {

    MyTokenizer _tokenizer;

    public Parser(MyTokenizer tokenizer) {
        _tokenizer = tokenizer;
    }

    public Exp parseExp(){
        return null;
    }

    public static void main(String[] args) {
        MyTokenizer mathTokenizer = new MyTokenizer("location = canberra; price < 100000 ; year > 2000");
        Exp t1 = new Parser(mathTokenizer).parseExp();
        System.out.println(t1.show());
        System.out.println(t1.evaluate());
    }
}
