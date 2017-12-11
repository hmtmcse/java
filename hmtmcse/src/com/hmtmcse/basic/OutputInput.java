package com.hmtmcse.basic;

import java.util.Scanner;

/**
 * Created by Touhid Mia on 3/01/2015.
 */
public class OutputInput {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.println("You Enter = " + s);


        //Technic 1
        System.out.println("Hello JAVA");

        //Technic 2
        System.out.print("Hello JAVA ");

        //Technic 3
        String hello = "Hello ", java = "JAVA";
        System.out.println(hello + java);

    }

}
