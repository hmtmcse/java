package com.miaisoft.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by H.M.Touhid Mia on 6/13/2014.
 */
public class RegularExpressionM {

    private static final String REGEX = "\\bcat\\b";
    private static final String INPUT = "cat cat cat cattie cat";

    public static void main( String args[] ){
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT); // get a matcher object
        int count = 0;

        while(m.find()) {
            count++;
            System.out.println("Match number "+count);
            System.out.println("start(): "+m.start());
            System.out.println("end(): "+m.end());
        }
    }
}
