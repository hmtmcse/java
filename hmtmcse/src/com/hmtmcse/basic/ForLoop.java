package com.hmtmcse.basic;

/**
 * Created by Touhid Mia on 2/01/2015.
 */
public class ForLoop {

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum = sum + i;
        }
        System.out.println("Sum of 1 to 10 = " + sum);
    }
}
