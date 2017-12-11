package com.hmtmcse.basic;

/**
 * Created by Touhid Mia on 04/01/2016.
 */
public class UpperCamelCase {

    public static void main(String[] args) {

        String input = "input-in-snake-case";

        StringBuilder titleCase = new StringBuilder();
        boolean nextTitleCase = true;

        for (char c : input.toCharArray()) {
            if (c == '-') {
                nextTitleCase = true;
                continue;
            } else if (nextTitleCase) {
                c = Character.toTitleCase(c);
                nextTitleCase = false;
            }
            titleCase.append(c);
        }

        System.out.println(titleCase.toString());
    }
}
