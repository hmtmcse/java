package com.hmtmcse.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by touhid on 4/01/2016.
 */
public class GitBranch {


    public static void main(String[] args) {
        String mydata = "  2.1.5\n" +
                "* master\n";
        Pattern pattern = Pattern.compile("(\\*\\s+[\\w+\\.]+)");
        Matcher matcher = pattern.matcher(mydata);
//        System.out.println(matcher.find());
        if (matcher.find()){
            System.out.println(matcher.group(0));
        }
    }

}
