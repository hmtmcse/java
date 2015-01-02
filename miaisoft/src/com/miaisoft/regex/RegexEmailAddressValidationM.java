package com.miaisoft.regex;

/**
 * Created by H.M.Touhid Mia on 6/14/2014.
 */
public class RegexEmailAddressValidationM {

   public static String email = "hmtmcse@gmail.coma";

    public static void main(String[] args) {
        String regex = "[a-zA-z0-9\\-_\\.]+@[a-zA-z0-9\\-_\\.]{2,}\\.[a-zA-z0-9]{2,5}";
        /**
         * Here Before @ a to z or A to Z or 0 to 9 or - or _ or . occur 1 or more
         * Then @
         * Then again a to z or A to Z or 0 to 9 or - or _ or . occur 2 or more
         * After .
         * a to z or A to Z or 0 to 9 occur between 2 to 5
         */
        System.out.println(email.matches(regex));
    }


}
