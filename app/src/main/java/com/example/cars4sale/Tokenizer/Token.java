package com.example.cars4sale.Tokenizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Token {

    static final String[] keyword = {"name", "location", "price", "year"};
    static final char[] comparison = {'=', '<', '>'};
    static final String nameRegex = "name*";
    static final String locationRegex = "location*";
    static final String priceRegex = "price*";
    static final String yearRegex = "year*";
    private String _token = "";
    private Type _type = Type.UNKNOWN;

    public Token(String token, Type type) {
        _token = token;
        _type = type;
    }

    public static boolean regexMatching(String regex, String input) {
        return Pattern.matches(regex, input);
    }

    public static String sortString(String s) {
        Set<Character> set = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }

        ArrayList<Character> arrayList = new ArrayList<>(set);

        char[] charArray = new char[arrayList.size()];
        for(int i = 0; i < arrayList.size(); i++) {
            charArray[i] = arrayList.get(i);
        }
        Arrays.sort(charArray);
        return new String(charArray);
    }

    public static boolean nameContaining(String input) {
        String keyword = "name";
        keyword = sortString(keyword);
        input = sortString(input);
        if (keyword.contains(input) || input.contains(keyword)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean locationContaining(String input) {
        String keyword = "location";
        keyword = sortString(keyword);
        input = sortString(input);
        if (keyword.contains(input) || input.contains(keyword)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean priceContaining(String input) {
        String keyword = "price";
        keyword = sortString(keyword);
        input = sortString(input);
        if (keyword.contains(input) || input.contains(keyword)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean yearContaining(String input) {
        String keyword = "year";
        keyword = sortString(keyword);
        input = sortString(input);
        if (keyword.contains(input) || input.contains(keyword)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String keyword = "year";
        keyword = sortString(keyword);
        String input = "yearrrrr";
        input = sortString(input);
        System.out.println(keyword);
        System.out.println(input);
        System.out.println(yearContaining("yearrrrr"));

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < "yyuearrrrrrrr".length(); i++) {
            set.add("yyuearrrrrrrr".charAt(i));
        }
        System.out.println(set);
        System.out.println(set);

        ArrayList<Character> list = new ArrayList<>(set);
        System.out.println(list);

        char[] myCharArray = new char[list.size()];
        for(int i = 0; i < list.size(); i++) {
            myCharArray[i] = list.get(i);
        }
        System.out.println(myCharArray);

    }

    public String token() {
        return _token;
    }

    public Type type() {
        return _type;
    }

    public enum Type {UNKNOWN, INT, KEYWORD, COMPARISON, SEMICOLON, ELSE}

}
