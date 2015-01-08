package com.hmtmcse.basic;

/**
 * Created by Touhid Mia on 2/01/2015.
 */
public class WhileLoop {

    public static void main(String[] args) {
        int i = 1;
        int sum = 0;
        while (i <= 10) {
            sum = sum + i;
            i++;
        }
        System.out.println("Sum of 1 to 10 = " + sum);


    //do while Loop

         i = 1;
         sum = 0;
        do {
            sum = sum + i;
            i++;
        }while (i <= 10);
        System.out.println("Sum of 1 to 10 = " + sum);
    }
}
