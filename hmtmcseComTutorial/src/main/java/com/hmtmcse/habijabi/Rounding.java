package com.hmtmcse.habijabi;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Random;

public class Rounding {



    public static void main(String[] args) {



//        System.out.println(round(1.1, 2));
//        System.out.println(round(1.2, 2));
//        System.out.println(round(1.3, 2));
//        System.out.println(round(1.4, 2));
//        System.out.println(round(1.5, 2));
//        System.out.println(round(1.6, 2));
//        System.out.println(round(1.7, 2));
//        System.out.println(round(1.8, 2));
//
//        System.out.println(Math.round(1.99));
//        System.out.println(Math.round(1.11));
//        System.out.println(Math.round(1.12));
//        System.out.println(Math.round(1.13));
//        System.out.println(Math.round(1.14));

        DecimalFormat value = new DecimalFormat("#.#");

    }

    private static double round(double value, int places) {
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}
