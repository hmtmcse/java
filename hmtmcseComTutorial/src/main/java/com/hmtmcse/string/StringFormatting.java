package com.hmtmcse.string;

public class StringFormatting {

    public static void main(String[] args) {

        String text = "Hello %s, How you are doing?";
        String formattedText = String.format(text, "Touhid");
        System.out.println(formattedText);

        formattedText = String.format(text, 1000);
        System.out.println(formattedText);
    }

}
