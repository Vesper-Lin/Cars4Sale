package com.example.cars4sale.Tokenizer;

import java.util.regex.Pattern;

public class Token {

    static final String[] keyword = {"name", "location", "price", "year"};
    static final char[] comparison = {'=', '<', '>'};
    static final String nameRegex = "name*";
    static final String locationRegex = "location*";
    static final String priceRegex = "price*";
    static final String year = "year*";
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

    public static boolean regexMatching(String regex, String input) {
        return Pattern.matches(regex, input);
    }

    public static boolean nameContaining (String input) {
        String keyword = "name";
        if (keyword.contains(input) || input.contains(keyword)) {
            return true;
        }
        return false;
    }

    public static boolean locationContaining (String input) {
        String keyword = "location";
        if (keyword.contains(input) || input.contains(keyword)) {
            return true;
        }
        return false;
    }

    public static boolean priceContaining (String input) {
        String keyword = "price";
        if (keyword.contains(input) || input.contains(keyword)) {
            return true;
        }
        return false;
    }

    public static boolean yearContaining (String input) {
        String keyword = "year";
        if (keyword.contains(input) || input.contains(keyword)) {
            return true;
        }
        return false;
    }

    public enum Type {UNKNOWN, INT, KEYWORD, COMPARISON, SEMICOLON, IGNORE}

}
