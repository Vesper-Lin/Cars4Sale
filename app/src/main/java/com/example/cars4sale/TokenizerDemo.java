package com.example.cars4sale;

public class TokenizerDemo {

    static String text1 = "location = canberra; price < 100000 ; year > 2000;";
    static String text2 = "price >20000  ; location=canberra; year= 2018 ;";

    public static void main(String[] args) {
        Tokenizer tz = new MyTokenizer(text1);

        System.out.println("Tokenize the first text");
        while (tz.hasNext()) {
            Object token = tz.current();
            System.out.println(token);
            tz.next();
        }

        Tokenizer tz2 = new MyTokenizer(text2);

        System.out.println("Tokenize the second text");
        while (tz2.hasNext()) {
            Object token = tz2.current();
            System.out.println(token);
            tz2.next();
        }
    }

}

