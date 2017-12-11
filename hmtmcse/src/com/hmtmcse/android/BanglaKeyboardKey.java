package com.hmtmcse.android;

/**
 * Created by Touhid Mia on 12/02/2016.
 */
public class BanglaKeyboardKey {

    public static void main(String[] args) {

//        0 - 9
        System.out.println("0 to 9");
        System.out.println("==========================================================");
        Integer loop = 10;
        Integer number = 2534;
        for (int i = 0; i < loop; i ++){
            System.out.println("<Key android:codes=\"" + number +"\"    android:keyLabel=\"&#" + number + ";\" />");
            number++;
        }


        System.out.println("ক to য়");
        System.out.println("==========================================================");
        number = 2453;
        loop = 74;
        for (int i = 0; i < loop; i ++){
            System.out.println("<Key android:codes=\"" + number +"\"    android:keyLabel=\"&#" + number + ";\" />");
            number++;
        }

        System.out.println("অ to ঔ");
        System.out.println("==========================================================");
        number = 2437;
        loop = 16;
        for (int i = 0; i < loop; i ++){
            System.out.println("<Key android:codes=\"" + number +"\"    android:keyLabel=\"&#" + number + ";\" />");
            number++;
        }

    }

}
