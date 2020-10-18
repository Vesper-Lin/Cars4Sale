package com.example.cars4sale.Tokenizer;

public class Token {

    static final String[] keyword = {"name", "location", "price", "year"};
    static final char[] comparison = {'=', '<', '>'};
    private String _token = "";
    private Type _type = Type.UNKNOWN;

    public Token(String token, Type type) {
        _token = token;
        _type = type;
    }

    public String token() {
        return _token;
    }

    public Type type() {
        return _type;
    }

    public enum Type {UNKNOWN, INT, LETTER, KEYWORD, COMPARISON, SEMICOLON}

}
