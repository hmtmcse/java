package com.miaisoft.regex;

/**
 * Created by H.M.Touhid Mia on 6/14/2014.
 */
public class RegexExampleM2 {

    public static final String EXAMPLE_TEST = "This is my small example "
            + "string which I'm going to " + "use for pattern matching.";

    public static void main(String[] args) {

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
