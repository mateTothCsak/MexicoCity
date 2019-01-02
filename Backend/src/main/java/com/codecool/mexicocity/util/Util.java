package com.codecool.mexicocity.util;


import java.util.concurrent.ThreadLocalRandom;

public class Util {


    public static int randomNum(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }


    public static String randomOperator(int max){
        String[] operators = new String[]{"+", "-", "*", "/"};
        return operators[randomNum(0,max)];
    }

}
