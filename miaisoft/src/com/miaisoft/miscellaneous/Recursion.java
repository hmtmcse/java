package com.miaisoft.miscellaneous;

/**
 * Created by touhid on 4/12/2014.
 */
public class Recursion {

    public static void main(String[] args) {
        System.out.println(fact(3));

    }


    static int fact(int n) {
        // Base Case:
        //    If n <= 1 then n! = 1.
        if (n <= 1) {
            return 1;
        }
        // Recursive Case:
        //    If n > 1 then n! = n * (n-1)!
        else {
            System.out.println(fact(n - 1));
            return n + fact(n - 1);
        }
    }

}
