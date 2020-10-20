package com.example.cars4sale.Parser;

import com.example.cars4sale.Tokenizer.MyTokenizer;
import com.example.cars4sale.Tokenizer.Token;

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

    /**
     * Parse the queries with the form of
     * <exp> ::= <term> | <term> ; <exp>
     */
    public Exp parseExp() {
        if (_tokenizer.current().type().equals(Token.Type.KEYWORD)) {
            if (_tokenizer.current().token().equalsIgnoreCase("name")) {
                _tokenizer.next();
                if (!_tokenizer.current().type().equals(Token.Type.COMPARISON)) {
                    throw new IllegalArgumentException();
                }
                Exp term = parseName();
                if (_tokenizer.hasNext() && _tokenizer.current().type().equals(Token.Type.SEMICOLON)) {
                    _tokenizer.next();
                    Exp exp = parseExp();
                }
                return term;
            }
        } else throw new IllegalArgumentException();
        return null;
    }

    public Exp parseName() {
        return null;
    }

    public Exp parseLocation() {
        return null;
    }

    public Exp parsePrice() {
        return null;
    }

    public Exp parseYear() {
        return null;
    }

}
