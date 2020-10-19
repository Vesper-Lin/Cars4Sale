package com.example.cars4sale.DataGenerator;

import java.util.ArrayList;
import java.util.List;

public class GetRandom extends StringData {

    public static List<Car> cars;

    public GetRandom() {
        cars = new ArrayList<>();
    }

    public static int getRandomPrice(int start, int end) {
        int num = (int) (Math.random() * (end - start + 1) + start);
        return num;
    }

    public static String getRandomCarModelName() {
        String ran = "";
        String[] doc = carModelName;
        int index = (int) (Math.random() * doc.length);
        ran = doc[index];
        return ran;
    }

    public static String getRandomLocationOfAu() {
        String ran = "";
        String[] doc = locationOfAU;
        int index = (int) (Math.random() * doc.length);
        ran = doc[index];
        return ran;
    }

    public static int getRandomYear(int start, int end) {
        int year = (int) (Math.random() * (end - start + 1) + start);
        return year;
    }

}
