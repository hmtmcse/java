package com.hmtmcse.habijabi;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class JavaRoundDouble {


    public static void printData(double number, Integer place, RoundingMode roundingMode) {
        BigDecimal bigDecimal = new BigDecimal(number);
        System.out.println("----------------------------------------------");
        System.out.println("Actual Value: " + number);
        System.out.println("Rounding Mode: " + roundingMode.toString());
        System.out.println("Round Up " + place + " Decimal Place = " + bigDecimal.setScale(place, roundingMode));
        System.out.println("----------------------------------------------");
    }

    public static void main(String[] args) {
        double number = 54.54545454545455;
        printData(number, 2, RoundingMode.CEILING);
        printData(number, 2, RoundingMode.FLOOR);
        printData(number, 2, RoundingMode.UP);
        printData(number, 2, RoundingMode.DOWN);
        printData(number, 2, RoundingMode.HALF_UP);
        printData(number, 2, RoundingMode.HALF_DOWN);
        printData(number, 2, RoundingMode.HALF_EVEN);
    }
}
