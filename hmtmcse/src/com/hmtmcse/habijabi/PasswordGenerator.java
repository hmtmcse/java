package com.hmtmcse.habijabi;

import java.util.Random;
import java.util.UUID;

/**
 * Created by touhid on 3/08/2016.
 */
public class PasswordGenerator {

    final static String STRING_DATA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890@!*&abcdefghjijklmopqrstuvwxyz";
    final static Integer LENGTH = 10;

    public static String getSaltString() {



        String test = "<h2 class=\"text-center center-title-block\"><span>Trading Partners</span></h2>";

        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < LENGTH) {
            int index = (int) (rnd.nextFloat() * STRING_DATA.length());
            salt.append(STRING_DATA.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;




    }

    public static void main(String[] args) {
        System.out.println(getSaltString());

        for (int i = 15; i < 24; i ++){
            System.out.println("template" + i + ".webcommander.biz" + " " + getSaltString());
        }

    }


}
