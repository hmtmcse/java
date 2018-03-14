package com.hmtmcse.regix;

/**
 * Created by touhid on 24/12/2015.
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTestPatternMatcher {
    public static final String EXAMPLE_TEST = "This is my small example string which I'm going to use for pattern matching.";
    public static final String EXAMPLE_TEST1 = "2013-12-19 18:02:10,930 [http-bio-9100-exec-8] ERROR errors.GrailsExceptionResolver  - ObjectNotFoundException occurred when processing request: [POST] /customerAdmin/deleteSelected";

    public static void main(String[] args) {
//        Pattern pattern = Pattern.compile("\\w+");
        Pattern pattern = Pattern.compile("^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2},\\d+ \\[");
        Matcher matcher = pattern.matcher(EXAMPLE_TEST1);
        // check all occurance
        while (matcher.find()) {
            System.out.print("Start index: " + matcher.start());
            System.out.print(" End index: " + matcher.end() + " ");
            System.out.println(matcher.group());
        }


        Pattern pattern1 = Pattern.compile("[a-z0-9A-Z]+");
        Matcher m = pattern1.matcher("as12");
       if (m.matches()){
           System.out.println("Partial Search");
       }

       if ("1235".matches(".*[0-9].*")){
           System.out.println("Number");
       }else {
           System.out.println("Not Number");
       }

    }
}
