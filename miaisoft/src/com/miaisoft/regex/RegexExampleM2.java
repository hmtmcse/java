package com.miaisoft.regex;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by H.M.Touhid Mia on 6/14/2014.
 */
public class RegexExampleM2 {

    public static final String EXAMPLE_TEST = "This is my small example "
            + "string which I'm going to " + "use for pattern matching.";

    public static void main(String[] args) {

        List<String> input = new ArrayList<String>();
        input.add("123-45-6789");
        input.add("9876-5-4321");
        input.add("987-65-4321 (attack)");
        input.add("987-65-4321 ");
        input.add("192-83-7465");


        for (String ssn : input) {
            if ("Alex-1.xhtml".matches("(xhtml)$")) {
                System.out.println("Found good SSN: " + ssn);
            }
        }



        //Split by white space and then print them
        String[] splitString = (EXAMPLE_TEST.split("\\s+"));
        System.out.println(splitString.length);// should be 14
        for (String string : splitString) {
            System.out.println(string);
        }

//        Rplacing all whitespace with tabs then prints
        System.out.println(EXAMPLE_TEST.replaceAll("\\s+", "\t"));
    }

}
