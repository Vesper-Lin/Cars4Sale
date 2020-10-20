package com.example.cars4sale.Parser;

import com.example.cars4sale.Tokenizer.MyTokenizer;
import com.example.cars4sale.Tokenizer.Token;

import java.util.Map;

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

    MyTokenizer _tokenizer;

    public Parser(MyTokenizer _tokenizer) {
        this._tokenizer = _tokenizer;
    }

    public static void main(String[] args) {
        String text = "name=mini; location=Hobart";
        MyTokenizer _tokenizer = new MyTokenizer(text);
        Exp _exp = new Parser(_tokenizer).parseExp();
        Map searchResult = _exp.evaluate();
        System.out.println(searchResult);
    }

    /**
     * Parse the queries with the form of
     * <exp> ::= <term> | <term> ; <exp>
     */
    public Exp parseExp() {
        if (_tokenizer.current().type().equals(Token.Type.KEYWORD)) {
            Exp term = parseKeyword();
            if (_tokenizer.hasNext()) {
                _tokenizer.next();
                if (_tokenizer.hasNext() && _tokenizer.current().type().equals(Token.Type.SEMICOLON)) {
                    _tokenizer.next();
                    Exp exp = parseExp();
                    return new ExpAnd(term, exp);
                }
            }
            return term;
        } else throw new IllegalArgumentException();
    }

    public Exp parseKeyword() {
        if (_tokenizer.hasNext()) {
            Exp term = null;
            if (_tokenizer.current().token().equalsIgnoreCase("name")) {
                term = parseName();
            } else if (_tokenizer.current().token().equalsIgnoreCase("location")) {
                term = parseLocation();
            }
            return term;
        } else throw new IllegalArgumentException();
    }

    public Exp parseName() {
        if (_tokenizer.hasNext()) {
            _tokenizer.next();
            if (_tokenizer.current().type().equals(Token.Type.COMPARISON)) {
                if (_tokenizer.current().token().equals("=")) {
                    _tokenizer.next();
                    if (!_tokenizer.current().type().equals(Token.Type.NAME)) {
                        throw new IllegalArgumentException();
                    }
                    String name = _tokenizer.current().token();
                    return new ExpName(name);
                }
            }
        } else throw new IllegalArgumentException();
        return null;
    }

    public Exp parseLocation() {
        if (_tokenizer.hasNext()) {
            _tokenizer.next();
            if (_tokenizer.current().type().equals(Token.Type.COMPARISON)) {
                if (_tokenizer.current().token().equals("=")) {
                    _tokenizer.next();
                    if (!_tokenizer.current().type().equals(Token.Type.NAME)) {
                        throw new IllegalArgumentException();
                    }
                    String location = _tokenizer.current().token();
                    return new ExpLocation(location);
                }
            }
        } else throw new IllegalArgumentException();
        return null;
    }

    public Exp parsePrice() {
        return null;
    }

    public Exp parseYear() {
        return null;
    }

}
