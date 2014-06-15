package com.miaisoft.miscellaneous;

/**
 * Created by H.M.Touhid Mia on 6/14/2014.
 */
public class FindAndReplaceInAString {

    public static void main(String[] args) {
        String emails = "abul@gmail.com kabul@gmail.com heta@gmail.com keta@gmail.com";
        String removeEmail = "heta@gmail.com ";
        System.out.println(emails.replaceAll(removeEmail,""));
    }

}
