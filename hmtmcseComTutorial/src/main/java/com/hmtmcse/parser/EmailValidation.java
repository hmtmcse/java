package com.hmtmcse.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidation {



    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


    public static boolean validate(final String hex) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher  = pattern.matcher(hex);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(validate("tomcattomcattomcattomcattomcattomcattomcattomcattomcattomcattomcat@c.c"));
    }


}
