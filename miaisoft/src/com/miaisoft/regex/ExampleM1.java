package com.miaisoft.regex;

/**
 * Created by H.M.Touhid Mia on 6/14/2014.
 */
public class ExampleM1 {

    public static void main(String[] args) {

        ExampleM1 exampleM1 = new ExampleM1();
       System.out.println(exampleM1.isAllNumberSpaceCharacter("11  "));
    }


    /** Checking in a String All are Character or not */
    public boolean isAllCharacter(String content){
        String pattern = "[a-zA-Z]+";
        return content.matches(pattern);
    }


    /** Checking in a String All are Number or not */
    public boolean isAllNumber(String content){
        String pattern = "[0-9]+";
        return content.matches(pattern);
    }

    /** Checking in a String All are Number then space then alphabet */
    public boolean isAllNumberSpaceCharacter(String content){
    /** Here Content Must Started with Numeric (one or more) Then 1 space and
      *  then a to z or A to Z (1 or more) Alphabet
     */
        String pattern = "^[0-9]+\\s[a-zA-z]+";
        return content.matches(pattern);
    }

}
