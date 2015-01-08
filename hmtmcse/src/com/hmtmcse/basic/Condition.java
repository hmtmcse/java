package com.hmtmcse.basic;

/**
 * Created by Touhid Mia on 2/01/2015.
 */
public class Condition {

    public static void main(String[] args) {

        int age = 19;
        if (age < 18) {
            System.out.println("Your Age Under 18. :)");
        }

        age = 19;
        if (age < 18) {
            System.out.println("Your Age Under 18. :)");
        } else {
            System.out.println("Yah Your Age 18 or 18+. :D");
        }

        age = 30;
        if (age < 18) {
            System.out.println("Your Age Under 18");
        } else if (age < 25) {
            System.out.println("Your Age between 18 to 24");
        } else {
            System.out.println("Your Age 24+");
        }
    }
}
